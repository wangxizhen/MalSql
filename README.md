# MalSql
#运行项目需要在idea中下载antlr4和lombok组件

# 使用demo
select sum(metric1) as sumMetric1 from keyStr
IParserEngine engine =new ParserEngine();
MalSqlParserTemplate template = engine.parse(sql);
 Map<String, String> result=template.getContext(events, null);

