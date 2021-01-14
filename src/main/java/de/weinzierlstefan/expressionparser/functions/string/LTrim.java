package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class LTrim implements Function {
  @Override
  public String getName() {
    return "ltrim";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.get(0).toString();

    String mask = " \r\n\t";
    if (valueList.size()>1) {
      mask = valueList.get(1).toString();
    }

    int pos=0;
    while(pos<str.length()) {
      char c = str.charAt(pos);
      if (mask.indexOf(c)==-1) {
        break;
      }
      pos++;
    }

    return Value.of(str.substring(pos));
  }

  @Override
  public boolean parameterCount(int count) {
    return count>0;
  }
}
