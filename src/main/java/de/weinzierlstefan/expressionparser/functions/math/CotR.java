package de.weinzierlstefan.expressionparser.functions.math;

/**
 *
 */
public class CotR extends CommonMathFunction {
  @Override
  public String getName() {
    return "cotr";
  }

  @Override
  protected double calculate(double value) {
    return Math.cos(value) / Math.sin(value);
  }
}
