package de.weinzierlstefan.expressionparser.functions.bit;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueInt;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueLong;

public class ExtractBits implements Function {
  @Override
  public String getName() {
    return "extractbits";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    if (!valueList.allIsNumber()) {
      throw new ExpressionException(getName() + "-function can only operate on numbers");
    }

    long value = valueList.getLong(0);
    int start = valueList.getInt(1);
    int end = valueList.getInt(2);

    if (start < 0 || end < 0) {
      throw new ExpressionException("extractbits-function requires a positive integer");
    }

    long result = 0;

    if (end >= start) {
      for (int i = start, pos = 0; i <= end; ++i, ++pos) {
        if ((value & (1L << i)) > 0) {
          result |= 1L << pos;
        }
      }
    } else {
      for (int i = start, pos = 0; i >= end; --i, ++pos) {
        if ((value & (1L << i)) > 0) {
          result |= 1L << pos;
        }
      }
    }

    if (valueList.get(0).isInt()) {
      return ValueInt.of((int) result);
    }
    return ValueLong.of(result);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 3;
  }
}
