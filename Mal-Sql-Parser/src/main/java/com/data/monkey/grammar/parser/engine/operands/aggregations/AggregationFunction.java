package com.data.monkey.grammar.parser.engine.operands.aggregations;

@FunctionalInterface
public interface AggregationFunction {
    double apply(double accumulation, double value);
}
