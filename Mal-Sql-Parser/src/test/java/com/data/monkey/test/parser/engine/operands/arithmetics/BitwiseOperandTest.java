package com.data.monkey.test.parser.engine.operands.arithmetics;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.NameOperand;
import com.data.monkey.grammar.parser.engine.operands.arithmetics.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BitwiseOperandTest {

    @Test
    public void testBitwiseAnd() {
        NameOperand name1 = new NameOperand(null, "key1");
        NameOperand name2 = new NameOperand(null, "key2");

        BitwiseAndOperand andOperand = new BitwiseAndOperand(name1, name2);

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("key1", "19");
        raw.put("key2", "3");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        Assert.assertEquals(3.0, andOperand.getValue( Arrays.asList(e1), null));

        raw = new HashMap<String, String>();
        raw.put("key1", "19");
        raw.put("key2", "17");
        e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);
        Assert.assertEquals(17.0, andOperand.getValue(Arrays.asList(e1), null));

    }

    @Test
    public void testBitwiseOr() {
        NameOperand name1 = new NameOperand(null, "key1");
        NameOperand name2 = new NameOperand(null, "key2");

        BitwiseOrOperand orOperand = new BitwiseOrOperand(name1, name2);

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("key1", "12");
        raw.put("key2", "6");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        Assert.assertEquals(14.0, orOperand.getValue(Arrays.asList(e1), null));
    }

    @Test
    public void testBitwiseXor() {
        NameOperand name1 = new NameOperand(null, "key1");
        NameOperand name2 = new NameOperand(null, "key2");

        BitwiseXorOperand xorOperand = new BitwiseXorOperand(name1, name2);

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("key1", "12");
        raw.put("key2", "6");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        Assert.assertEquals(10.0, xorOperand.getValue( Arrays.asList(e1), null));
    }

    @Test
    public void testBitwiseShl() {
        NameOperand name1 = new NameOperand(null, "key1");
        NameOperand name2 = new NameOperand(null, "key2");

        BitwiseShlOperand shlOperand = new BitwiseShlOperand(name1, name2);

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("key1", "12");
        raw.put("key2", "1");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        Assert.assertEquals(24.0, shlOperand.getValue( Arrays.asList(e1), null));
    }

    @Test
    public void testBitwiseShr() {
        NameOperand name1 = new NameOperand(null, "key1");
        NameOperand name2 = new NameOperand(null, "key2");

        BitwiseShrOperand and = new BitwiseShrOperand(name1, name2);

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("key1", "12");
        raw.put("key2", "2");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        Assert.assertEquals(3.0, and.getValue(Arrays.asList(e1), null));
    }


}
