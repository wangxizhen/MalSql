package com.data.monkey.test.parser.engine.operands;

import com.data.monkey.common.entity.Event;
import com.data.monkey.grammar.parser.engine.IParserEngine;
import com.data.monkey.grammar.parser.engine.MalSqlParserTemplate;
import com.data.monkey.grammar.parser.engine.ParserEngine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ContainExprTest extends BaseTestUtils{

    @Test
    public void testContainByExpr() {

/*        String sql = "select sum(val1) as sum_val1 from test where sum(val1) > 4 and val2 like b% for last 3 min";
        sql = "select sum(val1) as sum_val1 from test where sum(val1) > 4 and val2 like %b for last 3 min";
        // sql = "select sum(val1) as sum_val1 from test where sum(val1) < 4  for last 3 min";

        MalSqlParserTemplate template = engine.parse(sql);
        Assert.assertNotNull(template);*/

/*        List<Event> events = new ArrayList<>();

        Map<String, String> raw = new HashMap<>();
        raw.put("val1", "-4");
        raw.put("val2", "as");
        raw.put("val3", "as");
        Event event = new Event("test", raw);
        events.add(event);

        raw = new HashMap<>();
        raw.put("val1", "-2");
        raw.put("val2", "bs");
        raw.put("val3", "cs");
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
        raw.put("val2", "baa");
        raw.put("val3", "aaaa");
        Event event4 = new Event("test", raw);
        events.add(event4);

        assertEquals("5.0", template.getContext( events, null).get("sum_val1"));
        Assert.assertTrue(template.getResult( events, null));*/
    }


    @Test
    public void testSimpleSql() {

        String sql = "select sum(metric1) as sumMetric1,sum(metric2) as sumMetric2 from keyStr";
        // sql = "select sum(val1) as sum_val1 from test where sum(val1) < 4  for last 3 min";

        MalSqlParserTemplate template = engine.parse(sql);
        Assert.assertNotNull(template);

        List<Event> events = new ArrayList<>();

        Map<String, String> curMetric = new HashMap<>();
        curMetric.put("metric1", "-4");
        curMetric.put("metric2", "5");
        Event curEvent = new Event("keyStr", curMetric);


        Map<String, String> metric = new HashMap<>();
        metric.put("metric1", "-4");
        metric.put("metric2", "5");
        Event event = new Event("keyStr", metric);
        events.add(event);
        Map<String, String> metric2 = new HashMap<>();
        metric2.put("metric1", "3");
        metric2.put("metric2", "8");
        Event  event2 = new Event("keyStr", metric2);
        events.add(event2);

        Map<String, String> res = template.getContext( events, null);
        System.out.println(res);


        //  Assert.assertTrue(template.getResult(null, events, null));
    }


}
