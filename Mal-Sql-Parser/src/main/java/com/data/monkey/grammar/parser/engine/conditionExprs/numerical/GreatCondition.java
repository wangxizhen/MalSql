package com.data.monkey.grammar.parser.engine.conditionExprs.numerical;



import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.Operand;

import java.util.List;
import java.util.Map;

/**
 * boolean expression greater than
 */
public class GreatCondition extends AbstractNumericalBooleanExpr
{
    public GreatCondition(Operand left, Operand right) {
        super(left, right);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public boolean getResult(List<Event> events, Map<String, String> parameters) {
        Object left = leftValue(events, parameters);
        Object right = rightValue(events, parameters);
        return sameType(left, right)
                && compare((Comparable) left, (Comparable) right) > 0;
    }

    protected boolean predication(double leftNumber, double rightNumber)
    {
        return !isEqualWithinPrecision(leftNumber, rightNumber) && leftNumber > rightNumber;
    }

    @Override
    public String getExpressionName()
    {
        return ">";
    }
}
