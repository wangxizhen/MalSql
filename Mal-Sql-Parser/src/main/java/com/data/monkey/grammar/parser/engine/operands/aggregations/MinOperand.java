package com.data.monkey.grammar.parser.engine.operands.aggregations;



import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.booleanExprs.IBooleanExpression;
import com.data.monkey.grammar.parser.engine.operands.Operand;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MinOperand extends AbstractAggregationOperand {

    public MinOperand(Operand innerOperand) {
        super(innerOperand);
    }

    @Override
    protected String getAggregationType()
    {
        return "MIN";
    }

    public MinOperand(IBooleanExpression predicate) {
        super(predicate);
    }

    public MinOperand(Operand innerOperand, IBooleanExpression predicate) {
        super(innerOperand, predicate);
    }

    @Override
    public Object getValue(Event currEvent, List<Event> events, Map<String, String> parameters) {

        final Operand innerOpt = this.getNameOperand();
        Event value = filterForCalculus(filter(events, parameters), parameters).min((event, t1) -> {
            BigDecimal b1 = new BigDecimal(innerOpt.getValue(event, Arrays.asList(event), parameters).toString());
            BigDecimal b2 = new BigDecimal(innerOpt.getValue(t1, Arrays.asList(t1), parameters).toString());
            return b1.compareTo(b2);
        }).orElse(null);

        if (value == null)
            return 0.0;

        return innerOpt.getValue(value, Arrays.asList(value), parameters);

    }

    @Override
    public AggregationFunction getAggregationFunction() {
        return Double::min;
    }

    @Override
    public Double getAggregationInitialValue()
    {
        return Double.MAX_VALUE;
    }
}
