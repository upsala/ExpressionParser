package de.weinzierlstefan.expressionparser.functions.datetime;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class SetMonth implements Function {
  @Override
  public String getName() {
    return "setmonth";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value valueDateTime = valueList.get(0);
    if (!valueDateTime.isTemporal()) {
      throw new ExpressionException("Value must be a DateTime");
    }

    Value valueOffset = valueList.get(1);
    if (!valueOffset.isNumber()) {
      throw new ExpressionException("Offset must be a number");
    }

    Temporal t = valueDateTime.toTemporal();
    if (!t.isSupported(ChronoUnit.MONTHS)) {
      throw new ExpressionException("Month is not supported");
    }

    t = t.with(ChronoField.MONTH_OF_YEAR, valueOffset.toLong());

    return Value.of(t);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==2;
  }
}
