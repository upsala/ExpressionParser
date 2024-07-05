package de.weinzierlstefan.expressionparser.functions.object;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.*;

import java.util.Map;

public class ObjectFilter implements Function {
  @Override
  public String getName() {
    return "arrayfilter";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Map<Value, Value> object = valueList.getMap(0);
    if (!valueList.isLambda(1)) {
      throw new ExpressionException("Lambda expected");
    }

    ValueLambda lambda = (ValueLambda) valueList.get(1);

    ValueList result = new ValueList();
    for(Value key : object.keySet()) {
      ValueList parameter = new ValueList();
      parameter.add(object.get(key));
      parameter.add(key);
      parameter.add(ValueObject.of(object));

      if (lambda.exec(parameter, executorContext).getBoolean()) {
        result.add(object.get(key));
      }
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
