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

    public List<Event> getEvents(){
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
        return events;
    }


    @Test
    public void testCacluteRes(){
        String sql = "select (sum(num1) / sum(num2)) as num from tableName1 ";
        sql="select (sum(num1) / sum(num2)) as num from tableName1  filter by num1<1";
        MalSqlParserTemplate template = engine.parse(sql);
        Assert.assertNotNull(template);
        List<Event> events = getEvents();
        Map<String, String> context = template.getContext(null, events, null);
        assertEquals(1, Double.parseDouble(context.get("num")), 0.01);
    }


    @Test
    public void testFilterByExpr() {
        //过滤过去对应时间内的数据和最近一条对应的过滤字段值都相等的数据进行计算
        // filter by val2, val3
        // 最近一条数据即为event4  val2 对应的值b  val3 对应的值为 a   则相同的字段值为 event3  则两条数据相加即为5

        String sql = "select sum(val1) as sum_val1 from test where sum(val1) > 4 filter by val2, val3 for last 3 min";

        MalSqlParserTemplate template = engine.parse(sql);
        Assert.assertNotNull(template);

        List<Event> events = new ArrayList<>();

        Map<String, String> raw = new HashMap<>();
        raw.put("val1", "-4");
        raw.put("val2", "a");
        raw.put("val3", "a");
        Event event = new Event("test", raw);
        events.add(event);

        raw = new HashMap<>();
        raw.put("val1", "-2");
        raw.put("val2", "b");
        raw.put("val3", "c");
        Event  event2 = new Event("test", raw);
        events.add(event2);

        raw = new HashMap<>();
        raw.put("val1", "2");
        raw.put("val2", "b");
        raw.put("val3", "a");
        Event event3 = new Event("test", raw);
        events.add(event3);

        raw = new HashMap<>();
        raw.put("val1", "3");
        raw.put("val2", "b");
        raw.put("val3", "a");
        Event event4 = new Event("test", raw);
        events.add(event4);

        assertEquals("5.0", template.getContext(null, events, null).get("sum_val1"));
        Assert.assertTrue(template.getResult(null, events, null));
    }






}
