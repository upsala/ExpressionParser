package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueString;

public class LTrim implements Function {
  @Override
  public String getName() {
    return "ltrim";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.getString(0);

    if (valueList.size() == 1) {
      return ValueString.of(str.stripLeading());
    }

    String mask = valueList.getString(1);

    int pos = 0;
    while (pos < str.length()) {
      char c = str.charAt(pos);
      if (mask.indexOf(c) == -1) {
        break;
      }
      pos++;
    }

    return ValueString.of(str.substring(pos));
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1 || count == 2;
  }
}
