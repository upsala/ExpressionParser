package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class Right implements Function {
  @Override
  public String getName() {
    return "right";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.get(0).toString();

    if (!valueList.get(1).isNumber()) {
      throw new ExpressionException("position must be a number");
    }

    int length = str.length();
    long pos = valueList.get(1).toLong();
    if (pos>length) {
      pos = length;
    }
    if (pos<0) {
      pos = 0;
    }

    str=str.substring(length-(int)pos, length);

    return Value.of(str);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==2;
  }
}
