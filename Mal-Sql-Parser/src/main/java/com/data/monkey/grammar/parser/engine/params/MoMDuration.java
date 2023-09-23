package com.data.monkey.grammar.parser.engine.params;


import com.data.monkey.grammar.parser.engine.operands.NameOperand;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractSingleOperand;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Duration;


@Data
@AllArgsConstructor
public class MoMDuration {

    private Operand metricOperand;

    private Duration windowTime;

    private Duration intervalTime;

    private Duration cycleTime;

    public MoMDuration (Operand metricOperand ,Duration windowTime, Duration cycleTime) {
        this.metricOperand = metricOperand;
        this.windowTime = windowTime;
        this.intervalTime = Duration.ofDays(1);  //默认是日趋势
        this.cycleTime = cycleTime;
    }

    public String getMetricName() {
        NameOperand nameOperand;
        if (metricOperand instanceof NameOperand) {
            nameOperand = NameOperand.class.cast(metricOperand);
        } else {
            nameOperand = NameOperand.class.cast(AbstractSingleOperand.class.cast(metricOperand).getNameOperand());
        }
        return nameOperand.getFieldName();
    }
}
