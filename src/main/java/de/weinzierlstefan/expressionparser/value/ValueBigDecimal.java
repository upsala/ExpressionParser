package de.weinzierlstefan.expressionparser.value;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

public class ValueBigDecimal extends ValueNumber {

  private ValueBigDecimal(BigDecimal value) {
    this.value = value;
  }

  public static ValueBigDecimal of(BigInteger value) {
    return new ValueBigDecimal(new BigDecimal(value));
  }

  public static ValueBigDecimal of(BigDecimal value) {
    return new ValueBigDecimal(value);
  }

  @Override
  public String toString() {
    return value.toString();
  }

  public boolean toBoolean() {
    return !value.equals(BigDecimal.ZERO);
  }

  public BigDecimal toBigDecimal() {
    return value;
  }

  @Override
  public int compareTo(Value v2) {
    return value.compareTo(v2.toBigDecimal());
  }

  public long toLong() {
    return value.longValueExact();
  }

  public double toDouble() {
    return value.doubleValue();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ValueBigDecimal)) return false;
    ValueBigDecimal that = (ValueBigDecimal) o;
    return that.value.equals(value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  private final BigDecimal value;
}
