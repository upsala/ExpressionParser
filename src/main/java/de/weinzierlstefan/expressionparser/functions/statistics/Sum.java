package de.weinzierlstefan.expressionparser.functions.statistics;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.math.BigDecimal;

public class Sum implements Function {
  @Override
  public String getName() {
    return "sum";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList list = valueList.get(0).toArray();
    if (list==null) {
      throw new ExpressionException("Parameter must be a array");
    }

    BigDecimal sum = StatisticTools.sum(list);

    return Value.of(sum);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
