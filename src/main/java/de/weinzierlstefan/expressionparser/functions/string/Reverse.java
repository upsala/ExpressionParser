package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueString;

public class Reverse implements Function {
  @Override
  public String getName() {
    return "reverse";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    StringBuilder builder = new StringBuilder();
    builder.append(valueList.getString(0));
    builder.reverse();

    return ValueString.of(builder);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
