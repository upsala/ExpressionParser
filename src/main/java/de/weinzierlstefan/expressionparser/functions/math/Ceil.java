package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ceil implements Function {
  @Override
  public String getName() {
    return "ceil";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    if (!valueList.allIsNumber()) {
      throw new ExpressionException(getName()+"-function can only operate on numbers");
    }

    BigDecimal value = valueList.getBigDecimal(0);
    value = value.setScale(0, RoundingMode.CEILING);

    return Value.of(value.stripTrailingZeros());
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
