package de.weinzierlstefan.expressionparser.functions.math;

public class ACosR extends CommonMathFunction {
  @Override
  public String getName() {
    return "acosr";
  }

  @Override
  protected double calculate(double value) {
    return Math.acos(value);
  }

}
