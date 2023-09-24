package com.data.monkey.test.parser.engine.operands;

import com.data.monkey.grammar.parser.engine.operands.primitives.FloatOperand;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FloatOperandTest {

    @Test
    public void testGetValueListOfEventMapOfStringObject() {
        FloatOperand op = new FloatOperand(3D);
        assertEquals(3D, op.getValue(null, null, null));
    }

    @Test
    public void object_equals_and_hash_code()
    {
        final FloatOperand operand1 = new FloatOperand(1.0);
        final FloatOperand operand2 = new FloatOperand(1.0);
        final FloatOperand operand3 = new FloatOperand(2.0);

        assertEquals(operand1, operand2);
        assertEquals(operand1.hashCode(), operand2.hashCode());

        assertNotEquals(operand1, operand3);
        assertNotEquals(operand1.hashCode(), operand3.hashCode());
    }

    @Test
    public void object_to_string()
    {
        assertEquals("FloatOperand(1.0)", new FloatOperand(1.0).toString());
    }

    @Test
    public void to_readable_string()
    {
        assertEquals("1.0", new FloatOperand(1.0).toReadableString());
    }
}
