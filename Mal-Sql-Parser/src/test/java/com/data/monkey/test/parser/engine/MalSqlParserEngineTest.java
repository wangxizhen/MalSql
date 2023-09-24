package com.data.monkey.test.parser.engine;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.IParserEngine;
import com.data.monkey.grammar.parser.engine.ParserEngine;
import com.data.monkey.grammar.parser.engine.MalSqlParserTemplate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MalSqlParserEngineTest {

    private IParserEngine engine;

    @Before
    public void setUp() {
        engine =new ParserEngine();
    }
    
    @Test
    public void testParserSqlByColumns(){
        String sql="select sum(age / scope) as devRes,age from parserSql where (name=1 or age=1) or type=one and hobby=eat";
        MalSqlParserTemplate template = engine.parse(sql);
        System.out.println(template.getColumns());

    }



    @Test
    public void testParserSqlByWhereOrAndAnd(){
        String sql="select name,age from parserSql where (name=1 or age=1) and type=one";
        sql="select name,age from parserSql where (name=1 or age=1) and type=one or hobby=eat";
        sql="select name,age from parserSql where (name=1 or age=1) or type=one and hobby=eat";
        sql="select name / hobby,age from parserSql where (name=1 or age=1) or type=one and hobby=eat";

        MalSqlParserTemplate template = engine.parse(sql);
        System.out.println(template.getWhereClause());
    }

    @Test
    public void testCacluteRes(){
        String sql = "select (sum(num1) / sum(num2)) as num from tableName1 ";

        MalSqlParserTemplate template = engine.parse(sql);
        Assert.assertNotNull(template);

        List<Event> events = new ArrayList<>();

        Map<String, String> metric = new HashMap<>();
        metric.put("num1", "2");
        metric.put("num2", "4");

        Event event = new Event("tableName1", metric);
        events.add(event);

        HashMap metric2 = new HashMap<>();
        metric2.put("num2", "4");
        metric2.put("num1", "6");

        event = new Event("tableName1", metric2);
        events.add(event);

        Map<String, String> context = template.getContext(null, events, null);
        assertEquals(1, Double.parseDouble(context.get("num")), 0.01);

    }



}
