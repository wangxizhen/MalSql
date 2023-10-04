package com.data.monkey.grammar.parser.engine.conditionExprs.numerical;



import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.Operand;

import java.util.List;
import java.util.Map;

/**
 * boolean expression greater than
 * 
 *
 */
public class GreatEqCondition extends AbstractNumericalBooleanExpr
{

    public GreatEqCondition(Operand left, Operand right) {
        super(left, right);
    }

    @Override
    protected boolean predication(double leftNumber, double rightNumber)
    {
        return isEqualWithinPrecision(leftNumber, rightNumber) || leftNumber >= rightNumber;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public boolean getResult(List<Event> events, Map<String, String> parameters) {
        Object left = leftValue(events, parameters);
        Object right = rightValue(events, parameters);
        return sameType(left, right)
                && compare((Comparable) left, (Comparable) right) >= 0;
    }

    @Override
    public String getExpressionName()
    {
        return ">=";
    }
}
