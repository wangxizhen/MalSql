package com.data.monkey.test.parser.engine.operands.outlier.dataflow;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.outlier.EventDataParser;
import com.data.monkey.grammar.parser.engine.operands.outlier.Metric;
import com.data.monkey.grammar.parser.engine.operands.outlier.dataflow.ClearDataFlowController;
import com.data.monkey.test.parser.engine.operands.outlier.DataPreProcessorTest;
import com.google.common.collect.Lists;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ClearDataFlowControllerTest extends DataPreProcessorTest {
    @Test
    public void testControllData() {
        Map<String, ArrayList<Metric>> eventDataCache = new HashMap<>();
        List<String> requiredMetricNames=Lists.newArrayList("metric_a", "metric_b", "metric_c");
        ClearDataFlowController clearDataFlowController = new ClearDataFlowController();
        EventDataParser parser = new EventDataParser(requiredMetricNames);
        parser.initEventDataCache(eventDataCache);
        for (int i = 0; i < 9; i++) {
            Event event = createEvent("rule1", Pair.of("metric_a", "1"), Pair.of("metric_b", "1"));
            parser.parse(eventDataCache, event );
            clearDataFlowController.controllData(eventDataCache);
            Assert.assertEquals(eventDataCache.get("metric_a").size(), i+1);
        }
        Event event = createEvent("rule1", Pair.of("metric_a", "1"), Pair.of("metric_b", "1"));
        parser.parse(eventDataCache,event);
        clearDataFlowController.controllData(eventDataCache);
        Assert.assertEquals(eventDataCache.get("metric_a").size(), 0);
    }



}
