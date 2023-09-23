package com.data.monkey.test.parser.engine;

import com.data.monkey.grammar.parser.engine.IParserEngine;
import com.data.monkey.grammar.parser.engine.ParserEngine;
import com.data.monkey.grammar.parser.engine.MalSqlParserTemplate;
import org.junit.Before;
import org.junit.Test;

public class MalSqlParserEngineTest {

    private IParserEngine engine;

    @Before
    public void setUp() {
        engine =new ParserEngine();
    }
    
    @Test
    public void testParserSql(){

        MalSqlParserTemplate template = engine.parse("select name,age from parserSql");
        System.out.println(template.getColumns());

    }

    @Test
    public void testParserSqlBySimpleWhere(){
        MalSqlParserTemplate template = engine.parse("select name,age from parserSql where name=1");
        System.out.println(template.getWhereClause());
    }

    @Test
    public void testParserSqlByWhereAnd(){
        MalSqlParserTemplate template = engine.parse("select name,age from parserSql where name=1 and age=1");
        System.out.println(template.getWhereClause());
    }

    @Test
    public void testParserSqlByWhereOr(){
        MalSqlParserTemplate template = engine.parse("select name,age from parserSql where name=1 or age=1");
        System.out.println(template.getWhereClause());
    }

    @Test
    public void testParserSqlByWhereOrAndAnd(){
        String sql="select name,age from parserSql where (name=1 or age=1) and type=one";
        sql="select name,age from parserSql where (name=1 or age=1) and type=one or hobby=eat";
        sql="select name,age from parserSql where (name=1 or age=1) or type=one and hobby=eat";
        MalSqlParserTemplate template = engine.parse(sql);
        System.out.println(template.getWhereClause());
    }



}
