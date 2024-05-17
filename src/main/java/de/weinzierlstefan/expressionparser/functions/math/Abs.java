package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.*;

public class Abs implements Function {
  @Override
  public String getName() {
    return "abs";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value value = valueList.get(0);

    if (value.isDouble()) {
      return ValueDouble.of(Math.abs(value.getDouble()));
    }

    if (value.isLong()) {
      return ValueLong.of(Math.abs(value.getLong()));
    }

    if (value.isInt()) {
      return ValueInt.of(Math.abs(value.getInt()));
    }

    throw new ExpressionException("Function abs can not work with this type: " + value.getType());
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
