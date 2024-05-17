package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueString;

public class RTrim implements Function {
  @Override
  public String getName() {
    return "rtrim";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.getString(0);

    if (valueList.size() == 1) {
      return ValueString.of(str.stripTrailing());
    }

    String mask = valueList.getString(1);

    int pos = str.length() - 1;
    while (pos >= 0) {
      char c = str.charAt(pos);
      if (mask.indexOf(c) == -1) {
        pos++;
        break;
      }
      pos--;
    }

    return ValueString.of(str.substring(0, pos));
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1 || count == 2;
  }
}
