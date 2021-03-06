package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class ASin implements Function {
  @Override
  public String getName() {
    return "asin";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    if (!valueList.allIsNumber()) {
      throw new ExpressionException(getName()+"-function can only operate on numbers");
    }

    double value = valueList.getDouble(0);

    return Value.of(Math.toDegrees(Math.asin(value)));
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
