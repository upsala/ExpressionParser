package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class ArrayValues implements Function {
  @Override
  public String getName() {
    return "arrayvalues";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value objectValue = valueList.get(0);
    if (!objectValue.isArray()) {
      throw new ExpressionException("Value must be a array");
    }

    ValueList resultList = new ValueList();
    resultList.addAll(objectValue.toArray());

    return Value.of(resultList);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
