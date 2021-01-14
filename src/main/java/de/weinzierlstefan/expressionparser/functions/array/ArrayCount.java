package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class ArrayCount implements Function {
  @Override
  public String getName() {
    return "arraycount";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value arrValue = valueList.get(0);
    if (!arrValue.isArray()) {
      throw new ExpressionException("Value must be an array");
    }

    return Value.of(arrValue.toArray().size());
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
