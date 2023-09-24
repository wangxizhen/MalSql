package com.data.monkey.test.parser.engine.booleanExprs;

import com.data.monkey.grammar.parser.engine.booleanExprs.BooleanExprAND;
import com.data.monkey.grammar.parser.engine.booleanExprs.BooleanExprEQ;
import com.data.monkey.grammar.parser.engine.booleanExprs.IBooleanExpression;
import com.data.monkey.grammar.parser.engine.operands.primitives.FloatOperand;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BooleanExprANDTest
{

    @Test
    public void testGetResult() {
        IBooleanExpression left = new BooleanExprEQ(new FloatOperand(4.5), new FloatOperand(4.5));
        IBooleanExpression right = new BooleanExprEQ(new FloatOperand(4.5), new FloatOperand(4.5));
        BooleanExprAND and = new BooleanExprAND(left, right);
        Assert.assertTrue("AND expression test error", and.getResult(null, null, null));
    }

    @Test
    public void object_equals_and_hash_code()
    {
        IBooleanExpression expression1 = new BooleanExprEQ(new FloatOperand(4.5), new FloatOperand(4.5));
        IBooleanExpression expression2 = new BooleanExprEQ(new FloatOperand(4.5), new FloatOperand(4.5));
        IBooleanExpression expression3 = new BooleanExprEQ(new FloatOperand(4.5), new FloatOperand(5.5));
        BooleanExprAND expr1 = new BooleanExprAND(expression1, expression2);
        BooleanExprAND expr2 = new BooleanExprAND(expression2, expression1);
        BooleanExprAND expr3 = new BooleanExprAND(expression1, expression3);

        assertEquals(expr1, expr2);
        assertEquals(expr1.hashCode(), expr2.hashCode());

        assertNotEquals(expr1, expr3);
        assertNotEquals(expr1.hashCode(), expr3.hashCode());
    }

    @Test
    public void object_to_string()
    {
        IBooleanExpression expression1 = new BooleanExprEQ(new FloatOperand(4.5), new FloatOperand(4.5));
        IBooleanExpression expression2 = new BooleanExprEQ(new FloatOperand(4.5), new FloatOperand(5.5));
        BooleanExprAND expr1 = new BooleanExprAND(expression1, expression2);
        assertEquals(
            "BooleanExprAND(left=BooleanExprEQ(left=FloatOperand(4.5), right=FloatOperand(4.5)), right=BooleanExprEQ(left=FloatOperand(4.5), right=FloatOperand(5.5)))",
            expr1.toString()
        );
    }

    @Test
    public void to_readable_string()
    {
        IBooleanExpression expression1 = new BooleanExprEQ(new FloatOperand(4.5), new FloatOperand(4.5));
        IBooleanExpression expression2 = new BooleanExprEQ(new FloatOperand(4.5), new FloatOperand(5.5));
        BooleanExprAND expr1 = new BooleanExprAND(expression1, expression2);
        assertEquals("(4.5 = 4.5) and (4.5 = 5.5)", expr1.toReadableString());
    }
}
