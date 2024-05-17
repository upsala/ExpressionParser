package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueDouble;
import de.weinzierlstefan.expressionparser.value.ValueList;

abstract class CommonMathFunction implements Function {

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value value = valueList.get(0);

    if (value.isNumber()) {
      return ValueDouble.of(calculate(value.getDouble()));
    }

    throw new ExpressionException(
      String.format(
        "Function '%s' can not work with type '%s'",
        getName(),
        value.getType()
      )
    );
  }

  protected abstract double calculate(double value);

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
