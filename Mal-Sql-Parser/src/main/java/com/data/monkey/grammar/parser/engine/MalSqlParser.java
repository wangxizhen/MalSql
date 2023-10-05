package com.data.monkey.grammar.parser.engine;


import com.data.monkey.grammar.MalSqlLexer;
import com.data.monkey.grammar.MalSqlParserVisitor;
import com.data.monkey.grammar.parser.engine.conditionExprs.*;
import com.data.monkey.grammar.parser.engine.conditionExprs.numerical.GreatCondition;
import com.data.monkey.grammar.parser.engine.conditionExprs.numerical.GreatEqCondition;
import com.data.monkey.grammar.parser.engine.conditionExprs.numerical.LessCondition;
import com.data.monkey.grammar.parser.engine.conditionExprs.numerical.LessThanEqCondition;
import com.data.monkey.grammar.parser.engine.boundingBox.SizeBoundingBox;
import com.data.monkey.grammar.parser.engine.boundingBox.TimeBoundingBox;
import com.data.monkey.grammar.parser.engine.datasource.AllEventsFinder;
import com.data.monkey.grammar.parser.engine.datasource.FixedCountEventsFinder;
import com.data.monkey.grammar.parser.engine.datasource.TimeWindowEventsFinder;
import com.data.monkey.grammar.parser.engine.exception.RuleParseException;
import com.data.monkey.grammar.parser.engine.function.Function;
import com.data.monkey.grammar.parser.engine.function.FunctionManager;
import com.data.monkey.grammar.parser.engine.operands.*;
import com.data.monkey.grammar.parser.engine.operands.aggregations.PeriodOperand;
import com.data.monkey.grammar.parser.engine.operands.arithmetics.*;
import com.data.monkey.grammar.parser.engine.operands.like.ContainLikeOperand;
import com.data.monkey.grammar.parser.engine.operands.like.LeftLikeOperand;
import com.data.monkey.grammar.parser.engine.operands.like.RightLikeOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.FloatOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.IntegerOperand;
import com.data.monkey.grammar.parser.engine.operands.primitives.StringOperand;
import com.google.common.collect.Lists;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import com.data.monkey.grammar.MalSqlParserParser.*;
import org.apache.commons.lang3.StringUtils;

import java.time.Duration;
import java.util.*;

import static java.time.Duration.*;
import static java.time.Duration.ofDays;
import static java.util.stream.Collectors.toList;

public class MalSqlParser implements MalSqlParserVisitor<Boolean> {

    private Deque<Object> stack = new ArrayDeque<>();


    private List<PeriodOperand> periodOperands = Lists.newArrayList();
    private MalSqlParserTemplate.MalSqlParserTemplateBuilder builder = MalSqlParserTemplate.builder();

    private String tableName;

    @Override
    public Boolean visit(ParseTree parseTree) {
        return parseTree instanceof RootContext && visitRoot((RootContext) parseTree);
    }

    @Override
    public Boolean visitChildren(RuleNode arg0) {
        return false;
    }

    @Override
    public Boolean visitErrorNode(ErrorNode arg0) {
        return false;
    }

    @Override
    public Boolean visitTerminal(TerminalNode arg0) {
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Boolean visitRoot(RootContext ctx) {
        if (ctx.tableName() != null) {
            if (!visitTableName(ctx.tableName()))
                return false;
            builder.tables((List<String>) stack.pop());
        }
        if (ctx.fields() != null) {
            if (!visitFields(ctx.fields())) {
                return false;
            }
            builder.columns((List<Operand>) stack.pop());
        }

        if (ctx.whereStatement() != null) {
            if (!visitWhereStatement(ctx.whereStatement())) {
                return false;
            }
            builder.whereClause((IBooleanExpression) stack.pop());
        } else {
            //没有where,则获取所有事件
            builder.eventsFinder(AllEventsFinder.newInstance());
        }
        if (ctx.exportStatement() != null) {
            if (!(visitExportStatement(ctx.exportStatement()))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean visitFields(FieldsContext ctx) {
        List<Operand> oprands = new ArrayList<>();
        List<FieldContext> list = ctx.field();
        for (FieldContext fieldContext : list) {
            if (!visitField(fieldContext)) {
                return false;
            }
            Operand oprand = (Operand) stack.pop();
            oprands.add(oprand);
        }
        stack.push(oprands);

        if (ctx.allFields() != null) {
            if (!visitAllFields(ctx.allFields())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean visitAllFields(AllFieldsContext ctx) {
        builder.allColumn(ctx.getText());

        return true;
    }

    @Override
    public Boolean visitField(FieldContext ctx) {
        // 每次都将默认的表名压入栈中
        stack.push(tableName);
        if (ctx.actualTableName != null) {
            tableName = ctx.actualTableName.getText();
        }
        if (visitName(ctx.name())) {
            // 选择的列
            Operand inOprand = (Operand) stack.pop();

            // 选择热数据源
            tableName = String.valueOf(stack.pop());

            if (ctx.alias != null) {
                stack.push(new AliasOperand(inOprand, ctx.alias.getText()));
            } else {
                stack.push(inOprand);
            }
            return true;
        }
        return false;
    }

    @Override
    public Boolean visitTableName(TableNameContext ctx) {
        this.tableName = ctx.actualTableName.getText();
        //多数据源时进行扩展
        stack.push(Collections.singletonList(tableName));
        return true;
    }

    @Override
    public Boolean visitExportStatement(ExportStatementContext ctx) {
        try {
            if (StringUtils.isNotBlank(ctx.fileName.getText())) {
                builder.exportFileName(ctx.fileName.getText());
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return true;
        }
    }

    private Boolean visitBoolExpr(ConditionStatementContext ctx) {
        if (ctx instanceof InsideExpressionContext) {
            return visitInsideExpression((InsideExpressionContext) ctx);
        } else if (ctx instanceof AndOperationContext) {
            return visitAndOperation((AndOperationContext) ctx);
        } else if (ctx instanceof OrOperationContext) {
            return visitOrOperation((OrOperationContext) ctx);
        } else if (ctx instanceof BasicExprContext) {
            return visitBasicExpr((BasicExprContext) ctx);
        }
        return false;
    }

    @Override
    public Boolean visitInsideExpression(InsideExpressionContext ctx) {
        return visitBoolExpr(ctx.conditionStatement());
    }

    @Override
    public Boolean visitAndOperation(AndOperationContext ctx) {
        if (visitBoolExpr(ctx.left)) {
            IBooleanExpression left = (IBooleanExpression) stack.pop();
            if (visitBoolExpr(ctx.right)) {
                IBooleanExpression right = (IBooleanExpression) stack.pop();
                stack.push(new AndCondition(left, right));
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean visitOrOperation(OrOperationContext ctx) {
        if (visitBoolExpr(ctx.left)) {
            IBooleanExpression left = (IBooleanExpression) stack.pop();
            if (visitBoolExpr(ctx.right)) {
                IBooleanExpression right = (IBooleanExpression) stack.pop();
                stack.push(new OrCondition(left, right));
                return true;
            }
        }
        return false;
    }

    private Boolean visitName(NameContext ctx) {
        if (ctx instanceof LRNameContext) {
            return visitLRName((LRNameContext) ctx);
        } else if (ctx instanceof MulNameContext) {
            return visitMulName((MulNameContext) ctx);
        } else if (ctx instanceof AddNameContext) {
            return visitAddName((AddNameContext) ctx);
        } else if (ctx instanceof AggregationNameContext) {
            return visitAggregationName((AggregationNameContext) ctx);
        } else if (ctx instanceof ColumnNameContext) {
            return visitColumnName((ColumnNameContext) ctx);
        } else if (ctx instanceof BitwiseNameContext) {
            return visitBitwiseName((BitwiseNameContext) ctx);
        } else if (ctx instanceof ParenthesisNameContext) {
            return visitParenthesisName((ParenthesisNameContext) ctx);
        }

        return false;
    }


    @Override
    public Boolean visitLRName(LRNameContext ctx) {
        return visitName(ctx.name());
    }



    @Override
    public Boolean visitMulName(MulNameContext ctx) {
        if (visitName(ctx.left)) {
            Operand left = (Operand) stack.pop();
            if (visitName(ctx.right)) {
                Operand right = (Operand) stack.pop();
                int type = ctx.op.getType();
                switch (type) {
                    case MalSqlLexer.STAR:
                        stack.push(new ProductOperand(left, right));
                        return true;
                    case MalSqlLexer.SLASH:
                        stack.push(new DivideOperand(left, right));
                        return true;
                    case MalSqlLexer.MOD:
                        throw new RuleParseException("不支持%");
                    default:
                        return false;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean visitAddName(AddNameContext ctx) {
        if (visitName(ctx.left)) {
            Operand left = (Operand) stack.pop();
            if (visitName(ctx.right)) {
                Operand right = (Operand) stack.pop();
                int type = ctx.op.getType();
                switch (type) {
                    case MalSqlLexer.PLUS:
                        stack.push(new PlusOperand(left, right));
                        return true;
                    case MalSqlLexer.SUB:
                        stack.push(new MinusOperand(left, right));
                        return true;
                    default:
                        return false;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean visitParenthesisName(ParenthesisNameContext ctx) {
      ParenthesisContext parenthesisContext = ctx.parenthesis();
        return visitParenthesis(parenthesisContext);
    }

    @Override
    public Boolean visitColumnName(ColumnNameContext ctx) {
     IdentityContext identity = ctx.identity();
        return visitIdentity(identity);
    }

    @Override
    public Boolean visitBitwiseName(BitwiseNameContext ctx) {
        if (visitName(ctx.left)) {
            Operand left = (Operand) stack.pop();
            if (visitName(ctx.right)) {
                Operand right = (Operand) stack.pop();
                int type = ctx.op.getType();
                switch (type) {
                    case MalSqlLexer.AMP:
                        stack.push(new BitwiseAndOperand(left, right));
                        return true;
                    case MalSqlLexer.BAR:
                        stack.push(new BitwiseOrOperand(left, right));
                        return true;
                    case MalSqlLexer.CARET:
                        stack.push(new BitwiseXorOperand(left, right));
                        return true;
                    case MalSqlLexer.LTLT:
                        stack.push(new BitwiseShlOperand(left, right));
                        return true;
                    case MalSqlLexer.GTGT:
                        stack.push(new BitwiseShrOperand(left, right));
                        return true;
                    default:
                        return false;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean visitParenthesis(ParenthesisContext ctx) {
        stack.push(new ParenthesisOperand(ctx.PARENTHESIS().getText()));
        return true;
    }


    @Override
    public Boolean visitLetterOrDigitElement(LetterOrDigitElementContext ctx) {
        stack.push(new NameOperand(tableName, ctx.LetterOrDigit().getText()));
        return true;
    }


    @Override
    public Boolean visitIntElement(IntElementContext ctx) {
        stack.push(new IntegerOperand(Long.valueOf(ctx.getText())));
        return true;
    }


    @Override
    public Boolean visitFloatElement(FloatElementContext ctx) {
        stack.push(new FloatOperand(Double.valueOf(ctx.getText())));
        return true;
    }

    @Override
    public Boolean visitNegativeIntElement(NegativeIntElementContext ctx) {
        stack.push(new IntegerOperand(Long.valueOf(ctx.getText())));
        return true;
    }

    @Override
    public Boolean visitNegativeFloatElement(NegativeFloatElementContext ctx) {
        stack.push(new FloatOperand(Double.valueOf(ctx.getText())));
        return true;
    }


    @Override
    public Boolean visitStringElement(StringElementContext ctx) {
        String str = ctx.STRING().getText();
        stack.push(new StringOperand(str.substring(1, str.length() - 1)));
        return true;
    }


    @Override
    public Boolean visitAggregationName(AggregationNameContext ctx) {

        String aggFun = ctx.LetterOrDigit().getText();
        // aggregate operand
        Function fun = FunctionManager.getFunction(aggFun);
        if (fun == null) {
            throw new RuleParseException(String.format("aggregate function: [%s] not exists.", aggFun));
        } else if (visitName(ctx.name())) {
            // inner operand
            Operand innerOperand = (Operand) stack.pop();
            Operand aggregationOperand = null;

            if (ctx.COMMA() != null) {
                if (visitBoolExpr(ctx.predicate)) {
                    IBooleanExpression predicate = (IBooleanExpression) stack.pop();
                    aggregationOperand = (Operand) fun.call(innerOperand, predicate);

                } else {
                    throw new RuleParseException("aggregate failed, no such define supported");
                }
            } else {
                aggregationOperand = (Operand) fun.call(innerOperand);
            }

            // 入栈
            stack.push(aggregationOperand);
            return true;
        } else if (visitBoolExpr(ctx.predicate)) {
            // 里面返回的operand
            IBooleanExpression predicate = (IBooleanExpression) stack.pop();

            Operand aggregationOperand = (Operand) fun.call(predicate);
            // 入栈
            stack.push(aggregationOperand);
            return true;
        }
        return false;
    }



    public boolean visitFilterLikeStatement(FilterStatementContext ctx){
        if(ctx!=null){
            if(ctx instanceof MatchByFieldValueContext){
                return visitMatchByFieldValue((MatchByFieldValueContext) ctx);
            }
            if(ctx instanceof LeftMatchContext){
                return visitLeftMatch((LeftMatchContext) ctx);
            }
            if (ctx instanceof RightMatchContext){
                return visitRightMatch((RightMatchContext) ctx);
            }
            if(ctx instanceof ContainMatchContext){
                return visitContainMatch((ContainMatchContext) ctx);
            }
        }
        return true;
    }



    @Override
    public Boolean visitWhereStatement(WhereStatementContext ctx) {
        if (ctx.timeRangeStatement() != null) {
            return visitBoolExpr(ctx.conditionStatement())
                    && visitFilterLikeStatement(ctx.filterStatement())
                    && visitTimeRangeStatement(ctx.timeRangeStatement());
        } else {
            //没有during,则获取所有事件
            builder.eventsFinder(AllEventsFinder.newInstance());

            if (visitBoolExpr(ctx.conditionStatement())) {
                return visitFilterLikeStatement(ctx.filterStatement());
            }
        }
        return false;
    }

    @Override
    public Boolean visitTimeRangeStatement(TimeRangeStatementContext ctx) {

        if (visitName(ctx.number)) {

            final Operand numberOperand = (Operand) stack.pop();
            IntegerOperand integerOperand = numberOperand instanceof IntegerOperand
                    ? (IntegerOperand) numberOperand
                    : null;


            if (ctx.unit.getStartIndex() == -1) {
                throw new RuleParseException("Currently only support units: [events, min].");
            }

            int type = ctx.unit.getType();

            switch (type) {
                case MalSqlLexer.MINUTE:
                    final long unitInMills = unitInMills(type);
                    builder.eventsFinder(TimeWindowEventsFinder.newInstance(numberOperand, unitInMills));
                    if (integerOperand != null) {
                        builder.boundingBox(new TimeBoundingBox(Duration.ofMillis(unitInMills
                                * integerOperand.getValue())));
                    }
                    return true;
                case MalSqlLexer.EVENTS:
                    builder.eventsFinder(FixedCountEventsFinder.newInstance(numberOperand));
                    if (integerOperand != null) {
                        builder.boundingBox(new SizeBoundingBox(integerOperand.getValue()));
                    }
                    return true;
                default:
                    return false;
            }

        }
        return false;
    }

    @Override
    public Boolean visitTimeRange(TimeRangeContext ctx) {
        if (ctx != null) {
            Integer number = Integer.parseInt(ctx.number.getText());
            switch (ctx.unit.getType()) {
                case MalSqlLexer.MINUTE:
                    stack.push(Duration.ofMinutes(number));
                    return true;
                case MalSqlLexer.HOUR:
                    stack.push(Duration.ofHours(number));
                    return true;
                case MalSqlLexer.DAY:
                    stack.push(Duration.ofDays(number));
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }

    private long unitInMills(int unit) {
        switch (unit) {
            case MalSqlLexer.MINUTE:
                return ofMinutes(1).toMillis();
            case MalSqlLexer.HOUR:
                return ofHours(1).toMillis();
            case MalSqlLexer.DAY:
                return ofDays(1).toMillis();
            case MalSqlLexer.WEEK:
                return ofDays(7).toMillis();
            default:
                return 0;
        }
    }



    @Override
    public Boolean visitMatchByFieldValue(MatchByFieldValueContext ctx){
        if (ctx != null) {
            List<Operand> operands = ctx.LetterOrDigit().stream().map(letterOrDigit -> new NameOperand(tableName, letterOrDigit.getText())).collect(toList());
            builder.valueFilterCondition(operands);
        }
        return true;
    }
    @Override
    public Boolean visitLeftMatch(LeftMatchContext ctx) {

        if (ctx != null) {
            List<Operand> operands = new ArrayList<>();
            operands.add(new LeftLikeOperand(tableName, ctx.left.getText(), ctx.right.getText()));
            builder.likeFilterCondition(operands);
        }
        return true;
    }

    @Override
    public Boolean visitRightMatch(RightMatchContext ctx) {

        if (ctx != null) {
            List<Operand> operands = new ArrayList<>();
            operands.add(new RightLikeOperand(tableName, ctx.left.getText(), ctx.right.getText()));
            builder.likeFilterCondition(operands);
        }
        return true;
    }


    @Override
    public Boolean visitContainMatch(ContainMatchContext ctx) {
        if (ctx != null) {
            List<Operand> operands = new ArrayList<>();
            operands.add(new ContainLikeOperand(tableName, ctx.left.getText(), ctx.right.getText()));
            builder.likeFilterCondition(operands);
        }
        return true;
    }


    @Override
    public Boolean visitBasicExpr(BasicExprContext ctx) {
        return visitBasicConditionExpr(ctx.basicConditionExpr());
    }







    private Boolean visitBasicConditionExpr(BasicConditionExprContext ctx) {
        if (ctx instanceof CompareExprContext) {
            return visitCompareExpr((CompareExprContext) ctx);
        } else if (ctx instanceof InExpressionContext) {
            return visitInExpression((InExpressionContext) ctx);
        }
        throw new RuleParseException("Parse basic boolean expression error.");
    }

    @Override
    public Boolean visitCompareExpr(CompareExprContext ctx) {
        if (visitName(ctx.left)) {
            Operand left = (Operand) stack.pop();
            if (visitName(ctx.right)) {

                Operand right = (Operand) stack.pop();

                int type = ctx.option.getType();
                switch (type) {
                    case MalSqlLexer.GT:
                        stack.push(new GreatCondition(left, right));
                        break;
                    case MalSqlLexer.GTEQ:
                        stack.push(new GreatEqCondition(left, right));
                        break;
                    case MalSqlLexer.EQ:
                        stack.push(new EqCondition(left, right));
                        break;
                    case MalSqlLexer.LT:
                        stack.push(new LessCondition(left, right));
                        break;
                    case MalSqlLexer.LTEQ:
                        stack.push(new LessThanEqCondition(left, right));
                        break;
                    case MalSqlLexer.NEQ:
                        stack.push(new NotEqCondition(left, right));
                        break;

                    default:
                        return false;
                }

                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean visitInExpression(InExpressionContext ctx) {
        if (visitName(ctx.left)) {
            Operand left = (Operand) stack.pop();
            if (visitCollection(ctx.collection())) {
                SetOperand right = (SetOperand) stack.pop();
                stack.push(new InCondition(left, right));
                return true;
            }
        }
        return false;
    }


    @Override
    public Boolean visitCollection(CollectionContext ctx) {
        Set<Object> elements = new HashSet<>();
        for (IdentityContext o : ctx.identity()) {
            visitIdentity(o);
            Operand operand = (Operand) stack.pop();
            elements.add(operand.getValue(null, null));
        }
        stack.push(new SetOperand(elements));
        return true;
    }

    private Boolean visitIdentity(IdentityContext identity) {
        if (identity instanceof LetterOrDigitElementContext) {
            return visitLetterOrDigitElement((LetterOrDigitElementContext) identity);
        } else if (identity instanceof IntElementContext) {
            return visitIntElement((IntElementContext) identity);
        } else if (identity instanceof FloatElementContext) {
            return visitFloatElement((FloatElementContext) identity);
        } else if (identity instanceof StringElementContext) {
            return visitStringElement((StringElementContext) identity);
        } else if (identity instanceof NegativeIntElementContext) {
            return visitNegativeIntElement((NegativeIntElementContext) identity);
        } else if (identity instanceof NegativeFloatElementContext) {
            return visitNegativeFloatElement((NegativeFloatElementContext) identity);
        }

        throw new RuleParseException("Parse identity error: " + identity.getText() + " .");
    }


    public MalSqlParserTemplate getMalSqlParserTemplate() {
        builder.periodOperands(periodOperands);
        return builder.build();
    }
}
