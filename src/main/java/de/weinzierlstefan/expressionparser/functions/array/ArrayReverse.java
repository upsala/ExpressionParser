package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueArray;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.util.Collections;

public class ArrayReverse implements Function {
  @Override
  public String getName() {
    return "arrayreverse";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList list = valueList.getArray(0);
    if (list == null) {
      throw new ExpressionException("First parameter must be a array");
    }

    ValueList resultList = new ValueList(list);

    Collections.reverse(resultList);

    return ValueArray.of(resultList);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
