package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueArray;
import de.weinzierlstefan.expressionparser.value.ValueList;

/**
 *
 */
public class ArrayUnion implements Function {
  @Override
  public String getName() {
    return "arrayunion";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    if (!valueList.allIsArray()) {
      throw new ExpressionException("All parameteres must be arrays");
    }

    ValueList resultList = new ValueList();
    for (Value valueArray : valueList) {
      for (Value value : valueArray.getArray()) {
        if (!resultList.contains(value)) {
          resultList.add(value);
        }
      }
    }

    return ValueArray.of(resultList);
  }

  @Override
  public boolean parameterCount(int count) {
    return count > 0;
  }
}
