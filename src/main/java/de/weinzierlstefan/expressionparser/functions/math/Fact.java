package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.math.BigDecimal;

public class Fact implements Function {
  @Override
  public String getName() {
    return "fact";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value numberValue = valueList.get(0);
    if (!numberValue.isNumber()) {
      throw new ExpressionException("Value must be a number");
    }

    long number = numberValue.toLong();

    if (number<0) {
      throw new ExpressionException("Value must be positiv");
    }

    BigDecimal factorial = BigDecimal.ONE;
    try {
      for (long i = 1; i <= number; i++) {
        factorial = factorial.multiply(new BigDecimal(i), executorContext.getMathContext());
      }
      return Value.of(factorial);
    } catch (Exception ex) {
      throw new ExpressionException("Overflow");
    }
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
