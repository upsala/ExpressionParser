package de.weinzierlstefan.expressionparser.functions.math;

/**
 *
 */
public class ASinR extends CommonMathFunction {
  @Override
  public String getName() {
    return "asinr";
  }

  @Override
  protected double calculate(double value) {
    return Math.asin(value);
  }
}
