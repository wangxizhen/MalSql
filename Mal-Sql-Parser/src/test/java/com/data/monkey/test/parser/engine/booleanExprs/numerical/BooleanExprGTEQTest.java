package com.data.monkey.test.parser.engine.booleanExprs.numerical;


import com.data.monkey.grammar.parser.engine.booleanExprs.numerical.BooleanExprGTEQ;
import com.data.monkey.grammar.parser.engine.operands.primitives.FloatOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.StringOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import org.junit.Test;

import static org.junit.Assert.*;

public class BooleanExprGTEQTest {

    @Test
    public void testGetResult() {
        BooleanExprGTEQ gteq = new BooleanExprGTEQ(new FloatOperand(4.5), new FloatOperand(4.5));
        assertTrue(gteq.getResult( null, null));
        gteq = new BooleanExprGTEQ(new FloatOperand(4.6), new FloatOperand(4.5));
        assertTrue(gteq.getResult(null, null));
        gteq = new BooleanExprGTEQ(new FloatOperand(4.4), new FloatOperand(4.5));
        assertFalse(gteq.getResult(null, null));
    }

    @Test
    public void testGTEQBetweenStringValues() {
        BooleanExprGTEQ gteq = new BooleanExprGTEQ(new StringOperand("a"), new StringOperand("a"));
        assertTrue(gteq.getResult( null, null));
        gteq = new BooleanExprGTEQ(new StringOperand("b"), new StringOperand("a"));
        assertTrue(gteq.getResult(null, null));
        gteq = new BooleanExprGTEQ(new StringOperand("a"), new StringOperand("b"));
        assertFalse(gteq.getResult(null, null));
    }

    @Test
    public void testGTEQBetweenDifferentTypeValues() {
        BooleanExprGTEQ gteq = new BooleanExprGTEQ(new FloatOperand(10L), new StringOperand("5"));
        assertFalse(gteq.getResult(null, null));
    }

    @Test
    public void comparision_returns_correct_value()
    {
        final BooleanExprGTEQ booleanExpr = new BooleanExprGTEQ(new FloatOperand(10L), new FloatOperand(9.999));
        assertTrue(booleanExpr.getResult(new ProcessingContext(null, null)));

        final BooleanExprGTEQ booleanExpr2 = new BooleanExprGTEQ(new FloatOperand(9.999), new FloatOperand(9.999));
        assertTrue(booleanExpr2.getResult(new ProcessingContext(null, null)));
    }

    @Test
    public void comparision_returns_negative_result()
    {
        final BooleanExprGTEQ booleanExpr = new BooleanExprGTEQ(new FloatOperand(9.999), new FloatOperand(10L));
        assertFalse(booleanExpr.getResult(new ProcessingContext(null, null)));
    }

    @Test
    public void object_equals_and_hash_code()
    {
        final FloatOperand operand1 = new FloatOperand(1.0);
        final FloatOperand operand2 = new FloatOperand(1.0);
        final FloatOperand operand3 = new FloatOperand(2.0);
        final BooleanExprGTEQ expr1 = new BooleanExprGTEQ(operand1, operand2);
        final BooleanExprGTEQ expr2 = new BooleanExprGTEQ(operand2, operand1);
        final BooleanExprGTEQ expr3 = new BooleanExprGTEQ(operand1, operand3);

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
        final BooleanExprGTEQ expr1 = new BooleanExprGTEQ(operand1, operand2);
        assertEquals("1.0 >= 2.0", expr1.toReadableString());
    }
}
