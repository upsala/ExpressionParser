package de.weinzierlstefan.expressionparser.functions.bit;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueBoolean;
import de.weinzierlstefan.expressionparser.value.ValueList;


public class TestBit implements Function {
  @Override
  public String getName() {
    return "testbit";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    if (!valueList.allIsNumber()) {
      throw new ExpressionException(getName() + "-function can only operate on numbers");
    }

    long value = valueList.getLong(0);
    int pos = valueList.getInt(1);

    return ValueBoolean.of(((1L << pos) & value) != 0);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 2;
  }
}
