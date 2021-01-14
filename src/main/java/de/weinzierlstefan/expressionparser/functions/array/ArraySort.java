package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class ArraySort implements Function {
  @Override
  public String getName() {
    return "arraysort";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList list = valueList.get(0).toArray();

    list.sort((o1, o2) -> o1.compareTo(o2));

    return Value.of(list);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
