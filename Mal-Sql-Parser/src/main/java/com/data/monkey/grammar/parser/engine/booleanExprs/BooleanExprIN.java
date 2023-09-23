package com.data.monkey.grammar.parser.engine.booleanExprs;



import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.operands.SetOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import com.google.common.base.Preconditions;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * in clause
 *
 */
public class BooleanExprIN extends BooleanExprBase {

    public BooleanExprIN(Operand left, Operand right) {
        super(left, right);
    }

    @Override
    public boolean getResult(Event currEvent, List<Event> events, Map<String, String> parameters) {
        Object val =  this.getLeft().getValue(currEvent, events, parameters);
        Set<Object> elements = (Set<Object>)this.getRight().getValue(currEvent, events, parameters);
        return elements != null && !elements.isEmpty() && elements.contains(val);
    }

    @Override
    public Boolean getResult(ProcessingContext context)
    {
        Preconditions.checkArgument(this.getRight() instanceof SetOperand);
        final Object value = this.getLeft().getValue(context);
        final Set<Object> expectedValues = (Set<Object>) this.getRight().getValue(context);
        return expectedValues.contains(value);
    }

    @Override
    public String getExpressionName()
    {
        return "in";
    }
}
