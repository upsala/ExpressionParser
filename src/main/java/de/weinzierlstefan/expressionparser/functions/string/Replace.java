package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueString;

public class Replace implements Function {
  @Override
  public String getName() {
    return "replace";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.getString(0);
    String search = valueList.getString(1);
    String replace = valueList.getString(2);

    return ValueString.of(str.replace(search, replace));
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 3;
  }
}
