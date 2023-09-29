package com.data.monkey.grammar.parser.engine.operands;



import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractAggregationOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Operand {
    /**
     * get value represents by this operand.
     *
     * @param events
     * @param parameters
     * @return
     */
    @Deprecated
    Object getValue(List<Event> events, Map<String, String> parameters);

    /**
     * @param context
     *
     * @return
     *
     * @since 3.0.0
     */
    Object getValue(ProcessingContext context);

    /**
     * get possible aggregation operands
     *
     * @return
     *
     * @since 3.0.0
     */
    Set<AbstractAggregationOperand> getAggregationOperands();

    /**
     * @return
     *
     * @since 3.0.0
     */
    String toReadableString();
}
