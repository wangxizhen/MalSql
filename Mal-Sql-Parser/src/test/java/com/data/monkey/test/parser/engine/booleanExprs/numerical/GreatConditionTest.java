package com.data.monkey.test.parser.engine.booleanExprs.numerical;


import com.data.monkey.grammar.parser.engine.conditionExprs.numerical.GreatCondition;
import com.data.monkey.grammar.parser.engine.operands.primitives.FloatOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.StringOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import org.junit.Test;

import static org.junit.Assert.*;

public class GreatConditionTest {

    @Test
    public void test() {
        GreatCondition eq = new GreatCondition(new FloatOperand(11L), new FloatOperand(10.0));
        assertTrue(eq.getResult( null, null));
    }

    @Test
    public void testGTBetweenStringValues() {
        GreatCondition gteq = new GreatCondition(new StringOperand("a"), new StringOperand("a"));
        assertFalse(gteq.getResult( null, null));
        gteq = new GreatCondition(new StringOperand("b"), new StringOperand("a"));
        assertTrue(gteq.getResult(null, null));
        gteq = new GreatCondition(new StringOperand("a"), new StringOperand("b"));
        assertFalse(gteq.getResult(null, null));
    }

    @Test
    public void testGTBetweenDifferentTypeValues() {
        GreatCondition gt = new GreatCondition(new FloatOperand(10L), new StringOperand("5"));
        assertFalse(gt.getResult( null, null));
    }

    @Test
    public void comparision_returns_correct_value()
    {
        final GreatCondition greatCondition = new GreatCondition(new FloatOperand(10L), new FloatOperand(9.999));
        assertTrue(greatCondition.getResult(new ProcessingContext(null, null)));
    }

    @Test
    public void comparision_returns_negative_result()
    {
        final GreatCondition greatCondition = new GreatCondition(new FloatOperand(9.99), new FloatOperand(10L));
        assertFalse(greatCondition.getResult(new ProcessingContext(null, null)));
    }

    @Test
    public void object_equals_and_hash_code()
    {
        final FloatOperand operand1 = new FloatOperand(1.0);
        final FloatOperand operand2 = new FloatOperand(1.0);
        final FloatOperand operand3 = new FloatOperand(2.0);
        final GreatCondition expr1 = new GreatCondition(operand1, operand2);
        final GreatCondition expr2 = new GreatCondition(operand2, operand1);
        final GreatCondition expr3 = new GreatCondition(operand1, operand3);

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
        final GreatCondition expr1 = new GreatCondition(operand1, operand2);
        assertEquals("GreatCondition(left=FloatOperand(1.0), right=FloatOperand(2.0))", expr1.toString());
    }

    @Test
    public void to_readable_string()
    {
        final FloatOperand operand1 = new FloatOperand(1.0);
        final FloatOperand operand2 = new FloatOperand(2.0);
        final GreatCondition expr1 = new GreatCondition(operand1, operand2);
        assertEquals("1.0 > 2.0", expr1.toReadableString());
    }
}
