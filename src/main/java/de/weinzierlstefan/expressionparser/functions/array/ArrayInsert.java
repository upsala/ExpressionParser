package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class ArrayInsert implements Function {
  @Override
  public String getName() {
    return "arrayinsert";
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

    int pos = (int)valueList.get(1).toLong();

    if (pos<0 || pos>=list.size()) {
      throw new ExpressionException("Index out of range");
    }

    list.add(pos, valueList.get(2));

    return Value.of(list);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==3;
  }
}
