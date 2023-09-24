// Generated from com\data\monkey\grammar\MalSqlParser.g4 by ANTLR 4.9.2
package com.data.monkey.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MalSqlParserParser}.
 */
public interface MalSqlParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MalSqlParserParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(MalSqlParserParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link MalSqlParserParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(MalSqlParserParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link MalSqlParserParser#columList}.
	 * @param ctx the parse tree
	 */
	void enterColumList(MalSqlParserParser.ColumListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MalSqlParserParser#columList}.
	 * @param ctx the parse tree
	 */
	void exitColumList(MalSqlParserParser.ColumListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MalSqlParserParser#allColumn}.
	 * @param ctx the parse tree
	 */
	void enterAllColumn(MalSqlParserParser.AllColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link MalSqlParserParser#allColumn}.
	 * @param ctx the parse tree
	 */
	void exitAllColumn(MalSqlParserParser.AllColumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link MalSqlParserParser#nameOprand}.
	 * @param ctx the parse tree
	 */
	void enterNameOprand(MalSqlParserParser.NameOprandContext ctx);
	/**
	 * Exit a parse tree produced by {@link MalSqlParserParser#nameOprand}.
	 * @param ctx the parse tree
	 */
	void exitNameOprand(MalSqlParserParser.NameOprandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulName}
	 * labeled alternative in {@link MalSqlParserParser#name}.
	 * @param ctx the parse tree
	 */
	void enterMulName(MalSqlParserParser.MulNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulName}
	 * labeled alternative in {@link MalSqlParserParser#name}.
	 * @param ctx the parse tree
	 */
	void exitMulName(MalSqlParserParser.MulNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AggregationName}
	 * labeled alternative in {@link MalSqlParserParser#name}.
	 * @param ctx the parse tree
	 */
	void enterAggregationName(MalSqlParserParser.AggregationNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AggregationName}
	 * labeled alternative in {@link MalSqlParserParser#name}.
	 * @param ctx the parse tree
	 */
	void exitAggregationName(MalSqlParserParser.AggregationNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddName}
	 * labeled alternative in {@link MalSqlParserParser#name}.
	 * @param ctx the parse tree
	 */
	void enterAddName(MalSqlParserParser.AddNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddName}
	 * labeled alternative in {@link MalSqlParserParser#name}.
	 * @param ctx the parse tree
	 */
	void exitAddName(MalSqlParserParser.AddNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesisName}
	 * labeled alternative in {@link MalSqlParserParser#name}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisName(MalSqlParserParser.ParenthesisNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesisName}
	 * labeled alternative in {@link MalSqlParserParser#name}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisName(MalSqlParserParser.ParenthesisNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LRName}
	 * labeled alternative in {@link MalSqlParserParser#name}.
	 * @param ctx the parse tree
	 */
	void enterLRName(MalSqlParserParser.LRNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LRName}
	 * labeled alternative in {@link MalSqlParserParser#name}.
	 * @param ctx the parse tree
	 */
	void exitLRName(MalSqlParserParser.LRNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code columnName}
	 * labeled alternative in {@link MalSqlParserParser#name}.
	 * @param ctx the parse tree
	 */
	void enterColumnName(MalSqlParserParser.ColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code columnName}
	 * labeled alternative in {@link MalSqlParserParser#name}.
	 * @param ctx the parse tree
	 */
	void exitColumnName(MalSqlParserParser.ColumnNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseName}
	 * labeled alternative in {@link MalSqlParserParser#name}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseName(MalSqlParserParser.BitwiseNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseName}
	 * labeled alternative in {@link MalSqlParserParser#name}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseName(MalSqlParserParser.BitwiseNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MalSqlParserParser#parenthesis}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(MalSqlParserParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by {@link MalSqlParserParser#parenthesis}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(MalSqlParserParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letterOrDigitElement}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void enterLetterOrDigitElement(MalSqlParserParser.LetterOrDigitElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letterOrDigitElement}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void exitLetterOrDigitElement(MalSqlParserParser.LetterOrDigitElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intElement}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void enterIntElement(MalSqlParserParser.IntElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intElement}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void exitIntElement(MalSqlParserParser.IntElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatElement}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void enterFloatElement(MalSqlParserParser.FloatElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatElement}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void exitFloatElement(MalSqlParserParser.FloatElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negativeIntElement}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void enterNegativeIntElement(MalSqlParserParser.NegativeIntElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negativeIntElement}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void exitNegativeIntElement(MalSqlParserParser.NegativeIntElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negativeFloatElement}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void enterNegativeFloatElement(MalSqlParserParser.NegativeFloatElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negativeFloatElement}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void exitNegativeFloatElement(MalSqlParserParser.NegativeFloatElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringElement}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void enterStringElement(MalSqlParserParser.StringElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringElement}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void exitStringElement(MalSqlParserParser.StringElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MalSqlParserParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(MalSqlParserParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MalSqlParserParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(MalSqlParserParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MalSqlParserParser#exportExpr}.
	 * @param ctx the parse tree
	 */
	void enterExportExpr(MalSqlParserParser.ExportExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MalSqlParserParser#exportExpr}.
	 * @param ctx the parse tree
	 */
	void exitExportExpr(MalSqlParserParser.ExportExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MalSqlParserParser#whereCluaster}.
	 * @param ctx the parse tree
	 */
	void enterWhereCluaster(MalSqlParserParser.WhereCluasterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MalSqlParserParser#whereCluaster}.
	 * @param ctx the parse tree
	 */
	void exitWhereCluaster(MalSqlParserParser.WhereCluasterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code basicExpr}
	 * labeled alternative in {@link MalSqlParserParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void enterBasicExpr(MalSqlParserParser.BasicExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code basicExpr}
	 * labeled alternative in {@link MalSqlParserParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void exitBasicExpr(MalSqlParserParser.BasicExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andOperation}
	 * labeled alternative in {@link MalSqlParserParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndOperation(MalSqlParserParser.AndOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andOperation}
	 * labeled alternative in {@link MalSqlParserParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndOperation(MalSqlParserParser.AndOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insideExpression}
	 * labeled alternative in {@link MalSqlParserParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void enterInsideExpression(MalSqlParserParser.InsideExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insideExpression}
	 * labeled alternative in {@link MalSqlParserParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void exitInsideExpression(MalSqlParserParser.InsideExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orOperation}
	 * labeled alternative in {@link MalSqlParserParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrOperation(MalSqlParserParser.OrOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orOperation}
	 * labeled alternative in {@link MalSqlParserParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrOperation(MalSqlParserParser.OrOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compareExpr}
	 * labeled alternative in {@link MalSqlParserParser#basicBoolExpr}.
	 * @param ctx the parse tree
	 */
	void enterCompareExpr(MalSqlParserParser.CompareExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compareExpr}
	 * labeled alternative in {@link MalSqlParserParser#basicBoolExpr}.
	 * @param ctx the parse tree
	 */
	void exitCompareExpr(MalSqlParserParser.CompareExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link MalSqlParserParser#basicBoolExpr}.
	 * @param ctx the parse tree
	 */
	void enterInExpression(MalSqlParserParser.InExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link MalSqlParserParser#basicBoolExpr}.
	 * @param ctx the parse tree
	 */
	void exitInExpression(MalSqlParserParser.InExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MalSqlParserParser#collection}.
	 * @param ctx the parse tree
	 */
	void enterCollection(MalSqlParserParser.CollectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MalSqlParserParser#collection}.
	 * @param ctx the parse tree
	 */
	void exitCollection(MalSqlParserParser.CollectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MalSqlParserParser#durationExpr}.
	 * @param ctx the parse tree
	 */
	void enterDurationExpr(MalSqlParserParser.DurationExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MalSqlParserParser#durationExpr}.
	 * @param ctx the parse tree
	 */
	void exitDurationExpr(MalSqlParserParser.DurationExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MalSqlParserParser#duration}.
	 * @param ctx the parse tree
	 */
	void enterDuration(MalSqlParserParser.DurationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MalSqlParserParser#duration}.
	 * @param ctx the parse tree
	 */
	void exitDuration(MalSqlParserParser.DurationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MalSqlParserParser#filterByExpr}.
	 * @param ctx the parse tree
	 */
	void enterFilterByExpr(MalSqlParserParser.FilterByExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MalSqlParserParser#filterByExpr}.
	 * @param ctx the parse tree
	 */
	void exitFilterByExpr(MalSqlParserParser.FilterByExprContext ctx);
}