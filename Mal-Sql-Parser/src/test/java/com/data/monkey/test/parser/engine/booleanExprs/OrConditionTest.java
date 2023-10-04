package com.data.monkey.test.parser.engine.booleanExprs;

import com.data.monkey.grammar.parser.engine.conditionExprs.EqCondition;
import com.data.monkey.grammar.parser.engine.conditionExprs.OrCondition;
import com.data.monkey.grammar.parser.engine.conditionExprs.IBooleanExpression;
import com.data.monkey.grammar.parser.engine.operands.primitives.FloatOperand;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class OrConditionTest {

    @Test
    public void testGetResult() {
        IBooleanExpression left = new EqCondition(new FloatOperand(4.5), new FloatOperand(4.5));
        IBooleanExpression right = new EqCondition(new FloatOperand(4.1), new FloatOperand(4.5));
        OrCondition and = new OrCondition(left, right);
        Assert.assertTrue("OR expression test error", and.getResult(null, null));
    }

    @Test
    public void object_equals_and_hash_code()
    {
        IBooleanExpression expression1 = new EqCondition(new FloatOperand(4.5), new FloatOperand(4.5));
        IBooleanExpression expression2 = new EqCondition(new FloatOperand(4.5), new FloatOperand(4.5));
        IBooleanExpression expression3 = new EqCondition(new FloatOperand(4.5), new FloatOperand(5.5));
        OrCondition expr1 = new OrCondition(expression1, expression2);
        OrCondition expr2 = new OrCondition(expression2, expression1);
        OrCondition expr3 = new OrCondition(expression1, expression3);

        assertEquals(expr1, expr2);
        assertEquals(expr1.hashCode(), expr2.hashCode());

        assertNotEquals(expr1, expr3);
        assertNotEquals(expr1.hashCode(), expr3.hashCode());
    }

    @Test
    public void object_to_string()
    {
        IBooleanExpression expression1 = new EqCondition(new FloatOperand(4.5), new FloatOperand(4.5));
        IBooleanExpression expression2 = new EqCondition(new FloatOperand(4.5), new FloatOperand(5.5));
        OrCondition expr1 = new OrCondition(expression1, expression2);
        assertEquals(
            "OrCondition(left=EqCondition(left=FloatOperand(4.5), right=FloatOperand(4.5)), right=EqCondition(left=FloatOperand(4.5), right=FloatOperand(5.5)))",
            expr1.toString()
        );
    }

    @Test
    public void to_readable_string()
    {
        IBooleanExpression expression1 = new EqCondition(new FloatOperand(4.5), new FloatOperand(4.5));
        IBooleanExpression expression2 = new EqCondition(new FloatOperand(4.5), new FloatOperand(5.5));
        OrCondition expr1 = new OrCondition(expression1, expression2);
        assertEquals("4.5 = 4.5 or 4.5 = 5.5", expr1.toReadableString());
    }

}
