package com.data.monkey.grammar.parser.engine.operands.outlier;


import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.outlier.dataflow.DataFlowController;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Data
public class DataPreProcessor {

    private List<String> requiredMetricNames;

    private DataFlowController dataFlowController;

    private EventDataParser eventDataParser;


    //Data cache. Key represents the metric name, value represents a list of this metric.
    private Map<String, ArrayList<Metric>> eventDataCache = new HashMap<>();

    public void setRequiredMetricNames(List<String> requiredMetricNames) {
        eventDataParser = new EventDataParser(requiredMetricNames);
        eventDataParser.initEventDataCache(this.eventDataCache);
    }


    public DataPreProcessor(DataFlowController dataFlowController) {
        this.dataFlowController = dataFlowController;
    }

    /**
     * Parsing the metric data from the event and store them in the eventDataCache.
     *
     * @param event
     */
    private void parseMetricDataFromEvent(Event event) {
        this.eventDataParser.parse(this.eventDataCache, event);
    }

    /***
     * retrieve the metric data from eventDataCache and assemble them into the object of Point
     * @return
     */
    public Point retrievePoint(Event event) {
        //Parsing the data from the event and store them in the field eventDataCache.
        parseMetricDataFromEvent(event);
        return dataFlowController.controllData(this.eventDataCache);
    }


}
