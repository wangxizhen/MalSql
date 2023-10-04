package com.data.monkey.test.parser.engine.operands.aggregations;


import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.conditionExprs.AndCondition;
import com.data.monkey.grammar.parser.engine.conditionExprs.BooleanExprBase;
import com.data.monkey.grammar.parser.engine.conditionExprs.numerical.GreatCondition;
import com.data.monkey.grammar.parser.engine.operands.NameOperand;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AvgOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.IntegerOperand;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AvgOperandTest {


    @Test
    public void testGetValue() {
        NameOperand name = new NameOperand(null, "test");
        NameOperand name2 = new NameOperand(null, "test2");
        NameOperand name3 = new NameOperand(null, "test3");

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

        AvgOperand avg = new AvgOperand(name);

        double actual = Double.parseDouble(avg.getValue(Arrays.asList(e1, e2, e3), null).toString());
        Assert.assertEquals(0.137, actual, 0.001);

        avg = new AvgOperand(name2);
        actual = Double.parseDouble(avg.getValue(Arrays.asList(e1, e2, e3), null).toString());
        Assert.assertEquals(0.20, actual, 0.001);

        avg = new AvgOperand(name3);
        actual = Double.parseDouble(avg.getValue(Arrays.asList(e1, e2, e3), null).toString());
        Assert.assertEquals(0.0, actual, 0.001);
    }

    @Test
    public void testAvgOfStringValues() {
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

        AvgOperand avg = new AvgOperand(name);

        double actual = Double.parseDouble(avg.getValue(Arrays.asList(e1, e2, e3), null).toString());
        Assert.assertEquals(1.0, actual, 0.001);
    }

    @Test
    public void testAvgWithInnerPredicate() {
        BooleanExprBase booleanExprBase = new GreatCondition(new NameOperand("table", "test"), new IntegerOperand(1));

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("test", "2");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "1");
        Event e2 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "3");
        Event e3 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        AvgOperand avg = new AvgOperand(booleanExprBase);

        Assert.assertEquals(2.5, avg.getValue( Arrays.asList(e1, e2, e3), null));
    }

    @Test
    public void testAvgAfterAllElements() {
        // avg(val > 1)
        BooleanExprBase booleanExprBase = new GreatCondition(new NameOperand("table", "test"), new IntegerOperand(1));

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("test", "0");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "1");
        Event e2 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "-1");
        Event e3 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        AvgOperand avg = new AvgOperand(booleanExprBase);

        Assert.assertEquals(0.0, avg.getValue(Arrays.asList(e1, e2, e3), null));
    }

    @Test
    public void testAvgWithInnerPredicates() {
        // avg(val > 1)
        BooleanExprBase left = new GreatCondition(new NameOperand("table", "test"), new IntegerOperand(1));
        BooleanExprBase right = new GreatCondition(new NameOperand("table", "test2"), new IntegerOperand(3));
        AndCondition andExpr = new AndCondition(left, right);

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("test", "2");
        raw.put("test2", "4");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "2");
        raw.put("test2", "0");
        Event e2 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "3");
        raw.put("test2", "5");
        Event e3 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        AvgOperand avg = new AvgOperand(andExpr);

        Assert.assertEquals(2.5, avg.getValue(Arrays.asList(e1, e2, e3), null));
    }

    @Test
    public void testAvgWithSpecificNameAndInnerPredicates() {
        // avg(val > 1)
        BooleanExprBase left = new GreatCondition(new NameOperand("table", "test"), new IntegerOperand(1));
        BooleanExprBase right = new GreatCondition(new NameOperand("table", "test2"), new IntegerOperand(3));
        AndCondition andExpr = new AndCondition(left, right);

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("test", "2");
        raw.put("test2", "4");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "2");
        raw.put("test2", "0");
        Event e2 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "3");
        raw.put("test2", "5");
        Event e3 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        AvgOperand avgOperand = new AvgOperand(new NameOperand("table", "test"), andExpr);

        Assert.assertEquals(2.5, avgOperand.getValue(Arrays.asList(e1, e2, e3), null));

        avgOperand = new AvgOperand(new NameOperand("table", "test2"), andExpr);

        Assert.assertEquals(4.5, avgOperand.getValue( Arrays.asList(e1, e2, e3), null));
    }

}
