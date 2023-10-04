package com.data.monkey.test.parser.engine.booleanExprs;

import com.data.monkey.grammar.parser.engine.conditionExprs.InCondition;
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

public class InConditionTest {

    @Test
    public void test() {
        Set<Object> set = new HashSet<>();
        set.add(10.0);
        set.add(11.0);
        InCondition eq = new InCondition(new FloatOperand(10.0), new SetOperand(set));
        Assert.assertTrue(eq.getResult(null, null));
    }

    @Test
    public void test_value_not_in_given_strings()
    {
        final InCondition inCondition = new InCondition(
            new StringOperand("asdf"),
            new SetOperand(Sets.newHashSet("Asdf", "asdf "))
        );
        final Boolean result = inCondition.getResult(new ProcessingContext(null, null));
        assertFalse(result);
    }

    @Test
    public void test_value_in_given_strings()
    {
        final InCondition inCondition = new InCondition(
            new StringOperand("asdf"),
            new SetOperand(Sets.newHashSet("Asdf", "asdf"))
        );
        final Boolean result = inCondition.getResult(new ProcessingContext(null, null));
        assertTrue(result);
    }

    @Test
    public void test_value_not_in_given_integers()
    {
        final InCondition inCondition = new InCondition(
            new IntegerOperand(1),
            new SetOperand(Sets.newHashSet(2L, 3L))
        );
        final Boolean result = inCondition.getResult(new ProcessingContext(null, null));
        assertFalse(result);
    }

    @Test
    public void test_value_in_given_integers()
    {
        final InCondition inCondition = new InCondition(
            new IntegerOperand(1),
            new SetOperand(Sets.newHashSet(1L, 3L))
        );
        final Boolean result = inCondition.getResult(new ProcessingContext(null, null));
        assertTrue(result);
    }

    @Test
    public void test_value_not_in_given_floats()
    {
        final InCondition inCondition = new InCondition(
            new FloatOperand(1.0),
            new SetOperand(Sets.newHashSet(2.0, 3.0))
        );
        final Boolean result = inCondition.getResult(new ProcessingContext(null, null));
        assertFalse(result);
    }

    @Test
    public void test_value_in_given_floats()
    {
        final InCondition inCondition = new InCondition(
            new FloatOperand(1.0),
            new SetOperand(Sets.newHashSet(1.0, 3.0))
        );
        final Boolean result = inCondition.getResult(new ProcessingContext(null, null));
        assertTrue(result);
    }
}
