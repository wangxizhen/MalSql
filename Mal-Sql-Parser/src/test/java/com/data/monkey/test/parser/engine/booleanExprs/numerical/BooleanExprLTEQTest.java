package com.data.monkey.test.parser.engine.booleanExprs.numerical;


import com.data.monkey.grammar.parser.engine.booleanExprs.numerical.BooleanExprLTEQ;
import com.data.monkey.grammar.parser.engine.operands.primitives.FloatOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.StringOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import org.junit.Test;

import static org.junit.Assert.*;

public class BooleanExprLTEQTest {

    @Test
    public void testGetResult() {
        BooleanExprLTEQ lteq = new BooleanExprLTEQ(new FloatOperand(4.5), new FloatOperand(4.5));
        assertTrue(lteq.getResult(null, null, null));
        lteq = new BooleanExprLTEQ(new FloatOperand(4.4), new FloatOperand(4.5));
        assertTrue(lteq.getResult(null, null, null));
        lteq = new BooleanExprLTEQ(new FloatOperand(4.5), new FloatOperand(4.4));
        assertFalse(lteq.getResult(null, null, null));
    }

    @Test
    public void testLTEQBetweenStringValues() {
        BooleanExprLTEQ lteq = new BooleanExprLTEQ(new StringOperand("a"), new StringOperand("a"));
        assertTrue(lteq.getResult(null, null, null));
        lteq = new BooleanExprLTEQ(new StringOperand("b"), new StringOperand("a"));
        assertFalse(lteq.getResult(null, null, null));
        lteq = new BooleanExprLTEQ(new StringOperand("a"), new StringOperand("b"));
        assertTrue(lteq.getResult(null, null, null));
    }

    @Test
    public void testLTEQBetweenDifferentTypeValues() {
        BooleanExprLTEQ lteq = new BooleanExprLTEQ(new FloatOperand(10L), new StringOperand("5"));
        assertFalse(lteq.getResult(null, null, null));
    }

    @Test
    public void comparision_returns_correct_value()
    {
        final BooleanExprLTEQ booleanExpr = new BooleanExprLTEQ(new FloatOperand(9.999), new FloatOperand(10.0));
        assertTrue(booleanExpr.getResult(new ProcessingContext(null, null)));

        final BooleanExprLTEQ booleanExpr2 = new BooleanExprLTEQ(new FloatOperand(9.999), new FloatOperand(9.999));
        assertTrue(booleanExpr2.getResult(new ProcessingContext(null, null)));
    }

    @Test
    public void comparision_returns_negative_result()
    {
        final BooleanExprLTEQ booleanExpr = new BooleanExprLTEQ(new FloatOperand(10L), new FloatOperand(9.999));
        assertFalse(booleanExpr.getResult(new ProcessingContext(null, null)));
    }

    @Test
    public void object_equals_and_hash_code()
    {
        final FloatOperand operand1 = new FloatOperand(1.0);
        final FloatOperand operand2 = new FloatOperand(1.0);
        final FloatOperand operand3 = new FloatOperand(2.0);
        final BooleanExprLTEQ expr1 = new BooleanExprLTEQ(operand1, operand2);
        final BooleanExprLTEQ expr2 = new BooleanExprLTEQ(operand2, operand1);
        final BooleanExprLTEQ expr3 = new BooleanExprLTEQ(operand1, operand3);

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
        final BooleanExprLTEQ expr1 = new BooleanExprLTEQ(operand1, operand2);
        assertEquals("BooleanExprLTEQ(left=FloatOperand(1.0), right=FloatOperand(2.0))", expr1.toString());
    }

    @Test
    public void to_readable_string()
    {
        final FloatOperand operand1 = new FloatOperand(1.0);
        final FloatOperand operand2 = new FloatOperand(2.0);
        final BooleanExprLTEQ expr1 = new BooleanExprLTEQ(operand1, operand2);
        assertEquals("1.0 <= 2.0", expr1.toReadableString());
    }
}
