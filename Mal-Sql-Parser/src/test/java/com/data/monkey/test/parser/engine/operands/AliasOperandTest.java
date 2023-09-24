package com.data.monkey.test.parser.engine.operands;

import com.data.monkey.grammar.parser.engine.operands.AliasOperand;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class AliasOperandTest
{

    @Test
    public void get_name_returns_alias()
    {
        final String alias = "aliass";
        assertEquals(alias, new AliasOperand(null, alias).toReadableString());
    }

    @Test
    public void returns_inner_operand_value_when_get_value()
    {
        final Operand mock = Mockito.mock(Operand.class);
        final ProcessingContext context = new ProcessingContext(null, null);
        new AliasOperand(mock, "alias").getValue(context);
        Mockito.verify(mock).getValue(context);
    }

    @Test
    public void returns_inner_operand_aggregations_when_get_aggregation_operands()
    {
        final Operand mock = Mockito.mock(Operand.class);
        new AliasOperand(mock, "alias").getAggregationOperands();
        Mockito.verify(mock).getAggregationOperands();
    }
    
}