package de.weinzierlstefan.expressionparser.functions.common;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

/**
 *
 */
public class Bound implements Function {
  @Override
  public String getName() {
    return "bound";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value minValue = valueList.get(0);
    Value curValue = valueList.get(1);
    Value maxValue = valueList.get(2);

    if (minValue.compareTo(curValue) > 0) {
      return minValue;
    }
    if (maxValue.compareTo(curValue) < 0) {
      return maxValue;
    }

    return curValue;
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 3;
  }
}
