package com.data.monkey.grammar.parser.engine.operands;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.exception.NotFoundException;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractAggregationOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import com.data.monkey.grammar.parser.engine.processing.ReadableEvent;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Data
@AllArgsConstructor
public class NameOperand implements Operand {
    private final String tableName;
    private final String fieldName;

    @Override
    public Set<AbstractAggregationOperand> getAggregationOperands() {
        return Sets.newHashSet();
    }

    @Override
    public String toReadableString()
    {
        return StringUtils.isEmpty(tableName) ? fieldName : String.format("%s.%s", tableName, fieldName);
    }

    @Override
    public Object getValue(Event currEvent, List<Event> events, Map<String, String> parameters) {
        String valueStr = currEvent != null ? currEvent.getMetrics().get(fieldName) :
                events.get(events.size() - 1).getMetrics().get(fieldName);

        if (valueStr == null) {
            throw new NotFoundException("field:[" + fieldName +
                    "] in event metrics set: " + events.get(events.size() - 1).getMetrics() + ".");
        }
        try {
            return Double.parseDouble(valueStr);
        } catch (NumberFormatException e) {
            return valueStr; // 支持字符串作为metric值
        }
    }

    @Override
    public Object getValue(ProcessingContext context)
    {
        final ReadableEvent event = context.getEvent();
        Optional<Object> result = event.readValue(this.fieldName);
        if (!result.isPresent()) {
            result = event.readValue(getFullName());
        }
        return result.orElse(null);
    }

    private String getFullName() {return String.format("%s.%s", tableName, fieldName);}
}
