package de.weinzierlstefan.expressionparser.functions.datetime;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class AddSecond implements Function {
  @Override
  public String getName() {
    return "addsecond";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Temporal t = valueList.getTemporal(0);
    if (t==null) {
      throw new ExpressionException("Value must be a DateTime");
    }

    if (!valueList.isNumber(1)) {
      throw new ExpressionException("Offset must be a number");
    }

    if (!t.isSupported(ChronoUnit.SECONDS)) {
      throw new ExpressionException("Day is not supported");
    }

    long offset = valueList.getLong(1);

    t = t.plus(offset, ChronoUnit.SECONDS);

    return Value.of(t);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==2;
  }
}
