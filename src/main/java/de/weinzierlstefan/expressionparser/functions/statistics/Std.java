package de.weinzierlstefan.expressionparser.functions.statistics;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueDouble;
import de.weinzierlstefan.expressionparser.value.ValueList;


public class Std implements Function {
  @Override
  public String getName() {
    return "std";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList list = valueList.getArray(0);
    if (list == null) {
      throw new ExpressionException("Parameter must be a array");
    }

    if (list.isEmpty()) {
      throw new ExpressionException("Array is empty");
    }

    double std = StatisticTools.std(list);

    return ValueDouble.of(std);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }

}
