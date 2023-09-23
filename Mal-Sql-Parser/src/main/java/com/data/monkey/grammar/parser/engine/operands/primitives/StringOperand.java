package com.data.monkey.grammar.parser.engine.operands.primitives;

public class StringOperand extends AbstractPrimitiveOperand<String>
{
    public StringOperand(String value)
    {
        super(value);
    }

    @Override
    public String toReadableString()
    {
        return value == null ? "null" : String.format("'%s'", value.toString());
    }
}
