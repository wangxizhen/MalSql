package com.data.monkey.grammar.parser.engine.operands.like;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.exception.NotFoundException;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractAggregationOperand;
import com.data.monkey.grammar.parser.engine.operands.like.BaseLikeOperand;
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

/**
 * LIKE clause
 *
 */
@Data
@AllArgsConstructor
public class RightLikeOperand extends BaseLikeOperand {

    private final String tableName;
    private final String fieldName;
    private final String matchValue;

    @Override
    public Object getValue(List<Event> events, Map<String, String> parameters) {
        String valueStr = events.get(events.size() - 1).getMetrics().get(fieldName);
        if (valueStr == null) {
            throw new NotFoundException("field:[" + fieldName +
                    "] in event metrics set: " + events.get(events.size() - 1).getMetrics() + ".");
        }
        if(valueStr.endsWith(matchValue)){
            return valueStr;
        }
        return null;
    }

    @Override
    public Object getValue(ProcessingContext context) {
        final ReadableEvent event = context.getEvent();
        Optional<Object> result = event.readValue(this.fieldName);
        if (!result.isPresent()) {
            result = event.readValue(toReadableString());
        }
        return result.orElse(null);
    }

    @Override
    public Set<AbstractAggregationOperand> getAggregationOperands() {
        return Sets.newHashSet();
    }

    @Override
    public String toReadableString() {
        return StringUtils.isEmpty(tableName) ? fieldName : String.format("%s.%s.%s", tableName, fieldName,matchValue);
    }

}
