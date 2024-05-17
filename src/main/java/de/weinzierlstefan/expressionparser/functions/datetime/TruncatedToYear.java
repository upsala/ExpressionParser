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
import java.time.temporal.TemporalAdjusters;


public class TruncatedToYear implements Function {
  @Override
  public String getName() {
    return "truncatedtoyear";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Temporal t = valueList.getTemporal(0);

    if (t instanceof LocalDate localDate) {
      return ValueTemporal.of(
        localDate
          .with(TemporalAdjusters.firstDayOfYear())
      );
    }

    if (t instanceof LocalDateTime localDateTime) {
      return ValueTemporal.of(
        localDateTime
          .truncatedTo(ChronoUnit.DAYS)
          .with(TemporalAdjusters.firstDayOfYear())
      );
    }

    if (t instanceof LocalTime localTime) {
      return ValueTemporal.of(localTime.truncatedTo(ChronoUnit.DAYS));
    }

    if (t instanceof OffsetDateTime offsetDateTime) {
      return ValueTemporal.of(
        offsetDateTime
          .truncatedTo(ChronoUnit.DAYS)
          .with(TemporalAdjusters.firstDayOfYear())
      );
    }

    if (t instanceof OffsetTime offsetTime) {
      return ValueTemporal.of(offsetTime.truncatedTo(ChronoUnit.DAYS));
    }

    if (t instanceof ZonedDateTime zonedDateTime) {
      return ValueTemporal.of(
        zonedDateTime
          .truncatedTo(ChronoUnit.DAYS)
          .with(TemporalAdjusters.firstDayOfYear())
      );
    }

    throw new ExpressionException("Operation is not supported");
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
