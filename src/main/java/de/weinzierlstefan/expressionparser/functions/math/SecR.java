package de.weinzierlstefan.expressionparser.functions.math;

public class SecR extends CommonMathFunction {
  @Override
  public String getName() {
    return "secr";
  }

  @Override
  protected double calculate(double value) {
    return 1. / Math.cos(value);
  }
}
