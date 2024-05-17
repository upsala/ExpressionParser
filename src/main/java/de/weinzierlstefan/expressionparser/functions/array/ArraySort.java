package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueArray;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.util.Comparator;

/**
 *
 */
public class ArraySort implements Function {
  @Override
  public String getName() {
    return "arraysort";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList list = valueList.getArray(0);
    if (list == null) {
      throw new ExpressionException("Value must be a array");
    }

    list.sort(Comparator.naturalOrder());

    return ValueArray.of(list);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
