package de.weinzierlstefan.expressionparser.functions.math;

/**
 *
 */
public class ASin extends CommonMathFunction {
  @Override
  public String getName() {
    return "asin";
  }

  @Override
  protected double calculate(double value) {
    return Math.toDegrees(Math.asin(value));
  }
}
