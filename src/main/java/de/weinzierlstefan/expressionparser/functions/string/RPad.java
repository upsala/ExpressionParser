package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class RPad implements Function {
  @Override
  public String getName() {
    return "rpad";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.get(0).toString();

    Value lengthValue = valueList.get(1);
    if (!lengthValue.isNumber()) {
      throw new ExpressionException("Length must be a number");
    }
    long length = lengthValue.toLong();

    String padding = " ";
    if (valueList.size()>=3) {
      padding = valueList.get(2).toString();
    }

    int rest = (int)length-str.length();
    if (rest>0) {
      str+=padding.repeat(rest / padding.length()).substring(0, rest);
    }

    return Value.of(str);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==2 || count==3;
  }
}
