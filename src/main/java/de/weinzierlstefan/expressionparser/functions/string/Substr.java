package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueString;

public class Substr implements Function {
  @Override
  public String getName() {
    return "substr";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.getString(0);
    if (!valueList.isNumber(1)) {
      throw new ExpressionException("Start-Position must be a number");
    }
    int start = valueList.getInt(1);
    int length = Integer.MAX_VALUE;

    if (valueList.size() > 2) {
      if (!valueList.isNumber(2)) {
        throw new ExpressionException("Length must be a number");
      }
      length = valueList.getInt(2);
    }
    if (length < 0) {
      throw new ExpressionException("Length must be positiv");
    }

    if (start < 0) {
      start = str.length() + start;
      if (start < 0) {
        length += start;
        start = 0;
      }
    }
    if (start > str.length() || length == 0) {
      return ValueString.EMPTY;
    }

    int end = (int) Math.min(Integer.MAX_VALUE, (long) start + (long) length);

    if (end > str.length()) {
      end = str.length();
    }

    return ValueString.of(str.substring(start, end));
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 2 || count == 3;
  }
}
