package de.weinzierlstefan.expressionparser.functions.datetime;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class DiffMonth implements Function {
  @Override
  public String getName() {
    return "diffmonth";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value valueDateTime1 = valueList.get(0);
    Value valueDateTime2 = valueList.get(1);
    if (!valueDateTime1.isTemporal() || !valueDateTime2.isTemporal()) {
      throw new ExpressionException("Values must be a DateTime");
    }

    Temporal t1 = valueDateTime1.toTemporal();
    Temporal t2 = valueDateTime2.toTemporal();

    long diff = t1.until(t2, ChronoUnit.MONTHS);

    return Value.of(diff);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==2;
  }
}
