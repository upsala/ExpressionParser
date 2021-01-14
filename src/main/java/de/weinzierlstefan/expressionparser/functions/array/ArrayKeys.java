package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class ArrayKeys implements Function {
  @Override
  public String getName() {
    return "arraykeys";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value objectValue = valueList.get(0);
    if (!objectValue.isArray()) {
      throw new ExpressionException("Value must be a array");
    }

    ValueList keyList = new ValueList(objectValue.toMap().keySet());

    return Value.of(keyList);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
