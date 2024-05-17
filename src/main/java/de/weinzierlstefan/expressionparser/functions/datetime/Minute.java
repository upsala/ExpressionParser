package de.weinzierlstefan.expressionparser.functions.datetime;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueInt;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;


public class Minute implements Function {
  @Override
  public String getName() {
    return "minute";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value value = valueList.get(0);

    if (!value.isTemporal()) {
      throw new ExpressionException("Value must be a DateTime");
    }

    Temporal t = value.getTemporal();
    if (t.isSupported(ChronoField.MINUTE_OF_HOUR)) {
      return ValueInt.of(t.get(ChronoField.MINUTE_OF_HOUR));
    }
    return ValueInt.of(0);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
