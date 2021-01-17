package de.weinzierlstefan.expressionparser.functions.bit;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.math.BigInteger;

public class TestBit implements Function {
  @Override
  public String getName() {
    return "testbit";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    if (!valueList.allIsNumber()) {
      throw new ExpressionException(getName()+"-function can only operate on numbers");
    }

    BigInteger value = valueList.getBigDecimal(0).toBigInteger();
    int pos = (int) valueList.getLong(1);

    return Value.of(value.testBit(pos));
  }

  @Override
  public boolean parameterCount(int count) {
    return count==2;
  }
}
