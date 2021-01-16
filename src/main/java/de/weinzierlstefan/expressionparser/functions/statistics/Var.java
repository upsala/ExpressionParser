package de.weinzierlstefan.expressionparser.functions.statistics;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.math.BigDecimal;

public class Var implements Function {
  @Override
  public String getName() {
    return "var";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList list = valueList.getArray(0);
    if (list==null) {
      throw new ExpressionException("Parameter must be a array");
    }

    if (list.isEmpty()) {
      throw new ExpressionException("Array is empty");
    }

    BigDecimal var = StatisticTools.var(list, executorContext);

    return Value.of(var);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
