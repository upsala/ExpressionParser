package de.weinzierlstefan.expressionparser.functions.math;

public class SinR extends CommonMathFunction {
  @Override
  public String getName() {
    return "sinr";
  }

  @Override
  protected double calculate(double value) {
    return Math.sin(value);
  }
}
