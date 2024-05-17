package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueArray;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.util.stream.Collectors;

public class ArrayDistinct implements Function {
  @Override
  public String getName() {
    return "arraydistinct";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    return ValueArray.of(
      valueList
        .getArray(0)
        .stream()
        .distinct()
        .collect(Collectors.toCollection(ValueList::new))
    );
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
