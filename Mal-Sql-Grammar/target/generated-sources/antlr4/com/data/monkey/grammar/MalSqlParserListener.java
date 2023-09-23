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
	 * Enter a parse tree produced by the {@code idEle}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void enterIdEle(MalSqlParserParser.IdEleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idEle}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void exitIdEle(MalSqlParserParser.IdEleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intEle}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void enterIntEle(MalSqlParserParser.IntEleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intEle}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void exitIntEle(MalSqlParserParser.IntEleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatEle}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void enterFloatEle(MalSqlParserParser.FloatEleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatEle}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void exitFloatEle(MalSqlParserParser.FloatEleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negativeIntEle}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void enterNegativeIntEle(MalSqlParserParser.NegativeIntEleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negativeIntEle}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void exitNegativeIntEle(MalSqlParserParser.NegativeIntEleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negativeFloatELe}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void enterNegativeFloatELe(MalSqlParserParser.NegativeFloatELeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negativeFloatELe}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void exitNegativeFloatELe(MalSqlParserParser.NegativeFloatELeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringEle}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void enterStringEle(MalSqlParserParser.StringEleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringEle}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 */
	void exitStringEle(MalSqlParserParser.StringEleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MalSqlParserParser#tableRef}.
	 * @param ctx the parse tree
	 */
	void enterTableRef(MalSqlParserParser.TableRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MalSqlParserParser#tableRef}.
	 * @param ctx the parse tree
	 */
	void exitTableRef(MalSqlParserParser.TableRefContext ctx);
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
	 * Enter a parse tree produced by the {@code lrExpr}
	 * labeled alternative in {@link MalSqlParserParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void enterLrExpr(MalSqlParserParser.LrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lrExpr}
	 * labeled alternative in {@link MalSqlParserParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void exitLrExpr(MalSqlParserParser.LrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andOpr}
	 * labeled alternative in {@link MalSqlParserParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndOpr(MalSqlParserParser.AndOprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andOpr}
	 * labeled alternative in {@link MalSqlParserParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndOpr(MalSqlParserParser.AndOprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orOpr}
	 * labeled alternative in {@link MalSqlParserParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrOpr(MalSqlParserParser.OrOprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orOpr}
	 * labeled alternative in {@link MalSqlParserParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrOpr(MalSqlParserParser.OrOprContext ctx);
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
	 * Enter a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link MalSqlParserParser#basicBoolExpr}.
	 * @param ctx the parse tree
	 */
	void enterInExpr(MalSqlParserParser.InExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link MalSqlParserParser#basicBoolExpr}.
	 * @param ctx the parse tree
	 */
	void exitInExpr(MalSqlParserParser.InExprContext ctx);
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