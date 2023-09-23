package com.data.monkey.grammar.parser.engine.processing;

import java.util.Optional;

public interface ReadableEvent
{
    Optional<Object> readValue(String field);

    long getTimeStamp();

    String getPartitionKey();
}
