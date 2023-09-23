package com.data.monkey.grammar.parser.engine.operands.primitives;


import com.data.monkey.common.entity.Event;

import java.util.List;
import java.util.Map;

public class IntegerOperand extends AbstractPrimitiveOperand<Long>
{
    public IntegerOperand(Long value)
    {
        super(value);
    }

    public IntegerOperand(int value)
    {
        super(Long.valueOf(value));
    }

    @Override
    public Object getValue(Event currEvent, List<Event> eventRaws, Map<String, String> parameters)
    {
        return new Double(value);
    }
}
