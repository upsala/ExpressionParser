package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueDouble;
import de.weinzierlstefan.expressionparser.value.ValueList;


public class Floor implements Function {
  @Override
  public String getName() {
    return "floor";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value inputValue = valueList.get(0);

    if (inputValue.isNull() || inputValue.isInt() || inputValue.isLong()) {
      return inputValue;
    }
    if (inputValue.isDouble()) {
      return ValueDouble.of(Math.floor(inputValue.getDouble()));
    }

    throw new ExpressionException("floor-function can only operate on numbers");
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
