package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueArray;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class ArrayReplace implements Function {
  @Override
  public String getName() {
    return "arrayreplace";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList list = valueList.getArray(0);
    if (list == null) {
      throw new ExpressionException("First parameter must be a array");
    }

    int limit = Integer.MAX_VALUE;
    if (list.size() > 3) {
      limit = valueList.getInt(3);
    }

    ValueList resultList = new ValueList();
    int replaced = 0;
    for (Value value : list) {
      if (replaced<limit && value.equals(valueList.get(1))) {
        resultList.add(valueList.get(2));
        replaced++;
      } else {
        resultList.add(value);
      }
    }

    return ValueArray.of(resultList);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 3 || count==4;
  }
}
