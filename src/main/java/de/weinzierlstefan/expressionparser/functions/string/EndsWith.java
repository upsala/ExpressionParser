package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

/**
 * Returns true if the first string ends with the second string
 */
public class EndsWith implements Function {
  @Override
  public String getName() {
    return "endswith";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str1 = valueList.get(0).toString();
    String str2 = valueList.get(1).toString();

    return Value.of(str1.endsWith(str2));
  }

  @Override
  public boolean parameterCount(int count) {
    return count==2;
  }
}
