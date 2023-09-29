package com.data.monkey.grammar.parser.engine.booleanExprs;


import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractAggregationOperand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public abstract class BooleanExprBase implements IBooleanExpression {
    private final Operand left;
    private final Operand right;

    protected Object leftValue(List<Event> events, Map<String, String> parameters) {
        return   getLeft().getValue(events, parameters);
    }

    protected Object rightValue(List<Event> events, Map<String, String> parameters) {
        return getRight().getValue(events, parameters);
    }

    protected boolean sameType(Object leftValue, Object rightValue) {
        return leftValue.getClass() == rightValue.getClass();
    }

    protected int compare(Comparable leftValue, Comparable rightValue) {
        return ObjectUtils.compare(leftValue, rightValue);
    }

    @Override
    public Set<AbstractAggregationOperand> getAggregationOperands() {
        Set<AbstractAggregationOperand> aggregationOperands = left.getAggregationOperands();
        aggregationOperands.addAll(right.getAggregationOperands());
        return aggregationOperands;
    }

    public abstract String getExpressionName();

    @Override
    public String toReadableString()
    {
        return String.format(
            "%s %s %s",
            this.getLeft().toReadableString(),
            this.getExpressionName(),
            this.getRight().toReadableString()
        );
    }

    @Override
    public String toString()
    {
        return String.format(
            "%s(left=%s, right=%s)",
            this.getClass().getSimpleName(),
            Objects.toString(this.getLeft()),
            Objects.toString(this.getRight())
        );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.getLeft(), this.getRight(), this.getExpressionName());
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            final BooleanExprBase expr = (BooleanExprBase) obj;
            return Objects.equals(this.getLeft(), expr.getLeft()) &&
                   Objects.equals(this.getRight(), expr.getRight());
        }
        return false;
    }
}
