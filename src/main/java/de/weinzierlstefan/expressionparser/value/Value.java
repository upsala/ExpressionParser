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

  /*public static final Value FALSE = Value.of(false);
  public static final Value TRUE = Value.of(true);*/


  Value() {
  }

  public static ValueBoolean of(boolean value) {
    return ValueBoolean.of(value);
  }

  public static ValueLong of(long value) { return ValueLong.of(value); }

  public static ValueDouble of(double value) { return ValueDouble.of(value); }

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

  public static Value of(String value) {
    if (value==null) {
      return ValueNull.INSTANCE;
    }

    return ValueString.of(value);
  }

  public static Value of(Collection<Value> valueCollection) {
    if (valueCollection==null) {
      return ValueNull.INSTANCE;
    }

    return ValueArray.of(valueCollection);
  }

  public static Value of(Map<Value, Value> valueMap) {
    if (valueMap==null) {
      return ValueNull.INSTANCE;
    }

    return ValueArray.of(valueMap);
  }

  public static Value of(Temporal value) {
    if (value==null) {
      return ValueNull.INSTANCE;
    }

    return ValueTemporal.of(value); }

  public Temporal toTemporal() { return null; }

  public boolean toBoolean() { return false; }

  public long toLong() { return 0; }

  public double toDouble() { return 0; }

  public BigDecimal toBigDecimal() { return BigDecimal.ZERO; }

  public String toPlainString() { return toString(); }

  public Map<Value, Value> toMap() { return null; };

  abstract public int compareTo(Value v2);

  abstract public int getType();

  public boolean isNumber() { return false; }

  public boolean isString() { return false; }

  public boolean isArray() { return false; }

  public boolean isTemporal() { return false; }

  public boolean isBoolean() { return false; }

  public boolean isDouble() { return false; }

  public boolean isLong() { return false; }

  public boolean isNull() { return false; }

  @Override
  public boolean equals(Object o) {
    return false;
  }

  public ValueList toArray() {
    return null;
  }


}
