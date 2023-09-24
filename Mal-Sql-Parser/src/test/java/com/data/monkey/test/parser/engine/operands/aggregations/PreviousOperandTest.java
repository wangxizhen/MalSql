package com.data.monkey.test.parser.engine.operands.aggregations;


import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.booleanExprs.BooleanExprAND;
import com.data.monkey.grammar.parser.engine.booleanExprs.BooleanExprBase;
import com.data.monkey.grammar.parser.engine.booleanExprs.BooleanExprEQ;
import com.data.monkey.grammar.parser.engine.booleanExprs.BooleanExprNE;
import com.data.monkey.grammar.parser.engine.booleanExprs.numerical.BooleanExprGT;
import com.data.monkey.grammar.parser.engine.operands.NameOperand;
import com.data.monkey.grammar.parser.engine.operands.aggregations.PreviousOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.IntegerOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.StringOperand;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PreviousOperandTest {


    @Test
    public void testGetValue() {
        NameOperand name = new NameOperand(null, "test");

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("test", "0.20");
        raw.put("test2", "0.20");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "0.11");
        Event e2 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "0.1");
        Event e3 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        PreviousOperand previousOperand = new PreviousOperand(name);

        double actual = Double.parseDouble(previousOperand.getValue(e3, Arrays.asList(e1, e2, e3), null).toString());
        Assert.assertEquals(0.11, actual, 0.001);

    }

    @Test
    public void testPreviousOperandOfStringValues() {
        NameOperand name = new NameOperand(null, "test");

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("test", "a");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "b");
        Event e2 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "1");
        Event e3 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        PreviousOperand avg = new PreviousOperand(name);

        Object actual = avg.getValue(e3, Arrays.asList(e1, e2, e3), null).toString();
        Assert.assertEquals("b", actual);
    }

    @Test
    public void testPreviousOperandAfterFilterAllElements() {
        // previous(test > 1)
        BooleanExprBase booleanExprBase = new BooleanExprGT(new NameOperand("table", "test"), new IntegerOperand(1));

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("test", "0");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "1");
        Event e2 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "-1");
        Event e3 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        PreviousOperand previousOperand = new PreviousOperand(booleanExprBase);

        Assert.assertEquals(0.0, previousOperand.getValue(e3, Arrays.asList(e1, e2, e3), null));


        // previous(test = "a")
        booleanExprBase = new BooleanExprEQ(new NameOperand("table", "test"), new StringOperand("a"));

        raw = new HashMap<String, String>();
        raw.put("test", "b");
        Event e4 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);
        previousOperand = new PreviousOperand(booleanExprBase);

        raw = new HashMap<String, String>();
        raw.put("test", "b");
        Event e5 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);
        previousOperand = new PreviousOperand(booleanExprBase);

        Assert.assertEquals("", previousOperand.getValue(e5, Arrays.asList(e4, e5), null));

    }

    @Test
    public void testPreviousOperandWithInnerPredicate() {
        // previous(test != "WARNING")
        BooleanExprBase booleanExprBase = new BooleanExprNE(new NameOperand("table", "test"), new StringOperand("WARNING"));

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("test", "NORMAL");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "WARNING");
        Event e2 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "WARNING");
        Event e3 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        PreviousOperand previousOperand = new PreviousOperand(booleanExprBase);

        Assert.assertEquals("NORMAL", previousOperand.getValue(e3, Arrays.asList(e1, e2, e3), null));
    }

    @Test
    public void testPreviousOperandWithSpecificNameAndInnerPredicates() {
        // previous(test, test > 1 and test2 > 3)
        BooleanExprBase left = new BooleanExprGT(new NameOperand("table", "test"), new IntegerOperand(1));
        BooleanExprBase right = new BooleanExprGT(new NameOperand("table", "test2"), new IntegerOperand(3));
        BooleanExprAND andExpr = new BooleanExprAND(left, right);

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("test", "2");
        raw.put("test2", "4");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "2");
        raw.put("test2", "0");
        Event e2 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "0");
        raw.put("test2", "5");
        Event e3 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "3");
        raw.put("test2", "5");
        Event e4 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        PreviousOperand previousOperand = new PreviousOperand(new NameOperand("table", "test"), andExpr);

        Assert.assertEquals(2.0, previousOperand.getValue(e4, Arrays.asList(e1, e2, e3, e4), null));

        previousOperand = new PreviousOperand(new NameOperand("table", "test2"), andExpr);

        Assert.assertEquals(4.0, previousOperand.getValue(e4, Arrays.asList(e1, e2, e3, e4), null));
    }

}
