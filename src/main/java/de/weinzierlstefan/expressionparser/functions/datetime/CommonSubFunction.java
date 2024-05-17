package de.weinzierlstefan.expressionparser.functions.datetime;

import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueTemporal;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;


abstract class CommonSubFunction implements Function {
  protected Value execute(String name, ChronoUnit type, ValueList valueList) throws ExpressionException {
    Value valueDateTime = valueList.get(0);
    if (!valueDateTime.isTemporal()) {
      throw new ExpressionException("Value must be a DateTime");
    }

    Value valueOffset = valueList.get(1);
    if (!valueOffset.isNumber()) {
      throw new ExpressionException("Offset must be a number");
    }

    Temporal t = valueDateTime.getTemporal();
    if (!t.isSupported(type)) {
      throw new ExpressionException(name + " is not supported");
    }

    t = t.minus(valueOffset.getLong(), type);

    return ValueTemporal.of(t);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 2;
  }
}
