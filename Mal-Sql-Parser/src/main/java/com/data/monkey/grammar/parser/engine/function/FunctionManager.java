package com.data.monkey.grammar.parser.engine.function;

import com.data.monkey.grammar.parser.engine.exception.RuleParseException;
import com.data.monkey.grammar.parser.engine.operands.aggregations.*;
import com.data.monkey.grammar.parser.engine.operands.outlier.single.AnomListOperand;
import com.data.monkey.grammar.parser.engine.operands.outlier.single.AnomListSizeOperand;
import com.google.common.collect.Maps;


import java.util.Map;


public class FunctionManager {
    private static final Map<String, Function> funs = Maps.newConcurrentMap();


    static {
        funs.put("sum", new CommonFunction(SumOperand.class, "sum"));
        funs.put("avg", new CommonFunction(AvgOperand.class, "avg"));
        funs.put("maximum", new CommonFunction(MaxOperand.class, "maximum"));
        funs.put("minimum", new CommonFunction(MinOperand.class, "minimum"));
        funs.put("count", new CommonFunction(CountOperand.class, "count"));
        funs.put("previous", new CommonFunction(PreviousOperand.class, "previous"));
        funs.put("period", new CommonFunction(PeriodOperand.class, "period"));
        funs.put("anomlist", new CommonFunction(AnomListOperand.class, "anomlist"));
        funs.put("anomlistsize", new CommonFunction(AnomListSizeOperand.class, "anomlistsize"));
    }


    public static Function getFunction(String functionName) {
        if (!funs.containsKey(functionName.toLowerCase())) {
            throw new RuleParseException("parse sql error:not found " + functionName + " funcation");
        }
        return funs.get(functionName.toLowerCase());
    }
}
