package de.weinzierlstefan.expressionparser.value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

public class ValueTemporal extends Value {
  private ValueTemporal(Temporal value) {
    this.value = value;
  }

  public static ValueTemporal of(Temporal value) {
    return new ValueTemporal(value);
  }

  @Override
  public int getType() {
    return TEMPORAL;
  }

  public boolean isTemporal() {
    return true;
  }

  public Temporal toTemporal() {
    return value;
  }

  @Override
  public boolean toBoolean() {
    return true;
  }

  @Override
  public int compareTo(Value v2) {
    return 0; //TODO...
  }

  public String toString() {
    if (value instanceof LocalDateTime) {
      return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(value);
    } else if (value instanceof LocalDate) {
      return DateTimeFormatter.ISO_LOCAL_DATE.format(value);
    } else if (value instanceof LocalTime) {
      return DateTimeFormatter.ISO_LOCAL_TIME.format(value);
    } else if (value instanceof ZonedDateTime) {
      return DateTimeFormatter.ISO_DATE_TIME.format(value);
    }

    return value.toString();
  }

  private final Temporal value;
}
