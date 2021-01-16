package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class Left implements Function {
  @Override
  public String getName() {
    return "left";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.getString(0);

    if (!valueList.isNumber(1)) {
      throw new ExpressionException("position must be a number");
    }

    int length = str.length();
    long pos = valueList.getLong(1);
    if (pos>length) {
      pos = length;
    }

    str=str.substring(0, (int)pos);

    return Value.of(str);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==2;
  }
}
