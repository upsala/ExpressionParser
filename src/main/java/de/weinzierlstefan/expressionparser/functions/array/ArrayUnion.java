package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueArray;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.util.HashSet;
import java.util.Set;

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

    Set<Value> valueSet = new HashSet<>();
    ValueList resultList = new ValueList();
    for (Value valueArray : valueList) {
      for (Value value : valueArray.getArray()) {
        if (!valueSet.contains(value)) {
          resultList.add(value);
          valueSet.add(value);
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
