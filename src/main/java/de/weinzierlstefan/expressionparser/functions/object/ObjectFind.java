package de.weinzierlstefan.expressionparser.functions.object;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.*;

public class ObjectFind implements Function {
  @Override
  public String getName() {
    return "objectfind";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    var map = valueList.getMap(0);
    if (map == null) {
      throw new ExpressionException("First parameter must be a object");
    }

    Value search = valueList.get(1);

    if (!search.isLambda()) {
      throw new ExpressionException("Second parameter must be a lambda");
    }

    ValueLambda lambda = (ValueLambda)search;

    for(var key : map.keySet()) {
      ValueList parameter = new ValueList();
      parameter.add(map.get(key));
      parameter.add(key);
      parameter.add(ValueObject.of(map));

      if (lambda.exec(parameter, executorContext).getBoolean()) {
        return map.get(key);
      }
    }

    return ValueNull.INSTANCE;
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
