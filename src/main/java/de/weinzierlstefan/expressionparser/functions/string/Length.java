package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueInt;
import de.weinzierlstefan.expressionparser.value.ValueList;

/**
 * Returns the length of the String-Value
 */
public class Length implements Function {
  @Override
  public String getName() {
    return "length";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    return ValueInt.of(valueList.getString(0).length());
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
