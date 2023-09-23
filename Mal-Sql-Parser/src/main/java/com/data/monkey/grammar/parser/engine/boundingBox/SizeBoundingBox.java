package com.data.monkey.grammar.parser.engine.boundingBox;

import com.google.common.base.Preconditions;
import lombok.Getter;

@Getter
public class SizeBoundingBox implements BoundingBox
{
    private final long size;

    public SizeBoundingBox(long size)
    {
        Preconditions.checkArgument(size > 0, "size > 0");
        this.size = size;
    }
}
