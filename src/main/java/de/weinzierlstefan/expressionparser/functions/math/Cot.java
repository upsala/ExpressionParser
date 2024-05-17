package de.weinzierlstefan.expressionparser.functions.math;

/**
 *
 */
public class Cot extends CommonMathFunction {
  @Override
  public String getName() {
    return "cot";
  }

  @Override
  protected double calculate(double value) {
    value = Math.toRadians(value);
    return Math.cos(value) / Math.sin(value);
  }
}
