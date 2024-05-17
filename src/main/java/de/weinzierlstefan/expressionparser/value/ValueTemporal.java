package de.weinzierlstefan.expressionparser.value;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.Objects;

public class ValueTemporal extends Value {
  private final Temporal value;

  private ValueTemporal(Temporal value) {
    this.value = value;
  }

  public static ValueTemporal of(Temporal value) {
    return new ValueTemporal(value);
  }

  public boolean isTemporal() {
    return true;
  }

  public Temporal getTemporal() {
    return value;
  }

  @Override
  public boolean getBoolean() {
    return true;
  }

  @Override
  public String getType() {
    return "temporal";
  }

  public String getString() {
    if (value instanceof LocalDateTime) {
      return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(value);
    } else if (value instanceof LocalDate) {
      return DateTimeFormatter.ISO_LOCAL_DATE.format(value);
    } else if (value instanceof LocalTime) {
      return DateTimeFormatter.ISO_LOCAL_TIME.format(value);
    } else if (value instanceof ZonedDateTime) {
      return DateTimeFormatter.ISO_ZONED_DATE_TIME.format(value);
    } else if (value instanceof OffsetDateTime) {
      return DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(value);
    } else if (value instanceof OffsetTime) {
      return DateTimeFormatter.ISO_OFFSET_TIME.format(value);
    } else if (value instanceof Instant) {
      return DateTimeFormatter.ISO_INSTANT.format(value);
    }

    return value.toString();
  }

  public String toString() {
    return "'" + getString() + "'";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ValueTemporal that)) return false;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

  @Override
  public Object get() {
    return value;
  }
}
