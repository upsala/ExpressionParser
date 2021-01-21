package de.weinzierlstefan.expressionparser.functions.datetime;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.time.DayOfWeek;
import java.time.temporal.*;

public class FirstInMonth implements Function {
  @Override
  public String getName() {
    return "firstinmonth";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value valueTemportal = valueList.get(0);
    if (!valueTemportal.isTemporal()) {
      throw new ExpressionException("Value must be a DateTime");
    }

    DayOfWeek dow = DayOfWeek.valueOf(valueList.get(1).toString().toUpperCase());

    Temporal t = valueTemportal.toTemporal();

    t = t.with(TemporalAdjusters.firstInMonth(dow));

    return Value.of(t);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==2;
  }
}
