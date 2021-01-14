package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Floor implements Function {
  @Override
  public String getName() {
    return "floor";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value inputValue = valueList.get(0);

    if (!inputValue.isNumber()) {
      throw new ExpressionException("floor-function can only operate on numbers");
    }

    BigDecimal value = inputValue.toBigDecimal();
    value = value.setScale(0, RoundingMode.FLOOR);

    return Value.of(value.stripTrailingZeros());
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
