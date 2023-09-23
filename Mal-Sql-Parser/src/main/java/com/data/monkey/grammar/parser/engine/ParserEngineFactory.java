package com.data.monkey.grammar.parser.engine;


public final class ParserEngineFactory {

    private static IParserEngine parserEngine = (IParserEngine) new MalSqlParser();

    private ParserEngineFactory() {
        // no construct
    }

    public static IParserEngine getParseEngine() {
        return parserEngine;
    }
}
