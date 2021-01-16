package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class LPad implements Function {
  @Override
  public String getName() {
    return "lpad";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.getString(0);

    if (!valueList.isNumber(1)) {
      throw new ExpressionException("Length must be a number");
    }
    long length = valueList.getLong(1);

    String padding = " ";
    if (valueList.size()>=3) {
      padding = valueList.getString(2);
    }

    int rest = (int)length-str.length();
    if (rest>0) {
      str=padding.repeat(rest / padding.length()).substring(0, rest)+str;
    }

    return Value.of(str);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==2 || count==3;
  }
}
