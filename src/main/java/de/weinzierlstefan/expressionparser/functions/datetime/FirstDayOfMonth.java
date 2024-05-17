package de.weinzierlstefan.expressionparser.functions.datetime;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueTemporal;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;


public class FirstDayOfMonth implements Function {
  @Override
  public String getName() {
    return "firstdayofmonth";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value valueTemportal = valueList.get(0);
    if (!valueTemportal.isTemporal()) {
      throw new ExpressionException("Value must be a DateTime");
    }

    Temporal t = valueTemportal.getTemporal();

    t = t.with(TemporalAdjusters.firstDayOfMonth());

    return ValueTemporal.of(t);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
