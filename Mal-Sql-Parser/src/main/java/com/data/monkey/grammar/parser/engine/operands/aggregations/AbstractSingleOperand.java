package com.data.monkey.grammar.parser.engine.operands.aggregations;


import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.booleanExprs.BooleanExprAND;
import com.data.monkey.grammar.parser.engine.booleanExprs.BooleanExprBase;
import com.data.monkey.grammar.parser.engine.booleanExprs.BooleanExprOR;
import com.data.monkey.grammar.parser.engine.booleanExprs.IBooleanExpression;
import com.data.monkey.grammar.parser.engine.exception.NotFoundException;
import com.data.monkey.grammar.parser.engine.operands.NameOperand;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.operands.arithmetics.AbstractArithmeticOperand;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

@Deprecated
@Getter
@Setter
public abstract class AbstractSingleOperand implements Operand {
    private Operand innerOperand;
    private IBooleanExpression predicate;

    public AbstractSingleOperand(Operand innerOperand, IBooleanExpression predicate) {
        this.innerOperand = innerOperand;
        this.predicate = predicate;
    }

    public AbstractSingleOperand(Operand innerOperand) {
        this.innerOperand = innerOperand;
    }

    public AbstractSingleOperand(IBooleanExpression predicate) {
        this.predicate = predicate;
    }

    public Operand getNameOperand() {
        //
        if (getInnerOperand() != null)
            return getInnerOperand();
        else if (getPredicate() != null) {
            if (predicate instanceof BooleanExprBase) {
                return getNameOperandFromBooleanExprBase(predicate);
            } else {
                IBooleanExpression p = predicate;
                while (p instanceof BooleanExprAND || p instanceof BooleanExprOR) {
                    if (p instanceof BooleanExprAND)
                        p = ((BooleanExprAND) p).getLeft();
                    if (p instanceof BooleanExprOR)
                        p = ((BooleanExprOR) p).getLeft();
                }
                return getNameOperandFromBooleanExprBase(p);
            }
        }

        return null;
    }

    private Operand getNameOperandFromBooleanExprBase(IBooleanExpression expr) {
        if (!(expr instanceof BooleanExprBase))
            return null;

        BooleanExprBase booleanExprBase = (BooleanExprBase) expr;

        if (booleanExprBase.getLeft() instanceof NameOperand
                || booleanExprBase.getLeft() instanceof AbstractArithmeticOperand)
            return booleanExprBase.getLeft();
        else if (booleanExprBase.getRight() instanceof NameOperand
                || booleanExprBase.getRight() instanceof AbstractArithmeticOperand)
            return booleanExprBase.getRight();
        return null;
    }

    protected Stream<Event> filter(List<Event> events, Map<String, String> parameters) {

        Stream<Event> stream = events.stream().filter(e -> {
            try {
                getNameOperand().getValue(Collections.singletonList(e), parameters).toString();
                return true;
            } catch (NotFoundException ex) {
                // 聚合函数需要过滤不存在指定metric的event
                return false;
            }
        });

        if (getPredicate() != null) {
            stream = stream.filter(e -> getPredicate().getResult(Collections.singletonList(e), parameters));
        }

        return stream;
    }

    protected Stream<Event> filterForCalculus(Stream<Event> stream, Map<String, String> parameters) {

        return stream
                .filter(e -> {
                    try {
                        Double.parseDouble(getNameOperand().getValue(Collections.singletonList(e), parameters).toString());
                        return true;
                    } catch (NumberFormatException ex) {
                        // 需要做数值计算的的聚合函数需要过滤metric值为字符串的event
                        return false;
                    }
                });
    }


    @Override
    public Set<AbstractAggregationOperand> getAggregationOperands() {
        throw new UnsupportedOperationException();
    }
}
