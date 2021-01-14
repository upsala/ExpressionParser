package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class Replace implements Function {
  @Override
  public String getName() {
    return "replace";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.get(0).toString();
    String search = valueList.get(1).toString();
    String replace = valueList.get(2).toString();

    return Value.of(str.replace(search, replace));
  }

  @Override
  public boolean parameterCount(int count) {
    return count==3;
  }
}
