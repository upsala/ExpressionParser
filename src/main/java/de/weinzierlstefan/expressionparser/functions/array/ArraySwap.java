package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.util.Collections;

public class ArraySwap implements Function {
  @Override
  public String getName() {
    return "arrayswap";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList list = valueList.get(0).toArray();
    if (list==null) {
      throw new ExpressionException("First parameter must be a array");
    }

    if (!valueList.get(1).isNumber() || !valueList.get(2).isNumber()) {
      throw new ExpressionException("Second and third parameter must be numbers");
    }

    int first = (int)valueList.get(1).toLong();
    int second = (int)valueList.get(2).toLong();

    if (first<0 || first>=list.size() || second<0 || second>=list.size()) {
      throw new ExpressionException("Positions are out of range");
    }

    ValueList resultList = new ValueList(list);

    Collections.swap(resultList, first, second);

    return Value.of(resultList);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==3;
  }
}
