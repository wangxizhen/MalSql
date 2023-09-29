package com.data.monkey.test.parser.engine.operands;


import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.NameOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import com.data.monkey.grammar.parser.engine.processing.ReadableEvent;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class NameOperandTest {


    @Test
    public void testGetValue() {
        NameOperand name = new NameOperand(null, "test");
        Map<String, String> raw = new HashMap<String, String>();
        raw.put("test", "0.098");
        Event e = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);
        assertEquals(0.098, name.getValue( Arrays.asList(e), null));
    }

    @Test
    public void extracts_expected_value_from_event()
    {
        final ReadableEvent event = Mockito.mock(ReadableEvent.class);
        Mockito.when(event.readValue("nm1")).thenReturn(Optional.empty());
        Mockito.when(event.readValue("st1.nm1")).thenReturn(Optional.of("asdf"));
        final ProcessingContext context = new ProcessingContext(null, event);

        final NameOperand nameOperand = new NameOperand("st1", "nm1");
        final Object value = nameOperand.getValue(context);
        assertEquals("asdf", value);
    }

    @Test
    public void extracts_null_value_from_event()
    {
        final ReadableEvent event = Mockito.mock(ReadableEvent.class);
        Mockito.when(event.readValue("nm1")).thenReturn(Optional.empty());
        Mockito.when(event.readValue("st1.nm1")).thenReturn(Optional.empty());
        final ProcessingContext context = new ProcessingContext(null, event);

        final NameOperand nameOperand = new NameOperand("st1", "nm1");
        final Object value = nameOperand.getValue(context);
        assertNull(value);
    }

    @Test
    public void returns_full_name_when_stream_name_is_not_empty()
    {
        final NameOperand nameOperand = new NameOperand("asdf", "asdf");
        assertEquals("asdf.asdf", nameOperand.toReadableString());
    }

    @Test
    public void returns_simple_name_when_stream_name_is_empty()
    {
        final NameOperand nameOperand = new NameOperand("", "asdf");
        assertEquals("asdf", nameOperand.toReadableString());
    }
}
