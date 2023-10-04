package com.data.monkey.grammar.parser.engine.operands.aggregations;

import com.data.monkey.grammar.parser.engine.conditionExprs.IBooleanExpression;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import com.data.monkey.grammar.parser.engine.processing.ProcessingException;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;


import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * this class subs AbstractSingleOperand due to compatibility issue.
 */
public abstract class AbstractAggregationOperand extends AbstractSingleOperand
{

    public AbstractAggregationOperand(Operand innerOperand, IBooleanExpression predicate) {
        super(innerOperand, predicate);
    }

    public AbstractAggregationOperand(IBooleanExpression predicate)
    {
        super(predicate);
    }

    public AbstractAggregationOperand(Operand innerOperand) {
        super(innerOperand);
    }

    @Override
    public Object getValue(ProcessingContext context)
    {
        final ListenableFuture<Double> defaultValue = Futures.immediateFuture(this.getAggregationInitialValue());
        try {
            //how to determine the timeout value
            return context.getAggregationValues().getOrDefault(this, defaultValue).get(10, TimeUnit.SECONDS);
        }
        catch (Exception e) {
            final String message = String.format("compute aggregation operand [%s] value error", this);
            throw new ProcessingException(message, e);
        }
    }

    protected abstract String getAggregationType();

    public Set<AbstractAggregationOperand> getAggregationOperands() {
        return Sets.newHashSet(this);
    }

    public abstract Double getAggregationInitialValue();

    public abstract AggregationFunction getAggregationFunction();

    @Override
    public String toReadableString()
    {
        if (this.getPredicate() != null) {
            return String.format(
                "%s(%s) if %s",
                this.getAggregationType().toLowerCase(),
                this.getInnerOperand().toReadableString(),
                this.getPredicate().toReadableString()
            );
        } else {
            return String.format(
                "%s(%s)",
                this.getAggregationType().toLowerCase(),
                this.getInnerOperand().toReadableString()
            );
        }
    }

    @Override
    public String toString()
    {
        return String.format(
            "%s(innerOperand=%s, predicate=%s)",
            this.getClass().getSimpleName(),
            Objects.toString(this.getInnerOperand()),
            Objects.toString(this.getPredicate())
        );
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            final AbstractAggregationOperand operand = (AbstractAggregationOperand) obj;
            return Objects.equals(this.getInnerOperand(), operand.getInnerOperand()) &&
                   Objects.equals(this.getPredicate(), operand.getPredicate());
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.getAggregationType(), this.getInnerOperand(), this.getPredicate());
    }
}
