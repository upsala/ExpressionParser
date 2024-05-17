package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueArray;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class Array implements Function {
  @Override
  public String getName() {
    return "array";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    return ValueArray.of(valueList);
  }

  @Override
  public boolean parameterCount(int count) {
    return count >= 0;
  }

  @Override
  public boolean returnsNullOnNull() {
    return false;
  }
}
