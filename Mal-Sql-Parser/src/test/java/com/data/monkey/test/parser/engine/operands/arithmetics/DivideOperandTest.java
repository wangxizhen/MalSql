package com.data.monkey.test.parser.engine.operands.arithmetics;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.NameOperand;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.operands.aggregations.SumOperand;
import com.data.monkey.grammar.parser.engine.operands.arithmetics.DivideOperand;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DivideOperandTest {

    @Test
    public void testGetValue() {
        NameOperand name1 = new NameOperand(null, "key1");
        NameOperand name2 = new NameOperand(null, "key2");

        DivideOperand div = new DivideOperand(name1, name2);

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("key1", "0.1");
        raw.put("key2", "0.05");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);


        assertEquals(2.0D, div.getValue(Arrays.asList(e1), null));
    }

    @Test
    public void testInAdditionToZero () {
        NameOperand name1 = new NameOperand(null, "key1");
        NameOperand name2 = new NameOperand(null, "key2");

        DivideOperand div = new DivideOperand(name1, name2);

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("key1", "0.1");
        raw.put("key2", "0");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        assertEquals(0.0D, div.getValue(Arrays.asList(e1), null));
    }

    @Test
    public void testGetValueBySum() {
        NameOperand name1 = new NameOperand(null, "key1");
        NameOperand name2 = new NameOperand(null, "key2");

        SumOperand sum1 = new SumOperand(name1);
        SumOperand sum2 = new SumOperand(name2);

        DivideOperand div = new DivideOperand(sum1, sum2);

        Map<String, String> raw = new HashMap<String, String>();
        raw.put("key1", "0.1");
        raw.put("key2", "0.05");
        Event e1 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);

        raw = new HashMap<String, String>();
        raw.put("key1", "0.3");
        raw.put("key2", "0.05");
        Event e2 = new Event("key1", raw, UUID.randomUUID(), System.currentTimeMillis(), 1L, 2L);


        assertEquals(4.0D, div.getValue(Arrays.asList(e1, e2), null));
    }

    @Test
    public void get_name_returns_correct_result()
    {
        final Operand leftOperand = Mockito.mock(Operand.class);
        final Operand rightOperand = Mockito.mock(Operand.class);
        Mockito.when(leftOperand.toReadableString()).thenReturn("asdf");
        Mockito.when(rightOperand.toReadableString()).thenReturn("qwer");

        final DivideOperand divideOperand = new DivideOperand(leftOperand, rightOperand);
        assertEquals("(asdf)/(qwer)", divideOperand.toReadableString());
    }

    @Test
    public void object_equals_and_hash_code()
    {
        final DivideOperand operand = new DivideOperand(new NameOperand("", "n1"), new NameOperand("", "n2"));
        final DivideOperand operand2 = new DivideOperand(new NameOperand("", "n1"), new NameOperand("", "n2"));
        final DivideOperand operand3 = new DivideOperand(new NameOperand("", "n1"), new NameOperand("", "n3"));
        assertEquals(operand, operand2);
        assertEquals(operand.hashCode(), operand2.hashCode());
        assertNotEquals(operand2, operand3);
        assertNotEquals(operand2.hashCode(), operand3.hashCode());
    }


}
