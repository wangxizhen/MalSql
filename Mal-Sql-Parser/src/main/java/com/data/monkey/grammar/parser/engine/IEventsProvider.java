package com.data.monkey.grammar.parser.engine;


import com.data.monkey.common.entity.Event;

import java.util.List;


public interface IEventsProvider {

    List<Event> getAllEvent();

    /**
     * query fixed count events
     * @param count
     * @return
     */
    List<Event> getEventsByFixedCount(int count);

    /**
     * query events in time window (startTime, endTime)
     * @param key
     * @param startTime
     * @param endTime
     * @return
     */
    List<Event> getEventsByTimeWindow(String key, long startTime, long endTime, boolean totalMatch);
    List<Event> getEventsByTimeWindow(String key, long startTime, long endTime);

    /**
     * Query the event before current event
     * @param event
     * @return {@link Event}
     */
    Event getThePreviousEvent(Event event);


}
