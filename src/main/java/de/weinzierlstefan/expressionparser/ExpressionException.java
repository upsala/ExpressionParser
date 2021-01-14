package de.weinzierlstefan.expressionparser;

public class ExpressionException extends Exception {
  public ExpressionException(String message) {
    super(message);
  }

  public ExpressionException(Exception e) {
    super(e);
  }
}
