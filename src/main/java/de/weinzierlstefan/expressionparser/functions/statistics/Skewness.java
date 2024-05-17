package de.weinzierlstefan.expressionparser.functions.statistics;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueDouble;
import de.weinzierlstefan.expressionparser.value.ValueList;


public class Skewness implements Function {
  @Override
  public String getName() {
    return "skewness";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList list = valueList.getArray(0);
    if (list == null) {
      throw new ExpressionException("Parameter must be a array");
    }

    double sum = 0;

    double avg = StatisticTools.mean(list);

    double std = StatisticTools.std(list);

    for (Value value : list) {
      double v = value.getDouble();

      v = v - avg;
      v = v / std;
      v = Math.pow(v, 3);

      sum = sum + v;
    }

    return ValueDouble.of(sum);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
