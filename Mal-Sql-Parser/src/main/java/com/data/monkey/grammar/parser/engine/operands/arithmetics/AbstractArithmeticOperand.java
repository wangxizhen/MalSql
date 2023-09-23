package com.data.monkey.grammar.parser.engine.operands.arithmetics;

import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.operands.aggregations.AbstractAggregationOperand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import lombok.*;

import java.util.Objects;
import java.util.Set;
import java.util.function.BiFunction;

@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractArithmeticOperand implements Operand {
    @Getter
    @Setter(AccessLevel.PACKAGE)
    protected Operand left;
    @Getter
    @Setter(AccessLevel.PACKAGE)
    protected Operand right;

    @Override
    public Object getValue(ProcessingContext context)
    {
        final Object leftValue = left.getValue(context);
        final Object rightValue = right.getValue(context);
        return getArithmeticOperation().apply(leftValue, rightValue);
    }

    protected abstract BiFunction<Object, Object, Object> getArithmeticOperation();

    protected abstract String getArithmeticName();

    @Override
    public String toReadableString()
    {
        return String.format("(%s)%s(%s)", getLeft().toReadableString(), getArithmeticName(), getRight().toReadableString());
    }

    @Override
    public Set<AbstractAggregationOperand> getAggregationOperands() {
        Set<AbstractAggregationOperand> aggregationOperands = right.getAggregationOperands();
        aggregationOperands.addAll(left.getAggregationOperands());
        return aggregationOperands;
    }

    @Override
    public String toString()
    {
        return String.format(
            "%s(left=%s, right=%s)",
            this.getClass().getSimpleName(),
            Objects.toString(getLeft()),
            Objects.toString(getRight())
        );
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        } else if (obj != null && obj.getClass() == this.getClass()) {
            final AbstractArithmeticOperand operand = (AbstractArithmeticOperand) obj;
            return Objects.equals(operand.getLeft(), this.getLeft()) &&
                   Objects.equals(operand.getRight(), this.getRight());
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.getArithmeticName(), this.getLeft(), this.getRight());
    }
}
