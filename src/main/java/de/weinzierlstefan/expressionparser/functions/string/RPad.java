package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueString;

public class RPad implements Function {
  @Override
  public String getName() {
    return "rpad";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.getString(0);

    if (!valueList.isNumber(1)) {
      throw new ExpressionException("Length must be a number");
    }
    int length = valueList.getInt(1);

    String padding = " ";
    if (valueList.size() >= 3) {
      padding = valueList.getString(2);
    }

    int rest = length - str.length();
    if (rest > 0) {
      str += padding.repeat(rest / padding.length()).substring(0, rest);
    }

    return ValueString.of(str);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 2 || count == 3;
  }
}
