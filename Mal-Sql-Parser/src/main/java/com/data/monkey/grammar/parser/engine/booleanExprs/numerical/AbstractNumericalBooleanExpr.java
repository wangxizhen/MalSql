package com.data.monkey.grammar.parser.engine.booleanExprs.numerical;


import com.data.monkey.grammar.parser.engine.booleanExprs.BooleanExprBase;
import com.data.monkey.grammar.parser.engine.operands.Operand;
import com.data.monkey.grammar.parser.engine.processing.ProcessingContext;
import com.google.common.base.Preconditions;

public abstract class AbstractNumericalBooleanExpr extends BooleanExprBase
{
    public AbstractNumericalBooleanExpr(Operand left, Operand right) {super(left, right);}

    @Override
    public Boolean getResult(ProcessingContext context)
    {
        final Object leftValue = getLeft().getValue(context);
        final Object rightValue = getRight().getValue(context);

        Preconditions.checkNotNull(leftValue);
        Preconditions.checkNotNull(rightValue);
        Preconditions.checkArgument(leftValue instanceof Number, "operand value should be number");
        Preconditions.checkArgument(rightValue instanceof Number, "operand value should be number");
        final double leftNumber = ((Number) leftValue).doubleValue();
        final double rightNumber = ((Number) rightValue).doubleValue();

        return predication(leftNumber, rightNumber);
    }

    protected abstract boolean predication(double leftNumber, double rightNumber);

    protected boolean isEqualWithinPrecision(double leftNumber, double rightNumber)
    {
        return Math.abs(leftNumber - rightNumber) < 0.000001;
    }
}
