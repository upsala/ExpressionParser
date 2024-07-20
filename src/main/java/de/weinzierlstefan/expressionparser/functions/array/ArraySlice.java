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
public class ArraySlice implements Function {
  @Override
  public String getName() {
    return "arrayslice";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList list = valueList.getArray(0);
    if (list == null) {
      throw new ExpressionException("First parameter must be a array");
    }

    if (!valueList.isNumber(1) || !valueList.isNumber(2)) {
      throw new ExpressionException("Second and third parameter must be numbers");
    }

    int first = valueList.getInt(1);
    int second = valueList.getInt(2);

    first = Math.max(-1, Math.min(list.size(), first));
    second = Math.max(-1, Math.min(list.size(), second));

    ValueList resultList = new ValueList();
    if (second<first) {
      for (int i = first; i >= second; --i) {
        if (i>=0 && i<list.size()) {
          resultList.add(list.get(i));
        }
      }
    } else {
      for (int i = first; i <= second; ++i) {
        if (i>=0 && i<list.size()) {
          resultList.add(list.get(i));
        }
      }
    }

    return ValueArray.of(resultList);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 3;
  }
}
