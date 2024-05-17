package de.weinzierlstefan.expressionparser.functions.math;

public class Sec extends CommonMathFunction {
  @Override
  public String getName() {
    return "sec";
  }

  @Override
  protected double calculate(double value) {
    return 1d / Math.cos(Math.toRadians(value));
  }
}
