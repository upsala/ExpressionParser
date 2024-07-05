package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.*;

public class ArrayReduce implements Function {
  @Override
  public String getName() {
    return "arrayreduce";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList array = valueList.getArray(0);
    if (!valueList.isLambda(1)) {
      throw new ExpressionException("Lambda expected");
    }
    Value carry = valueList.get(2);

    ValueLambda lambda = (ValueLambda) valueList.get(1);

    for(int i=0; i<array.size(); i++) {
      ValueList parameter = new ValueList();
      parameter.add(carry);
      parameter.add(array.get(i));
      parameter.add(ValueInt.of(i));
      parameter.add(ValueArray.of(array));

      carry = lambda.exec(parameter, executorContext);
    }

    return carry;
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 3;
  }

  @Override
  public boolean canHandleLambda() {
    return true;
  }
}
