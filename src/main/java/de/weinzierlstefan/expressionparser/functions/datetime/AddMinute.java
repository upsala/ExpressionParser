package de.weinzierlstefan.expressionparser.functions.datetime;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.time.temporal.ChronoUnit;


public class AddMinute extends CommonAddFunction {
  @Override
  public String getName() {
    return "addminute";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    return execute("Minute", ChronoUnit.MINUTES, valueList);
  }
}
