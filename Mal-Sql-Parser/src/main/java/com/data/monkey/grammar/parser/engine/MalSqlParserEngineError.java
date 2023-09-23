package com.data.monkey.grammar.parser.engine;

public class MalSqlParserEngineError extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MalSqlParserEngineError(String message, Throwable cause) {
        super(message, cause);
    }
}