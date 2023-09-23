package com.data.monkey.grammar.parser.engine.operands.outlier.dataflow;



import com.data.monkey.grammar.parser.engine.operands.outlier.Metric;
import com.data.monkey.grammar.parser.engine.operands.outlier.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public abstract class DataFlowController {
    public abstract Point controllData(Map<String, ArrayList<Metric>> eventDataCache);

    protected boolean checkMetricReady(Map<String, ArrayList<Metric>> eventDataCache) {
        boolean metricListReady = true;
        for (Map.Entry<String, ArrayList<Metric>> entry : eventDataCache.entrySet()) {
            if (entry.getValue().size() == 0) {
                metricListReady = false;
                break;
            }
        }
        return metricListReady;
    }

    protected Point retrievePoint(Map<String, ArrayList<Metric>> eventDataCache) {
        if (!checkMetricReady(eventDataCache)) {
            return null;
        }
        Point point = new Point();
        point.setTimestamp(getAvgTimestamp(eventDataCache));
        eventDataCache.entrySet().stream().forEach(metricsEntry -> {
            Metric firstMetric = metricsEntry.getValue().get(0);
            metricsEntry.getValue().remove(0);
            point.getMetricValues().put(metricsEntry.getKey(), firstMetric);
        });
        return point;
    }

    protected long getAvgTimestamp(Map<String, ArrayList<Metric>> eventDataCache) {
        long timestampTotal = 0l;
        long avgTimestamp = (long) eventDataCache.entrySet().stream().mapToLong(metricEntry -> (
                metricEntry.getValue().get(0).getTimestamp()
        )).average().getAsDouble();
        List<String> metricNames = getMetricNamesFromEventDataCache(eventDataCache);
        if (metricNames.size() != 0) avgTimestamp = timestampTotal / metricNames.size();
        return avgTimestamp;
    }

    protected List<String> getMetricNamesFromEventDataCache(Map<String, ArrayList<Metric>> eventDataCache) {
        List<String> metricNames = new ArrayList<>();
        eventDataCache.entrySet().stream().forEach(metricEntry -> {
            metricNames.add(metricEntry.getKey());
        });
        return metricNames;
    }
}
