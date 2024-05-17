package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueArray;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.util.Collections;

/**
 *
 */
public class ArraySwap implements Function {
  @Override
  public String getName() {
    return "arrayswap";
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

    if (first < 0 || first >= list.size() || second < 0 || second >= list.size()) {
      throw new ExpressionException("Positions are out of range");
    }

    ValueList resultList = new ValueList(list);

    Collections.swap(resultList, first, second);

    return ValueArray.of(resultList);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 3;
  }
}
