package com.data.monkey.test.parser.engine.operands.aggregations;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.booleanExprs.BooleanExprAND;
import com.data.monkey.grammar.parser.engine.booleanExprs.BooleanExprBase;
import com.data.monkey.grammar.parser.engine.booleanExprs.numerical.BooleanExprGT;
import com.data.monkey.grammar.parser.engine.operands.NameOperand;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractAggregationOperand;
import com.data.monkey.grammar.parser.engine.operands.aggregations.CountOperand;
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

public class CountOperandTest {


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

        CountOperand countOperand = new CountOperand(name);

        double actual = Double.parseDouble(countOperand.getValue( Arrays.asList(e1, e2, e3), null).toString());
        Assert.assertEquals(3, actual, 0.001);

        countOperand = new CountOperand(name2);

        actual = Double.parseDouble(countOperand.getValue(Arrays.asList(e1, e2, e3), null).toString());
        Assert.assertEquals(1, actual, 0.001);

        countOperand = new CountOperand(name3);

        actual = Double.parseDouble(countOperand.getValue(Arrays.asList(e1, e2, e3), null).toString());
        Assert.assertEquals(0, actual, 0.001);
    }

    @Test
    public void testCountOfStringValues() {
        NameOperand name = new NameOperand(null, "test");

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("test", "a");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "b");
        Event e2 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "2");
        Event e3 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        CountOperand countOperand = new CountOperand(name);

        double actual = Double.parseDouble(countOperand.getValue(Arrays.asList(e1, e2, e3), null).toString());
        Assert.assertEquals(3.0, actual, 0.001);
    }

    @Test
    public void testCountAfterFilter() {
        BooleanExprBase booleanExprBase = new BooleanExprGT(new NameOperand("table", "test"), new IntegerOperand(1));

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("test", "2");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "1");
        Event e2 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "3");
        Event e3 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        CountOperand countOperand = new CountOperand(booleanExprBase);

        Assert.assertEquals(2.0, countOperand.getValue(Arrays.asList(e1, e2, e3), null));
    }

    @Test
    public void testCountAfterFilterAllElements() {
        BooleanExprBase booleanExprBase = new BooleanExprGT(new NameOperand("table", "test"), new IntegerOperand(5));

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("test", "0.5");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "1");
        Event e2 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "2");
        Event e3 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        CountOperand countOperand = new CountOperand(booleanExprBase);

        Assert.assertEquals(0.0, countOperand.getValue(Arrays.asList(e1, e2, e3), null));
    }

    @Test
    public void testCountWithSpecificNameAndInnerPredicates() {
        // avg(val > 1)
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
        raw.put("test", "3");
        raw.put("test2", "5");
        Event e3 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        CountOperand countOperand = new CountOperand(new NameOperand("table", "test"), andExpr);

        Assert.assertEquals(2.0, countOperand.getValue(Arrays.asList(e1, e2, e3), null));
    }


    @Test
    public void get_name_returns_correct_result()
    {
        final Operand mock = Mockito.mock(Operand.class);
        Mockito.when(mock.toReadableString()).thenReturn("asdf");
        assertEquals("count(asdf)", new CountOperand(mock).toReadableString());
    }

    @Test
    public void get_value_returns_default_aggregation_value_when_future_result_not_found()
    {
        final CountOperand countOperand = new CountOperand(Mockito.mock(Operand.class));
        final Object actual = countOperand.getValue(new ProcessingContext(Maps.newHashMap(), null));
        assertEquals(0.0D, actual);
    }

    @Test
    public void get_value_returns_value_from_future_result()
    {
        final CountOperand countOperand = new CountOperand(Mockito.mock(Operand.class));
        final HashMap<AbstractAggregationOperand, Future<Double>> aggregationValues = Maps.newHashMap();
        aggregationValues.put(countOperand, Futures.immediateFuture(5.0D));
        final Object actual = countOperand.getValue(new ProcessingContext(aggregationValues, null));
        assertEquals(5.0D, actual);
    }

    @Test
    public void returns_sef_in_the_aggregation_operands_set()
    {
        final CountOperand countOperand = new CountOperand(Mockito.mock(Operand.class));
        assertEquals(Sets.newHashSet(countOperand), countOperand.getAggregationOperands());
    }

    @Test
    public void aggregation_function_returns_count_value()
    {
        assertEquals(2.0, new CountOperand(Mockito.mock(Operand.class)).getAggregationFunction().apply(1.0, 5.0), 0.1);
    }

    @Test
    public void object_equals_and_hash_code()
    {
        final NameOperand nameOperand1 = new NameOperand("", "n1");
        final NameOperand nameOperand2 = new NameOperand("", "n2");

        assertNotEquals(new CountOperand(nameOperand1), new CountOperand(nameOperand2));
        assertEquals(new CountOperand(nameOperand1), new CountOperand(nameOperand1));

        assertNotEquals(new CountOperand(nameOperand1).hashCode(), new CountOperand(nameOperand2).hashCode());
        assertEquals(new CountOperand(nameOperand1).hashCode(), new CountOperand(nameOperand1).hashCode());
    }


}
