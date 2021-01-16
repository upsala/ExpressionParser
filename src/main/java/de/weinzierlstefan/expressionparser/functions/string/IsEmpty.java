package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class IsEmpty implements Function {
  @Override
  public java.lang.String getName() {
    return "isempty";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    return Value.of(valueList.getString(0).isEmpty());
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
