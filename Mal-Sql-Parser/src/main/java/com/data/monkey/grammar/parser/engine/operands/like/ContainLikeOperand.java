package com.data.monkey.grammar.parser.engine.operands.like;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.exception.NotFoundException;
import com.data.monkey.grammar.parser.engine.operands.like.BaseLikeOperand;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * LIKE clause
 *
 */
@Data
@AllArgsConstructor
public class ContainLikeOperand extends BaseLikeOperand {

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
        if(valueStr.contains(matchValue)){
            return valueStr;
        }
        return null;
    }





}
