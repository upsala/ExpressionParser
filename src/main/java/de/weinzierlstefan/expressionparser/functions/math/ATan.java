package de.weinzierlstefan.expressionparser.functions.math;

/**
 *
 */
public class ATan extends CommonMathFunction {
  @Override
  public String getName() {
    return "atan";
  }

  @Override
  protected double calculate(double value) {
    return Math.toDegrees(Math.atan(value));
  }
}
