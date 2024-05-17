package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueDouble;
import de.weinzierlstefan.expressionparser.value.ValueList;


public class Pow implements Function {
  @Override
  public String getName() {
    return "pow";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    if (!valueList.allIsNumber()) {
      throw new ExpressionException(getName() + "-function can only operate on numbers");
    }

    double base = valueList.getDouble(0);
    double exponent = valueList.getDouble(1);

    return ValueDouble.of(Math.pow(base, exponent));
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 2;
  }
}
