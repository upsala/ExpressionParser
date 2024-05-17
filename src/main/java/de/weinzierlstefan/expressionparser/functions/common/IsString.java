package de.weinzierlstefan.expressionparser.functions.common;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueBoolean;
import de.weinzierlstefan.expressionparser.value.ValueList;


public class IsString implements Function {
  @Override
  public String getName() {
    return "isstring";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    return ValueBoolean.of(valueList.allIsString());
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
