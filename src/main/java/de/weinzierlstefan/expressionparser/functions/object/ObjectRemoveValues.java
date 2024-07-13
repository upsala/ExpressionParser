package de.weinzierlstefan.expressionparser.functions.object;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueObject;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ObjectRemoveValues implements Function {
  @Override
  public String getName() {
    return "objectremovevalues";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value objValue = valueList.get(0);
    if (!objValue.isObject()) {
      throw new ExpressionException("First value must be a object");
    }

    Set<Value> valueSet = valueList
      .stream()
      .skip(1)
      .collect(Collectors.toSet());

    var resultMap = objValue.getMap();
    Set<Value> keys = new HashSet<>();
    for(var entry : resultMap.entrySet()) {
      if (valueSet.contains(entry.getValue())) {
        keys.add(entry.getKey());
      }
    }

    keys.forEach(resultMap::remove);

    return ValueObject.of(resultMap);
  }

  @Override
  public boolean parameterCount(int count) {
    return count > 1;
  }
}
