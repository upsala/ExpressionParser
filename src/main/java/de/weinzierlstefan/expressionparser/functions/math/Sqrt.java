package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.math.BigDecimal;

public class Sqrt implements Function {
  @Override
  public String getName() {
    return "sqrt";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    if (!valueList.allIsNumber()) {
      throw new ExpressionException(getName()+"-function can only operate on numbers");
    }

    BigDecimal value = valueList.getBigDecimal(0);

    if (value.signum()==-1) {
      throw new ExpressionException("Value must be not negativ");
    }

    value = value.sqrt(executorContext.getMathContext());

    return Value.of(value);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
