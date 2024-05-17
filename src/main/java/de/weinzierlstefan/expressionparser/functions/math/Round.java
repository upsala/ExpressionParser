package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueDouble;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Round implements Function {
  @Override
  public String getName() {
    return "round";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value inputValue = valueList.get(0);

    if (inputValue.isNull() || inputValue.isInt() || inputValue.isLong()) {
      return inputValue;
    }

    if (inputValue.isDouble()) {
      double value = inputValue.getDouble();

      if (valueList.size() > 1) {
        int scale = valueList.getInt(1);
        BigDecimal bd = new BigDecimal(value).setScale(scale, RoundingMode.HALF_EVEN);
        return ValueDouble.of(bd.doubleValue());
      }
      return ValueDouble.of(Math.round(value));
    }

    throw new ExpressionException("round-function can only operate on numbers");
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1 || count == 2;
  }
}
