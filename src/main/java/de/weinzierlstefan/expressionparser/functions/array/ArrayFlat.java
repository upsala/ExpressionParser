package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueArray;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.util.List;


public class ArrayFlat implements Function {
  @Override
  public String getName() {
    return "arrayflat";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    return ValueArray.of(flatten(valueList));
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }

  private static ValueList flatten(List<Value> list) {
    ValueList resultList = new ValueList();

    for (Value value : list) {
      if (value.isArray()) {
        resultList.addAll(flatten(value.getArray()));
      } else {
        resultList.add(value);
      }
    }

    return resultList;
  }
}
