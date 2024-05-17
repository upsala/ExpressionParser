package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.DefaultValueContainer;
import de.weinzierlstefan.expressionparser.value.ValueInt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVariables {
  @Test
  public void testVars() throws ExpressionException {
    ExpressionParser expressionParser = new ExpressionParser();
    expressionParser.setVariable("a", ValueInt.of(2));
    assertEquals("2", expressionParser.parse("a").eval().toString());

    expressionParser = new ExpressionParser();
    expressionParser.setVariable("a", ValueInt.of(2));
    expressionParser.setVariable("b", ValueInt.of(3));
    assertEquals("5", expressionParser.parse("a+b").eval().toString());

    expressionParser = new ExpressionParser();
    expressionParser.setVariable("_a", ValueInt.of(2));
    assertEquals("2", expressionParser.parse("_a").eval().toString());

    expressionParser = new ExpressionParser();
    expressionParser.setVariable("longvariablename", ValueInt.of(2));
    assertEquals("2", expressionParser.parse("longvariablename").eval().toString());

    expressionParser = new ExpressionParser();
    expressionParser.setVariable("var123456789", ValueInt.of(2));
    assertEquals("2", expressionParser.parse("var123456789").eval().toString());

    expressionParser = new ExpressionParser();
    expressionParser.setVariable("var_12345_6789", ValueInt.of(2));
    assertEquals("2", expressionParser.parse("var_12345_6789").eval().toString());
  }

  @Test
  public void testCase() {

  }

  @Test
  public void testOverwriting() throws ExpressionException {
    ExpressionParser parser = new ExpressionParser();
    parser.setVariable("a", ValueInt.of(1));
    parser.setVariable("a", ValueInt.of(2));
    assertEquals("2", parser.parse("a").eval().toString());

    parser = new ExpressionParser();
    parser.setVariable("a", ValueInt.of(1));
    Expression expression = parser.parse("a");
    expression.setVariable("a", ValueInt.of(2));
    assertEquals("2", expression.eval().toString());
  }

  @Test
  public void testVariableContainer() throws ExpressionException {
    DefaultValueContainer defaultVariableContainer = new DefaultValueContainer();
    defaultVariableContainer.set("a", ValueInt.of(1));

    ExpressionParser expressionParser = new ExpressionParser();
    expressionParser.addValueContainer(defaultVariableContainer);

    assertEquals("1", expressionParser.parse("a").eval().toString());
  }

  @Test
  public void testMissing() throws ExpressionException {
    String err = null;
    try {
      new ExpressionParser().parse("a==1").eval().toString();
    } catch (ExpressionException ex) {
      err = ex.getMessage();
    }
    assertEquals("Variable not found: a", err);
  }

}
