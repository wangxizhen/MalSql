package com.data.monkey.grammar.parser.engine.booleanExprs.numerical;



import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.Operand;

import java.util.List;
import java.util.Map;

/**
 * boolean expression less than.
 * 
 *
 */
public class BooleanExprLT extends AbstractNumericalBooleanExpr
{

    public BooleanExprLT(Operand left, Operand right) {
        super(left, right);
    }

    @Override
    protected boolean predication(double leftNumber, double rightNumber)
    {
        return !isEqualWithinPrecision(leftNumber, rightNumber) && leftNumber < rightNumber;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public boolean getResult(Event currEvent, List<Event> events, Map<String, String> parameters) {
        Object left = leftValue(currEvent, events, parameters);
        Object right = rightValue(currEvent, events, parameters);
        return sameType(left, right)
                && compare((Comparable) left, (Comparable) right) < 0;
    }

    @Override
    public String getExpressionName()
    {
        return "<";
    }
}
