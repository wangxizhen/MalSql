package com.data.monkey.grammar.parser.engine.operands.arithmetics;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.google.common.base.Preconditions;


import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;


public class PlusOperand extends AbstractArithmeticOperand
{
    public PlusOperand(Operand left, Operand right) {
        super(left, right);
    }

    @Override
    public Object getValue(Event currEvent, List<Event> events, Map<String, String> parameters) {
        Double right = (Double) this.getRight().getValue(currEvent, events, parameters);
        Double left = (Double) this.getLeft().getValue(currEvent, events, parameters);
        return (left == null ? 0.0 : left) + (right == null ? 0.0 : right);
    }

    @Override
    protected BiFunction<Object, Object, Object> getArithmeticOperation()
    {
        return PLUS_OP;
    }

    @Override
    protected String getArithmeticName()
    {
        return "+";
    }

    public static final BiFunction<Object, Object, Object> PLUS_OP = (num1, num2) -> {
        Preconditions.checkNotNull(num1);
        Preconditions.checkNotNull(num2);
        Preconditions.checkArgument(num1 instanceof Number, "arguments need to be number");
        Preconditions.checkArgument(num2 instanceof Number, "arguments need to be number");

        return ((Number) num1).doubleValue() + ((Number) num2).doubleValue();
    };
}
