package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueString;

public class Right implements Function {
  @Override
  public String getName() {
    return "right";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.getString(0);

    if (!valueList.isNumber(1)) {
      throw new ExpressionException("position must be a number");
    }

    int length = str.length();
    int pos = valueList.getInt(1);
    if (pos > length) {
      pos = length;
    }
    if (pos < 0) {
      pos = 0;
    }

    str = str.substring(length - pos, length);

    return ValueString.of(str);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 2;
  }
}
