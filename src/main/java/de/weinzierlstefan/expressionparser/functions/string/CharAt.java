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
    if (!valueList.get(1).isNumber()) {
      throw new ExpressionException("Position must be a number");
    }

    int pos = (int)valueList.get(1).toLong();

    String str = valueList.get(0).toString();
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
