package com.data.monkey.grammar.parser.engine;

import com.data.monkey.common.entity.Event;
import com.google.common.collect.Lists;
import lombok.NonNull;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;


public class DefaultEventsProvider implements IEventsProvider {

    private Iterable<Event> events;

    public DefaultEventsProvider(@NonNull Iterable<Event> events) {
        this.events = events;
    }

    @Override
    public List<Event> getAllEvent() {
        return Lists.newLinkedList(events);
    }

    @Override
    public List<Event> getEventsByFixedCount(int count) {

        List<Event> eventList = Lists.newLinkedList(events);

        int endIndex = eventList.size();
        int startIndex = (endIndex - count > 0) ? endIndex - count : 0;
        return Lists.newArrayList(eventList.subList(startIndex, endIndex));
    }

    @Override
    public List<Event> getEventsByTimeWindow(String key, long startTime, long endTime, boolean totalMatch) {
        if (!totalMatch || fitBuffer(Lists.newArrayList(events), startTime, endTime)) {
            return stream(events.spliterator(), false)
                .filter(event -> startTime < event.getTimestamp() && event.getTimestamp() <= endTime)
                .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public List<Event> getEventsByTimeWindow(String key, long startTime, long endTime) {
        return getEventsByTimeWindow(key, startTime, endTime, false);
    }

    private boolean fitBuffer(List<Event> events, long startTime, long endTime) {
        return !events.isEmpty() && events.get(0).getTimestamp() <= startTime + TimeUnit.MINUTES.toMillis(1) && events.get(events.size() - 1).getTimestamp() == endTime;
    }

    @Override
    public Event getThePreviousEvent(@NonNull Event event) {
        Iterator<Event> iterator = events.iterator();
        Event previousEvent;
        if (iterator.hasNext()) {
            previousEvent = iterator.next();
            while (iterator.hasNext()) {
                Event currentEvent = iterator.next();
                if (event.equals(currentEvent)) {
                    return previousEvent;
                } else {
                    previousEvent = currentEvent;
                }
            }
        }
        return null;
    }


}
