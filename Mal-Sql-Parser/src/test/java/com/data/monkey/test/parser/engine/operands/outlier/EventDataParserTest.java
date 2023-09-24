package com.data.monkey.test.parser.engine.operands.outlier;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.outlier.EventDataParser;
import com.data.monkey.grammar.parser.engine.operands.outlier.Metric;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class EventDataParserTest extends DataPreProcessorTest {
    EventDataParser parser;
    Map<String, ArrayList<Metric>> eventDataCache;

    @Before
    public void init() {
        parser = new EventDataParser(Lists.newArrayList("metric_a", "metric_b", "metric_c"));
        eventDataCache = new HashMap<>();
        parser.initEventDataCache(eventDataCache);
    }

    @Test
    public void testParse() {
        Event event = createEvent("rule1", Pair.of("metric_a", "1")
            , Pair.of("metric_b", "1"), Pair.of("metric_c", "1"));
        for (int i = 0; i < 10; i++) {
            parser.parse(eventDataCache, event);
            Assert.assertEquals(eventDataCache.get("metric_a").size(), i + 1);
        }
    }

    @Test
    public void testinitEventDataCache() {
        Map<String, ArrayList<Metric>> eventDataCache = new HashMap<>();
        Assert.assertEquals(eventDataCache.size(), 0);
        parser.initEventDataCache(eventDataCache);
        Assert.assertEquals(eventDataCache.size(), 3);
    }
}
