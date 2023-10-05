package com.data.monkey.grammar.parser.engine.function;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.Operand;

@FunctionalInterface
public interface FilterMatchFunction {
     boolean match(Operand operand, Event event);
}
