package de.weinzierlstefan.expressionparser.value;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.time.temporal.Temporal;
import java.util.Collection;
import java.util.Map;

public abstract class Value implements Comparable<Value> {
  public static final int NUMBER = 1;
  public static final int STRING = 2;
  public static final int ARRAY = 3;
  public static final int OBJECT = 4;
  public static final int TEMPORAL = 5;
  public static final int LONG = 6;
  public static final int DOUBLE = 7;
  public static final int BOOLEAN = 8;
  public static final int BIGDECIMAL = 9;
  public static final int CONTAINER = 10;
  public static final int NULL = 11;

  Value() {
  }

  /**
   * Returns a {@link ValueBoolean}
   * @param value
   * @return
   */
  public static ValueBoolean of(boolean value) {
    return ValueBoolean.of(value);
  }

  /**
   * Returns a {@link ValueLong}
   * @param value
   * @return
   */
  public static ValueLong of(long value) { return ValueLong.of(value); }

  /**
   * Returns a {@link ValueDouble}
   * @param value
   * @return
   */
  public static ValueDouble of(double value) { return ValueDouble.of(value); }

  /**
   * Returns a {@link ValueLong} or a {@link ValueBigDecimal}, depending on the value
   * @param value
   * @return
   */
  public static Value of(BigInteger value) {
    if (value==null) {
      return ValueNull.INSTANCE;
    }

    long longValue = value.longValue();
    BigInteger biLongValue = BigInteger.valueOf(longValue);
    if (value.equals(biLongValue)) {
      return ValueLong.of(longValue);
    }

    return ValueBigDecimal.of(value);
  }

  /**
   * Returns a {@link ValueLong}, a {@link ValueDouble} or a {@link ValueBigDecimal} depending on the given value
   * @param value
   * @return
   */
  public static Value of(BigDecimal value) {
    if (value==null) {
      return ValueNull.INSTANCE;
    }

    long longValue = value.longValue();
    BigDecimal bdLongValue = BigDecimal.valueOf(longValue);
    if (value.equals(bdLongValue)) {
      return ValueLong.of(longValue);
    }

    double doubleValue = value.doubleValue();
    BigDecimal bdDoubleValue = BigDecimal.valueOf(doubleValue);
    if (value.equals(bdDoubleValue)) {
      return ValueDouble.of(doubleValue);
    }

    return ValueBigDecimal.of(value);
  }

  public static Value of(Number value, MathContext mc) {
    if (value==null) {
      return ValueNull.INSTANCE;
    }

    return ValueBigDecimal.of(value, mc);
  }

  /**
   * Returns a {@link ValueString}
   * @param value
   * @return
   */
  public static Value of(String value) {
    if (value==null) {
      return ValueNull.INSTANCE;
    }

    return ValueString.of(value);
  }

  /**
   * Returns a {@link ValueArray} with the keys from 0 to the size of the give collection-1
   * @param valueCollection
   * @return
   */
  public static Value of(Collection<Value> valueCollection) {
    if (valueCollection==null) {
      return ValueNull.INSTANCE;
    }

    return ValueArray.of(valueCollection);
  }

  /**
   * Returns a {@link ValueArray} with a copy of the given map.
   * @param valueMap
   * @return
   */
  public static Value of(Map<Value, Value> valueMap) {
    if (valueMap==null) {
      return ValueNull.INSTANCE;
    }

    return ValueArray.of(valueMap);
  }

  /**
   * Returns a {@link ValueTemporal}
   * @param value
   * @return
   */
  public static Value of(Temporal value) {
    if (value==null) {
      return ValueNull.INSTANCE;
    }

    return ValueTemporal.of(value);
  }

  /**
   * Converts to a {@link Temporal} if possible, otherwise null is returned
   * @return
   */
  public Temporal toTemporal() { return null; }

  /**
   * Converts the value to a boolean if possible, otherwise false is returned
   * @return
   */
  public boolean toBoolean() { return false; }

  /**
   * Converts the value to a long if possible, otherwise 0 is returned
   * @return
   */
  public long toLong() { return 0; }

  /**
   * Converts the value to a double if possible, otherwise 0 is returned
   * @return
   */
  public double toDouble() { return 0; }

  /**
   * Converts the value to a {@link BigDecimal} if possible, otherwise {@link BigDecimal#ZERO} is returned
   * @return
   */
  public BigDecimal toBigDecimal() { return BigDecimal.ZERO; }

  /**
   * Converts the value to a {@link String}
   * @return
   */
  public String toPlainString() { return toString(); }

  /**
   * Converts the value to a {@link Map} if possible, otherwise null is returned
   * @return
   */
  public Map<Value, Value> toMap() { return null; };

  abstract public int compareTo(Value v2);

  /**
   * Gets the type of the Value, possible types are {@link #NUMBER}, {@link #STRING}, {@link #ARRAY}, {@link #TEMPORAL}, {@link #LONG}, {@link #DOUBLE}, {@link #BOOLEAN},
   * {@link #BIGDECIMAL}, {@link #CONTAINER} and {@link #NULL}
   * @return
   */
  abstract public int getType();

  /**
   * Returns true if {@link Value} is a {@link ValueLong}, {@link ValueDouble}, a {@link ValueBigDecimal} or a {@link ValueBoolean}
   * @return
   */
  public boolean isNumber() { return false; }

  /**
   * Returns true if {@link Value} is a {@link ValueString}
   * @return
   */
  public boolean isString() { return false; }

  /**
   * Returns true if {@link Value} is a {@link ValueArray}
   * @return
   */
  public boolean isArray() { return false; }

  /**
   * Returns true if {@link Value} is a {@link ValueTemporal}
   * @return
   */
  public boolean isTemporal() { return false; }

  /**
   * Returns true if {@link Value} is a {@link ValueBoolean}
   * @return
   */
  public boolean isBoolean() { return false; }

  /**
   * Returns true if {@link Value} is a {@link ValueDouble}
   * @return
   */
  public boolean isDouble() { return false; }

  /**
   * Returns true if {@link Value} is a {@link ValueLong}
   * @return
   */
  public boolean isLong() { return false; }

  /**
   * Returns true if {@link Value} is a {@link ValueNull}
   * @return
   */
  public boolean isNull() { return false; }

  @Override
  public boolean equals(Object o) {
    return false;
  }

  /**
   * Returns a {@link ValueList} of the values of a {@link ValueArray}
   * @return
   */
  public ValueList toArray() {
    return null;
  }


}
