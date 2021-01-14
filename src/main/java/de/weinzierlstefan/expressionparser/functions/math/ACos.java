package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class ACos implements Function {
  @Override
  public String getName() {
    return "acos";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value inputValue = valueList.get(0);

    if (!inputValue.isNumber()) {
      throw new ExpressionException("acos-function can only operate on numbers");
    }

    double value = inputValue.toBigDecimal().doubleValue();

    return Value.of(Math.toDegrees(Math.acos(value)));
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
