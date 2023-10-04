package com.data.monkey.grammar.parser.engine.conditionExprs;


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
public class ParenthesisCondition implements IBooleanExpression {
    private IBooleanExpression inner;

    @Override
    public boolean getResult(List<Event> events, Map<String, String> parameters) {
        return inner.getResult(events, parameters);
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
