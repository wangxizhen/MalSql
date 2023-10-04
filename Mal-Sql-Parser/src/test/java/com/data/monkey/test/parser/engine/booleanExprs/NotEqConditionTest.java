package com.data.monkey.test.parser.engine.booleanExprs;


import com.data.monkey.grammar.parser.engine.conditionExprs.NotEqCondition;
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

public class NotEqConditionTest {

    @Test
    public void testGetResult() {
        NotEqCondition ne = new NotEqCondition(new FloatOperand(4.5), new FloatOperand(4.5));
        assertFalse(ne.getResult(null, null));
        ne = new NotEqCondition(new FloatOperand(4.4), new FloatOperand(4.5));
        assertTrue(ne.getResult( null, null));
        ne = new NotEqCondition(new FloatOperand(4.5), new FloatOperand(4.4));
        assertTrue(ne.getResult(null, null));
    }

    @Test
    public void testNEBetweenStringValues() {
        NotEqCondition ne = new NotEqCondition(new StringOperand("a"), new StringOperand("a"));
        assertFalse(ne.getResult(null, null));
        ne = new NotEqCondition(new StringOperand("b"), new StringOperand("a"));
        assertTrue(ne.getResult(null, null));
        ne = new NotEqCondition(new StringOperand("a"), new StringOperand("b"));
        assertTrue(ne.getResult( null, null));
    }

    @Test
    public void testNEBetweenDifferentTypeValues() {
        NotEqCondition ne = new NotEqCondition(new FloatOperand(10L), new StringOperand("5"));
        assertTrue(ne.getResult( null, null));
    }


    @Test
    public void test_not_equal_for_string_primitives()
    {
        final NotEqCondition notEqCondition = new NotEqCondition(new StringOperand("asdf"), new StringOperand("ASDF"));
        final Boolean result = notEqCondition.getResult(new ProcessingContext(null, null));
        assertTrue(result);
    }

    @Test
    public void test_not_equal_for_number_primitives()
    {
        final NotEqCondition notEqCondition = new NotEqCondition(new IntegerOperand(1), new IntegerOperand(1));
        final Boolean result = notEqCondition.getResult(new ProcessingContext(null, null));
        assertFalse(result);
    }

    @Test
    public void test_not_equal_for_name_operands()
    {
        final NotEqCondition notEqCondition = new NotEqCondition(
            new NameOperand("stream1", "num1"),
            new IntegerOperand(1)
        );

        ReadableEvent readableEvents = Mockito.mock(ReadableEvent.class);
        Mockito.when(readableEvents.readValue("num1")).thenReturn(java.util.Optional.of(1L));

        final Boolean result = notEqCondition.getResult(new ProcessingContext(null, readableEvents));
        assertFalse(result);
    }

    @Test
    public void object_equals_and_hash_code()
    {
        final FloatOperand operand1 = new FloatOperand(1.0);
        final FloatOperand operand2 = new FloatOperand(1.0);
        final FloatOperand operand3 = new FloatOperand(2.0);
        final NotEqCondition expr1 = new NotEqCondition(operand1, operand2);
        final NotEqCondition expr2 = new NotEqCondition(operand2, operand1);
        final NotEqCondition expr3 = new NotEqCondition(operand1, operand3);

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
        final NotEqCondition expr1 = new NotEqCondition(operand1, operand2);
        assertEquals("NotEqCondition(left=FloatOperand(1.0), right=FloatOperand(2.0))", expr1.toString());
    }

    @Test
    public void to_readable_string()
    {
        final FloatOperand operand1 = new FloatOperand(1.0);
        final FloatOperand operand2 = new FloatOperand(2.0);
        final NotEqCondition expr1 = new NotEqCondition(operand1, operand2);
        assertEquals("1.0 != 2.0", expr1.toReadableString());
    }
}
