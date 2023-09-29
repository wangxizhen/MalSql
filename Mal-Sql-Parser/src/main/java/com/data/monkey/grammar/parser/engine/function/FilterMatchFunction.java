package com.data.monkey.grammar.parser.engine.function;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.NameOperand;

@FunctionalInterface
public interface FilterMatchFunction {
     boolean match(NameOperand operand, Event event);
}
