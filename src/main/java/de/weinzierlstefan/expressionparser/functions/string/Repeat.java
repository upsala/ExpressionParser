package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueString;

public class Repeat implements Function {
  private final static int MAX_LENGHT = 1000000;

  @Override
  public String getName() {
    return "repeat";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.getString(0);

    if (!valueList.isNumber(1)) {
      throw new ExpressionException("count must be a number");
    }

    int counter = valueList.getInt(1);

    if (counter < 0) {
      throw new ExpressionException("count is negativ");
    }

    if (str.length() * counter > MAX_LENGHT) {
      throw new ExpressionException("Result will get to long");
    }

    return ValueString.of(str.repeat(counter));
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 2;
  }
}
