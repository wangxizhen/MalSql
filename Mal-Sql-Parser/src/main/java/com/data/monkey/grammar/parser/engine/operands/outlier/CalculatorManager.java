package com.data.monkey.grammar.parser.engine.operands.outlier;

import java.util.HashMap;

public class CalculatorManager {
    private static volatile CalculatorManager instance = null;
    private HashMap<String, IncreClusterCalculator> calculators = new HashMap<>();

    /**
     * @return
     */
    public synchronized static CalculatorManager getInstance() {
        if (instance == null) {
            instance = new CalculatorManager();
        }
        return instance;
    }

    /**
     * @param ruleId
     * @return
     */
    public synchronized IncreClusterCalculator getCalculator(String ruleId) {
        IncreClusterCalculator calculator = this.calculators.get(ruleId);
        if (calculator == null) {
            calculator = new IncreClusterCalculator(ruleId);
            this.calculators.put(ruleId, calculator);
        }
        return calculator;
    }

    /**
     * @param ruleId
     * @return true if the calculator exists.
     */
    public boolean removeCalculator(String ruleId) {
        IncreClusterCalculator calculator = calculators.get(ruleId);
        if (calculator == null) {
            return false;
        } else {
            calculators.remove(ruleId);
            return true;
        }
    }
}
