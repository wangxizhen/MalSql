package com.data.monkey.grammar.parser.engine.exception;


public class RuleParseException extends RuntimeException {
    private static final long serialVersionUID = -4709561400676666787L;

    public RuleParseException(String errorMsg) {
        super(errorMsg);
    }

    public RuleParseException(String errorMsg, Throwable throwable) {
        super(errorMsg, throwable);
    }
}
