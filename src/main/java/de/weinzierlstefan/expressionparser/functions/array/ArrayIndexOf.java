package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.*;

public class ArrayIndexOf implements Function {
  @Override
  public String getName() {
    return "arrayindexof";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList list = valueList.getArray(0);
    if (list == null) {
      throw new ExpressionException("First parameter must be a array");
    }

    Value search = valueList.get(1);

    if (search.isLambda()) {
      ValueLambda lambda = (ValueLambda)search;

      for (int i = 0; i < list.size(); i++) {
        ValueList parameter = new ValueList();
        parameter.add(list.get(i));
        parameter.add(ValueInt.of(i));
        parameter.add(ValueArray.of(list));

        if (lambda.exec(parameter, executorContext).getBoolean()) {
          return ValueInt.of(i);
        }
      }
      return ValueInt.of(-1);
    }

    return ValueInt.of(list.indexOf(search));
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
