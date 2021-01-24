package de.weinzierlstefan.expressionparser.value;

import java.util.Objects;

public class ValueString extends Value {

  public final static ValueString EMPTY = new ValueString("");

  private ValueString(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }

  @Override
  public boolean isString() {
    return true;
  }

  public static ValueString of(String value) {
    return new ValueString(value);
  }

  public boolean toBoolean() {
    return !value.isEmpty();
  }

  public long toLong() {
    try {
      return Long.valueOf(value);
    } catch (NumberFormatException ex) {
      return 0;
    }
  }

  @Override
  public int compareTo(Value v2) {
    return value.compareTo(v2.toString());
  }

  public double toDouble() {
    try {
      return Double.valueOf(value);
    } catch (NumberFormatException ex) {
      return 0;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ValueString)) return false;
    if (!super.equals(o)) return false;
    ValueString that = (ValueString) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  private final String value;
}
