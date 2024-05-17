package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueArray;
import de.weinzierlstefan.expressionparser.value.ValueList;


public class ArraySet implements Function {
  @Override
  public String getName() {
    return "arrayset";
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

    int pos = valueList.getInt(1);

    if (pos < 0 || pos >= list.size()) {
      throw new ExpressionException("Index out of range");
    }

    list.set(pos, valueList.get(2));

    return ValueArray.of(list);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 3;
  }
}
