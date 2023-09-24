package com.data.monkey.test.parser.engine.datasource;


import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.IEventsProvider;
import com.data.monkey.grammar.parser.engine.datasource.EventsFinder;
import com.data.monkey.grammar.parser.engine.datasource.TimeWindowEventsFinder;
import com.data.monkey.grammar.parser.engine.operands.primitives.IntegerOperand;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;
import java.util.concurrent.TimeUnit;



public class TimeWindowEventsFinderTest {

    private EventsFinder finder;

    @Test
    public void testGetEvents() {

        int timeWindow = 3;

        String key = "key1";
        Map<String, String> raw = new HashMap<>();
        long endTime = new Date().getTime();

        IEventsProvider provider = Mockito.mock(IEventsProvider.class);
        List<Event> result = new ArrayList<>();
        result.add(new Event(key, raw, UUID.randomUUID(), endTime - 1000, 0, 0));
        result.add(new Event(key, raw, UUID.randomUUID(), endTime - 2000, 0, 0));

        Event e = new Event(key, raw, UUID.randomUUID(), endTime, 0, 0);
        result.add(e);

        Mockito.when(provider.getEventsByTimeWindow(key, endTime - TimeUnit.MINUTES.toMillis(timeWindow), endTime)).thenReturn(result);

        finder = TimeWindowEventsFinder.newInstance(new IntegerOperand(timeWindow), 60 * 1000);

//        assertNotNull(finder.getProvider());
        // reset provider
        finder.setProvider(provider);


        List<Event> events = finder.backwardFrom(e, null);

    }

}
