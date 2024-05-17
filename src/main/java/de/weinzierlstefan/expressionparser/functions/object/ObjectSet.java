package de.weinzierlstefan.expressionparser.functions.object;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueObject;

import java.util.HashMap;
import java.util.Map;


public class ObjectSet implements Function {
  @Override
  public String getName() {
    return "objectset";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value value = valueList.get(0);
    if (!value.isObject()) {
      throw new ExpressionException("First parameter must be a object");
    }

    Map<Value, Value> resultMap = new HashMap<>();

    for (int i = 1; i < valueList.size(); i += 2) {
      resultMap.put(valueList.get(i), valueList.get(i + 1));
    }

    return ValueObject.of(resultMap);
  }

  @Override
  public boolean parameterCount(int count) {
    return count % 2 == 1;
  }
}
