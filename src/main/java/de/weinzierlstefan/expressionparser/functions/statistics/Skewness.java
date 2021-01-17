package de.weinzierlstefan.expressionparser.functions.statistics;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.math.BigDecimal;
import java.math.MathContext;

public class Skewness implements Function {
  @Override
  public String getName() {
    return "skewness";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList list = valueList.getArray(0);
    if (list==null) {
      throw new ExpressionException("Parameter must be a array");
    }

    BigDecimal sum = BigDecimal.ZERO;

    BigDecimal avg = StatisticTools.mean(list, executorContext);

    BigDecimal std = StatisticTools.std(list, executorContext);

    MathContext mc = executorContext.getMathContext();

    for(Value value : list) {
      BigDecimal  v = value.toBigDecimal();

      v = v.subtract(avg, mc);
      v = v.divide(std, mc);
      v = v.pow(3, mc);

      sum = sum.add(v, mc);
    }

    return Value.of(sum);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
