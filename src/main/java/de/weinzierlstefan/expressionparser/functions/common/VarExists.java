package de.weinzierlstefan.expressionparser.functions.common;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueBoolean;
import de.weinzierlstefan.expressionparser.value.ValueList;


public class VarExists implements Function {
  @Override
  public String getName() {
    return "varexists";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    return ValueBoolean.of(
      valueList
        .stream()
        .map(Value::getString)
        .allMatch(executorContext::hasVariable)
    );
  }

  @Override
  public boolean parameterCount(int count) {
    return count > 0;
  }
}
