package de.weinzierlstefan.expressionparser.functions.statistics;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueDouble;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class Mean implements Function {
  @Override
  public String getName() {
    return "mean";
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

    double avg = StatisticTools.mean(list);
    return ValueDouble.of(avg);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
