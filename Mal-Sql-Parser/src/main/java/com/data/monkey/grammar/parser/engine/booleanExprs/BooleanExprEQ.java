package com.data.monkey.grammar.parser.engine.booleanExprs;


import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * boolean operation equals.
 *
 */
public class BooleanExprEQ extends BooleanExprBase {

    public BooleanExprEQ(Operand left, Operand right) {
        super(left, right);
    }

    @Override
    public boolean getResult(Event currEvent, List<Event> events, Map<String, String> parameters) {
        return Objects.equals(this.getLeft().getValue(currEvent, events, parameters), this.getRight().getValue(currEvent, events, parameters));
    }

    @Override
    public Boolean getResult(ProcessingContext context) {
        final Object leftValue = getLeft().getValue(context);
        final Object rightValue = getRight().getValue(context);
        return Objects.equals(leftValue, rightValue);
    }

    @Override
    public String getExpressionName()
    {
        return "=";
    }
}
