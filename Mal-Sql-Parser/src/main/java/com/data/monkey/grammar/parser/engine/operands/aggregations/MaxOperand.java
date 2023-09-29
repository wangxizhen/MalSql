package com.data.monkey.grammar.parser.engine.operands.aggregations;



import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.booleanExprs.IBooleanExpression;
import com.data.monkey.grammar.parser.engine.operands.Operand;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MaxOperand extends AbstractAggregationOperand {

    public MaxOperand(Operand innerOperand) {
        super(innerOperand);
    }

    @Override
    protected String getAggregationType()
    {
        return "MAX";
    }

    public MaxOperand(IBooleanExpression predicate) {
        super(predicate);
    }

    public MaxOperand(Operand innerOperand, IBooleanExpression predicate) {
        super(innerOperand, predicate);
    }

    @Override
    public Object getValue(List<Event> events, Map<String, String> parameters) {

        final Operand innerOpt = this.getNameOperand();
        Event value = filterForCalculus(filter(events, parameters), parameters).min((event, t1) -> {
            BigDecimal b1 = new BigDecimal(innerOpt.getValue( Arrays.asList(event), parameters).toString());
            BigDecimal b2 = new BigDecimal(innerOpt.getValue(Arrays.asList(t1), parameters).toString());
            return b2.compareTo(b1);
        }).orElse(null);

        if (value == null)
            return 0.0;

        return innerOpt.getValue(Arrays.asList(value), parameters);
    }

    @Override
    public Double getAggregationInitialValue() {
        return Double.MIN_VALUE;
    }

    @Override
    public AggregationFunction getAggregationFunction() {
        return Double::max;
    }
}
