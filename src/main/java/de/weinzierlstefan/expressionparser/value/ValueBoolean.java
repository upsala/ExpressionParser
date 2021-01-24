package de.weinzierlstefan.expressionparser.value;

import java.math.BigDecimal;
import java.util.Objects;

public class ValueBoolean extends ValueNumber {

  public static final ValueBoolean TRUE = new ValueBoolean(true);
  public static final ValueBoolean FALSE = new ValueBoolean(false);

  private ValueBoolean(boolean value) {
    this.value = value;
  }

  public static ValueBoolean of(boolean value) {
    return value ? TRUE : FALSE;
  }

  public boolean isBoolean() {
    return true;
  }

  public long toLong() {
    return value ? 1 : 0;
  }

  public double toDouble() {
    return value ? 1.0 : 0.0;
  }

  public boolean toBoolean() {
    return value;
  }

  public String toString() {
    return value ? "true" : "false";
  }

  public BigDecimal toBigDecimal() {
    return value ? BigDecimal.ONE : BigDecimal.ZERO;
  }

  @Override
  public int compareTo(Value v2) {
    return Boolean.compare(value, v2.toBoolean());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ValueBoolean)) return false;
    ValueBoolean that = (ValueBoolean) o;
    return value == that.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  private final boolean value;
}
