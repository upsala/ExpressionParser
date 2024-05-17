package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueDouble;
import de.weinzierlstefan.expressionparser.value.ValueList;


public class Log2 implements Function {
  @Override
  public String getName() {
    return "log2";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    if (!valueList.allIsNumber()) {
      throw new ExpressionException(getName() + "-function can only operate on numbers");
    }

    double value = valueList.getDouble(0);

    return ValueDouble.of(Math.log(value) / Math.log(2.));
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
