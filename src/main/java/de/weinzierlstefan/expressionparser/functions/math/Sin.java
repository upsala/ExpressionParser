package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class Sin implements Function {
  @Override
  public String getName() {
    return "sin";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value inputValue = valueList.get(0);

    if (!inputValue.isNumber()) {
      throw new ExpressionException("sin-function can only operate on numbers");
    }

    double value = inputValue.toBigDecimal().doubleValue();

    return Value.of(Math.sin(Math.toRadians(value)));
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
