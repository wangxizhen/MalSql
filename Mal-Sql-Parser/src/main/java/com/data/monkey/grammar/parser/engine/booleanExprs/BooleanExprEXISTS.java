package com.data.monkey.grammar.parser.engine.booleanExprs;


import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractAggregationOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class BooleanExprEXISTS implements IBooleanExpression {
    private final Operand operand;

    @Override
    public boolean getResult(List<Event> events, Map<String, String> parameters) {
        throw new NotImplementedException("EXISTS operator not supported.");
    }

    @Override
    public Boolean getResult(ProcessingContext context)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<AbstractAggregationOperand> getAggregationOperands() {
        throw new NotImplementedException("EXISTS operator not supported.");
    }

    @Override
    public String toReadableString()
    {
        throw new UnsupportedOperationException();
    }
}
