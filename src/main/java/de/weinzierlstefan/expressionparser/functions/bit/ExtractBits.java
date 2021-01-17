package de.weinzierlstefan.expressionparser.functions.bit;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.math.BigInteger;

public class ExtractBits implements Function {
  @Override
  public String getName() {
    return "extractbits";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    if (!valueList.allIsNumber()) {
      throw new ExpressionException(getName()+"-function can only operate on numbers");
    }

    BigInteger value = valueList.getBigDecimal(0).toBigInteger();
    int start = (int) valueList.getLong(1);
    int end = (int) valueList.getLong(2);

    BigInteger result = BigInteger.ZERO;

    if (end>=start) {
      for (int i = start, pos = 0; i <= end; ++i, ++pos) {
        if (i>=0) {
          if (value.testBit(i)) {
            result = result.setBit(pos);
          } else {
            result = result.clearBit(pos);
          }
        }
      }
    } else {
      for (int i = start, pos = 0; i >= end; --i, ++pos) {
        if (i>=0) {
          if (value.testBit(i)) {
            result = result.setBit(pos);
          } else {
            result = result.clearBit(pos);
          }
        }
      }
    }

    return Value.of(result);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==3;
  }
}
