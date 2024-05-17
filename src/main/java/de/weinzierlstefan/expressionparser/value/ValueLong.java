package de.weinzierlstefan.expressionparser.value;

import de.weinzierlstefan.expressionparser.ExpressionException;

import java.util.Objects;

/**
 *
 */
public class ValueLong extends ValueNumber {
  private final static int CACHE_MIN = -127;
  private final static int CACHE_MAX = 128;
  private static final ValueLong[] cache;

  static {
    cache = new ValueLong[CACHE_MAX - CACHE_MIN + 1];
    int j = CACHE_MIN;
    for (int i = 0; i < cache.length; i++, j++) {
      cache[i] = new ValueLong(j);
    }
  }

  private final long value;

  private ValueLong(long value) {
    this.value = value;
  }

  /**
   *
   * @param value
   * @return
   */
  public static ValueLong of(long value) {
    if (value >= CACHE_MIN && value <= CACHE_MAX) {
      return cache[(int) (value - CACHE_MIN)];
    }
    return new ValueLong(value);
  }

  /**
   * Returns the string "long"
   * @return
   */
  @Override
  public String getType() {
    return "long";
  }

  @Override
  public long getLong() throws ExpressionException {
    return value;
  }

  /**
   * Always returns true
   * @return
   */
  @Override
  public boolean isLong() {
    return true;
  }

  /**
   * Returns the value as a double (loose of precision is possible)
   * @return
   * @throws ExpressionException
   */
  @Override
  public double getDouble() throws ExpressionException {
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
   * Returns the value as a int, or throws an exception, if it doesn't fit into a int
   * @return
   * @throws ExpressionException
   */
  @Override
  public int getInt() throws ExpressionException {
    if (((int) value) == value) {
      return (int) value;
    }
    throw new ExpressionException("Can not convert to a int value");
  }

  @Override
  public String toString() {
    return Long.toString(value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ValueLong valueLong)) return false;
    return value == valueLong.value;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

  @Override
  public Object get() {
    return Long.valueOf(value);
  }
}
