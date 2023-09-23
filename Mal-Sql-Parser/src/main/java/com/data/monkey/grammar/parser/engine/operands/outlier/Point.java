package com.data.monkey.grammar.parser.engine.operands.outlier;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;


@Data
@NoArgsConstructor
public class Point {
    private HashMap<String, Metric> metricValues = new HashMap<>();
    private long timestamp = 0L;
    private Outlier outlier;

    public List<Double> getValueList(@NonNull List<String> metrics) {
        return metrics.stream().map(metricValues::get).map(Metric::getValue).collect(toList());
    }
}
