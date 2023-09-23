package com.data.monkey.grammar.parser.engine;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.booleanExprs.IBooleanExpression;
import com.data.monkey.grammar.parser.engine.boundingBox.BoundingBox;
import com.data.monkey.grammar.parser.engine.datasource.EventsFinder;
import com.data.monkey.grammar.parser.engine.exception.NotFoundException;
import com.data.monkey.grammar.parser.engine.operands.AliasOperand;
import com.data.monkey.grammar.parser.engine.operands.NameOperand;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractAggregationOperand;
import com.data.monkey.grammar.parser.engine.operands.aggregations.PeriodOperand;
import com.data.monkey.grammar.parser.engine.util.TimeUtil;
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
    private final List<NameOperand> filterKeys;

    private final BoundingBox boundingBox;

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
            return getResult(currEvent, events, params);
        } catch (IllegalArgumentException e) {
            return false;
        }
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

    public boolean getResult(Event currEvent, List<Event> events, Map<String, String> params) {
        try {
            return this.getWhereClause().getResult(currEvent, filterByKeys(currEvent, events), params);
        } catch (NotFoundException e) {
            // dsl使用不存在的字段做触发告警条件的时候, 记录异常同时不触发告警
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    private List<Event> filterByKeys(Event currEvent, List<Event> events) {
        if (filterKeys != null) {
            return events.stream().filter(e -> {
                boolean filter = true;
                for (Operand operand : filterKeys) {
                    filter = filter
                        && (operand.getValue(e, Collections.singletonList(e), null).
                        equals(operand.getValue(currEvent, Collections.singletonList(
                            events.get(events.size() - 1)), null)));
                }
                return filter;
            }).collect(Collectors.toList());
        }
        return events;
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
