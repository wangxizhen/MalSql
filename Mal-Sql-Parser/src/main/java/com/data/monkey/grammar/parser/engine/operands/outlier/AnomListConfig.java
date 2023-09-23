package com.data.monkey.grammar.parser.engine.operands.outlier;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;



@AllArgsConstructor
@Data
public class AnomListConfig {
    //The metric names that appear in the rule sql.
    private List<String> metrics;

    //The confidence represents the float parameter that appears in the rule sql.
    //It is used for adjusting the sensitivity of the outlier detection.
    private double confidence = 0.4;
}
