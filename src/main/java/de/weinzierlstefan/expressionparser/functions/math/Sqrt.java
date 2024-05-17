package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueDouble;
import de.weinzierlstefan.expressionparser.value.ValueList;


public class Sqrt implements Function {
  @Override
  public String getName() {
    return "sqrt";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value value = valueList.get(0);
    if (value.isNull()) {
      return value;
    }

    if (value.isNumber()) {
      double dbl = value.getDouble();
      if (dbl < 0) {
        throw new ExpressionException("Cannot sqrt a negative number");
      }
      return ValueDouble.of(Math.sqrt(dbl));
    }

    throw new ExpressionException(getName() + "-function can only operate on numbers");
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
