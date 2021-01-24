package de.weinzierlstefan.expressionparser.value;

import java.math.BigDecimal;
import java.util.Objects;

public class ValueLong extends ValueNumber {
  private ValueLong(long value) {
    this.value = value;
  }

  public static ValueLong of(long value) {
    return new ValueLong(value);
  }

  public boolean isLong() { return true; }

  public long toLong() {
    return value;
  }

  public double toDouble() {
    return (double)value;
  }

  public boolean toBoolean() {
    return value!=0;
  }

  public String toString() {
    return Long.toString(value);
  }

  public BigDecimal toBigDecimal() {
    return BigDecimal.valueOf(value);
  }

  @Override
  public int compareTo(Value v2) {
    return Long.compare(value, v2.toLong());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ValueLong)) return false;
    ValueLong valueLong = (ValueLong) o;
    return value == valueLong.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  private final long value;
}
