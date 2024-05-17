package de.weinzierlstefan.expressionparser.functions.datetime;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueTemporal;

import java.time.LocalDate;

/**
 *
 */
public class Date implements Function {
  @Override
  public String getName() {
    return "date";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    int year = 1;
    int month = 1;
    int day = 1;

    if (!valueList.isEmpty()) {
      Value valueYear = valueList.get(0);
      if (!valueYear.isNumber()) {
        throw new ExpressionException("Year must be a number");
      }
      year = valueYear.getInt();
    }

    if (valueList.size() > 1) {
      Value valueMonth = valueList.get(1);
      if (!valueMonth.isNumber()) {
        throw new ExpressionException("Month must be a number");
      }
      month = valueMonth.getInt();
    }

    if (valueList.size() > 2) {
      Value valueDay = valueList.get(2);
      if (!valueDay.isNumber()) {
        throw new ExpressionException("Year must be a number");
      }
      day = valueDay.getInt();
    }

    return ValueTemporal.of(LocalDate.of(year, month, day));
  }

  @Override
  public boolean parameterCount(int count) {
    return count >= 0 && count <= 3;
  }
}
