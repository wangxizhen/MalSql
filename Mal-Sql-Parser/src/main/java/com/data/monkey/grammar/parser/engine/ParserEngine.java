package com.data.monkey.grammar.parser.engine;

import com.data.monkey.grammar.MalSqlParserParser;
import org.apache.commons.lang3.Validate;


public class ParserEngine implements IParserEngine {

    @Override
    public MalSqlParserTemplate parse(String sql) throws MalSqlParserEngineError {
        Validate.notBlank(sql);

        MalSqlParserParser malSqlParser = ParserFactory.createParser(sql);
        MalSqlParserParser.RootContext tree = malSqlParser.root();
        MalSqlParser parser = new MalSqlParser();
        try{
            Boolean isQuery = parser.visit(tree);

            if (isQuery == null || !isQuery) {
                throw new MalSqlParserEngineError("Query not supported: " + sql, null);
            }
        } catch (RuntimeException e) {
            throw new MalSqlParserEngineError(e.getMessage(), e);
        }

        //validate rule template
        return parser.getMalSqlParserTemplate();
    }
}
