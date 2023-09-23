package com.data.monkey.grammar.parser.engine.booleanExprs;



import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * boolean expression not equals.
 **/
public class BooleanExprNE extends BooleanExprBase {

    public BooleanExprNE(Operand left, Operand right) {
        super(left, right);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public boolean getResult(Event currEvent, List<Event> events, Map<String, String> parameters) {
        Object left = leftValue(currEvent, events, parameters);
        Object right = rightValue(currEvent, events, parameters);
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
