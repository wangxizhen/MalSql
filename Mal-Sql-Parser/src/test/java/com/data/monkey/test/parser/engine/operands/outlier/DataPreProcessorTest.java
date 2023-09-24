package com.data.monkey.test.parser.engine.operands.outlier;


import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.outlier.DataPreProcessor;
import com.data.monkey.grammar.parser.engine.operands.outlier.dataflow.ClearDataFlowController;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class DataPreProcessorTest {
    @Test
    public void testRetrievePoints() {
        DataPreProcessor processor = createDataPreProcessor("metric_a", "metric_b", "metric_c");
        Event event1 = createEvent("rule1", "metric_a", "1");
        Assert.assertNull(processor.retrievePoint(event1));
        Event event2 = createEvent("rule1", "metric_b", "1");
        Assert.assertNull(processor.retrievePoint(event2));
        Event event3 = createEvent("rule1", "metric_c", "1");
        Assert.assertNotNull(processor.retrievePoint(event3));
    }

    @Test
    public void testLackOfMetric() {
        DataPreProcessor processor = createDataPreProcessor("metric_a", "metric_b", "metric_c");
        for (int i = 0; i < 10; i++) {
            Pair<String, String> metricA = Pair.of("metric_a", "1");
            Pair<String, String> metricB = Pair.of("metric_b", "1");
            Event event = createEvent("rule1", metricA, metricB);
            processor.retrievePoint(event);
        }
        Assert.assertEquals(processor.getEventDataCache().get("metric_a").size(), 0);
    }

    protected Event createEvent(String ruleId, Map<String, String> metrics) {
        Event event = new Event();
        event.setTimestamp(1);
        event.setMetrics(metrics);
        return event;
    }

    protected Event createEvent(String ruleId, Pair<String, String>... metrics) {
        Map<String, String> metricMap = new HashMap<>();
        for (Pair<String, String> metricPair : metrics) {
            metricMap.put(metricPair.getKey(), metricPair.getValue());
        }
        return createEvent(ruleId, metricMap);
    }

    protected Event createEvent(String ruleId, String metricName, String metricValue) {
        Map<String, String> metrics = new HashMap<>();
        metrics.put(metricName, metricValue);
        return createEvent(ruleId, metrics);
    }

    protected Event createEvent(String ruleId, Pair<String, String> metric) {
        Map<String, String> metrics = new HashMap<>();
        metrics.put(metric.getKey(), metric.getValue());
        return createEvent(ruleId, metrics);
    }

    private DataPreProcessor createDataPreProcessor(String... metricNames) {
        DataPreProcessor dataPreProcessor = new DataPreProcessor(new ClearDataFlowController());
        dataPreProcessor.setRequiredMetricNames(Arrays.stream(metricNames).collect(Collectors.toList()));
        return dataPreProcessor;
    }
}
