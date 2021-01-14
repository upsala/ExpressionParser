package de.weinzierlstefan.expressionparser.functions.datetime;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.time.temporal.*;

public class FirstDayOfNextMonth implements Function {
  @Override
  public String getName() {
    return "firstdayofnextmonth";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value valueTemportal = valueList.get(0);
    if (!valueTemportal.isTemporal()) {
      throw new ExpressionException("Value must be a DateTime");
    }

    Temporal t = valueTemportal.toTemporal();

    t = t.with(TemporalAdjusters.firstDayOfNextMonth());

    return Value.of(t);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
