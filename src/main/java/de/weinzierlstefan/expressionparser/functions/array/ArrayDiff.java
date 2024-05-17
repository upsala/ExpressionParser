package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueArray;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.util.stream.Collectors;

public class ArrayDiff implements Function {
  @Override
  public String getName() {
    return "arraydiff";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList list1 = valueList.getArray(0);
    ValueList list2 = valueList.getArray(1);
    if (list1 == null || list2 == null) {
      throw new ExpressionException("Parameters must be a arrays");
    }

    ValueList resultList = list1
      .stream()
      .filter(e -> !list2.contains(e))
      .collect(Collectors.toCollection(ValueList::new));

    return ValueArray.of(resultList);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 2;
  }
}
