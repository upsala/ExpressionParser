package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.math.BigDecimal;

public class Sign implements Function {
  @Override
  public String getName() {
    return "sign";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value inputValue = valueList.get(0);

    if (!inputValue.isNumber()) {
      throw new ExpressionException("sign-function can only operate on numbers");
    }

    BigDecimal number = inputValue.toBigDecimal();

    return Value.of(number.signum());
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
