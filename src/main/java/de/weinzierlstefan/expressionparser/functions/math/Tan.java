package de.weinzierlstefan.expressionparser.functions.math;

public class Tan extends CommonMathFunction {
  @Override
  public String getName() {
    return "tan";
  }

  @Override
  protected double calculate(double value) {
    return Math.tan(Math.toRadians(value));
  }
}
