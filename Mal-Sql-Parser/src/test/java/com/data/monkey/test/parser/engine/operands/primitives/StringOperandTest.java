package com.data.monkey.test.parser.engine.operands.primitives;

import com.data.monkey.grammar.parser.engine.operands.primitives.StringOperand;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StringOperandTest
{
    @Test
    public void object_equals_and_hash_code()
    {
        final StringOperand operand1 = new StringOperand("asdf");
        final StringOperand operand2 = new StringOperand("asdf");
        final StringOperand operand3 = new StringOperand("qwer");

        assertEquals(operand1, operand2);
        assertEquals(operand1.hashCode(), operand2.hashCode());

        assertNotEquals(operand1, operand3);
        assertNotEquals(operand1.hashCode(), operand3.hashCode());
    }

    @Test
    public void object_to_string()
    {
        assertEquals("StringOperand('asdf')", new StringOperand("asdf").toString());
    }

    @Test
    public void to_readable_string()
    {
        assertEquals("'asdf'", new StringOperand("asdf").toReadableString());
    }
}