package de.weinzierlstefan.expressionparser.functions.datetime;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.time.temporal.ChronoUnit;


public class DiffDay extends CommonDiffFunction {
  @Override
  public String getName() {
    return "diffday";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    return execute("Day", ChronoUnit.DAYS, valueList);
  }
}
