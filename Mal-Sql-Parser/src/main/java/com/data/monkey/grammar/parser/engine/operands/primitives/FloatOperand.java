package com.data.monkey.grammar.parser.engine.operands.primitives;

public class FloatOperand extends AbstractPrimitiveOperand<Double>
{
    public FloatOperand(Double value)
    {
        super(value);
    }

    public FloatOperand(Long value)
    {
        super(Double.valueOf(value));
    }

    public FloatOperand(Float value)
    {
        super(Double.valueOf(value));
    }
}
