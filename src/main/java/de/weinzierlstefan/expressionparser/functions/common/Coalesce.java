package de.weinzierlstefan.expressionparser.functions.common;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueNull;


public class Coalesce implements Function {
  @Override
  public String getName() {
    return "coalesce";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    for (Value value : valueList) {
      if (!value.isNull()) {
        return value;
      }
    }

    return ValueNull.INSTANCE;
  }

  @Override
  public boolean parameterCount(int count) {
    return true;
  }

  @Override
  public boolean returnsNullOnNull() {
    return false;
  }
}
