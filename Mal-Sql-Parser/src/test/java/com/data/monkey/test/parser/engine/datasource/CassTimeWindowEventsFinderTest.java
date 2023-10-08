package com.data.monkey.test.parser.engine.datasource;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.IEventsProvider;
import com.data.monkey.grammar.parser.engine.datasource.CassTimeWindowEventsFinder;
import com.data.monkey.grammar.parser.engine.datasource.EventsFinder;
import com.data.monkey.grammar.parser.engine.operands.primitives.IntegerOperand;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CassTimeWindowEventsFinderTest {

    private EventsFinder finder;

    @Test
    public void testGetEvents() {

        int timeWindow = 3;
        int delay = 10;

        String key = "key1";
        Map<String, String> raw = new HashMap<>();

        /**
         * start        end       current
         * |---window---|--delay--|
         */
        long currentTime = System.currentTimeMillis();
        long endTime = currentTime - TimeUnit.MINUTES.toMillis(delay);
        long startTime = endTime - TimeUnit.MINUTES.toMillis(timeWindow);

        IEventsProvider provider = Mockito.mock(IEventsProvider.class);

        List<Event> result = new ArrayList<>();
        Event event1 = new Event(key, raw, endTime - 1000);
        result.add(event1);
        Event event2 = new Event(key, raw, endTime - 2000);
        result.add(event2);


        Mockito.when(provider.getEventsByTimeWindow(key, startTime, endTime))
                .thenReturn(result);

        finder = CassTimeWindowEventsFinder.newInstance(new IntegerOperand(-delay), 60 * 1000, new IntegerOperand(timeWindow), 60 * 1000);

        finder.setProvider(provider);

        Event e = new Event(key, raw, currentTime);
        List<Event> events = finder.backwardFrom(e, null);

        assertEquals(2, events.size());
        assertTrue(events.contains(event1));
        assertTrue(events.contains(event2));
    }
}
