// Generated from com\data\monkey\grammar\MalSqlParser.g4 by ANTLR 4.9.2
package com.data.monkey.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MalSqlParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MalSqlParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MalSqlParserParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(MalSqlParserParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link MalSqlParserParser#columList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumList(MalSqlParserParser.ColumListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MalSqlParserParser#allColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllColumn(MalSqlParserParser.AllColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MalSqlParserParser#nameOprand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameOprand(MalSqlParserParser.NameOprandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulName}
	 * labeled alternative in {@link MalSqlParserParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulName(MalSqlParserParser.MulNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AggregationName}
	 * labeled alternative in {@link MalSqlParserParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregationName(MalSqlParserParser.AggregationNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddName}
	 * labeled alternative in {@link MalSqlParserParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddName(MalSqlParserParser.AddNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesisName}
	 * labeled alternative in {@link MalSqlParserParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisName(MalSqlParserParser.ParenthesisNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LRName}
	 * labeled alternative in {@link MalSqlParserParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLRName(MalSqlParserParser.LRNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code columnName}
	 * labeled alternative in {@link MalSqlParserParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnName(MalSqlParserParser.ColumnNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitwiseName}
	 * labeled alternative in {@link MalSqlParserParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseName(MalSqlParserParser.BitwiseNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MalSqlParserParser#parenthesis}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis(MalSqlParserParser.ParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idEle}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdEle(MalSqlParserParser.IdEleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intEle}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntEle(MalSqlParserParser.IntEleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatEle}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatEle(MalSqlParserParser.FloatEleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negativeIntEle}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegativeIntEle(MalSqlParserParser.NegativeIntEleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negativeFloatELe}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegativeFloatELe(MalSqlParserParser.NegativeFloatELeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringEle}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringEle(MalSqlParserParser.StringEleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MalSqlParserParser#tableRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableRef(MalSqlParserParser.TableRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MalSqlParserParser#exportExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportExpr(MalSqlParserParser.ExportExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MalSqlParserParser#whereCluaster}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereCluaster(MalSqlParserParser.WhereCluasterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code basicExpr}
	 * labeled alternative in {@link MalSqlParserParser#boolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicExpr(MalSqlParserParser.BasicExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lrExpr}
	 * labeled alternative in {@link MalSqlParserParser#boolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLrExpr(MalSqlParserParser.LrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andOpr}
	 * labeled alternative in {@link MalSqlParserParser#boolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndOpr(MalSqlParserParser.AndOprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orOpr}
	 * labeled alternative in {@link MalSqlParserParser#boolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrOpr(MalSqlParserParser.OrOprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compareExpr}
	 * labeled alternative in {@link MalSqlParserParser#basicBoolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpr(MalSqlParserParser.CompareExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link MalSqlParserParser#basicBoolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInExpr(MalSqlParserParser.InExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MalSqlParserParser#collection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollection(MalSqlParserParser.CollectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MalSqlParserParser#durationExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDurationExpr(MalSqlParserParser.DurationExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MalSqlParserParser#duration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuration(MalSqlParserParser.DurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MalSqlParserParser#filterByExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterByExpr(MalSqlParserParser.FilterByExprContext ctx);
}