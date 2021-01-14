package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class Pow implements Function {
  @Override
  public String getName() {
    return "pow";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    if (!valueList.allIsNumber()) {
      throw new ExpressionException("Values must be numbers");
    }

    double base = valueList.get(0).toDouble();
    double exponent = valueList.get(1).toDouble();

    return Value.of(Math.pow(base, exponent));
  }

  @Override
  public boolean parameterCount(int count) {
    return count==2;
  }
}
