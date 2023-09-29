package com.data.monkey.test.parser.engine.operands;

import com.data.monkey.grammar.parser.engine.operands.ParenthesisOperand;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class ParenthesisOperandTest {

    @Test
    public void testGetValue() {
        ParenthesisOperand operand = new ParenthesisOperand("?test");
        Map<String, String> params = new HashMap<String, String>();
        params.put("test", "1");
        Assert.assertEquals(1.0, operand.getValue(null, params));
    }
}
