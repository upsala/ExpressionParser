package de.weinzierlstefan.expressionparser.functions.datetime;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueTemporal;

import java.time.LocalDateTime;

/**
 *
 */
public class DateTime implements Function {
  @Override
  public String getName() {
    return "datetime";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    int year = 1;
    int month = 1;
    int day = 1;
    int hour = 0;
    int minute = 0;
    int second = 0;
    int nano = 0;

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

    if (valueList.size() > 3) {
      Value valueHour = valueList.get(3);
      if (!valueHour.isNumber()) {
        throw new ExpressionException("Hour must be a number");
      }
      hour = valueHour.getInt();
    }

    if (valueList.size() > 4) {
      Value valueMinute = valueList.get(4);
      if (!valueMinute.isNumber()) {
        throw new ExpressionException("Minute must be a number");
      }
      minute = valueMinute.getInt();
    }

    if (valueList.size() > 5) {
      Value valueSecond = valueList.get(5);
      if (!valueSecond.isNumber()) {
        throw new ExpressionException("Second must be a number");
      }
      second = valueSecond.getInt();
    }

    if (valueList.size() > 6) {
      Value valueNano = valueList.get(6);
      if (!valueNano.isNumber()) {
        throw new ExpressionException("Millisecond must be a number");
      }
      nano = valueNano.getInt();
      if (nano < 0 || nano > 999999999) {
        throw new ExpressionException("Nanosecond is not valid");
      }
    }

    return ValueTemporal.of(LocalDateTime.of(year, month, day, hour, minute, second, nano));
  }

  @Override
  public boolean parameterCount(int count) {
    return count >= 0 && count <= 7;
  }
}
