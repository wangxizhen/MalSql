package com.data.monkey.grammar.parser.engine.operands.primitives;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractAggregationOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import com.google.common.collect.Sets;


import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public abstract class AbstractPrimitiveOperand<T> implements Operand
{
    protected T value;

    public T getValue()
    {
        return value;
    }

    public AbstractPrimitiveOperand(T value)
    {
        this.value = value;
    }

    @Override
    public Object getValue(Event currEvent, List<Event> eventRaws, Map<String, String> parameters)
    {
        return value;
    }

    @Override
    public Object getValue(ProcessingContext context)
    {
        return value;
    }

    @Override
    public Set<AbstractAggregationOperand> getAggregationOperands()
    {
        return Sets.newHashSet();
    }

    @Override
    public String toReadableString()
    {
        return value == null ? "null" : value.toString();
    }

    @Override
    public String toString()
    {
        return String.format("%s(%s)", this.getClass().getSimpleName(), this.toReadableString());
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(value);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            final AbstractPrimitiveOperand operand = (AbstractPrimitiveOperand) obj;
            return Objects.equals(this.getValue(), operand.getValue());
        }
        return false;
    }
}
