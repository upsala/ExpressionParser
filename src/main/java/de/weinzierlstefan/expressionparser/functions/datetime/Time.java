package de.weinzierlstefan.expressionparser.functions.datetime;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueTemporal;

import java.time.LocalTime;


public class Time implements Function {
  @Override
  public String getName() {
    return "time";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    int hour = 0;
    int minute = 0;
    int second = 0;
    int nano = 0;

    if (!valueList.isEmpty()) {
      Value valueHour = valueList.get(0);
      if (!valueHour.isNumber()) {
        throw new ExpressionException("Hour must be a number");
      }
      hour = valueHour.getInt();
      if (hour < 0 || hour > 23) {
        throw new ExpressionException("Hour is not valid");
      }
    }

    if (valueList.size() > 1) {
      Value valueMinute = valueList.get(1);
      if (!valueMinute.isNumber()) {
        throw new ExpressionException("Minute must be a number");
      }
      minute = valueMinute.getInt();
      if (minute < 0 || minute > 59) {
        throw new ExpressionException("Minute is not valid");
      }
    }

    if (valueList.size() > 2) {
      Value valueSecond = valueList.get(2);
      if (!valueSecond.isNumber()) {
        throw new ExpressionException("Second must be a number");
      }
      second = valueSecond.getInt();
      if (second < 0 || second > 59) {
        throw new ExpressionException("Second is not valid");
      }
    }

    if (valueList.size() > 3) {
      Value valueNano = valueList.get(3);
      if (!valueNano.isNumber()) {
        throw new ExpressionException("Nanosecond must be a number");
      }
      nano = valueNano.getInt();
      if (nano < 0 || nano > 999999999) {
        throw new ExpressionException("Nanosecond is not valid");
      }
    }

    return ValueTemporal.of(LocalTime.of(hour, minute, second, nano));
  }

  @Override
  public boolean parameterCount(int count) {
    return count >= 0 && count <= 4;
  }
}
