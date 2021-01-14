package de.weinzierlstefan.expressionparser.functions.datetime;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class DiffDay implements Function {
  @Override
  public String getName() {
    return "diffday";
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
    if (!t1.isSupported(ChronoUnit.DAYS) || !t2.isSupported(ChronoUnit.DAYS)) {
      throw new ExpressionException("Day is not supported");
    }


    long diff = t1.until(t2, ChronoUnit.DAYS);

    return Value.of(diff);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==2;
  }
}
