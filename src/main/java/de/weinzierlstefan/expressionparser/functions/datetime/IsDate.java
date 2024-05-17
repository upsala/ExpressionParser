package de.weinzierlstefan.expressionparser.functions.datetime;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueBoolean;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.time.LocalDate;
import java.time.temporal.Temporal;


public class IsDate implements Function {
  @Override
  public String getName() {
    return "isdate";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    boolean is = false;

    Value value = valueList.get(0);
    if (value.isTemporal()) {
      Temporal t = value.getTemporal();
      is = (t instanceof LocalDate);
    }
    return ValueBoolean.of(is);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }

  @Override
  public boolean returnsNullOnNull() {
    return false;
  }
}
