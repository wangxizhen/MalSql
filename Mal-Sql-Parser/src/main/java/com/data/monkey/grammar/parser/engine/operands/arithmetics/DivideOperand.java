package com.data.monkey.grammar.parser.engine.operands.arithmetics;



import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.google.common.base.Preconditions;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class DivideOperand extends AbstractArithmeticOperand
{
    public DivideOperand(Operand left, Operand right) {
        super(left, right);
    }

    @Override
    public Object getValue(List<Event> events, Map<String, String> parameters) {
        Double right = (Double) this.getRight().getValue(events, parameters);
        if (right != null && right != 0.0) {
            Double left = (Double) this.getLeft().getValue(events, parameters);
            if (left != null) {
                return left / right;
            }
        }
        return 0D;
    }

    private static final BiFunction<Object, Object, Object> DIVIDE_OP = (num1, num2) -> {
        Preconditions.checkNotNull(num1);
        Preconditions.checkNotNull(num2);
        Preconditions.checkArgument(num1 instanceof Number, "arguments need to be number");
        Preconditions.checkArgument(num2 instanceof Number, "arguments need to be number");

        final double num2d = ((Number) num2).doubleValue();
        Preconditions.checkArgument(num2d != 0, "divider cannot be zero");

        return ((Number) num1).doubleValue() / num2d;
    };

    @Override
    protected BiFunction<Object, Object, Object> getArithmeticOperation()
    {
        return DIVIDE_OP;
    }

    @Override
    protected String getArithmeticName()
    {
        return "/";
    }
}
