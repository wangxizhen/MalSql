package com.data.monkey.grammar.parser.engine.operands.arithmetics;



import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.Operand;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public abstract class AbstractBitwiseOperand extends AbstractArithmeticOperand
{
    public AbstractBitwiseOperand(Operand left, Operand right)
    {
        super(left, right);
    }

    @Override
    public Object getValue(
            Event currEvent, List<Event> events, Map<String, String> parameters
    )
    {
        throw new UnsupportedOperationException();
    }

    @Override
    protected BiFunction<Object, Object, Object> getArithmeticOperation()
    {
        throw new UnsupportedOperationException();
    }
}
