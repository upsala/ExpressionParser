package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueString;

/**
 * Replaces all '%' of the first-string with the string-values of the rest of the list
 */
public class Format implements Function {
  @Override
  public String getName() {
    return "format";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.getString(0);
    int token = 1;

    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c == '%') {
        if (token < valueList.size()) {
          stringBuilder.append(valueList.getString(token));
        }
        token++;
      } else {
        stringBuilder.append(c);
      }
    }
    return ValueString.of(stringBuilder.toString());
  }

  @Override
  public boolean parameterCount(int count) {
    return count > 1;
  }
}
