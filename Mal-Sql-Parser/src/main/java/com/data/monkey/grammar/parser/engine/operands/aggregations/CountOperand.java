package com.data.monkey.grammar.parser.engine.operands.aggregations;



import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.booleanExprs.IBooleanExpression;
import com.data.monkey.grammar.parser.engine.operands.Operand;

import java.util.List;
import java.util.Map;

public class CountOperand extends AbstractAggregationOperand {

    public CountOperand(Operand innerOperand) {
        super(innerOperand);
    }

    @Override
    protected String getAggregationType()
    {
        return "COUNT";
    }

    public CountOperand(IBooleanExpression predicate) {
        super(predicate);
    }

    public CountOperand(Operand innerOperand, IBooleanExpression predicate) {
        super(innerOperand, predicate);
    }

    @Override
    public Object getValue(Event currEvent, List<Event> events, Map<String, String> parameters) {

        Long value = filter(events, parameters).count();

        return value.doubleValue();

    }

    @Override
    public AggregationFunction getAggregationFunction() {
        //count should be different from sum, but now they looks the same.
        return (n1, n2) -> n1 + 1;
    }

    @Override
    public Double getAggregationInitialValue()
    {
        return 0.0D;
    }
}
