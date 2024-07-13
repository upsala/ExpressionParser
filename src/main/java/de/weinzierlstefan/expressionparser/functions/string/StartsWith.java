package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueBoolean;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class StartsWith implements Function {
  @Override
  public String getName() {
    return "startswith";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str1 = valueList.getString(0);
    String str2 = valueList.getString(1);

    int offset = 0;
    if (valueList.size() > 2) {
      if (!valueList.isNumber(2)) {
        throw new ExpressionException("Offset must be a number");
      }
      offset = valueList.getInt(2);
    }
    if (offset < 0) {
      return ValueBoolean.FALSE;
    }

    return ValueBoolean.of(str1.startsWith(str2, offset));
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 2 || count == 3;
  }
}
