// Generated from /home/stefan/IdeaProjects/ExpressionParser/src/main/java/de/weinzierlstefan/expressionparser/Parser.g4 by ANTLR 4.13.1
package de.weinzierlstefan.expressionparser.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ParserParser#start_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_expression(ParserParser.Start_expressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(ParserParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanLiteral}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(ParserParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code With}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWith(ParserParser.WithContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Function}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(ParserParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryIntegerLiteral}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryIntegerLiteral(ParserParser.BinaryIntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyObject}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyObject(ParserParser.EmptyObjectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(ParserParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(ParserParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DecimalLiteral}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalLiteral(ParserParser.DecimalLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleQuoteString}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleQuoteString(ParserParser.SingleQuoteStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Lambda}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda(ParserParser.LambdaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentheses(ParserParser.ParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OctalIntegerLiteral}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOctalIntegerLiteral(ParserParser.OctalIntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Shift}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShift(ParserParser.ShiftContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyArray}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyArray(ParserParser.EmptyArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Ternary}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernary(ParserParser.TernaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleQuoteString}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleQuoteString(ParserParser.DoubleQuoteStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QuotedVariable}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuotedVariable(ParserParser.QuotedVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitOperations}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitOperations(ParserParser.BitOperationsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HexIntegerLiteral}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHexIntegerLiteral(ParserParser.HexIntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Array}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(ParserParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(ParserParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditionOrSubtraction}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionOrSubtraction(ParserParser.AdditionOrSubtractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiplicationOrDivision}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationOrDivision(ParserParser.MultiplicationOrDivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Object}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject(ParserParser.ObjectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Negate}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegate(ParserParser.NegateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArraySelector}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraySelector(ParserParser.ArraySelectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NullLiteral}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullLiteral(ParserParser.NullLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Power}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPower(ParserParser.PowerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#lambdaParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameter(ParserParser.LambdaParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#objectEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectEntry(ParserParser.ObjectEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#arraySelectorEntries}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraySelectorEntries(ParserParser.ArraySelectorEntriesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#arraySelectorEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraySelectorEntry(ParserParser.ArraySelectorEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#functionParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParameter(ParserParser.FunctionParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#withLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithLiteral(ParserParser.WithLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#withParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithParameter(ParserParser.WithParameterContext ctx);
}