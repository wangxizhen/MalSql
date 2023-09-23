package com.data.monkey.grammar.parser.engine.booleanExprs.numerical;



import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.Operand;

import java.util.List;
import java.util.Map;

/**
 * boolean expression greater than
 */
public class BooleanExprGT extends AbstractNumericalBooleanExpr
{
    public BooleanExprGT(Operand left, Operand right) {
        super(left, right);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public boolean getResult(Event currEvent, List<Event> events, Map<String, String> parameters) {
        Object left = leftValue(currEvent, events, parameters);
        Object right = rightValue(currEvent, events, parameters);
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
