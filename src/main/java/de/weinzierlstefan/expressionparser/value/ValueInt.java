package de.weinzierlstefan.expressionparser.value;

import de.weinzierlstefan.expressionparser.ExpressionException;

import java.util.Objects;

/**
 *
 */
public class ValueInt extends ValueNumber {
  public static final Value ZERO = new ValueInt(0);
  public static final Value ONE = new ValueInt(1);
  private final static int CACHE_MIN = -127;
  private final static int CACHE_MAX = 128;
  private static final ValueInt[] cache;

  static {
    cache = new ValueInt[CACHE_MAX - CACHE_MIN + 1];
    int j = CACHE_MIN;
    for (int i = 0; i < cache.length; i++, j++) {
      cache[i] = new ValueInt(j);
    }
  }

  private final int value;

  private ValueInt(int value) {
    this.value = value;
  }

  /**
   *
   * @param value
   * @return
   */
  public static ValueInt of(int value) {
    if (value >= CACHE_MIN && value <= CACHE_MAX) {
      return cache[value - CACHE_MIN];
    }
    return new ValueInt(value);
  }

  /**
   * Always returns true
   * @return
   */
  @Override
  public boolean isInt() {
    return true;
  }

  @Override
  public int getInt() throws ExpressionException {
    return value;
  }

  /**
   * Returns true if the value is not 0
   * @return
   */
  @Override
  public boolean getBoolean() {
    return value != 0;
  }

  /**
   * Returns "int"
   * @return
   */
  @Override
  public String getType() {
    return "int";
  }

  /**
   * Returns the value converted to a long
   * @return
   * @throws ExpressionException
   */
  @Override
  public long getLong() throws ExpressionException {
    return value;
  }

  /**
   * Returns the value converted to a double
   * @return
   * @throws ExpressionException
   */
  @Override
  public double getDouble() throws ExpressionException {
    return value;
  }

  @Override
  public String toString() {
    return Integer.toString(value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ValueInt valueInt)) return false;
    return value == valueInt.value;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

  @Override
  public Object get() {
    return Integer.valueOf(value);
  }
}
