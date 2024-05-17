package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueArray;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.util.Collections;

/**
 *
 */
public class ArrayRotate implements Function {
  @Override
  public String getName() {
    return "arrayrotate";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList list = valueList.getArray(0);
    if (list == null) {
      throw new ExpressionException("First parameter must be a array");
    }

    if (!valueList.isNumber(1)) {
      throw new ExpressionException("Second parameter must be a number");
    }

    int distance = valueList.getInt(1);

    ValueList resultList = new ValueList(list);

    Collections.rotate(resultList, distance);

    return ValueArray.of(resultList);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 2;
  }
}
