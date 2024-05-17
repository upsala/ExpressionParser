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

    return ValueBoolean.of(str1.startsWith(str2));
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 2;
  }
}