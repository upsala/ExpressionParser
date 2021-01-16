package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class CharAt implements Function {
  @Override
  public String getName() {
    return "charat";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    if (!valueList.isNumber(1)) {
      throw new ExpressionException("Position must be a number");
    }

    int pos = (int)valueList.getLong(1);

    String str = valueList.getString(0);
    if (pos<0 || pos>=str.length()) {
      return Value.of("");
    }

    return Value.of(str.substring(pos, pos+1));
  }

  @Override
  public boolean parameterCount(int count) {
    return count==2;
  }
}
