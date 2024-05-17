package de.weinzierlstefan.expressionparser.value;

import de.weinzierlstefan.expressionparser.ExpressionException;

import java.util.Objects;

/**
 *
 */
public class ValueBoolean extends Value {
  public final static ValueBoolean TRUE = new ValueBoolean(true);
  public final static ValueBoolean FALSE = new ValueBoolean(false);
  private final boolean value;

  private ValueBoolean(boolean value) {
    this.value = value;
  }

  /**
   *
   * @param value
   * @return
   */
  public static ValueBoolean of(boolean value) {
    return value ? TRUE : FALSE;
  }

  /**
   * Returns a int of value 1 if the ValueBoolean is true, otherwise a int of value 0
   * @return
   * @throws ExpressionException
   */
  @Override
  public int getInt() throws ExpressionException {
    return value ? 1 : 0;
  }

  @Override
  public boolean getBoolean() {
    return value;
  }

  /**
   * Returns a long of value 1 if the ValueBoolean is true, otherwise a long of value 0
   * @return
   * @throws ExpressionException
   */
  @Override
  public long getLong() throws ExpressionException {
    return value ? 1 : 0;
  }

  /**
   * Returns a double of value 1 if the ValueBoolean is true, otherwise a double of value 0
   * @return
   * @throws ExpressionException
   */
  @Override
  public double getDouble() throws ExpressionException {
    return value ? 1d : 0d;
  }

  @Override
  public String getType() {
    return "boolean";
  }

  /**
   * Always returns true
   * @return true
   */
  @Override
  public boolean isBoolean() {
    return true;
  }

  @Override
  public String toString() {
    return value ? "true" : "false";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ValueBoolean that)) return false;
    return value == that.value;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

  @Override
  public Object get() {
    return Boolean.valueOf(value);
  }
}
