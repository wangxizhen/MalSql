package com.data.monkey.grammar.parser.engine.operands.outlier.single;


import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractAggregationOperand;
import com.data.monkey.grammar.parser.engine.operands.outlier.AnomListConfig;
import com.data.monkey.grammar.parser.engine.operands.outlier.CalculatorManager;
import com.data.monkey.grammar.parser.engine.operands.outlier.IncreClusterCalculator;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;
import java.util.Map;
import java.util.Set;


@Slf4j
public class AnomListOperand implements Operand {

    //Currently, the constructor uses the parameter only for distinguishing from the
    //others. Not useful in reality.
    public AnomListOperand(AnomListConfig anomListConfig) {
    }

    @Override
    public Set<AbstractAggregationOperand> getAggregationOperands() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toReadableString()
    {
        throw new NotImplementedException("");
    }

    @Override
    public Object getValue(Event currEvent, List<Event> events, Map<String, String> parameters) {
        IncreClusterCalculator calculator = CalculatorManager.getInstance().getCalculator(currEvent.getRuleId());
        Map<String, Object> result = calculator.getAlertResult();
        return result;
    }

    @Override
    public Object getValue(ProcessingContext context)
    {
        throw new UnsupportedOperationException();
    }
}
