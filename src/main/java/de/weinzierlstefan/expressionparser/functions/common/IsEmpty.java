package de.weinzierlstefan.expressionparser.functions.common;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueBoolean;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class IsEmpty implements Function {
  @Override
  public String getName() {
    return "isempty";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value value = valueList.get(0);

    if (value.isNumber()) {
      return ValueBoolean.FALSE;
    }

    if (value.isObject()) {
      return ValueBoolean.of(value.getMap().isEmpty());
    }

    if (value.isArray()) {
      return ValueBoolean.of(value.getArray().isEmpty());
    }

    if (value.isNull()) {
      return ValueBoolean.TRUE;
    }

    return ValueBoolean.of(value.getString().isEmpty());
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }

  @Override
  public boolean returnsNullOnNull() {
    return false;
  }
}
