package de.weinzierlstefan.expressionparser.functions.common;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueNull;


public class IfNull implements Function {
  @Override
  public String getName() {
    return "ifnull";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value result = ValueNull.INSTANCE;

    int pos = 0;
    while (result.isNull() && pos < valueList.size()) {
      result = valueList.get(pos++);
    }

    return result;
  }

  @Override
  public boolean parameterCount(int count) {
    return count >= 0;
  }

  @Override
  public boolean returnsNullOnNull() {
    return false;
  }
}
