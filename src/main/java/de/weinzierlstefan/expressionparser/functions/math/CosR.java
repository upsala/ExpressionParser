package de.weinzierlstefan.expressionparser.functions.math;

/**
 *
 */
public class CosR extends CommonMathFunction {
  @Override
  public String getName() {
    return "cosr";
  }

  @Override
  protected double calculate(double value) {
    return Math.cos(value);
  }
}
