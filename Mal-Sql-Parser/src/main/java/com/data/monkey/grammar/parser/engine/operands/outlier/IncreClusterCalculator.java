package com.data.monkey.grammar.parser.engine.operands.outlier;


import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.outlier.dataflow.ClearDataFlowController;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Data
public class IncreClusterCalculator {

    //Data pre-processor for composing the metric data from the event.By default, we use
    //the ClearDataFlowController
    private DataPreProcessor dataPreProcessor = new DataPreProcessor(new ClearDataFlowController());

    //Each calculator stores the configuration of anomlist function.
    private AnomListConfig anomListConfig;

    //This field is used for passing the ruleId for the IncreClustering object.
    private String ruleId = "";



    //By default, 10 points represents 10 minutes agent data.
    private int maxLengthOfCalculatedPoints = 10;

    //Only for test (AnomListOperandTest)
    private ArrayList<Outlier> passedOutliers = new ArrayList<>();

    //Storing the passed calculated points. The number of these points is defined by the field maxLengthOfCalculatedPoints.
    private ArrayList<Point> calculatedPoints = new ArrayList<>();

    //Cache the original data from the probes and assemble the data in a point.
    private HashMap<Long, HashMap<String, Metric>> eventDataCache = new HashMap<>();

    /**
     * An IncreClusteringCalculator is created when the first event for the rule
     * comes.
     *
     * @param ruleId
     */
    protected IncreClusterCalculator(String ruleId) {

    }

    public void setAnomListConfig(AnomListConfig anomListConfig) {
        this.anomListConfig = anomListConfig;
        this.dataPreProcessor.setRequiredMetricNames(anomListConfig.getMetrics());
    }


    public void calculate(Event currEvent, List<Event> events, Map<String, String> parameters) {

    }

    /**
     * Count the outliers in which the same metric was presenting the anomaly pattern.
     *
     * @return
     */
    public List<Outlier> getSerialOutlier() {
        List<Outlier> continousOutliers = new ArrayList<>();

        for (Point point : this.calculatedPoints) {
            if (point.getOutlier() != null) {
                if (continousOutliers.size() > 0) {
                    Outlier lastOutlier = continousOutliers.get(continousOutliers.size() - 1);
                    if (lastOutlier.metric_name.equals(point.getOutlier().metric_name)) {
                        continousOutliers.add(point.getOutlier());
                    } else {
                        continousOutliers.clear();
                    }
                } else {
                    continousOutliers.add(point.getOutlier());
                }
            }
        }
        return continousOutliers;
    }

    /**
     * Getting the result for the final user. Called by AnomListOperand.readValue()
     *
     * @return
     */
    public HashMap<String, Object> getAlertResult() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("ruleId", this.ruleId);
        List<Outlier> outliers = getSerialOutlier();
        result.put("outliers", outliers);
        result.put("alertTimestamp", System.currentTimeMillis());
        return result;
    }
}