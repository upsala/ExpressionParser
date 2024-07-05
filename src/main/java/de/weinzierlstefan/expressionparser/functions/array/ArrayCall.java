package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.*;

public class ArrayCall implements Function {
  @Override
  public String getName() {
    return "arraycall";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList array = valueList.getArray(0);
    if (!valueList.isLambda(1)) {
      throw new ExpressionException("Lambda expected");
    }

    ValueLambda lambda = (ValueLambda) valueList.get(1);

    return lambda.exec(array, executorContext);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 2;
  }

  @Override
  public boolean canHandleLambda() {
    return true;
  }
}
