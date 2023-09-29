package com.data.monkey.grammar.parser.engine.datasource;



import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.Operand;

import java.util.Collections;
import java.util.List;
import java.util.Map;


public class TimeWindowEventsFinder extends EventsFinder {

    private Operand timeWindowOperand;
    private long unitInMills;

    TimeWindowEventsFinder(Operand timeWindowOperand, long unitInMills) {

        this.timeWindowOperand = timeWindowOperand;
        this.unitInMills = unitInMills;
    }

    public static EventsFinder newInstance(Operand timeWindowOperand, long unitInMills) {

        EventsFinder instance = new TimeWindowEventsFinder(timeWindowOperand, unitInMills);
//        instance.createProvider();

        return instance;
    }

    /**
     *
     * @param event
     * @param params
     * @return
     */
    @Override
    public List<Event> backwardFrom(Event event, Map<String, String> params) {
        if(provider == null)
            throw new NullPointerException("EventsProvider instance not found.");

        if (null == event) {
            return Collections.emptyList();
        }

        try {
            Double timeWindow = Double.parseDouble(timeWindowOperand.getValue( null, params).toString());

            if(timeWindow <= 0) {
                throw new IllegalArgumentException("time window value must be a positive number.");
            }

            Double timeWindowInMills = timeWindow * unitInMills;

            long startTime = event.getTimestamp() - timeWindowInMills.longValue();

            boolean totalMatch = null != params && "true".equalsIgnoreCase(params.get("totalMatch"));
            return provider.getEventsByTimeWindow("", startTime, event.getTimestamp(), totalMatch);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("time window value must be a positive number.", e);
        }
    }
}
