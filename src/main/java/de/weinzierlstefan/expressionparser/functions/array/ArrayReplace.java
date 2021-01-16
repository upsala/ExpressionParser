package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class ArrayReplace implements Function {
  @Override
  public String getName() {
    return "arrayreplace";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList list = valueList.getArray(0);
    if (list==null) {
      throw new ExpressionException("First parameter must be a array");
    }

    ValueList resultList = new ValueList();
    for(Value value : list) {
      if (value.equals(valueList.get(1))) {
        resultList.add(valueList.get(2));
      } else {
        resultList.add(value);
      }
    }

    return Value.of(resultList);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==3;
  }
}
