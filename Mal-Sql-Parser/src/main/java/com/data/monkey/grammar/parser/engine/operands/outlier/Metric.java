package com.data.monkey.grammar.parser.engine.operands.outlier;

import com.data.monkey.common.entity.Event;
import lombok.Data;



@Data
public class Metric {
    //Metric value
    private double value;

    //Metric name
    private String metricName;

    //The timestamp from the "original" event.
    private long timestamp;

    //backup the event reference.
    private Event event;

    public Metric(long timestamp, String metricName, double value) {
        this.timestamp = timestamp;
        this.value = value;
        this.metricName = metricName;
    }
}
