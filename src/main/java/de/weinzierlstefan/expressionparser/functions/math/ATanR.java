package de.weinzierlstefan.expressionparser.functions.math;

public class ATanR extends CommonMathFunction {
  @Override
  public String getName() {
    return "atanr";
  }

  @Override
  protected double calculate(double value) {
    return Math.atan(value);
  }

}
