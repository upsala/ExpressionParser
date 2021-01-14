package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class ATan2R implements Function {
  @Override
  public String getName() {
    return "atan2r";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value inputValue1 = valueList.get(0);
    Value inputValue2 = valueList.get(1);

    if (!inputValue1.isNumber() || !inputValue2.isNumber()) {
      throw new ExpressionException("atan2r-function can only operate on numbers");
    }

    double value1 = inputValue1.toBigDecimal().doubleValue();
    double value2 = inputValue2.toBigDecimal().doubleValue();

    return Value.of(Math.atan2(value1, value2));
  }

  @Override
  public boolean parameterCount(int count) {
    return count==2;
  }
}
