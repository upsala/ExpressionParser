package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.math.BigDecimal;
import java.math.MathContext;

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

    BigDecimal value = inputValue.toBigDecimal();

    return Value.of(value.round(new MathContext(1)).scale() * -1);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
