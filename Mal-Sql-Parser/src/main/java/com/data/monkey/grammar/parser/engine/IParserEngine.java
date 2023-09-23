package com.data.monkey.grammar.parser.engine;



public interface IParserEngine {

    MalSqlParserTemplate parse(String sql) throws MalSqlParserEngineError;
}
