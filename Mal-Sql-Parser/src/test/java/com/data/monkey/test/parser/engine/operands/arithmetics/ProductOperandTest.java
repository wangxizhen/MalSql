package com.data.monkey.test.parser.engine.operands.arithmetics;


import com.data.monkey.grammar.parser.engine.operands.NameOperand;
import com.data.monkey.grammar.parser.engine.operands.arithmetics.ProductOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.IntegerOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.StringOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ProductOperandTest
{
    @Test
    public void product_operation_returns_correct_value()
    {
        final IntegerOperand integerOperand = new IntegerOperand(3);
        final ProductOperand productOperand = new ProductOperand(integerOperand, integerOperand);
        final Object result = productOperand.getValue(Mockito.mock(ProcessingContext.class));
        assertEquals(9.0, result);
    }

    @Test(expected = NullPointerException.class)
    public void throws_exception_when_provided_value_is_null()
    {
        final IntegerOperand integerOperand = new IntegerOperand(null);
        final ProductOperand productOperand = new ProductOperand(integerOperand, integerOperand);
        productOperand.getValue(Mockito.mock(ProcessingContext.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throws_exception_when_provided_value_is_not_a_number()
    {
        final StringOperand integerOperand = new StringOperand("asdf");
        final ProductOperand productOperand = new ProductOperand(integerOperand, integerOperand);
        productOperand.getValue(Mockito.mock(ProcessingContext.class));
    }

    @Test
    public void object_equals_and_hash_code()
    {
        final ProductOperand operand = new ProductOperand(new NameOperand("", "n1"), new NameOperand("", "n2"));
        final ProductOperand operand2 = new ProductOperand(new NameOperand("", "n1"), new NameOperand("", "n2"));
        final ProductOperand operand3 = new ProductOperand(new NameOperand("", "n1"), new NameOperand("", "n3"));
        assertEquals(operand, operand2);
        assertEquals(operand.hashCode(), operand2.hashCode());
        assertNotEquals(operand2, operand3);
        assertNotEquals(operand2.hashCode(), operand3.hashCode());
    }


}