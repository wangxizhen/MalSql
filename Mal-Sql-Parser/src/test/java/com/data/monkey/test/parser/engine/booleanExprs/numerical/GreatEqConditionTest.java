package com.data.monkey.test.parser.engine.booleanExprs.numerical;


import com.data.monkey.grammar.parser.engine.conditionExprs.numerical.GreatEqCondition;
import com.data.monkey.grammar.parser.engine.operands.primitives.FloatOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.StringOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import org.junit.Test;

import static org.junit.Assert.*;

public class GreatEqConditionTest {

    @Test
    public void testGetResult() {
        GreatEqCondition gteq = new GreatEqCondition(new FloatOperand(4.5), new FloatOperand(4.5));
        assertTrue(gteq.getResult( null, null));
        gteq = new GreatEqCondition(new FloatOperand(4.6), new FloatOperand(4.5));
        assertTrue(gteq.getResult(null, null));
        gteq = new GreatEqCondition(new FloatOperand(4.4), new FloatOperand(4.5));
        assertFalse(gteq.getResult(null, null));
    }

    @Test
    public void testGTEQBetweenStringValues() {
        GreatEqCondition gteq = new GreatEqCondition(new StringOperand("a"), new StringOperand("a"));
        assertTrue(gteq.getResult( null, null));
        gteq = new GreatEqCondition(new StringOperand("b"), new StringOperand("a"));
        assertTrue(gteq.getResult(null, null));
        gteq = new GreatEqCondition(new StringOperand("a"), new StringOperand("b"));
        assertFalse(gteq.getResult(null, null));
    }

    @Test
    public void testGTEQBetweenDifferentTypeValues() {
        GreatEqCondition gteq = new GreatEqCondition(new FloatOperand(10L), new StringOperand("5"));
        assertFalse(gteq.getResult(null, null));
    }

    @Test
    public void comparision_returns_correct_value()
    {
        final GreatEqCondition booleanExpr = new GreatEqCondition(new FloatOperand(10L), new FloatOperand(9.999));
        assertTrue(booleanExpr.getResult(new ProcessingContext(null, null)));

        final GreatEqCondition booleanExpr2 = new GreatEqCondition(new FloatOperand(9.999), new FloatOperand(9.999));
        assertTrue(booleanExpr2.getResult(new ProcessingContext(null, null)));
    }

    @Test
    public void comparision_returns_negative_result()
    {
        final GreatEqCondition booleanExpr = new GreatEqCondition(new FloatOperand(9.999), new FloatOperand(10L));
        assertFalse(booleanExpr.getResult(new ProcessingContext(null, null)));
    }

    @Test
    public void object_equals_and_hash_code()
    {
        final FloatOperand operand1 = new FloatOperand(1.0);
        final FloatOperand operand2 = new FloatOperand(1.0);
        final FloatOperand operand3 = new FloatOperand(2.0);
        final GreatEqCondition expr1 = new GreatEqCondition(operand1, operand2);
        final GreatEqCondition expr2 = new GreatEqCondition(operand2, operand1);
        final GreatEqCondition expr3 = new GreatEqCondition(operand1, operand3);

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
        final GreatEqCondition expr1 = new GreatEqCondition(operand1, operand2);
        assertEquals("1.0 >= 2.0", expr1.toReadableString());
    }
}
