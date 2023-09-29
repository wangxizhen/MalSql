package com.data.monkey.grammar.parser.engine.operands;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.exception.NotFoundException;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractAggregationOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class ParenthesisOperand implements Operand {
    @Override
    public Object getValue(ProcessingContext context)
    {
        throw new UnsupportedOperationException();
    }

    private String fieldName;

    @Override
    public Set<AbstractAggregationOperand> getAggregationOperands() {
        return Sets.newHashSet();
    }

    @Override
    public String toReadableString()
    {
        throw new NotImplementedException("");
    }

    @Override
    public Object getValue(List<Event> events, Map<String, String> parameters) {
        fieldName = fieldName.replace("?", "");
        if (parameters == null || parameters.size() == 0 || !parameters.containsKey(fieldName)) {
            throw new NotFoundException("field:[" + fieldName +
                    "] in params set: " + parameters.toString() + ".");
        }
        String valueStr = parameters.get(fieldName);
        try {
            return Double.parseDouble(valueStr);
        } catch (NumberFormatException e) {
            return valueStr; // 支持字符串作为metric值
        }
    }
}
