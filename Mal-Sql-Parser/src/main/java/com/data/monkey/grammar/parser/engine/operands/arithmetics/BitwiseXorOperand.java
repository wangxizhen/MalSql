package com.data.monkey.grammar.parser.engine.operands.arithmetics;



import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.Operand;

import java.util.List;
import java.util.Map;

public class BitwiseXorOperand extends AbstractBitwiseOperand
{

    public BitwiseXorOperand(Operand left, Operand right) {
        super(left, right);
    }

    @Override
    public Object getValue(Event currEvent, List<Event> events, Map<String, String> parameters) {
        Double left = (Double) this.getLeft().getValue(currEvent, events, parameters);
        Double right = (Double) this.getRight().getValue(currEvent, events, parameters);

        int value = (left == null ? 0 : left.intValue()) ^ (right == null ? 0 : right.intValue());
        return Double.parseDouble(value + "");
    }

    @Override
    protected String getArithmeticName()
    {
        return "xor";
    }
}
