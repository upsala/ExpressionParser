package de.weinzierlstefan.expressionparser.functions.statistics;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.math.BigDecimal;

public class StatisticTools {

  public static BigDecimal sum(ValueList list) throws ExpressionException {
    BigDecimal sum = BigDecimal.ZERO;
    for(Value value : list) {
      if (!value.isNumber()) {
        throw new ExpressionException("Values must be numbers");
      }
      sum=sum.add(value.toBigDecimal());
    }

    return sum;
  }

  public static BigDecimal mean(ValueList list, ExecutorContext executorContext) throws ExpressionException {

    BigDecimal sum = StatisticTools.sum(list);

    BigDecimal avg = sum.divide(BigDecimal.valueOf(list.size()), executorContext.getMathContext());

    return avg;
  }

  public static BigDecimal std(ValueList list, ExecutorContext executorContext) throws ExpressionException {
    BigDecimal var = StatisticTools.var(list, executorContext);

    BigDecimal std = var.sqrt(executorContext.getMathContext());

    return std;
  }

  public static BigDecimal var(ValueList list, ExecutorContext executorContext) throws ExpressionException {
    BigDecimal avg = StatisticTools.mean(list, executorContext);

    BigDecimal sum = BigDecimal.ZERO;

    for(Value value : list) {
      sum = sum.add(value.toBigDecimal().subtract(avg).pow(2));
    }

    BigDecimal var = sum.divide(BigDecimal.valueOf(list.size()), executorContext.getMathContext());

    return var;
  }
}
