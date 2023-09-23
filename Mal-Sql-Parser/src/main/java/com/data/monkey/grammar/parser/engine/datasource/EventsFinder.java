package com.data.monkey.grammar.parser.engine.datasource;


import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.IEventsProvider;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;


public abstract class EventsFinder {

    @Setter
    @Getter
    protected IEventsProvider provider;

    public abstract List<Event> backwardFrom(Event event, Map<String, String> params);

    protected void createProvider() {
        ServiceLoader<IEventsProvider> serviceLoader = ServiceLoader.load(IEventsProvider.class);
        for(IEventsProvider o : serviceLoader) {
            provider = o;
        }
    }
}
