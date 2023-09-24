package com.data.monkey.test.parser.engine.booleanExprs;

import com.data.monkey.grammar.parser.engine.booleanExprs.BooleanExprIN;
import com.data.monkey.grammar.parser.engine.operands.SetOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.FloatOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.IntegerOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.StringOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import com.google.common.collect.Sets;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BooleanExprINTest {

    @Test
    public void test() {
        Set<Object> set = new HashSet<>();
        set.add(10.0);
        set.add(11.0);
        BooleanExprIN eq = new BooleanExprIN(new FloatOperand(10.0), new SetOperand(set));
        Assert.assertTrue(eq.getResult(null, null, null));
    }

    @Test
    public void test_value_not_in_given_strings()
    {
        final BooleanExprIN booleanExprIN = new BooleanExprIN(
            new StringOperand("asdf"),
            new SetOperand(Sets.newHashSet("Asdf", "asdf "))
        );
        final Boolean result = booleanExprIN.getResult(new ProcessingContext(null, null));
        assertFalse(result);
    }

    @Test
    public void test_value_in_given_strings()
    {
        final BooleanExprIN booleanExprIN = new BooleanExprIN(
            new StringOperand("asdf"),
            new SetOperand(Sets.newHashSet("Asdf", "asdf"))
        );
        final Boolean result = booleanExprIN.getResult(new ProcessingContext(null, null));
        assertTrue(result);
    }

    @Test
    public void test_value_not_in_given_integers()
    {
        final BooleanExprIN booleanExprIN = new BooleanExprIN(
            new IntegerOperand(1),
            new SetOperand(Sets.newHashSet(2L, 3L))
        );
        final Boolean result = booleanExprIN.getResult(new ProcessingContext(null, null));
        assertFalse(result);
    }

    @Test
    public void test_value_in_given_integers()
    {
        final BooleanExprIN booleanExprIN = new BooleanExprIN(
            new IntegerOperand(1),
            new SetOperand(Sets.newHashSet(1L, 3L))
        );
        final Boolean result = booleanExprIN.getResult(new ProcessingContext(null, null));
        assertTrue(result);
    }

    @Test
    public void test_value_not_in_given_floats()
    {
        final BooleanExprIN booleanExprIN = new BooleanExprIN(
            new FloatOperand(1.0),
            new SetOperand(Sets.newHashSet(2.0, 3.0))
        );
        final Boolean result = booleanExprIN.getResult(new ProcessingContext(null, null));
        assertFalse(result);
    }

    @Test
    public void test_value_in_given_floats()
    {
        final BooleanExprIN booleanExprIN = new BooleanExprIN(
            new FloatOperand(1.0),
            new SetOperand(Sets.newHashSet(1.0, 3.0))
        );
        final Boolean result = booleanExprIN.getResult(new ProcessingContext(null, null));
        assertTrue(result);
    }
}
