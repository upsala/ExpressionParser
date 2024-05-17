package de.weinzierlstefan.expressionparser.functions.datetime;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueTemporal;

import java.time.LocalDateTime;


public class Now implements Function {
  @Override
  public String getName() {
    return "now";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    return ValueTemporal.of(LocalDateTime.now());
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 0;
  }
}
