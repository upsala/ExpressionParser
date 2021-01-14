package de.weinzierlstefan.expressionparser.functions.common;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class IsArray implements Function {
  @Override
  public String getName() {
    return "isarray";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    return Value.of(valueList.get(0).isArray());
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }

  @Override
  public boolean returnsNullOnNull() {
    return false;
  }
}
