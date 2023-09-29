package com.data.monkey.grammar.parser.engine.booleanExprs;


import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractAggregationOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * and operator for boolean expressions.
 *
 */
@Data
@AllArgsConstructor
public class BooleanExprAND implements IBooleanExpression {
    private final IBooleanExpression left;
    private final IBooleanExpression right;

    @Override
    public boolean getResult( List<Event> events, Map<String, String> parameters) {
        return left.getResult(events, parameters) && right.getResult(events, parameters);
    }

    @Override
    public Boolean getResult(ProcessingContext context) {
        return left.getResult(context) && right.getResult(context);
    }

    @Override
    public Set<AbstractAggregationOperand> getAggregationOperands() {
        Set<AbstractAggregationOperand> aggregationOperands = left.getAggregationOperands();
        aggregationOperands.addAll(right.getAggregationOperands());
        return aggregationOperands;
    }

    @Override
    public String toReadableString()
    {
        return String.format("(%s) and (%s)", this.getLeft().toReadableString(), this.getRight().toReadableString());
    }
}
