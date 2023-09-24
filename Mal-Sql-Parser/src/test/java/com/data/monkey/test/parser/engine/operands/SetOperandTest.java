package com.data.monkey.test.parser.engine.operands;

import com.data.monkey.grammar.parser.engine.operands.SetOperand;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class SetOperandTest
{

    @Test(expected = UnsupportedOperationException.class)
    public void throws_exception_when_get_name()
    {
        new SetOperand(Sets.newHashSet()).toReadableString();
    }

    @Test
    public void returns_original_set_when_get_value()
    {
        final HashSet<Object> set = Sets.newHashSet("qwer", "asdf");
        assertEquals(set, new SetOperand(set).getValue(null));
    }
}