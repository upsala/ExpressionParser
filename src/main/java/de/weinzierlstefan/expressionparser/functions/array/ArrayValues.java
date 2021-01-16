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
    if (!valueList.isArray(0)) {
      throw new ExpressionException("Value must be a array");
    }

    ValueList resultList = new ValueList();
    resultList.addAll(valueList.getArray(0));

    return Value.of(resultList);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
