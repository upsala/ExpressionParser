package de.weinzierlstefan.expressionparser.functions.statistics;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.util.HashMap;
import java.util.Map;


public class Mode implements Function {
  @Override
  public String getName() {
    return "mode";
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

    Map<Value, Integer> counterMap = new HashMap<>();

    int max = 0;
    Value maxValue = null;
    for (Value value : list) {
      int counter = counterMap.getOrDefault(value, 0) + 1;
      counterMap.put(value, counter);
      if (counter > max) {
        max = counter;
        maxValue = value;
      }
    }

    return maxValue;
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
