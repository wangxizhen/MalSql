package com.data.monkey.grammar.parser.engine.booleanExprs;



import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractAggregationOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IBooleanExpression {
    /**
     * @param currEvent  current event data
     * @param events     raw event data
     * @param parameters rule parameters
     * @return
     */
    boolean getResult(Event currEvent, List<Event> events, Map<String, String> parameters);


    Boolean getResult(ProcessingContext context);

    Set<AbstractAggregationOperand> getAggregationOperands();

    /**
     * @return
     *
     * @since 3.0.0
     */
    String toReadableString();
}
