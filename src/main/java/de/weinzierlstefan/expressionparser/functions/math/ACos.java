package de.weinzierlstefan.expressionparser.functions.math;

public class ACos extends CommonMathFunction {
  @Override
  public String getName() {
    return "acos";
  }

  @Override
  protected double calculate(double value) {
    return Math.toDegrees(Math.acos(value));
  }
}
