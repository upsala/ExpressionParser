package de.weinzierlstefan.expressionparser.functions.datetime;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueTemporal;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;


public class TruncatedToSecond implements Function {
  @Override
  public String getName() {
    return "truncatedtosecond";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Temporal t = valueList.getTemporal(0);

    if (t instanceof LocalDate localDate) {
      return ValueTemporal.of(localDate);
    }

    if (t instanceof LocalDateTime localDateTime) {
      return ValueTemporal.of(localDateTime.truncatedTo(ChronoUnit.SECONDS));
    }

    if (t instanceof LocalTime localTime) {
      return ValueTemporal.of(localTime.truncatedTo(ChronoUnit.SECONDS));
    }

    if (t instanceof OffsetDateTime offsetDateTime) {
      return ValueTemporal.of(offsetDateTime.truncatedTo(ChronoUnit.SECONDS));
    }

    if (t instanceof OffsetTime offsetTime) {
      return ValueTemporal.of(offsetTime.truncatedTo(ChronoUnit.SECONDS));
    }

    if (t instanceof ZonedDateTime zonedDateTime) {
      return ValueTemporal.of(zonedDateTime.truncatedTo(ChronoUnit.SECONDS));
    }

    if (t instanceof Instant instant) {
      return ValueTemporal.of(instant.truncatedTo(ChronoUnit.SECONDS));
    }

    throw new ExpressionException("Operation is not supported");
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }

}
