package com.data.monkey.test.parser.engine.operands;

import com.data.monkey.grammar.parser.engine.operands.primitives.IntegerOperand;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class IntegerOperandTest {

    @Test
    public void testGetValueListOfEventMapOfStringObject() {
        IntegerOperand op = new IntegerOperand(2L);
        assertEquals(2.0D, op.getValue(null, null, null));
    }

    @Test
    public void object_equals_and_hash_code()
    {
        final IntegerOperand operand1 = new IntegerOperand(1);
        final IntegerOperand operand2 = new IntegerOperand(1);
        final IntegerOperand operand3 = new IntegerOperand(2);

        assertEquals(operand1, operand2);
        assertEquals(operand1.hashCode(), operand2.hashCode());

        assertNotEquals(operand1, operand3);
        assertNotEquals(operand1.hashCode(), operand3.hashCode());
    }

    @Test
    public void object_to_string()
    {
        assertEquals("IntegerOperand(1)", new IntegerOperand(1).toString());
    }

    @Test
    public void to_readable_string()
    {
        assertEquals("1", new IntegerOperand(1).toReadableString());
    }

}
