package de.weinzierlstefan.expressionparser.functions.math;

public class TanR extends CommonMathFunction {
  @Override
  public String getName() {
    return "tanr";
  }

  @Override
  protected double calculate(double value) {
    return Math.tan(value);
  }
}
