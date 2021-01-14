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
    String str = valueList.get(0).toString();
    String regex = valueList.get(1).toString();
    String newValue = valueList.get(2).toString();

    return Value.of(str.replaceAll(regex, newValue));
  }

  @Override
  public boolean parameterCount(int count) {
    return count==3;
  }
}
