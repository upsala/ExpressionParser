// Generated from /home/stefan/IdeaProjects/ExpressionParser/src/main/java/de/weinzierlstefan/expressionparser/Parser.g4 by ANTLR 4.13.1
package de.weinzierlstefan.expressionparser.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ParserParser}.
 */
public interface ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ParserParser#start_expression}.
	 * @param ctx the parse tree
	 */
	void enterStart_expression(ParserParser.Start_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#start_expression}.
	 * @param ctx the parse tree
	 */
	void exitStart_expression(ParserParser.Start_expressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariable(ParserParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariable(ParserParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanLiteral}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(ParserParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanLiteral}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(ParserParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code With}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterWith(ParserParser.WithContext ctx);
	/**
	 * Exit a parse tree produced by the {@code With}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitWith(ParserParser.WithContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Function}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunction(ParserParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Function}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunction(ParserParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryIntegerLiteral}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryIntegerLiteral(ParserParser.BinaryIntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryIntegerLiteral}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryIntegerLiteral(ParserParser.BinaryIntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyObject}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEmptyObject(ParserParser.EmptyObjectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyObject}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEmptyObject(ParserParser.EmptyObjectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComparison(ParserParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComparison(ParserParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBool(ParserParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBool(ParserParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DecimalLiteral}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDecimalLiteral(ParserParser.DecimalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DecimalLiteral}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDecimalLiteral(ParserParser.DecimalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleQuoteString}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSingleQuoteString(ParserParser.SingleQuoteStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleQuoteString}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSingleQuoteString(ParserParser.SingleQuoteStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Lambda}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLambda(ParserParser.LambdaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Lambda}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLambda(ParserParser.LambdaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(ParserParser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(ParserParser.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OctalIntegerLiteral}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOctalIntegerLiteral(ParserParser.OctalIntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OctalIntegerLiteral}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOctalIntegerLiteral(ParserParser.OctalIntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Shift}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterShift(ParserParser.ShiftContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Shift}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitShift(ParserParser.ShiftContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyArray}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEmptyArray(ParserParser.EmptyArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyArray}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEmptyArray(ParserParser.EmptyArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Ternary}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTernary(ParserParser.TernaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Ternary}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTernary(ParserParser.TernaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleQuoteString}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDoubleQuoteString(ParserParser.DoubleQuoteStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleQuoteString}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDoubleQuoteString(ParserParser.DoubleQuoteStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code QuotedVariable}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterQuotedVariable(ParserParser.QuotedVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code QuotedVariable}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitQuotedVariable(ParserParser.QuotedVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitOperations}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitOperations(ParserParser.BitOperationsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitOperations}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitOperations(ParserParser.BitOperationsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HexIntegerLiteral}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterHexIntegerLiteral(ParserParser.HexIntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HexIntegerLiteral}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitHexIntegerLiteral(ParserParser.HexIntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Array}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArray(ParserParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Array}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArray(ParserParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNot(ParserParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNot(ParserParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditionOrSubtraction}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditionOrSubtraction(ParserParser.AdditionOrSubtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditionOrSubtraction}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditionOrSubtraction(ParserParser.AdditionOrSubtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplicationOrDivision}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationOrDivision(ParserParser.MultiplicationOrDivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplicationOrDivision}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationOrDivision(ParserParser.MultiplicationOrDivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Object}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterObject(ParserParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Object}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitObject(ParserParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negate}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegate(ParserParser.NegateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negate}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegate(ParserParser.NegateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArraySelector}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArraySelector(ParserParser.ArraySelectorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArraySelector}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArraySelector(ParserParser.ArraySelectorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NullLiteral}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNullLiteral(ParserParser.NullLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NullLiteral}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNullLiteral(ParserParser.NullLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Power}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPower(ParserParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Power}
	 * labeled alternative in {@link ParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPower(ParserParser.PowerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#lambdaParameter}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameter(ParserParser.LambdaParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#lambdaParameter}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameter(ParserParser.LambdaParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#objectEntry}.
	 * @param ctx the parse tree
	 */
	void enterObjectEntry(ParserParser.ObjectEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#objectEntry}.
	 * @param ctx the parse tree
	 */
	void exitObjectEntry(ParserParser.ObjectEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#arraySelectorEntries}.
	 * @param ctx the parse tree
	 */
	void enterArraySelectorEntries(ParserParser.ArraySelectorEntriesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#arraySelectorEntries}.
	 * @param ctx the parse tree
	 */
	void exitArraySelectorEntries(ParserParser.ArraySelectorEntriesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#arraySelectorEntry}.
	 * @param ctx the parse tree
	 */
	void enterArraySelectorEntry(ParserParser.ArraySelectorEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#arraySelectorEntry}.
	 * @param ctx the parse tree
	 */
	void exitArraySelectorEntry(ParserParser.ArraySelectorEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#functionParameter}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParameter(ParserParser.FunctionParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#functionParameter}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParameter(ParserParser.FunctionParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#withLiteral}.
	 * @param ctx the parse tree
	 */
	void enterWithLiteral(ParserParser.WithLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#withLiteral}.
	 * @param ctx the parse tree
	 */
	void exitWithLiteral(ParserParser.WithLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#withParameter}.
	 * @param ctx the parse tree
	 */
	void enterWithParameter(ParserParser.WithParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#withParameter}.
	 * @param ctx the parse tree
	 */
	void exitWithParameter(ParserParser.WithParameterContext ctx);
}