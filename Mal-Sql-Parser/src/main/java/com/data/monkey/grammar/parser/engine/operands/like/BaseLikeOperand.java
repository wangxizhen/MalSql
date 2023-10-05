package com.data.monkey.grammar.parser.engine.operands.like;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractAggregationOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import com.data.monkey.grammar.parser.engine.processing.ReadableEvent;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public abstract class BaseLikeOperand implements Operand {


    public abstract Object getValue(List<Event> events, Map<String, String> parameters) ;

    @Override
    public Object getValue(ProcessingContext context) {
        final ReadableEvent event = context.getEvent();
        Optional<Object> result = event.readValue(getFieldName());
        if (!result.isPresent()) {
            result = event.readValue(toReadableString());
        }
        return result.orElse(null);
    }

    @Override
    public Set<AbstractAggregationOperand> getAggregationOperands() {
        return Sets.newHashSet();
    }

    @Override
    public String toReadableString() {
        return StringUtils.isEmpty(getTableName()) ? getFieldName() : String.format("%s.%s.%s", getTableName(), getFieldName(),getMatchValue());
    }

    public abstract String getFieldName();
    public abstract String getTableName();
    public abstract String getMatchValue();


}
