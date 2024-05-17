package de.weinzierlstefan.expressionparser.functions.datetime;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.time.temporal.ChronoUnit;


public class DiffMonth extends CommonDiffFunction {
  @Override
  public String getName() {
    return "diffmonth";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    return execute("Month", ChronoUnit.MONTHS, valueList);
  }
}
