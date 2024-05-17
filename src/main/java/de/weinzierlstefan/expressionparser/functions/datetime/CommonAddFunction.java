package de.weinzierlstefan.expressionparser.functions.datetime;

import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueTemporal;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;


abstract class CommonAddFunction implements Function {

  protected Value execute(String name, ChronoUnit type, ValueList valueList) throws ExpressionException {
    Temporal t = valueList.getTemporal(0);
    if (t == null) {
      throw new ExpressionException("Value must be a DateTime");
    }

    if (!valueList.isNumber(1)) {
      throw new ExpressionException("Offset must be a number");
    }

    if (!t.isSupported(type)) {
      throw new ExpressionException(name + " is not supported");
    }

    long offset = valueList.getLong(1);

    t = t.plus(offset, type);

    return ValueTemporal.of(t);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 2;
  }
}
