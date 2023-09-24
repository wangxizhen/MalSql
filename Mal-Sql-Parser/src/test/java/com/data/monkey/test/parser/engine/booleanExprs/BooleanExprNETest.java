package com.data.monkey.test.parser.engine.booleanExprs;


import com.data.monkey.grammar.parser.engine.booleanExprs.BooleanExprNE;
import com.data.monkey.grammar.parser.engine.operands.NameOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.FloatOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.IntegerOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.StringOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import com.data.monkey.grammar.parser.engine.processing.ReadableEvent;
import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

public class BooleanExprNETest {

    @Test
    public void testGetResult() {
        BooleanExprNE ne = new BooleanExprNE(new FloatOperand(4.5), new FloatOperand(4.5));
        assertFalse(ne.getResult(null, null, null));
        ne = new BooleanExprNE(new FloatOperand(4.4), new FloatOperand(4.5));
        assertTrue(ne.getResult(null, null, null));
        ne = new BooleanExprNE(new FloatOperand(4.5), new FloatOperand(4.4));
        assertTrue(ne.getResult(null, null, null));
    }

    @Test
    public void testNEBetweenStringValues() {
        BooleanExprNE ne = new BooleanExprNE(new StringOperand("a"), new StringOperand("a"));
        assertFalse(ne.getResult(null, null, null));
        ne = new BooleanExprNE(new StringOperand("b"), new StringOperand("a"));
        assertTrue(ne.getResult(null, null, null));
        ne = new BooleanExprNE(new StringOperand("a"), new StringOperand("b"));
        assertTrue(ne.getResult(null, null, null));
    }

    @Test
    public void testNEBetweenDifferentTypeValues() {
        BooleanExprNE ne = new BooleanExprNE(new FloatOperand(10L), new StringOperand("5"));
        assertTrue(ne.getResult(null, null, null));
    }


    @Test
    public void test_not_equal_for_string_primitives()
    {
        final BooleanExprNE booleanExprNE = new BooleanExprNE(new StringOperand("asdf"), new StringOperand("ASDF"));
        final Boolean result = booleanExprNE.getResult(new ProcessingContext(null, null));
        assertTrue(result);
    }

    @Test
    public void test_not_equal_for_number_primitives()
    {
        final BooleanExprNE booleanExprNE = new BooleanExprNE(new IntegerOperand(1), new IntegerOperand(1));
        final Boolean result = booleanExprNE.getResult(new ProcessingContext(null, null));
        assertFalse(result);
    }

    @Test
    public void test_not_equal_for_name_operands()
    {
        final BooleanExprNE booleanExprNE = new BooleanExprNE(
            new NameOperand("stream1", "num1"),
            new IntegerOperand(1)
        );

        ReadableEvent readableEvents = Mockito.mock(ReadableEvent.class);
        Mockito.when(readableEvents.readValue("num1")).thenReturn(java.util.Optional.of(1L));

        final Boolean result = booleanExprNE.getResult(new ProcessingContext(null, readableEvents));
        assertFalse(result);
    }

    @Test
    public void object_equals_and_hash_code()
    {
        final FloatOperand operand1 = new FloatOperand(1.0);
        final FloatOperand operand2 = new FloatOperand(1.0);
        final FloatOperand operand3 = new FloatOperand(2.0);
        final BooleanExprNE expr1 = new BooleanExprNE(operand1, operand2);
        final BooleanExprNE expr2 = new BooleanExprNE(operand2, operand1);
        final BooleanExprNE expr3 = new BooleanExprNE(operand1, operand3);

        assertEquals(expr1, expr2);
        assertEquals(expr1.hashCode(), expr2.hashCode());

        assertNotEquals(expr1, expr3);
        assertNotEquals(expr1.hashCode(), expr3.hashCode());
    }

    @Test
    public void object_to_string()
    {
        final FloatOperand operand1 = new FloatOperand(1.0);
        final FloatOperand operand2 = new FloatOperand(2.0);
        final BooleanExprNE expr1 = new BooleanExprNE(operand1, operand2);
        assertEquals("BooleanExprNE(left=FloatOperand(1.0), right=FloatOperand(2.0))", expr1.toString());
    }

    @Test
    public void to_readable_string()
    {
        final FloatOperand operand1 = new FloatOperand(1.0);
        final FloatOperand operand2 = new FloatOperand(2.0);
        final BooleanExprNE expr1 = new BooleanExprNE(operand1, operand2);
        assertEquals("1.0 != 2.0", expr1.toReadableString());
    }
}
