package de.weinzierlstefan.expressionparser.functions.bit;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.math.BigInteger;

public class InvertBit implements Function {
  @Override
  public String getName() {
    return "invertbit";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    if (!valueList.allIsNumber()) {
      throw new ExpressionException(getName()+"-function can only operate on numbers");
    }

    BigInteger value = valueList.getBigDecimal(0).toBigInteger();
    for(int i=1; i<valueList.size(); ++i) {
      int pos = (int) valueList.getLong(i);
      if (pos>=0) {
        if (value.testBit(pos)) {
          value = value.clearBit(pos);
        } else {
          value = value.setBit(pos);
        }
      }
    }

    return Value.of(value);
  }

  @Override
  public boolean parameterCount(int count) {
    return count>1;
  }
}
