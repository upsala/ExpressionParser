package de.weinzierlstefan.expressionparser.functions.datetime;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.time.temporal.ChronoUnit;


public class DiffNanoSecond extends CommonDiffFunction {
  @Override
  public String getName() {
    return "diffnanosecond";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    return execute("Nanosecond", ChronoUnit.NANOS, valueList);
  }
}
