package com.data.monkey.test.parser.engine.operands.aggregations;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.conditionExprs.AndCondition;
import com.data.monkey.grammar.parser.engine.conditionExprs.BooleanExprBase;
import com.data.monkey.grammar.parser.engine.conditionExprs.numerical.GreatCondition;
import com.data.monkey.grammar.parser.engine.operands.NameOperand;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractAggregationOperand;
import com.data.monkey.grammar.parser.engine.operands.aggregations.MinOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.FloatOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.IntegerOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MinOperandTest {


    @Test
    public void testMinOfDoubleValues() {
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

        MinOperand min = new MinOperand(name);
        Assert.assertEquals(0.1, min.getValue(Arrays.asList(e1, e2, e3), null));

        min = new MinOperand(name2);
        Assert.assertEquals(0.2, min.getValue(Arrays.asList(e1, e2, e3), null));

        min = new MinOperand(name3);
        Assert.assertEquals(0.0, min.getValue(Arrays.asList(e1, e2, e3), null));
    }

    @Test
    public void testMinOfStringValues() {
        NameOperand name = new NameOperand(null, "test");

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("test", "a");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "b");
        Event e2 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "c");
        Event e3 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        MinOperand min = new MinOperand(name);
        Assert.assertEquals(0.0, min.getValue(Arrays.asList(e1, e2, e3), null));
    }

    @Test
    public void testMinAfterFilter() {
        BooleanExprBase booleanExprBase = new GreatCondition(new NameOperand("table", "test"), new FloatOperand(1.0));

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("test", "1.20");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "1");
        Event e2 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "2.1");
        Event e3 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        MinOperand min = new MinOperand(booleanExprBase);

        Assert.assertEquals(1.20, min.getValue(Arrays.asList(e1, e2, e3), null));
    }

    @Test
    public void testMinAfterFilterAllElements() {
        BooleanExprBase booleanExprBase = new GreatCondition(new NameOperand("table", "test"), new FloatOperand(1.0));

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("test", "0.20");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "0.1");
        Event e2 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        MinOperand min = new MinOperand(booleanExprBase);

        Assert.assertEquals(0.0, min.getValue(Arrays.asList(e1, e2), null));
    }

    @Test
    public void testMinWithSpecificNameAndInnerPredicates() {
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

        MinOperand minOperand = new MinOperand(new NameOperand("table", "test"), andExpr);

        Assert.assertEquals(2.0, minOperand.getValue(Arrays.asList(e1, e2, e3), null));

        minOperand = new MinOperand(new NameOperand("table", "test2"), andExpr);

        Assert.assertEquals(4.0, minOperand.getValue(Arrays.asList(e1, e2, e3), null));
    }


    @Test
    public void get_name_returns_correct_result()
    {
        final Operand mock = Mockito.mock(Operand.class);
        Mockito.when(mock.toReadableString()).thenReturn("asdf");
        assertEquals("min(asdf)", new MinOperand(mock).toReadableString());
    }

    @Test
    public void get_value_returns_default_aggregation_value_when_future_result_not_found()
    {
        final MinOperand minOperand = new MinOperand(Mockito.mock(Operand.class));
        final Object actual = minOperand.getValue(new ProcessingContext(Maps.newHashMap(), null));
        assertEquals(Double.MAX_VALUE, actual);
    }

    @Test
    public void get_value_returns_value_from_future_result()
    {
        final MinOperand minOperand = new MinOperand(Mockito.mock(Operand.class));
        final HashMap<AbstractAggregationOperand, Future<Double>> aggregationValues = Maps.newHashMap();
        aggregationValues.put(minOperand, Futures.immediateFuture(5.0D));
        final Object actual = minOperand.getValue(new ProcessingContext(aggregationValues, null));
        assertEquals(5.0D, actual);
    }

    @Test
    public void returns_sef_in_the_aggregation_operands_set()
    {
        final MinOperand minOperand = new MinOperand(Mockito.mock(Operand.class));
        assertEquals(Sets.newHashSet(minOperand), minOperand.getAggregationOperands());
    }

    @Test
    public void aggregation_function_returns_mim_value()
    {
        assertEquals(1.0, new MinOperand(Mockito.mock(Operand.class)).getAggregationFunction().apply(1.0, 5.0), 0.1);
    }

    @Test
    public void object_equals_and_hash_code()
    {
        final NameOperand nameOperand1 = new NameOperand("", "n1");
        final NameOperand nameOperand2 = new NameOperand("", "n2");

        assertNotEquals(new MinOperand(nameOperand1), new MinOperand(nameOperand2));
        assertEquals(new MinOperand(nameOperand1), new MinOperand(nameOperand1));

        assertNotEquals(new MinOperand(nameOperand1).hashCode(), new MinOperand(nameOperand2).hashCode());
        assertEquals(new MinOperand(nameOperand1).hashCode(), new MinOperand(nameOperand1).hashCode());
    }


}
