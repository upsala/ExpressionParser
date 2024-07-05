package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.executor.ValueExecutor;
import de.weinzierlstefan.expressionparser.value.*;

public class ArrayMap implements Function {
  @Override
  public String getName() {
    return "arraymap";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList array = valueList.getArray(0);
    if (!valueList.isLambda(1)) {
      throw new ExpressionException("Lambda expected");
    }

    ValueLambda lambda = (ValueLambda) valueList.get(1);

    ValueList result = new ValueList();
    for(int i=0; i<array.size(); i++) {
      ValueList parameter = new ValueList();
      parameter.add(array.get(i));
      parameter.add(ValueInt.of(i));
      parameter.add(ValueArray.of(array));

      result.add(lambda.exec(parameter, executorContext));
    }

    return ValueArray.of(result);
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
