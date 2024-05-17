package de.weinzierlstefan.expressionparser.functions.datetime;

import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueLong;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;


abstract class CommonDiffFunction implements Function {
  protected Value execute(String name, ChronoUnit type, ValueList valueList) throws ExpressionException {
    Value valueDateTime1 = valueList.get(0);
    Value valueDateTime2 = valueList.get(1);
    if (!valueDateTime1.isTemporal() || !valueDateTime2.isTemporal()) {
      throw new ExpressionException("Values must be a DateTime");
    }

    Temporal t1 = valueDateTime1.getTemporal();
    Temporal t2 = valueDateTime2.getTemporal();
    if (!t1.isSupported(type) || !t2.isSupported(type)) {
      throw new ExpressionException(name + "Day is not supported");
    }

    long diff = t1.until(t2, type);

    return ValueLong.of(diff);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 2;
  }
}
