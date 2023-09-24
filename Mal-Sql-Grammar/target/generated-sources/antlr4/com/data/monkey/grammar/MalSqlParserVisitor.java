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
	 * Visit a parse tree produced by the {@code letterOrDigitElement}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetterOrDigitElement(MalSqlParserParser.LetterOrDigitElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intElement}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntElement(MalSqlParserParser.IntElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatElement}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatElement(MalSqlParserParser.FloatElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negativeIntElement}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegativeIntElement(MalSqlParserParser.NegativeIntElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negativeFloatElement}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegativeFloatElement(MalSqlParserParser.NegativeFloatElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringElement}
	 * labeled alternative in {@link MalSqlParserParser#identity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringElement(MalSqlParserParser.StringElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MalSqlParserParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(MalSqlParserParser.TableNameContext ctx);
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
	 * Visit a parse tree produced by the {@code andOperation}
	 * labeled alternative in {@link MalSqlParserParser#boolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndOperation(MalSqlParserParser.AndOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insideExpression}
	 * labeled alternative in {@link MalSqlParserParser#boolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsideExpression(MalSqlParserParser.InsideExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orOperation}
	 * labeled alternative in {@link MalSqlParserParser#boolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrOperation(MalSqlParserParser.OrOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compareExpr}
	 * labeled alternative in {@link MalSqlParserParser#basicBoolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpr(MalSqlParserParser.CompareExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link MalSqlParserParser#basicBoolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInExpression(MalSqlParserParser.InExpressionContext ctx);
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