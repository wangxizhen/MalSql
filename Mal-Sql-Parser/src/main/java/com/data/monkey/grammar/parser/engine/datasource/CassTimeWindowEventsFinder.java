package com.data.monkey.grammar.parser.engine.datasource;



import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.Operand;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CassTimeWindowEventsFinder extends EventsFinder {
    private Operand delayNumberOperand;
    private int delayUnit;
    private Operand durationNumberOperand;
    private int durationUnit;

    private CassTimeWindowEventsFinder(Operand delayNumberOperand, int delayUnit, Operand durationNumberOperand, int durationUnit) {

        this.delayNumberOperand = delayNumberOperand;
        this.delayUnit = delayUnit;
        this.durationNumberOperand = durationNumberOperand;
        this.durationUnit = durationUnit;
    }

    public static EventsFinder newInstance(Operand delayNumberOperand, int delayUnit, Operand durationNumberOperand, int durationUnit) {
        return new CassTimeWindowEventsFinder(delayNumberOperand, delayUnit, durationNumberOperand, durationUnit);
    }

    @Override
    public List<Event> backwardFrom(Event event, Map<String, String> params) {
        if(provider == null)
            throw new  NullPointerException("EventsProvider instance not found.");

        List<Event> events = null;
        try {

            Double delayNum = Double.parseDouble(delayNumberOperand.getValue(event, null, params).toString());
            Double durationNum = Double.parseDouble(durationNumberOperand.getValue(event, null, params).toString());

            if(durationNum <= 0)
                throw new IllegalArgumentException("duration must be a positive number.");

            Double delayInMills = delayNum * delayUnit;
            Double durationInMills = durationNum * durationUnit;

            long endTime = event.getTimestamp() + delayInMills.longValue();
            long startTime = endTime - durationInMills.longValue();

            events = provider.getEventsByTimeWindow(event.getKey(), startTime, endTime);

            if (events == null) {
                events = new ArrayList<>();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("delay or duration value must be a number.", e);
        }

        return events;
    }
}




