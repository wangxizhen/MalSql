package com.data.monkey.test.parser.engine.operands.arithmetics;


import com.data.monkey.grammar.parser.engine.operands.NameOperand;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.operands.arithmetics.PlusOperand;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PlusOperandTest
{
    @Test
    public void get_name_returns_correct_result()
    {
        final Operand leftOperand = Mockito.mock(Operand.class);
        final Operand rightOperand = Mockito.mock(Operand.class);
        Mockito.when(leftOperand.toReadableString()).thenReturn("asdf");
        Mockito.when(rightOperand.toReadableString()).thenReturn("qwer");

        final PlusOperand minusOperand = new PlusOperand(leftOperand, rightOperand);
        assertEquals("(asdf)+(qwer)", minusOperand.toReadableString());
    }

    @Test
    public void minus_operation_returns_success_value()
    {
        assertEquals(3.0D, PlusOperand.PLUS_OP.apply(1L, 2L));
    }

    @Test(expected = IllegalArgumentException.class)
    public void minus_operation_throws_exception_when_provided_NaN()
    {
        PlusOperand.PLUS_OP.apply("", 2L);
    }

    @Test
    public void object_equals_and_hash_code()
    {
        final PlusOperand operand = new PlusOperand(new NameOperand("", "n1"), new NameOperand("", "n2"));
        final PlusOperand operand2 = new PlusOperand(new NameOperand("", "n1"), new NameOperand("", "n2"));
        final PlusOperand operand3 = new PlusOperand(new NameOperand("", "n1"), new NameOperand("", "n3"));
        assertEquals(operand, operand2);
        assertEquals(operand.hashCode(), operand2.hashCode());
        assertNotEquals(operand2, operand3);
        assertNotEquals(operand2.hashCode(), operand3.hashCode());
    }


}