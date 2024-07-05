package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.executor.*;
import de.weinzierlstefan.expressionparser.executor.ValueExecutor;
import de.weinzierlstefan.expressionparser.parser.ParserBaseVisitor;
import de.weinzierlstefan.expressionparser.parser.ParserParser;
import de.weinzierlstefan.expressionparser.value.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class ParserVisitor extends ParserBaseVisitor<Executor> {
  @Override
  public Executor visitParentheses(ParserParser.ParenthesesContext ctx) {
    Executor child = visit(ctx.inner);

    if (child instanceof NestedExecutor
      || child instanceof ObjectExecutor
      || child instanceof ArrayExecutor
      || child instanceof ValueExecutor
      || child instanceof VariableExexcutor
      || child instanceof FunctionExecutor) {
      return child;
    }

    return new NestedExecutor(child);
  }

  @Override
  public Executor visitMultiplicationOrDivision(ParserParser.MultiplicationOrDivisionContext ctx) throws ExpressionException {
    String op = ctx.operator.getText();

    return switch (op) {
      case "*" -> new MulExecutor(visit(ctx.left), visit(ctx.right));
      case "/" -> new DivExecutor(visit(ctx.left), visit(ctx.right));
      case "%" -> new ModuloExecutor(visit(ctx.left), visit(ctx.right));
      default -> throw new ExpressionException("Undefined operator: " + op);
    };
  }

  @Override
  public Executor visitAdditionOrSubtraction(ParserParser.AdditionOrSubtractionContext ctx) {
    if (ctx.operator.getText().equals("+")) {
      return new AddExecutor(visit(ctx.left), visit(ctx.right));
    }

    return new SubExecutor(visit(ctx.left), visit(ctx.right));
  }

  @Override
  public Executor visitVariable(ParserParser.VariableContext ctx) {
    return new VariableExexcutor(ctx.name.getText());
  }

  @Override
  public Executor visitFunction(ParserParser.FunctionContext ctx) {
    List<Executor> executorList;

    if (ctx.parameter == null) {
      executorList = List.of();
    } else {
      executorList = ctx
        .parameter
        .children
        .stream()
        .map(this::visit)
        .filter(Objects::nonNull)
        .toList();
    }

    return new FunctionExecutor(ctx.name.getText(), executorList);
  }

  @Override
  public Executor visitDecimalLiteral(ParserParser.DecimalLiteralContext ctx) {
    String txt = ctx.getText();
    BigDecimal bd = new BigDecimal(txt);

    if (!txt.contains(".")) {
      try {
        return new ValueExecutor(ValueInt.of(bd.intValueExact()));
      } catch (ArithmeticException ex) {
      }

      try {
        return new ValueExecutor(ValueLong.of(bd.longValueExact()));
      } catch (ArithmeticException ex) {
      }
    }

    double dbl = bd.doubleValue();
    if (Double.isNaN(dbl)) {
      throw new ExpressionException("Invalid number: " + ctx.getText());
    }
    return new ValueExecutor(ValueDouble.of(dbl));
  }

  @Override
  public Executor visitHexIntegerLiteral(ParserParser.HexIntegerLiteralContext ctx) {
    try {
      return new ValueExecutor(ValueInt.of(Integer.parseInt(ctx.getText().substring(2), 16)));
    } catch (NumberFormatException ex) {
    }

    try {
      return new ValueExecutor(ValueLong.of(Long.parseLong(ctx.getText().substring(2), 16)));
    } catch (NumberFormatException ex) {
    }

    throw new ExpressionException("Invalid number: " + ctx.getText());
  }

  @Override
  public Executor visitOctalIntegerLiteral(ParserParser.OctalIntegerLiteralContext ctx) {
    try {
      return new ValueExecutor(ValueInt.of(Integer.parseInt(ctx.getText().substring(2), 8)));
    } catch (NumberFormatException ex) {
    }

    try {
      return new ValueExecutor(ValueLong.of(Long.parseLong(ctx.getText().substring(2), 8)));
    } catch (NumberFormatException ex) {
    }

    throw new ExpressionException("Invalid number: " + ctx.getText());
  }

  @Override
  public Executor visitBinaryIntegerLiteral(ParserParser.BinaryIntegerLiteralContext ctx) {
    try {
      return new ValueExecutor(ValueInt.of(Integer.parseInt(ctx.getText().substring(2), 2)));
    } catch (NumberFormatException ex) {
    }

    try {
      return new ValueExecutor(ValueLong.of(Long.parseLong(ctx.getText().substring(2), 2)));
    } catch (NumberFormatException ex) {
    }

    throw new ExpressionException("Invalid number: " + ctx.getText());
  }

  @Override
  public Executor visitShift(ParserParser.ShiftContext ctx) {
    String operator = ctx.operator.getText();
    Executor left = visit(ctx.left);
    Executor right = visit(ctx.right);

    return switch (operator) {
      case "<<" -> new ShiftLeftExecutor(left, right);
      case ">>" -> new ShiftRightExecutor(left, right);
      default -> throw new ExpressionException("Unsupported operand: " + operator);
    };
  }

  @Override
  public Executor visitBooleanLiteral(ParserParser.BooleanLiteralContext ctx) {
    String bool = ctx.getText();

    return new ValueExecutor("true".equalsIgnoreCase(bool) ? ValueBoolean.TRUE : ValueBoolean.FALSE);
  }

  @Override
  public Executor visitBitOperations(ParserParser.BitOperationsContext ctx) {
    String operator = ctx.operator.getText();
    Executor left = visit(ctx.left);
    Executor right = visit(ctx.right);

    return switch (operator) {
      case "&" -> new BitAndExecutor(left, right);
      case "|" -> new BitOrExecutor(left, right);
      case "^" -> new BitXorExecutor(left, right);
      default -> throw new ExpressionException("Unsupported operand: " + operator);
    };
  }

  @Override
  public Executor visitBool(ParserParser.BoolContext ctx) {
    String operator = ctx.operator.getText();
    Executor left = visit(ctx.left);
    Executor right = visit(ctx.right);

    return switch (operator) {
      case "&&" -> new BoolAndExecutor(left, right);
      case "||" -> new BoolOrExecutor(left, right);
      case "^^" -> new BoolXorExecutor(left, right);
      default -> throw new ExpressionException("Unsupported operand: " + operator);
    };
  }

  @Override
  public Executor visitComparison(ParserParser.ComparisonContext ctx) {
    String operator = ctx.operator.getText();
    Executor left = visit(ctx.left);
    Executor right = visit(ctx.right);

    return switch (operator) {
      case ">" -> new CompGTExecutor(left, right);
      case ">=" -> new CompGEExecutor(left, right);
      case "==" -> new CompEQExecutor(left, right);
      case "<" -> new CompLTExecutor(left, right);
      case "<=" -> new CompLEExecutor(left, right);
      case "<>", "!=" -> new CompNEExecutor(left, right);
      default -> throw new ExpressionException("Undefined operator: " + operator);
    };
  }

  @Override
  public Executor visitNullLiteral(ParserParser.NullLiteralContext ctx) {
    return new ValueExecutor(ValueNull.INSTANCE);
  }

  @Override
  public Executor visitWithLiteral(ParserParser.WithLiteralContext ctx) {
    List<WithParameterExecutor> parameterList = ctx
      .withParameter()
      .stream()
      .map(this::visit)
      .filter(WithParameterExecutor.class::isInstance)
      .map(WithParameterExecutor.class::cast)
      .toList();

    Executor executor = visit(ctx.parameter);

    return new WithExecutor(parameterList, executor);
  }

  @Override
  public Executor visitWithParameter(ParserParser.WithParameterContext ctx) {
    return new WithParameterExecutor(ctx.id.getText(), visit(ctx.expr));
  }

  @Override
  public Executor visitTernary(ParserParser.TernaryContext ctx) {
    return new TernaryExecutor(visit(ctx.condition), ctx.choice1 == null ? null : visit(ctx.choice1), visit(ctx.choice2));
  }

  @Override
  public Executor visitArray(ParserParser.ArrayContext ctx) {
    List<Executor> executorList = new ArrayList<>();

    for (var entry : ctx.children) {
      Executor exec = visit(entry);
      if (exec != null) {
        executorList.add(exec);
      }
    }

    return new ArrayExecutor(executorList);
  }

  @Override
  public Executor visitNegate(ParserParser.NegateContext ctx) {
    String operator = ctx.operator.getText();
    Executor right = visit(ctx.right);

    return switch (operator) {
      case "-" -> new NegateExecutor(right);
      case "+" -> right;
      case "~" -> new BitNotExecutor(right);
      default -> throw new ExpressionException("Unsupported operand: " + operator);
    };
  }

  @Override
  public Executor visitEmptyArray(ParserParser.EmptyArrayContext ctx) {
    return new ArrayExecutor(List.of());
  }

  @Override
  public Executor visitPower(ParserParser.PowerContext ctx) {
    return new PowerExecutor(visit(ctx.left), visit(ctx.right));
  }

  @Override
  public Executor visitDoubleQuoteString(ParserParser.DoubleQuoteStringContext ctx) {
    String txt = ctx.getText();
    Value value = ValueString.of(txt.substring(1, txt.length() - 1));
    return new ValueExecutor(value);
  }

  @Override
  public Executor visitSingleQuoteString(ParserParser.SingleQuoteStringContext ctx) {
    String txt = ctx.getText();
    Value value = ValueString.of(txt.substring(1, txt.length() - 1));
    return new ValueExecutor(value);
  }

  @Override
  public Executor visitArraySelector(ParserParser.ArraySelectorContext ctx) {
    List<Executor> executorList = ctx
      .selector
      .children
      .stream()
      .map(this::visit)
      .filter(Objects::nonNull)
      .peek((executor) -> {
        if (!(executor instanceof ArraySelectorEntryExecutor)) {
          throw new ExpressionException("Unexpected executor: " + executor);
        }
      })
      .toList();

    return new ArraySelectorExecutor(visit(ctx.expr), executorList);
  }

  @Override
  public Executor visitNot(ParserParser.NotContext ctx) {
    return new BoolNotExecutor(visit(ctx.right));
  }

  @Override
  public Executor visitEmptyObject(ParserParser.EmptyObjectContext ctx) {
    return new ValueExecutor(ValueObject.EMPTY);
  }

  @Override
  public Executor visitObject(ParserParser.ObjectContext ctx) {
    return new ObjectExecutor(
      ctx
        .children
        .stream()
        .map(this::visit)
        .filter(Objects::nonNull)
        .peek((executor) -> {
          if (!(executor instanceof ObjectEntryExecutor)) {
            throw new ExpressionException("Unexpected executor: " + executor);
          }
        })
        .toList()
    );
  }

  @Override
  public Executor visitObjectEntry(ParserParser.ObjectEntryContext ctx) {
    return new ObjectEntryExecutor(visit(ctx.key), visit(ctx.value));
  }

  @Override
  public Executor visitArraySelectorEntry(ParserParser.ArraySelectorEntryContext ctx) {
    Executor from = visit(ctx.from);
    Executor to = ctx.to == null ? null : visit(ctx.to);

    return new ArraySelectorEntryExecutor(from, to);
  }

  @Override
  public Executor visitQuotedVariable(ParserParser.QuotedVariableContext ctx) {
    String txt = ctx.getText();
    return new VariableExexcutor(txt.substring(1, txt.length() - 1));
  }

  @Override
  public Executor visitLambda(ParserParser.LambdaContext ctx) {
    ParserParser.LambdaParameterContext list = ctx.lambdaParameter();
    List<String> variables = List.of();
    if (list!=null) {
      variables = list
        .children
        .stream()
        .map(ParseTree::getText)
        .filter((e) -> !",".equals(e)) //TODO: is this the right way?
        .toList();
    }

    ValueLambda value = new ValueLambda(visit(ctx.expr), variables);
    return new ValueExecutor(value);
  }
}
