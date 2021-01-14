package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.util.Collections;

public class ArrayRotate implements Function {
  @Override
  public String getName() {
    return "arrayrotate";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList list = valueList.get(0).toArray();
    if (list==null) {
      throw new ExpressionException("First parameter must be a array");
    }

    if (!valueList.get(1).isNumber()) {
      throw new ExpressionException("Second parameter must be a number");
    }

    int distance = (int)valueList.get(1).toLong();

    ValueList resultList = new ValueList(list);

    Collections.rotate(resultList, distance);

    return Value.of(resultList);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==2;
  }
}
