package de.weinzierlstefan.expressionparser.functions.math;

/**
 *
 */
public class Cos extends CommonMathFunction {
  @Override
  public String getName() {
    return "cos";
  }

  @Override
  protected double calculate(double value) {
    return Math.cos(Math.toRadians(value));
  }
}
