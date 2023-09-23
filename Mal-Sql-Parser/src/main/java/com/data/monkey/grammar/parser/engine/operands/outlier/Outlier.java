package com.data.monkey.grammar.parser.engine.operands.outlier;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class Outlier {
    long timestamp = 0l;
    String metric_name = "";
    double value = 0d;
}
