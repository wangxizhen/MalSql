package com.data.monkey.grammar.parser.engine;
import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.conditionExprs.IBooleanExpression;
import com.data.monkey.grammar.parser.engine.boundingBox.BoundingBox;
import com.data.monkey.grammar.parser.engine.datasource.EventsFinder;
import com.data.monkey.grammar.parser.engine.exception.NotFoundException;
import com.data.monkey.grammar.parser.engine.function.FilterMatchFunction;
import com.data.monkey.grammar.parser.engine.operands.AliasOperand;
import com.data.monkey.grammar.parser.engine.operands.NameOperand;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractAggregationOperand;
import com.data.monkey.grammar.parser.engine.operands.aggregations.PeriodOperand;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Builder
public class MalSqlParserTemplate {
    private static Logger logger = LoggerFactory.getLogger("MalSqlParserTemplate");
    private final List<String> tables;
    private final IBooleanExpression whereClause;
    private final List<Operand> columns;
    private final String allColumn;
    private final List<Operand> valueFilterCondition;
    private final List<Operand> likeFilterCondition;
    private final BoundingBox boundingBox;
    private static final boolean isFilter=true;

    /**
     * @deprecated use {@link #boundingBox}
     */
    @Deprecated
    private final EventsFinder eventsFinder;

    private final List<PeriodOperand> periodOperands;

    //查询结果导出
    private final String exportFileName;

    public boolean getResult(Event currEvent, IEventsProvider provider, Map<String, String> params) {
        try {
            List<Event> events = findEventsWithProvider(currEvent, provider, params);
            if (events.isEmpty()) {
                return false;
            }
            return getResult(events, params);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public Map<String, String> getContext(List<Event> events, Map<String, String> params) {
        if(eventsFinder != null&&events.size()>0){
            events = findEventsWithProvider(events.get(0),new DefaultEventsProvider(events),params);
        }
        Set<String> names = new HashSet<>();
        List<Event> finalEvents = events;
        return this.columns.stream().filter(op -> names.add(filedName(op))).collect(Collectors.toMap(op -> filedName(op)
                , op -> {
                    try {
                        return op.getValue(filterByKeys(finalEvents), params).toString();
                    } catch (NotFoundException e) {
                        // dsl使用不存在的字段做select查询条件的时候, 返回空值.
                        return "";
                    }
                }));
    }


    private List<Event> findEventsWithProvider(Event currEvent, IEventsProvider provider, Map<String, String> params) throws IllegalArgumentException {
        List<Event> events = null;
        if (eventsFinder != null) {
            eventsFinder.setProvider(provider);
            events = eventsFinder.backwardFrom(currEvent, params);
        } else {
            events = Lists.newArrayList();
        }
        return events;
    }

    public boolean getResult(List<Event> events, Map<String, String> params) {
        try {
            return this.getWhereClause().getResult(filterByKeys(events), params);
        } catch (NotFoundException e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    public List<Event> getMatchResult(List<Event> events, List<Operand> matchKeys, FilterMatchFunction function) {
        if (matchKeys != null) {
            return events.stream().filter(e -> {
                boolean filter = true;
                for (Operand operand : matchKeys) {
                    filter = filter && function.match(operand,e);
                }
                return filter;
            }).collect(Collectors.toList());
        }
        return events;

    }

    private List<Event> filterByKeys(List<Event> events) {
        List<Event> matchResult=events;
        //like %% 的格式
        if(likeFilterCondition!=null){
            matchResult = getMatchResult(matchResult,likeFilterCondition,(operand,event)->(operand.getValue(Collections.singletonList(event), null))!=null);
        }
        if(valueFilterCondition!=null){
            matchResult = getMatchResult(matchResult,valueFilterCondition,(operand,event)->operand.getValue(Collections.singletonList(event), null).
                    equals(operand.getValue(Collections.singletonList(
                            events.get(events.size() - 1)), null)));
        }
        return matchResult;
    }



    private String filedName(Operand op) {
        if (NameOperand.class.isInstance(op)) {
            return ((NameOperand) op).getFieldName();
        } else if (AliasOperand.class.isInstance(op)) {
            return ((AliasOperand) op).getAlias();
        }

        throw new RuntimeException("use an aggregation function as a column should specify an alias: " + op);
    }

    @Override
    public String toString() {
        return "MalSqlParserTemplate [tables=" + tables + "]";
    }

    public Set<AbstractAggregationOperand> getAggregationOperands() {
        Set<AbstractAggregationOperand> operands = columns.stream().map(op -> op.getAggregationOperands()).reduce((s1, s2) -> {
            s1.addAll(s2);
            return s1;
        }).orElseGet(HashSet::new);
        operands.addAll(whereClause.getAggregationOperands());
        return operands;
    }
}
