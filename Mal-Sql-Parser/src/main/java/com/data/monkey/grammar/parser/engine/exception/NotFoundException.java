package com.data.monkey.grammar.parser.engine.exception;


public class NotFoundException extends RuntimeException {

    public NotFoundException(Object target) {
        super(String.format("not found %s", target));
    }

    private static final long serialVersionUID = 1L;

}
