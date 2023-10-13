# MalSql
#Running the project requires downloading the Antlr4 and Lombok components in the idea


## the description of  com.data.monkey.common.entity.Event

| Name | description  | Type | 
|---|---|---|
| key |  table name   | string |
| metrics |  the field of the table to calculate   | Map |
| timestamp |  timestamp   | long |


select sum(field) as sumField from tableName
- **field**.  the field  is defined in the metrics of  Event
- **sumField**. Aliases displayed in the results 
- **tableName**.  the tableName is the field  key of Event


# demo1
- **the simple sql**

```
List<Event> events = new ArrayList<>();

Map<String, String> metric = new HashMap<>();
metric.put("field1", "-4");
metric.put("field2", "3");
Event event = new Event("tableName", metric);
events.add(event);
Map<String, String> metri2  = new HashMap<>();
metri2.put("field1", "-2");
metri2.put("field2", "-1");
Event  event2 = new Event("tableName", metri2);
events.add(event2);

String sql="select sum(field1) as sumMetric1,sum(field2) as sumMetric2 from tableName"; 
IParserEngine engine =new ParserEngine();      
MalSqlParserTemplate template = engine.parse(sql); 
Map<String, String> result=template.getContext(events, null);

the result is {sumMetric2=2.0, sumMetric1=-6.0}




```



# demo2
- **Where statement**

```
Map<String, String> params = new HashMap<>();
params.put("avgParams","-7");
String sqlParams="select sum(field1) as sumMetric1,sum(field2) as sumMetric2 from tableName where sum(field1) >= ?avgParams"; 
MalSqlParserTemplate templateParams = engine.parse(sqlParams); 
boolean result = templateParams.getResult(events, params);
the result is true


```


