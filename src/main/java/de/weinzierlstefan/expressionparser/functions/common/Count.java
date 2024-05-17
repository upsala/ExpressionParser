package de.weinzierlstefan.expressionparser.functions.common;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueInt;
import de.weinzierlstefan.expressionparser.value.ValueList;

/**
 *
 */
public class Count implements Function {
  @Override
  public String getName() {
    return "count";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value value = valueList.get(0);

    if (value.isNull()) {
      return ValueInt.ZERO;
    }
    if (value.isArray()) {
      return ValueInt.of(value.getArray().size());
    }
    if (value.isObject()) {
      return ValueInt.of(value.getMap().size());
    }
    if (value.isString()) {
      return ValueInt.of(value.getString().length());
    }

    return ValueInt.of(1);
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
