package com.data.monkey.grammar.parser.engine.operands;


import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractAggregationOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;
import java.util.Set;


@Data
@AllArgsConstructor
@EqualsAndHashCode
public class AliasOperand implements Operand {
    private final Operand operand;
    private final String alias;

    @Override
    public Object getValue(Event currEvent, List<Event> events, Map<String, String> parameters) {
        return operand.getValue(currEvent, events, parameters);
    }

    @Override
    public Object getValue(ProcessingContext context)
    {
        return operand.getValue(context);
    }

    @Override
    public Set<AbstractAggregationOperand> getAggregationOperands() {
        return operand.getAggregationOperands();
    }

    @Override
    public String toReadableString()
    {
        return this.getAlias();
    }
}
