package com.data.monkey.grammar.parser.engine.datasource;



import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.Operand;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class FixedCountEventsFinder extends EventsFinder {

    private Operand fixedCountOperand;

    FixedCountEventsFinder(Operand fixedCountOperand) {
        this.fixedCountOperand = fixedCountOperand;
    }

    public static EventsFinder newInstance(Operand fixedCountOperand) {

        EventsFinder instance = new FixedCountEventsFinder(fixedCountOperand);
//        instance.createProvider();

        return instance;
    }

    @Override
    public List<Event> backwardFrom(Event event, Map<String, String> params) {
        if(provider == null)
            throw new  NullPointerException("EventsProvider instance not found.");

        try {
            Double fixedCount = Double.parseDouble(fixedCountOperand.getValue(event, null, params).toString());

            if(fixedCount <= 0) {
                throw new IllegalArgumentException("events count must be a positive integer.");
            }

            List<Event> events = provider.getEventsByFixedCount(fixedCount.intValue());
            if (events == null) {
                events = new ArrayList<>();
            }

            return events;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("events count must be a positive integer.", e);
        }
    }
}
