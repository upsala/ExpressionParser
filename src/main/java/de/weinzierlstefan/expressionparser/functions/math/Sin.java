package de.weinzierlstefan.expressionparser.functions.math;

public class Sin extends CommonMathFunction {
  @Override
  public String getName() {
    return "sin";
  }

  @Override
  protected double calculate(double value) {
    return Math.sin(Math.toRadians(value));
  }
}
