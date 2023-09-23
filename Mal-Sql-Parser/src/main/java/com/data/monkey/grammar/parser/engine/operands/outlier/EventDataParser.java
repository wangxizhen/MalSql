package com.data.monkey.grammar.parser.engine.operands.outlier;

import com.data.monkey.common.entity.Event;
import lombok.extern.slf4j.Slf4j;

import java.util.*;


@Slf4j
public class EventDataParser {

    private static Comparator<Metric> metricTimeComparator = (metric1, metric2) -> (
            (int) (metric1.getTimestamp() - metric2.getTimestamp())
    );

    private List<String> requiredMetricNames;

    public Map<String, ArrayList<Metric>> parse(Map<String, ArrayList<Metric>> eventDataCache,
                                                Event event) {
        long timestamp = event.getTimestamp();
        event.getMetrics().entrySet().stream().forEach(metricInEvent -> {
            if (!requiredMetricNames.contains(metricInEvent.getKey()))
                return;
            Double metricValue = Double.parseDouble(metricInEvent.getValue());
            Metric metric = new Metric(timestamp, metricInEvent.getKey(), metricValue);
            List<Metric> metricList = eventDataCache.get(metricInEvent.getKey());
            metricList.add(metric);
            Collections.sort(metricList, metricTimeComparator);
        });
        return eventDataCache;
    }

    public EventDataParser(List<String> requiredMetricNames) {
        this.requiredMetricNames = requiredMetricNames;

    }

    public void initEventDataCache(Map<String, ArrayList<Metric>> eventDataCache) {
        eventDataCache.clear();
        if (requiredMetricNames.size() == 0) {
            log.error("You cannot set the list of metric names with 0 size!");
            return;
        }
        for (String requiredMetricName : requiredMetricNames) {
            ArrayList<Metric> metricList = new ArrayList<>();
            eventDataCache.put(requiredMetricName, metricList);
        }
    }
}
