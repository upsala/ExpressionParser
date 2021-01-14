package de.weinzierlstefan.expressionparser.value;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Objects;

public class ValueDouble extends ValueNumber {
  private ValueDouble(double value) {
    this.value = value;
  }

  public static ValueDouble of(double value) {
    return new ValueDouble(value);
  }

  @Override
  public boolean isDouble() {
    return true;
  }

  @Override
  public int getType() {
    return DOUBLE;
  }

  public double toDouble() {
    return value;
  }

  public long toLong() {
    return (long)value;
  }

  public String toString() {
    String str = String.format (Locale.ENGLISH, "%.9f", value);
    if (str.contains(".")) {
      while (str.endsWith("0")) {
        str = str.substring(0, str.length() - 1);
      }
    }
    if (str.endsWith(".")) {
      str=str.substring(0, str.length()-1);
    }
    return str;
  }

  public boolean toBoolean() {
    return value!=0;
  }

  public BigDecimal toBigDecimal() {
    return BigDecimal.valueOf(value);
  }

  @Override
  public int compareTo(Value v2) {
    return Double.compare(value, v2.toDouble());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ValueDouble)) return false;
    ValueDouble that = (ValueDouble) o;
    return Double.compare(that.value, value) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  private final double value;
}
