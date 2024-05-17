package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueDouble;
import de.weinzierlstefan.expressionparser.value.ValueInt;
import de.weinzierlstefan.expressionparser.value.ValueList;


public class Sign implements Function {
  @Override
  public String getName() {
    return "sign";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value inputValue = valueList.get(0);

    if (!inputValue.isNumber()) {
      throw new ExpressionException("sign-function can only operate on numbers");
    }

    if (inputValue.isDouble()) {
      return ValueDouble.of(Math.signum(inputValue.getDouble()));
    }
    if (inputValue.isInt() || inputValue.isLong()) {
      long value = inputValue.getLong();

      return ValueInt.of(value == 0 ? 0 : (value > 0 ? 1 : -1));
    }

    throw new ExpressionException("sign-function can only operate on numbers");
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
