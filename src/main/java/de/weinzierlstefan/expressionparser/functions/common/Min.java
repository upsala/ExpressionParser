package de.weinzierlstefan.expressionparser.functions.common;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueNull;

import java.util.Optional;

public class Min implements Function {
  @Override
  public String getName() {
    return "min";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    if (valueList.size()==1 && valueList.get(0).isArray()) {
      valueList=valueList.getArray(0);
    }
    Optional<Value> result = valueList.stream().filter(e->!e.isNull()).min(Value::compareTo);

    if (result.isEmpty()) {
      return ValueNull.INSTANCE;
    }
    return result.get();
  }

  @Override
  public boolean parameterCount(int count) {
    return count>0;
  }

  @Override
  public boolean returnsNullOnNull() {
    return false;
  }
}
