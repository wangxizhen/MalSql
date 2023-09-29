package com.data.monkey.test.parser.engine.operands.aggregations;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.booleanExprs.BooleanExprAND;
import com.data.monkey.grammar.parser.engine.booleanExprs.BooleanExprBase;
import com.data.monkey.grammar.parser.engine.booleanExprs.numerical.BooleanExprGT;
import com.data.monkey.grammar.parser.engine.booleanExprs.numerical.BooleanExprLT;
import com.data.monkey.grammar.parser.engine.operands.NameOperand;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractAggregationOperand;
import com.data.monkey.grammar.parser.engine.operands.aggregations.MaxOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.FloatOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.IntegerOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MaxOperandTest {


    @Test
    public void testMax() {
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

        MaxOperand max = new MaxOperand(name);
        assertEquals(0.20, max.getValue( Arrays.asList(e1, e2, e3), null));

        max = new MaxOperand(name2);
        assertEquals(0.20, max.getValue( Arrays.asList(e1, e2, e3), null));

        max = new MaxOperand(name3);
        assertEquals(0.0, max.getValue(Arrays.asList(e1, e2, e3), null));
    }

    @Test
    public void testMaxOfStringValues() {
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

        MaxOperand max = new MaxOperand(name);
        assertEquals(0.0, max.getValue(Arrays.asList(e1, e2, e3), null));
    }

    @Test
    public void testMaxAfterFilter() {
        BooleanExprBase booleanExprBase = new BooleanExprLT(new NameOperand("table", "test"), new FloatOperand(0.5));

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("test", "0.20");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "0.11");
        Event e2 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "1");
        Event e3 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        MaxOperand max = new MaxOperand(booleanExprBase);

        assertEquals(0.20, max.getValue(Arrays.asList(e1, e2, e3), null));
    }

    @Test
    public void testMaxAfterFilterAllElements() {
        BooleanExprBase booleanExprBase = new BooleanExprGT(new NameOperand("table", "test"), new FloatOperand(0.5));

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("test", "0.20");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("test", "0.11");
        Event e2 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        MaxOperand max = new MaxOperand(booleanExprBase);

        assertEquals(0.0, max.getValue(Arrays.asList(e1, e2), null));
    }

    @Test
    public void testMaxWithSpecificNameAndInnerPredicates() {
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

        MaxOperand maxOperand = new MaxOperand(new NameOperand("table", "test"), andExpr);

        assertEquals(3.0, maxOperand.getValue(Arrays.asList(e1, e2, e3), null));

        maxOperand = new MaxOperand(new NameOperand("table", "test2"), andExpr);

        assertEquals(5.0, maxOperand.getValue(Arrays.asList(e1, e2, e3), null));
    }

    @Test
    public void get_name_returns_correct_result()
    {
        final Operand mock = Mockito.mock(Operand.class);
        Mockito.when(mock.toReadableString()).thenReturn("asdf");
        assertEquals("max(asdf)", new MaxOperand(mock).toReadableString());
    }

    @Test
    public void get_value_returns_default_aggregation_value_when_future_result_not_found()
    {
        final MaxOperand maxOperand = new MaxOperand(Mockito.mock(Operand.class));
        final Object actual = maxOperand.getValue(new ProcessingContext(Maps.newHashMap(), null));
        assertEquals(Double.MIN_VALUE, actual);
    }

    @Test
    public void get_value_returns_value_from_future_result()
    {
        final MaxOperand maxOperand = new MaxOperand(Mockito.mock(Operand.class));
        final HashMap<AbstractAggregationOperand, Future<Double>> aggregationValues = Maps.newHashMap();
        aggregationValues.put(maxOperand, Futures.immediateFuture(5.0D));
        final Object actual = maxOperand.getValue(new ProcessingContext(aggregationValues, null));
        assertEquals(5.0D, actual);
    }

    @Test
    public void returns_sef_in_the_aggregation_operands_set()
    {
        final MaxOperand maxOperand = new MaxOperand(Mockito.mock(Operand.class));
        assertEquals(Sets.newHashSet(maxOperand), maxOperand.getAggregationOperands());
    }

    @Test
    public void aggregation_function_returns_max_value()
    {
        assertEquals(5.0, new MaxOperand(Mockito.mock(Operand.class)).getAggregationFunction().apply(1.0, 5.0), 0.1);
    }

    @Test
    public void object_equals_and_hash_code()
    {
        final NameOperand nameOperand1 = new NameOperand("", "n1");
        final NameOperand nameOperand2 = new NameOperand("", "n2");

        assertNotEquals(new MaxOperand(nameOperand1), new MaxOperand(nameOperand2));
        assertEquals(new MaxOperand(nameOperand1), new MaxOperand(nameOperand1));

        assertNotEquals(new MaxOperand(nameOperand1).hashCode(), new MaxOperand(nameOperand2).hashCode());
        assertEquals(new MaxOperand(nameOperand1).hashCode(), new MaxOperand(nameOperand1).hashCode());
    }


}
