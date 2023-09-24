package com.data.monkey.test.parser.engine.function;


import com.data.monkey.grammar.parser.engine.booleanExprs.IBooleanExpression;
import com.data.monkey.grammar.parser.engine.function.FunctionManager;
import com.data.monkey.grammar.parser.engine.operands.NameOperand;
import com.data.monkey.grammar.parser.engine.operands.aggregations.*;
import com.data.monkey.grammar.parser.engine.params.MoMDuration;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class FunctionManagerTest {

    private final NameOperand nameOperand = new NameOperand("asdf", "num1");
    private final IBooleanExpression expression = Mockito.mock(IBooleanExpression.class);

    @Test
    public void testAddFunction() {
        Assert.assertNotNull(FunctionManager.getFunction("sum"));
        Assert.assertNotNull(FunctionManager.getFunction("avg"));
        Assert.assertNotNull(FunctionManager.getFunction("maximum"));
        Assert.assertNotNull(FunctionManager.getFunction("minimum"));
        Assert.assertNotNull(FunctionManager.getFunction("count"));
        Assert.assertNotNull(FunctionManager.getFunction("previous"));
        Assert.assertNotNull(FunctionManager.getFunction("period"));
    }

    @Test
    public void supports_sum_function()
    {
        Object result = FunctionManager.getFunction("sum").call(nameOperand);
        assertEquals(new SumOperand(nameOperand), result);

        Object result2 = FunctionManager.getFunction("sum").call(nameOperand, expression);
        assertEquals(new SumOperand(nameOperand, expression), result2);
    }

    @Test
    public void supports_avg_function()
    {
        Object result = FunctionManager.getFunction("avg").call(nameOperand);
        assertEquals(new AvgOperand(nameOperand), result);

        Object result2 = FunctionManager.getFunction("avg").call(nameOperand, expression);
        assertEquals(new AvgOperand(nameOperand, expression), result2);
    }

    @Test
    public void supports_maximum_function()
    {
        Object result = FunctionManager.getFunction("maximum").call(nameOperand);
        assertEquals(new MaxOperand(nameOperand), result);

        Object result2 = FunctionManager.getFunction("maximum").call(nameOperand, expression);
        assertEquals(new MaxOperand(nameOperand, expression), result2);
    }

    @Test
    public void supports_minimum_function()
    {
        Object result = FunctionManager.getFunction("minimum").call(nameOperand);
        assertEquals(new MinOperand(nameOperand), result);

        Object result2 = FunctionManager.getFunction("minimum").call(nameOperand, expression);
        assertEquals(new MinOperand(nameOperand, expression), result2);
    }

    @Test
    public void supports_count_function()
    {
        Object result = FunctionManager.getFunction("count").call(nameOperand);
        assertEquals(new CountOperand(nameOperand), result);

        Object result2 = FunctionManager.getFunction("count").call(nameOperand, expression);
        assertEquals(new CountOperand(nameOperand, expression), result2);
    }

    @Test
    public void supports_period_function()
    {
        MoMDuration duration = new MoMDuration(new NameOperand("", "aaaa"), Duration.ofDays(15), Duration.ofMinutes(60));
        Object result = FunctionManager.getFunction("period").call(duration);
        assertEquals(result, new PeriodOperand(duration));
    }

}
