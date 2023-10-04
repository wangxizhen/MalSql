package com.data.monkey.grammar.parser.engine.conditionExprs;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.operands.SetOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import com.google.common.base.Preconditions;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * LIKE clause
 *
 */
public class LikeCondition extends BooleanExprBase {

    public LikeCondition(Operand left, Operand right) {
        super(left, right);
    }

    @Override
    public boolean getResult( List<Event> events, Map<String, String> parameters) {
        String val = getLeftValue(events, parameters);
        String paramValue =  getRightValue(events, parameters);
        return val!=null && paramValue!=null&&val.contains(paramValue);
    }

    public String getLeftValue(List<Event> events, Map<String, String> parameters){
           return "";
    }


    public String getRightValue(List<Event> events, Map<String, String> parameters){
         return "";
    }

    @Override
    public Boolean getResult(ProcessingContext context)
    {
        Preconditions.checkArgument(this.getRight() instanceof SetOperand);
        final Object value = this.getLeft().getValue(context);
        final Set<Object> expectedValues = (Set<Object>) this.getRight().getValue(context);
        return expectedValues.contains(value);
    }

    @Override
    public String getExpressionName()
    {
        return "like";
    }
}
