package de.weinzierlstefan.expressionparser.functions.object;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueObject;

public class ObjectRemoveKeys implements Function {
  @Override
  public String getName() {
    return "objectremovekeys";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value objValue = valueList.get(0);
    if (!objValue.isObject()) {
      throw new ExpressionException("First value must be a object");
    }

    var resultMap = objValue.getMap();
    for (int i = 1; i < valueList.size(); i++) {
      resultMap.remove(valueList.get(i));
    }

    return ValueObject.of(resultMap);
  }

  @Override
  public boolean parameterCount(int count) {
    return count > 1;
  }
}
