package de.weinzierlstefan.expressionparser.functions.object;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueObject;

import java.util.HashMap;
import java.util.Map;

public class ObjectMerge implements Function {
  @Override
  public String getName() {
    return "objectmerge";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    if (!valueList.allIsObject()) {
      throw new ExpressionException("Values must be  objects");
    }

    Map<Value, Value> resultMap = new HashMap<>();
    for (Value value : valueList) {
      resultMap.putAll(value.getMap());
    }

    return ValueObject.of(resultMap);
  }

  @Override
  public boolean parameterCount(int count) {
    return true;
  }
}
