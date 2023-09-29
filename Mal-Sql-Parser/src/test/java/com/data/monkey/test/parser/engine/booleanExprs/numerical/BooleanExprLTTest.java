package com.data.monkey.test.parser.engine.booleanExprs.numerical;


import com.data.monkey.grammar.parser.engine.booleanExprs.numerical.BooleanExprLT;
import com.data.monkey.grammar.parser.engine.operands.primitives.FloatOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.StringOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import org.junit.Test;

import static org.junit.Assert.*;

public class BooleanExprLTTest {

    @Test
    public void testGetResult() {
        BooleanExprLT lt = new BooleanExprLT(new FloatOperand(4.5), new FloatOperand(4.5));
        assertFalse(lt.getResult( null, null));
        lt = new BooleanExprLT(new FloatOperand(4.4), new FloatOperand(4.5));
        assertTrue(lt.getResult( null, null));
        lt = new BooleanExprLT(new FloatOperand(4.5), new FloatOperand(4.4));
        assertFalse(lt.getResult( null, null));
    }

    @Test
    public void testLTBetweenStringValues() {
        BooleanExprLT lt = new BooleanExprLT(new StringOperand("a"), new StringOperand("a"));
        assertFalse(lt.getResult(null, null));
        lt = new BooleanExprLT(new StringOperand("b"), new StringOperand("a"));
        assertFalse(lt.getResult(null, null));
        lt = new BooleanExprLT(new StringOperand("a"), new StringOperand("b"));
        assertTrue(lt.getResult( null, null));
    }

    @Test
    public void testLTBetweenDifferentTypeValues() {
        BooleanExprLT lt = new BooleanExprLT(new FloatOperand(10L), new StringOperand("5"));
        assertFalse(lt.getResult(null, null));
    }

    @Test
    public void comparision_returns_correct_value()
    {
        final BooleanExprLT booleanExpr = new BooleanExprLT(new FloatOperand(9.999), new FloatOperand(10.0));
        assertTrue(booleanExpr.getResult(new ProcessingContext(null, null)));
    }

    @Test
    public void comparision_returns_negative_result()
    {
        final BooleanExprLT booleanExpr = new BooleanExprLT(new FloatOperand(10L), new FloatOperand(9.999));
        assertFalse(booleanExpr.getResult(new ProcessingContext(null, null)));
    }

    @Test
    public void object_equals_and_hash_code()
    {
        final FloatOperand operand1 = new FloatOperand(1.0);
        final FloatOperand operand2 = new FloatOperand(1.0);
        final FloatOperand operand3 = new FloatOperand(2.0);
        final BooleanExprLT expr1 = new BooleanExprLT(operand1, operand2);
        final BooleanExprLT expr2 = new BooleanExprLT(operand2, operand1);
        final BooleanExprLT expr3 = new BooleanExprLT(operand1, operand3);

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
        final BooleanExprLT expr1 = new BooleanExprLT(operand1, operand2);
        assertEquals("BooleanExprLT(left=FloatOperand(1.0), right=FloatOperand(2.0))", expr1.toString());
    }

    @Test
    public void to_readable_string()
    {
        final FloatOperand operand1 = new FloatOperand(1.0);
        final FloatOperand operand2 = new FloatOperand(2.0);
        final BooleanExprLT expr1 = new BooleanExprLT(operand1, operand2);
        assertEquals("1.0 < 2.0", expr1.toReadableString());
    }
}
