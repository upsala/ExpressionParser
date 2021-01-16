package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class RegexReplace implements Function {
  @Override
  public String getName() {
    return "regexreplace";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.getString(0);
    String regex = valueList.getString(1);
    String newValue = valueList.getString(2);

    return Value.of(str.replaceAll(regex, newValue));
  }

  @Override
  public boolean parameterCount(int count) {
    return count==3;
  }
}
