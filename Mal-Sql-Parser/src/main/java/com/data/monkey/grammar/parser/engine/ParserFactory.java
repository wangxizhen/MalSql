package com.data.monkey.grammar.parser.engine;


import com.data.monkey.grammar.MalSqlLexer;
import com.data.monkey.grammar.MalSqlParserParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

public class ParserFactory {
    public static MalSqlParserParser createParser(final String queryText) {
        MalSqlLexer lexer = newMalSqlLexer(queryText);

        TokenStream tokenStream = new CommonTokenStream(lexer);
        MalSqlParserParser parser = new MalSqlParserParser(tokenStream);
        //and error listener and handler
        return parser;
    }

    private static MalSqlLexer newMalSqlLexer(final String queryTest) {
        ANTLRInputStream input = new ANTLRInputStream(queryTest);
        MalSqlLexer lexer = new MalSqlLexer(input);
        lexer.removeErrorListeners();
        return lexer;
    }
}
