package com.data.monkey.grammar.parser.engine.conditionExprs;



import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * boolean expression not equals.
 **/
public class NotEqCondition extends BooleanExprBase {

    public NotEqCondition(Operand left, Operand right) {
        super(left, right);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public boolean getResult(List<Event> events, Map<String, String> parameters) {
        Object left = leftValue(events, parameters);
        Object right = rightValue(events, parameters);
        return !sameType(left, right) || (sameType(left, right) && compare((Comparable) left, (Comparable) right) != 0);
    }

    @Override
    public Boolean getResult(ProcessingContext context)
    {
        final Object leftValue = getLeft().getValue(context);
        final Object rightValue = getRight().getValue(context);
        return !Objects.equals(leftValue, rightValue);
    }

    @Override
    public String getExpressionName()
    {
        return "!=";
    }
}
