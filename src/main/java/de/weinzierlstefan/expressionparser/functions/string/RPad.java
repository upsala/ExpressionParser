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
    if (padding.isEmpty()) {
      padding = " ";
    }

    int rest = length - str.length();
    if (rest<=0) {
      return ValueString.of(str);
    }

    final char[] fill = new char[rest];
    final char[] padChars = padding.toCharArray();
    for (int i = 0; i < rest; i++) {
      fill[i] = padChars[i % padChars.length];
    }

    return ValueString.of(str+new String(fill));
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 2 || count == 3;
  }
}
