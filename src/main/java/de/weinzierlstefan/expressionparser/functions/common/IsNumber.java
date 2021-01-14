package de.weinzierlstefan.expressionparser.functions.common;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class IsNumber implements Function {
  @Override
  public String getName() {
    return "isnumber";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    return Value.of(valueList.get(0).isNumber());
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
