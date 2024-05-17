package de.weinzierlstefan.expressionparser.functions.object;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueObject;

import java.util.HashMap;
import java.util.Map;

public class ObjectCreator implements Function {
  @Override
  public String getName() {
    return "object";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Map<Value, Value> valueMap = new HashMap<>();

    for (int i = 0; i < valueList.size(); i += 2) {
      valueMap.put(valueList.get(i), valueList.get(i + 1));
    }

    return ValueObject.of(valueMap);
  }

  @Override
  public boolean parameterCount(int count) {
    return (count % 2) == 0;
  }
}
