package com.data.monkey.grammar.parser.engine.operands;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractAggregationOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import com.google.common.collect.Sets;


import java.util.List;
import java.util.Map;
import java.util.Set;

public class SetOperand implements Operand {

    private Set<Object> value;

    public SetOperand(Set<Object> elements) {
        this.value = elements;
    }

    @Override
    public Set<AbstractAggregationOperand> getAggregationOperands() {
        return Sets.newHashSet();
    }

    @Override
    public String toReadableString()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object getValue(List<Event> events, Map<String, String> parameters) {
        return value;
    }

    @Override
    public Object getValue(ProcessingContext context)
    {
        return value;
    }
}
