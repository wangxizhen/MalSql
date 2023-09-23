package com.data.monkey.grammar.parser.engine.operands.outlier.single;


import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractAggregationOperand;
import com.data.monkey.grammar.parser.engine.operands.outlier.AnomListConfig;
import com.data.monkey.grammar.parser.engine.operands.outlier.CalculatorManager;
import com.data.monkey.grammar.parser.engine.operands.outlier.IncreClusterCalculator;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import lombok.Data;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class AnomListSizeOperand extends DynaBLOperand {


    private AnomListConfig anomListConfig;

    public AnomListSizeOperand(AnomListConfig anomListConfig) {
        this.anomListConfig = anomListConfig;
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
        if (calculator.getAnomListConfig() == null) calculator.setAnomListConfig(anomListConfig);
        calculator.calculate(currEvent, events, parameters);
        return new Double(calculator.getSerialOutlier().size());
    }

    @Override
    public Object getValue(ProcessingContext context)
    {
        throw new UnsupportedOperationException();
    }
}
