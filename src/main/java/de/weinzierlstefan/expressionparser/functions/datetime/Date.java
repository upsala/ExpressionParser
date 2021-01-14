package de.weinzierlstefan.expressionparser.functions.datetime;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.time.LocalDate;

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

    if (valueList.size()>0) {
      Value valueYear = valueList.get(0);
      if (!valueYear.isNumber()) {
        throw new ExpressionException("Year must be a number");
      }
      year = (int)valueYear.toLong();
    }

    if (valueList.size()>1) {
      Value valueMonth = valueList.get(1);
      if (!valueMonth.isNumber()) {
        throw new ExpressionException("Month must be a number");
      }
      month = (int)valueMonth.toLong();
    }

    if (valueList.size()>2) {
      Value valueDay = valueList.get(2);
      if (!valueDay.isNumber()) {
        throw new ExpressionException("Year must be a number");
      }
      day = (int)valueDay.toLong();
    }

    return Value.of(LocalDate.of(year, month, day));
  }

  @Override
  public boolean parameterCount(int count) {
    return count>=0 && count<=3;
  }
}
