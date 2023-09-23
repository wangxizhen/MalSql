package com.data.monkey.grammar.parser.engine.processing;

public class ProcessingException extends RuntimeException {
    public ProcessingException(String message, Exception cause) {
        super(message, cause);
    }
}
