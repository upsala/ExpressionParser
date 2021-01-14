package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.math.BigDecimal;

public class Round implements Function {
  @Override
  public String getName() {
    return "round";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value inputValue = valueList.get(0);

    if (!inputValue.isNumber()) {
      throw new ExpressionException("round-function can only operate on numbers");
    }

    BigDecimal value = inputValue.toBigDecimal();
    int precision = 0;
    if (valueList.size()>1) {
      precision = (int) valueList.get(1).toLong();
    }
    value=value.setScale(precision, executorContext.getMathContext().getRoundingMode());
    return Value.of(value.stripTrailingZeros());
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1 || count==2;
  }
}
