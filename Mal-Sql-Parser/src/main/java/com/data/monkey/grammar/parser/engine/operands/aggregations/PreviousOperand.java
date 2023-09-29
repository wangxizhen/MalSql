package com.data.monkey.grammar.parser.engine.operands.aggregations;



import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.booleanExprs.IBooleanExpression;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PreviousOperand extends AbstractSingleOperand {

    public PreviousOperand(Operand innerOperand) {
        super(innerOperand);
    }

    public PreviousOperand(IBooleanExpression predicate) {
        super(predicate);
    }

    public PreviousOperand(Operand innerOperand, IBooleanExpression predicate) {
        super(innerOperand, predicate);
    }


    @Override
    public Object getValue(List<Event> events, Map<String, String> parameters) {

        Class metricValueClazz = getNameOperand().getValue(events, parameters).getClass();

        Stream<Event> stream = events.stream();

        // 和其他聚合函数有一点区别: 当前事件不能被过滤条件处理
        stream = stream.filter(e -> !e.equals(events.get(events.size() - 1)));

        if(getPredicate() != null) {
            stream = stream.filter(e -> getPredicate().getResult(Arrays.asList(e), null));
        }

        List<Event> filtered = stream.collect(Collectors.toList());

        // 如果无法获取到当前event的前一个event, 需要根据当前event中对应metric的类型返回默认值.
        if(filtered.isEmpty()) {
            if(metricValueClazz.equals(String.class))
                return "";
            else
                return 0.0;
        }
        return getNameOperand().getValue(filtered, parameters);

    }

    @Override
    public Object getValue(ProcessingContext context)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toReadableString()
    {
        return String.format("PREV(%s)", this.getInnerOperand().toReadableString());
    }

}
