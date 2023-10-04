package com.data.monkey.grammar.parser.engine.operands.aggregations;


import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.conditionExprs.IBooleanExpression;
import com.data.monkey.grammar.parser.engine.operands.Operand;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SumOperand extends AbstractAggregationOperand {

    public SumOperand(Operand innerOperand) {
        super(innerOperand);
    }

    public SumOperand(IBooleanExpression predicate)
    {
        super(predicate);
    }

    public SumOperand(Operand innerOperand, IBooleanExpression predicate)
    {
        super(innerOperand, predicate);
    }

    @Override
    protected String getAggregationType()
    {
        return "SUM";
    }

    @Override
    public Double getAggregationInitialValue()
    {
        return 0.0;
    }

    @Override
    public Object getValue(List<Event> events, Map<String, String> parameters) {

        final Operand innerOpt = this.getNameOperand();
        return filterForCalculus(filter(events, parameters), parameters).reduce(
                0D,
                (d, r) -> d + (Double) innerOpt.getValue(Arrays.asList(r), parameters),
                (d1, d2) -> d1 + d2);
    }

    @Override
    public AggregationFunction getAggregationFunction() {
        return Double::sum;
    }

}
