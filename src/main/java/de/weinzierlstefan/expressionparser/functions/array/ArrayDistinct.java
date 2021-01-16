package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class ArrayDistinct implements Function {
  @Override
  public String getName() {
    return "arraydistinct";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList resultList = new ValueList();

    for(Value value : valueList.getArray(0)) {
      if (!resultList.contains(value)) {
        resultList.add(value);
      }
    }

    return Value.of(resultList);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
