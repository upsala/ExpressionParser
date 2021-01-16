package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class Trim implements Function {
  @Override
  public String getName() {
    return "trim";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.getString(0);

    return Value.of(str.trim());
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
