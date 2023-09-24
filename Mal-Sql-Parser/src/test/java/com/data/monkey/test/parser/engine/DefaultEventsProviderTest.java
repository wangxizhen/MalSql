package com.data.monkey.test.parser.engine;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.DefaultEventsProvider;
import com.data.monkey.grammar.parser.engine.IEventsProvider;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class DefaultEventsProviderTest {

    @Test
    public void getFixedCountEvents() {

        String key = "key1";
        Map<String, String> raw = new HashMap<>();
        long endTime = System.currentTimeMillis();

        Event event1 = new Event(key, raw, endTime - 4000);
        Event event2 = new Event(key, raw, endTime - 3000);
        Event event3 = new Event(key, raw, endTime - 2000);
        Event event4 = new Event(key, raw, endTime);

        IEventsProvider provider = new DefaultEventsProvider(Lists.newArrayList(event1, event2, event3, event4));

        List<Event> result = provider.getEventsByFixedCount(2);
        assertEquals(2, result.size());
        assertTrue(result.contains(event3));
        assertTrue(result.contains(event4));

        result = provider.getEventsByFixedCount(5);
        assertEquals(4, result.size());
    }

    @Test
    public void getEventsByTimeWindow() {
        String key = "key1";
        Map<String, String> raw = new HashMap<>();
        long endTime = System.currentTimeMillis();

        Event event1 = new Event(key, raw, endTime - 4000);
        Event event2 = new Event(key, raw, endTime - 3000);
        Event event3 = new Event(key, raw, endTime - 2000);
        Event event4 = new Event(key, raw, endTime);

        IEventsProvider provider = new DefaultEventsProvider(Lists.newArrayList(event1, event2, event3, event4));

        List<Event> result = provider.getEventsByTimeWindow(key, endTime - 4000, endTime);
        assertEquals(3, result.size());
        assertTrue(result.contains(event2));
        assertTrue(result.contains(event3));
        assertTrue(result.contains(event4));

        result = provider.getEventsByTimeWindow(key, endTime - 4001, endTime);
        assertEquals(4, result.size());
    }
}
