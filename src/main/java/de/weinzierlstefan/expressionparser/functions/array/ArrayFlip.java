package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.util.HashMap;
import java.util.Map;

public class ArrayFlip implements Function {
  @Override
  public String getName() {
    return "arrayflip";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value arrayValue = valueList.get(0);
    if (!arrayValue.isArray()) {
      throw new ExpressionException("Value must be a array");
    }

    Map<Value, Value> resultMap = new HashMap<>();
    Map<Value, Value> sourceMap = arrayValue.toMap();
    for(Value key : sourceMap.keySet()) {
      resultMap.put(sourceMap.get(key), key);
    }

    return Value.of(resultMap);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
