package com.data.monkey.grammar.parser.engine.boundingBox;

import lombok.Getter;

import java.time.Duration;

@Getter
public class TimeBoundingBox implements BoundingBox
{
    private final Duration duration;

    public TimeBoundingBox(Duration duration) {this.duration = duration;}
}
