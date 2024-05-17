package de.weinzierlstefan.expressionparser.functions.bit;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueInt;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueLong;

/**
 *
 */
public class ClearBit extends CommonBitFunction {
  @Override
  public String getName() {
    return "clearbit";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    if (!valueList.allIsNumber()) {
      throw new ExpressionException(getName() + "-function can only operate on numbers");
    }

    long mask = ~getMask(valueList);

    Value value = valueList.get(0);

    if (value.isLong()) {
      return ValueLong.of(value.getLong() & mask);
    }
    if (value.isInt()) {
      return ValueInt.of(value.getInt() & (int) mask);
    }

    throw new ExpressionException(getName() + "-function can only operate on numbers");
  }
}
