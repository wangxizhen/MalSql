# MalSql
#运行项目需要在idea中下载antlr4和lombok组件

### com.data.monkey.common.entity.Event

the description of  com.data.monkey.common.entity.Event

| Name | description  | Type | 
|---|---|---|
| key |  table name   | string |
| metrics |  the field of the table to calculate   | Map |
| timestamp |  timestamp   | long |

# 使用demo
select sum(metric1) as sumMetric1 from keyStr
IParserEngine engine =new ParserEngine();
MalSqlParserTemplate template = engine.parse(sql);
Map<String, String> result=template.getContext(events, null);

