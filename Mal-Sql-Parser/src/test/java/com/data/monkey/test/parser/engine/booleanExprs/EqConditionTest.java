package com.data.monkey.test.parser.engine.booleanExprs;


import com.data.monkey.grammar.parser.engine.conditionExprs.EqCondition;
import com.data.monkey.grammar.parser.engine.operands.NameOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.FloatOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.IntegerOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.StringOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import com.data.monkey.grammar.parser.engine.processing.ReadableEvent;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.Assert.*;

public class EqConditionTest {

    @Test
    public void test() {
        EqCondition eq = new EqCondition(new FloatOperand(10L), new FloatOperand(10.0));
        assertTrue(eq.getResult(null, null));
        eq = new EqCondition(new FloatOperand(10L), new FloatOperand(9.0));
        assertFalse(eq.getResult(null, null));
    }

    @Test
    public void testEqBetweenStringValues() {
        EqCondition eq = new EqCondition(new StringOperand("a"), new StringOperand("a"));
        assertTrue(eq.getResult(null, null));

        eq = new EqCondition(new StringOperand("a"), new StringOperand("b"));
        assertFalse(eq.getResult( null, null));
    }

    @Test
    public void testEqBetweenDifferentTypeValues() {
        EqCondition eq = new EqCondition(new FloatOperand(10L), new StringOperand("10"));
        assertFalse(eq.getResult(null, null));
    }

    @Test
    public void test_equals_given_string()
    {
        final EqCondition eqCondition = new EqCondition(new StringOperand("asdf"), new StringOperand("asdf"));
        final Boolean result = eqCondition.getResult(new ProcessingContext(null, null));
        assertTrue(result);
    }

    @Test
    public void test_not_equals_given_string()
    {
        final EqCondition eqCondition = new EqCondition(new StringOperand("asdf"), new StringOperand("asdf "));
        final Boolean result = eqCondition.getResult(new ProcessingContext(null, null));
        assertFalse(result);
    }

    @Test
    public void test_equals_given_integers()
    {
        final EqCondition eqCondition = new EqCondition(new NameOperand("", "num1"), new IntegerOperand(10L));
        ReadableEvent readableEvent = Mockito.mock(ReadableEvent.class);
        Mockito.when(readableEvent.readValue("num1")).thenReturn(Optional.of(10));
        final Boolean result = eqCondition.getResult(new ProcessingContext(null, readableEvent));
        assertFalse(result);
    }

    @Test
    public void test_not_equals_given_integers()
    {
        final EqCondition eqCondition = new EqCondition(new NameOperand("", "num1"), new IntegerOperand(10L));
        ReadableEvent readableEvent = Mockito.mock(ReadableEvent.class);
        Mockito.when(readableEvent.readValue("num1")).thenReturn(Optional.of(0));
        final Boolean result = eqCondition.getResult(new ProcessingContext(null, readableEvent));
        assertFalse(result);
    }

    @Test
    public void test_equals_given_floats()
    {
        final EqCondition eqCondition = new EqCondition(new NameOperand("", "num1"), new FloatOperand(1.1));
        ReadableEvent readableEvent = Mockito.mock(ReadableEvent.class);
        Mockito.when(readableEvent.readValue("num1")).thenReturn(Optional.of(1.1));
        final Boolean result = eqCondition.getResult(new ProcessingContext(null, readableEvent));
        assertTrue(result);
    }

    @Test
    public void test_not_equals_given_floats()
    {
        final EqCondition eqCondition = new EqCondition(new NameOperand("", "num1"), new FloatOperand(1.1));
        ReadableEvent readableEvent = Mockito.mock(ReadableEvent.class);
        Mockito.when(readableEvent.readValue("num1")).thenReturn(Optional.of(1.0));
        final Boolean result = eqCondition.getResult(new ProcessingContext(null, readableEvent));
        assertFalse(result);
    }

    @Test
    public void test_integers_not_equals_floats()
    {
        final EqCondition eqCondition = new EqCondition(new NameOperand("", "num1"), new FloatOperand(1.0));
        ReadableEvent readableEvent = Mockito.mock(ReadableEvent.class);
        Mockito.when(readableEvent.readValue("num1")).thenReturn(Optional.of(1));
        final Boolean result = eqCondition.getResult(new ProcessingContext(null, readableEvent));
        assertFalse(result);
    }

    @Test
    public void object_equals_and_hash_code()
    {
        final FloatOperand operand1 = new FloatOperand(1.0);
        final FloatOperand operand2 = new FloatOperand(1.0);
        final FloatOperand operand3 = new FloatOperand(2.0);
        final EqCondition expr1 = new EqCondition(operand1, operand2);
        final EqCondition expr2 = new EqCondition(operand2, operand1);
        final EqCondition expr3 = new EqCondition(operand1, operand3);

        assertEquals(expr1, expr2);
        assertEquals(expr1.hashCode(), expr2.hashCode());

        assertNotEquals(expr1, expr3);
        assertNotEquals(expr1.hashCode(), expr3.hashCode());
    }

    @Test
    public void object_to_string()
    {
        final FloatOperand operand1 = new FloatOperand(1.0);
        final FloatOperand operand2 = new FloatOperand(2.0);
        final EqCondition expr1 = new EqCondition(operand1, operand2);
        assertEquals("EqCondition(left=FloatOperand(1.0), right=FloatOperand(2.0))", expr1.toString());
    }

    @Test
    public void to_readable_string()
    {
        final FloatOperand operand1 = new FloatOperand(1.0);
        final FloatOperand operand2 = new FloatOperand(2.0);
        final EqCondition expr1 = new EqCondition(operand1, operand2);
        assertEquals("1.0 = 2.0", expr1.toReadableString());
    }
}
