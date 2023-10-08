package com.data.monkey.test.parser.engine.operands.aggregations;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.conditionExprs.AndCondition;
import com.data.monkey.grammar.parser.engine.conditionExprs.BooleanExprBase;
import com.data.monkey.grammar.parser.engine.conditionExprs.numerical.GreatCondition;
import com.data.monkey.grammar.parser.engine.conditionExprs.numerical.LessCondition;
import com.data.monkey.grammar.parser.engine.operands.NameOperand;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractAggregationOperand;
import com.data.monkey.grammar.parser.engine.operands.aggregations.SumOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.FloatOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.IntegerOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import com.data.monkey.grammar.parser.engine.processing.ProcessingException;
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

public class SumOperandTest {


    @Test
    public void testGetValue() {
        NameOperand name = new NameOperand(null, "test");
        NameOperand name2 = new NameOperand(null, "test2");
        NameOperand name3 = new NameOperand(null, "test3");

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("test", "0.098");
        raw.put("test2", "0.098");
        Event e1 = new Event("key1", raw, System.currentTimeMillis());
        raw = new HashMap<String, String>();
        raw.put("test", "0.098");
        Event e2 = new Event("key1", raw, System.currentTimeMillis());

        SumOperand sum = new SumOperand(name);
        assertEquals(0.098 * 2, sum.getValue(Arrays.asList(e1, e2), null));

        sum = new SumOperand(name2);
        assertEquals(0.098, sum.getValue(Arrays.asList(e1, e2), null));

        sum = new SumOperand(name3);
        assertEquals(0.0, sum.getValue(Arrays.asList(e1, e2), null));
    }

    @Test
    public void testSumOfStringValues() {
        NameOperand name = new NameOperand(null, "test");

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("test", "a");
        Event e1 = new Event("key1", raw, System.currentTimeMillis());
        raw = new HashMap<String, String>();
        raw.put("test", "1");
        Event e2 = new Event("key1", raw, System.currentTimeMillis());

        SumOperand sum = new SumOperand(name);
        assertEquals(1.0, sum.getValue( Arrays.asList(e1, e2), null));
    }

    @Test
    public void testSumAfterFilter() {
        BooleanExprBase booleanExprBase = new LessCondition(new NameOperand("table", "test"), new FloatOperand(0.5));

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("test", "0.2");
        Event e1 = new Event("key1", raw, System.currentTimeMillis());

        raw = new HashMap<String, String>();
        raw.put("test", "0.3");
        Event e2 = new Event("key1", raw, System.currentTimeMillis());

        raw = new HashMap<String, String>();
        raw.put("test", "0.5");
        Event e3 = new Event("key1", raw, System.currentTimeMillis());

        SumOperand sum = new SumOperand(booleanExprBase);
        assertEquals(0.5, sum.getValue(Arrays.asList(e1, e2, e3), null));
    }

    @Test
    public void testSumAfterFilterAllElements() {
        BooleanExprBase booleanExprBase = new GreatCondition(new NameOperand("table", "test"), new FloatOperand(0.5));

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("test", "0.2");
        Event e1 = new Event("key1", raw, System.currentTimeMillis());

        raw = new HashMap<String, String>();
        raw.put("test", "0.3");
        Event e2 = new Event("key1", raw, System.currentTimeMillis());

        SumOperand sum = new SumOperand(booleanExprBase);
        assertEquals(0.0, sum.getValue(Arrays.asList(e1, e2), null));
    }

    @Test
    public void testSumWithSpecificNameAndInnerPredicates() {
        // avg(val > 1)
        BooleanExprBase left = new GreatCondition(new NameOperand("table", "test"), new IntegerOperand(1));
        BooleanExprBase right = new GreatCondition(new NameOperand("table", "test2"), new IntegerOperand(3));
        AndCondition andExpr = new AndCondition(left, right);

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("test", "2");
        raw.put("test2", "4");
        Event e1 = new Event("key1", raw, System.currentTimeMillis());

        raw = new HashMap<String, String>();
        raw.put("test", "2");
        raw.put("test2", "0");
        Event e2 = new Event("key1", raw, System.currentTimeMillis());

        raw = new HashMap<String, String>();
        raw.put("test", "3");
        raw.put("test2", "5");
        Event e3 = new Event("key1", raw, System.currentTimeMillis());

        SumOperand sumOperand = new SumOperand(new NameOperand("table", "test2"), andExpr);

        assertEquals(9.0, sumOperand.getValue( Arrays.asList(e1, e2, e3), null));

        sumOperand = new SumOperand(new NameOperand("table", "test"), andExpr);

        assertEquals(5.0, sumOperand.getValue( Arrays.asList(e1, e2, e3), null));
    }

    @Test
    public void returns_correct_value()
    {
        final SumOperand sumOperand = new SumOperand(new NameOperand("asdf", "asdf"));
        Map<AbstractAggregationOperand, Future<Double>> aggregationValues = new HashMap<>();
        aggregationValues.put(sumOperand, Futures.immediateFuture(10.0));
        ProcessingContext context = new ProcessingContext(aggregationValues, null);
        final Object value = sumOperand.getValue(context);
        assertEquals(10.0, value);
    }

    @Test(expected = ProcessingException.class)
    public void throws_processing_exception_when_futures_failed()
    {
        final SumOperand sumOperand = new SumOperand(new NameOperand("asdf", "asdf"));
        Map<AbstractAggregationOperand, Future<Double>> aggregationValues = new HashMap<>();
        aggregationValues.put(sumOperand, Futures.immediateFailedFuture(new RuntimeException()));
        ProcessingContext context = new ProcessingContext(aggregationValues, null);
        sumOperand.getValue(context);
    }


    @Test
    public void get_name_returns_correct_result()
    {
        final Operand mock = Mockito.mock(Operand.class);
        Mockito.when(mock.toReadableString()).thenReturn("asdf");
        assertEquals("sum(asdf)", new SumOperand(mock).toReadableString());
    }

    @Test
    public void get_value_returns_default_aggregation_value_when_future_result_not_found()
    {
        final SumOperand sumOperand = new SumOperand(Mockito.mock(Operand.class));
        final Object actual = sumOperand.getValue(new ProcessingContext(Maps.newHashMap(), null));
        assertEquals(0.0D, actual);
    }

    @Test
    public void get_value_returns_value_from_future_result()
    {
        final SumOperand sumOperand = new SumOperand(Mockito.mock(Operand.class));
        final HashMap<AbstractAggregationOperand, Future<Double>> aggregationValues = Maps.newHashMap();
        aggregationValues.put(sumOperand, Futures.immediateFuture(5.0D));
        final Object actual = sumOperand.getValue(new ProcessingContext(aggregationValues, null));
        assertEquals(5.0D, actual);
    }

    @Test
    public void returns_sef_in_the_aggregation_operands_set()
    {
        final SumOperand sumOperand = new SumOperand(Mockito.mock(Operand.class));
        assertEquals(Sets.newHashSet(sumOperand), sumOperand.getAggregationOperands());
    }

    @Test
    public void aggregation_function_returns_sum_value()
    {
        assertEquals(6.0, new SumOperand(Mockito.mock(Operand.class)).getAggregationFunction().apply(1.0, 5.0), 0.1);
    }

    @Test
    public void object_equals_and_hash_code()
    {
        final NameOperand nameOperand1 = new NameOperand("", "n1");
        final NameOperand nameOperand2 = new NameOperand("", "n2");

        assertNotEquals(new SumOperand(nameOperand1), new SumOperand(nameOperand2));
        assertEquals(new SumOperand(nameOperand1), new SumOperand(nameOperand1));

        assertNotEquals(new SumOperand(nameOperand1).hashCode(), new SumOperand(nameOperand2).hashCode());
        assertEquals(new SumOperand(nameOperand1).hashCode(), new SumOperand(nameOperand1).hashCode());
    }


}
