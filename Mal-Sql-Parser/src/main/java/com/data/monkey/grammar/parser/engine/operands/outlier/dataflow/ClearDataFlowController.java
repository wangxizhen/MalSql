package com.data.monkey.grammar.parser.engine.operands.outlier.dataflow;


import com.data.monkey.grammar.parser.engine.operands.outlier.Metric;
import com.data.monkey.grammar.parser.engine.operands.outlier.Point;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;


@Slf4j
public class ClearDataFlowController extends DataFlowController {
    private int maxLengthOfDataCache = 10;
    private Comparator<Map.Entry<String, ArrayList<Metric>>> metricLengthComparator =
            (metricEntry1, metricEntry2) ->
                    (metricEntry2.getValue().size() - metricEntry1.getValue().size());

    @Override
    public Point controllData(Map<String, ArrayList<Metric>> eventDataCache) {

        int maxMetricCount = eventDataCache.entrySet().stream().sorted(this.metricLengthComparator)
                .findFirst().get().getValue().size();
        if (maxMetricCount >= this.maxLengthOfDataCache) {
            clearEventDataCache(eventDataCache);
            return null;
        } else {
            return retrievePoint(eventDataCache);
        }
    }

    private void clearEventDataCache(Map<String, ArrayList<Metric>> eventDataCache) {
        eventDataCache.entrySet().stream().forEach(metricEntry ->
                metricEntry.getValue().clear()
        );
    }
}
