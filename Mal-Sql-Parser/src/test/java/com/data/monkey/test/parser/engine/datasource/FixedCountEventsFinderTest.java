package com.data.monkey.test.parser.engine.datasource;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.DefaultEventsProvider;
import com.data.monkey.grammar.parser.engine.IEventsProvider;
import com.data.monkey.grammar.parser.engine.datasource.EventsFinder;

import com.data.monkey.grammar.parser.engine.datasource.FixedCountEventsFinder;
import com.data.monkey.grammar.parser.engine.operands.primitives.IntegerOperand;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.Assert.*;


public class FixedCountEventsFinderTest {

    private EventsFinder finder;

    @Test
    //取列表中最后fixedCount事件
    public void testGetEvents() {
        int fixedCount = 3;

        String key = "key1";
        Map<String, String> raw = new HashMap<>();
        long endTime = new Date().getTime();

        List<Event> result = new ArrayList<>();

        Event e = new Event(key, raw, endTime);

        result.add(e);

        result.add(new Event(key, raw ,endTime - 1000));
        result.add(new Event(key, raw, endTime - 2000));
        result.add(new Event(key, raw,  endTime - 2000));
        result.add(new Event(key, raw, endTime - 2000));
        result.add(new Event(key, raw,  endTime - 2000));
        result.add(new Event(key, raw,  endTime - 2000));
        result.add(new Event(key, raw, endTime - 2000));
        result.add(new Event(key, raw,  endTime - 3000));
        IEventsProvider provider = new DefaultEventsProvider(result);

        finder = FixedCountEventsFinder.newInstance(new IntegerOperand(fixedCount));
        finder.setProvider(provider);

        List<Event> events = finder.backwardFrom(e, null);

        assertTrue(!events.contains(e));
    }

    @Test
    public void testGetEventsSizeLessThanFixedCount() {

        int fixedCount = 3;

        String key = "key1";
        Map<String, String> raw = new HashMap<>();
        long endTime = new Date().getTime();

        IEventsProvider provider = Mockito.mock(IEventsProvider.class);
        List<Event> result = new ArrayList<>();
        result.add(new Event(key, raw,endTime - 1000));
        Mockito.when(provider.getEventsByFixedCount(fixedCount)).thenReturn(result);

        finder = FixedCountEventsFinder.newInstance(new IntegerOperand(fixedCount));
        finder.setProvider(provider);

        Event e = new Event(key, raw, endTime);

        List<Event> events = finder.backwardFrom(e, null);

        assertEquals(1, events.size());
        assertFalse(events.contains(e));
    }

    @Test
    public void testGetEmptyEvents() {

        int fixedCount = 3;

        String key = "key1";
        Map<String, String> raw = new HashMap<>();
        long endTime = new Date().getTime();

        IEventsProvider provider = Mockito.mock(IEventsProvider.class);
        Mockito.when(provider.getEventsByFixedCount(fixedCount)).thenReturn(null);

        finder = FixedCountEventsFinder.newInstance(new IntegerOperand(fixedCount));
        finder.setProvider(provider);

        Event e = new Event(key, raw, endTime);

        List<Event> events = finder.backwardFrom(e, null);

        assertEquals(0, events.size());
        assertFalse(events.contains(e));

    }

}
