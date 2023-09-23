package com.data.monkey.grammar.parser.engine.booleanExprs;


import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractAggregationOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class BooleanExprParenthesis implements IBooleanExpression {
    private IBooleanExpression inner;

    @Override
    public boolean getResult(Event currEvent, List<Event> events, Map<String, String> parameters) {
        return inner.getResult(currEvent, events, parameters);
    }

    @Override
    public Boolean getResult(ProcessingContext context)
    {
        return inner.getResult(context);
    }

    @Override
    public Set<AbstractAggregationOperand> getAggregationOperands() {
        return inner.getAggregationOperands();
    }

    @Override
    public String toReadableString()
    {
        throw new UnsupportedOperationException();
    }
}
