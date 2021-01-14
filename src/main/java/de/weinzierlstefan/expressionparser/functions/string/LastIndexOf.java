package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class LastIndexOf implements Function {
  @Override
  public String getName() {
    return "lastindexof";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    return Value.of(valueList.get(0).toString().lastIndexOf(valueList.get(1).toString()));
  }

  @Override
  public boolean parameterCount(int count) {
    return count==2 || count==3;
  }
}
