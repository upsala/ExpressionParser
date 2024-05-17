package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueString;

public class Substring implements Function {
  @Override
  public String getName() {
    return "substring";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.getString(0);
    if (!valueList.isNumber(1)) {
      throw new ExpressionException("Start-Position must be a number");
    }
    int start = valueList.getInt(1);
    int end = Integer.MAX_VALUE;

    if (valueList.size() > 2) {
      if (!valueList.isNumber(2)) {
        throw new ExpressionException("End-Position must be a number");
      }
      end = valueList.getInt(2);
    }

    if (start < 0) {
      start = 0;
    }
    if (end > str.length()) {
      end = str.length();
    }
    if (start > str.length() || end < start) {
      return ValueString.EMPTY;
    }

    return ValueString.of(str.substring(start, end));
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 2 || count == 3;
  }
}
