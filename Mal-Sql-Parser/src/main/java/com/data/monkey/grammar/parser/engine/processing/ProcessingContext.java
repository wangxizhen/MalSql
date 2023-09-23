package com.data.monkey.grammar.parser.engine.processing;

import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractAggregationOperand;
import lombok.Getter;

import java.util.Map;
import java.util.concurrent.Future;

@Getter
public class ProcessingContext {
    private Map<AbstractAggregationOperand, Future<Double>> aggregationValues;
    private ReadableEvent event;

    public ProcessingContext(Map<AbstractAggregationOperand, Future<Double>> aggregationValues, ReadableEvent event)
    {
        this.aggregationValues = aggregationValues;
        this.event = event;
    }

    public long getTimeStamp()
    {
        return event.getTimeStamp();
    }

    @Override
    public String toString() {
        return event.toString();
    }
}
