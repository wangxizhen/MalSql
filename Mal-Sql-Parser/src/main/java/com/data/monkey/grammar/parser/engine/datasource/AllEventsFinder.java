package com.data.monkey.grammar.parser.engine.datasource;


import com.data.monkey.common.entity.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AllEventsFinder extends EventsFinder {

    public static EventsFinder newInstance() {
        EventsFinder instance = new AllEventsFinder();
        return instance;
    }

    @Override
    public List<Event> backwardFrom(Event event, Map<String, String> params) {
        if (provider == null)
            throw new NullPointerException("EventsProvider instance not found.");

        List<Event> allEvent = provider.getAllEvent();
        if (allEvent == null) {
            allEvent = new ArrayList<>();
        }

        return allEvent;
    }
}
