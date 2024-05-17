package de.weinzierlstefan.expressionparser.functions.common;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueBoolean;
import de.weinzierlstefan.expressionparser.value.ValueList;


public class IsTemporal implements Function {
  @Override
  public String getName() {
    return "istemporal";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    return ValueBoolean.of(valueList.allIsTemporal());
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
