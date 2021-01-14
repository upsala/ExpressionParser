package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueString;

public class Substring implements Function {
  @Override
  public String getName() {
    return "substring";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.get(0).toString();
    if (!valueList.get(1).isNumber()) {
      throw new ExpressionException("Start-Position must be a number");
    }
    int start = (int)valueList.get(1).toLong();
    int end = Integer.MAX_VALUE;

    if (valueList.size()>2) {
      if (!valueList.get(2).isNumber()) {
        throw new ExpressionException("End-Position must be a number");
      }
      end=(int)valueList.get(2).toLong();
    }

    if (start<0) {
      start=0;
    }
    if (end>str.length()) {
      end=str.length();
    }
    if (start>str.length() || end<start) {
      return ValueString.EMPTY;
    }

    return Value.of(str.substring(start, end));
  }

  @Override
  public boolean parameterCount(int count) {
    return count==2 || count==3;
  }
}
