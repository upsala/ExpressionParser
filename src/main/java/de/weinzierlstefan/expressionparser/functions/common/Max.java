package de.weinzierlstefan.expressionparser.functions.common;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueNull;


public class Max implements Function {
  @Override
  public String getName() {
    return "max";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    if (valueList.size() == 1 && valueList.get(0).isArray()) {
      valueList = valueList.getArray(0);
    }
    return valueList
      .stream()
      .filter(e -> !e.isNull())
      .max(Value::compareTo)
      .orElse(ValueNull.INSTANCE);
  }

  @Override
  public boolean parameterCount(int count) {
    return count > 0;
  }

  @Override
  public boolean returnsNullOnNull() {
    return false;
  }
}
