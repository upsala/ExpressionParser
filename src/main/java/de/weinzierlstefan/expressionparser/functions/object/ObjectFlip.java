package de.weinzierlstefan.expressionparser.functions.object;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueObject;

import java.util.HashMap;
import java.util.Map;


public class ObjectFlip implements Function {
  @Override
  public String getName() {
    return "objectflip";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value objValue = valueList.get(0);
    if (!objValue.isObject()) {
      throw new ExpressionException("Value must be a object");
    }

    Map<Value, Value> resultMap = new HashMap<>();
    Map<Value, Value> sourceMap = objValue.getMap();
    for (Value key : sourceMap.keySet()) {
      resultMap.put(sourceMap.get(key), key);
    }

    return ValueObject.of(resultMap);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
