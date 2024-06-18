package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.DefaultValueContainer;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueInt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVariables {
  private Value parse(String expression, ExecutorContext context) {
    return ExpressionParser.parse(expression, context).eval();
  }

  @Test
  public void testVars() throws ExpressionException {
    ExecutorContext ctx = new ExecutorContext();
    ctx.setVariable("a", ValueInt.of(2));
    assertEquals("2", parse("a", ctx).toString());

    ctx = new ExecutorContext();
    ctx.setVariable("a", ValueInt.of(2));
    ctx.setVariable("b", ValueInt.of(3));
    assertEquals("5", parse("a+b", ctx).toString());

    ctx = new ExecutorContext();
    ctx.setVariable("_a", ValueInt.of(2));
    assertEquals("2", parse("_a", ctx).toString());

    ctx = new ExecutorContext();
    ctx.setVariable("longvariablename", ValueInt.of(2));
    assertEquals("2", parse("longvariablename", ctx).toString());

    ctx = new ExecutorContext();
    ctx.setVariable("var123456789", ValueInt.of(2));
    assertEquals("2", parse("var123456789", ctx).toString());

    ctx = new ExecutorContext();
    ctx.setVariable("var_12345_6789", ValueInt.of(2));
    assertEquals("2", parse("var_12345_6789", ctx).toString());
  }

  @Test
  public void testCase() {

  }

  @Test
  public void testOverwriting() throws ExpressionException {
    ExecutorContext ctx = new ExecutorContext();

    ctx.setVariable("a", ValueInt.of(1));
    ctx.setVariable("a", ValueInt.of(2));
    assertEquals("2", parse("a", ctx).toString());

    ctx = new ExecutorContext();
    ctx.setVariable("a", ValueInt.of(1));
    Expression expression = ExpressionParser.parse("a", ctx);
    ctx.setVariable("a", ValueInt.of(2));
    assertEquals("2", expression.eval().toString());
  }

  @Test
  public void testVariableContainer() throws ExpressionException {
    DefaultValueContainer defaultVariableContainer = new DefaultValueContainer();
    defaultVariableContainer.set("a", ValueInt.of(1));

    ExecutorContext ctx = new ExecutorContext();
    ctx.setValueContainer(defaultVariableContainer);

    assertEquals("1", parse("a", ctx).toString());
  }

  @Test
  public void testMissing() throws ExpressionException {
    String err = null;
    try {
      ExpressionParser.parse("a==1").eval().toString();
    } catch (ExpressionException ex) {
      err = ex.getMessage();
    }
    assertEquals("Variable not found: a", err);
  }

}
