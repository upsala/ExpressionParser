package de.weinzierlstefan.expressionparser.functions.object;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.*;

import java.util.Map;

public class ObjectReduce implements Function {
  @Override
  public String getName() {
    return "objectreduce";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Map<Value, Value> object = valueList.getMap(0);
    if (!valueList.isLambda(1)) {
      throw new ExpressionException("Lambda expected");
    }
    Value carry = valueList.get(2);

    ValueLambda lambda = (ValueLambda) valueList.get(1);

    for(Value key : object.keySet()) {
      ValueList parameter = new ValueList();
      parameter.add(carry);
      parameter.add(object.get(key));
      parameter.add(key);
      parameter.add(ValueObject.of(object));

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
