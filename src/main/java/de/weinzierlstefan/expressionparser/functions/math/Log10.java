package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueDouble;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class Log10 implements Function {
  @Override
  public String getName() {
    return "log10";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value inputValue = valueList.get(0);

    if (!inputValue.isNumber()) {
      throw new ExpressionException("log10-function can only operate on numbers");
    }

    return ValueDouble.of(Math.log10(inputValue.getDouble()));
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
