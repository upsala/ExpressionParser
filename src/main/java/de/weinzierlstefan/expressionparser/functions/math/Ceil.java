package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueDouble;
import de.weinzierlstefan.expressionparser.value.ValueList;

/**
 *
 */
public class Ceil implements Function {
  @Override
  public String getName() {
    return "ceil";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value value = valueList.get(0);

    if (value.isNull() || value.isLong() || value.isInt()) {
      return value;
    }
    if (value.isDouble()) {
      return ValueDouble.of(Math.ceil(value.getDouble()));
    }

    throw new ExpressionException(getName() + "-function can only operate on numbers");
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
