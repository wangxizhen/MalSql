package com.data.monkey.grammar.parser.engine.operands.aggregations;


import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.params.MoMDuration;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;
import java.util.Map;
import java.util.Set;


@EqualsAndHashCode
public class PeriodOperand implements Operand {

    @Getter
    private MoMDuration duration;


    public PeriodOperand(MoMDuration duration) {
        this.duration = duration;
    }

    @Override
    public Object getValue(Event currEvent, List<Event> events, Map<String, String> parameters) {
        return null;
    }

    @Override
    public Object getValue(ProcessingContext context)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<AbstractAggregationOperand> getAggregationOperands() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toReadableString()
    {
        throw new NotImplementedException("");
    }

}
