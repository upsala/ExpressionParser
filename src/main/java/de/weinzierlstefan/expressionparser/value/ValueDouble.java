package de.weinzierlstefan.expressionparser.value;

import de.weinzierlstefan.expressionparser.ExpressionException;

import java.util.Objects;

public class ValueDouble extends ValueNumber {
  private final double value;

  private ValueDouble(double value) {
    this.value = value;
  }

  public static ValueDouble of(double value) {
    return new ValueDouble(value);
  }

  @Override
  public String getType() {
    return "double";
  }

  @Override
  public double getDouble() throws ExpressionException {
    return value;
  }

  @Override
  public boolean isDouble() {
    return true;
  }

  @Override
  public String toString() {
    return Double.toString(value);
  }

  @Override
  public int getInt() throws ExpressionException {
    return (int) value;
  }

  @Override
  public boolean getBoolean() {
    return value != 0.;
  }

  @Override
  public long getLong() throws ExpressionException {
    return (long) value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ValueDouble that)) return false;
    return Double.compare(value, that.value) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

  @Override
  public Object get() {
    return Double.valueOf(value);
  }
}
