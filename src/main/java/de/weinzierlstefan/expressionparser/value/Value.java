package de.weinzierlstefan.expressionparser.value;


import de.weinzierlstefan.expressionparser.ExpressionException;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Value implements Comparable<Value> {
  /**
   *
   * @param source
   * @return
   */
  public static Value create(Object source) {
    if (source instanceof Value value) {
      return value;
    }

    if (source == null) {
      return ValueNull.INSTANCE;
    }

    if (source instanceof Integer i) {
      return ValueInt.of(i);
    }

    if (source instanceof Long l) {
      return ValueLong.of(l);
    }

    if (source instanceof Double d) {
      return ValueDouble.of(d);
    }

    if (source instanceof Boolean b) {
      return ValueBoolean.of(b);
    }

    if (source instanceof String s) {
      return ValueString.of(s);
    }

    if (source instanceof List<?> l) {
      List<Value> array = new ArrayList<>();
      for (var entry : l) {
        array.add(create(entry));
      }
      return ValueArray.of(array);
    }

    if (source instanceof Map<?, ?> m) {
      Map<Value, Value> objectMap = new HashMap<>();
      m.forEach((k, v) -> {
        if (objectMap.put(Value.create(k), Value.create(v))!=null) {
          throw new ExpressionException("Duplicate key: "+k);
        }
      });
      return ValueObject.of(objectMap);
    }

    if (source instanceof Temporal t) {
      return ValueTemporal.of(t);
    }

    if (source instanceof Byte b) {
      return ValueInt.of((int)b);
    }

    if (source instanceof Short s) {
      return ValueInt.of((int)s);
    }

    if (source instanceof Character c) {
      return ValueInt.of((int)c);
    }

    if (source instanceof Float f) {
      return ValueDouble.of(f.doubleValue());
    }

    throw new ExpressionException("Unsupported conversation type: " + source.getClass());
  }

  /**
   * Checks if this value is of type {@link ValueNull}
   * @return
   */
  public boolean isNull() {
    return false;
  }

  /**
   * Checks if this value is of type {@link ValueString}
   * @return
   */
  public boolean isString() {
    return false;
  }

  /**
   * Checks if this value is of type {@link ValueNumber}, e.g. {@link ValueInt}, {@link ValueLong} or {Qlink ValueDouble}
   * @return
   */
  public boolean isNumber() {
    return false;
  }

  /**
   * Checks if this value is of type {@link ValueArray}
   * @return
   */
  public boolean isArray() {
    return false;
  }

  /**
   * Checks if this value is of type {@link ValueDouble}
   * @return
   */
  public boolean isDouble() {
    return false;
  }

  /**
   * Checks if this value is of type {@link ValueObject}
   * @return
   */
  public boolean isObject() {
    return false;
  }

  /**
   * Returns a Map&lt;Value, Value&gt;
   * @return
   */
  public Map<Value, Value> getMap() {
    throw new ExpressionException("Conversation to map not possible");
  }

  /**
   *
   * @return
   * @throws ExpressionException
   */
  public double getDouble() throws ExpressionException {
    throw new ExpressionException("Conversation to double not possible");
  }

  /**
   * Checks if this value is of type {@link ValueLong}
   * @return
   */
  public boolean isLong() {
    return false;
  }

  /**
   *
   * @return
   * @throws ExpressionException
   */
  public long getLong() throws ExpressionException {
    throw new ExpressionException("Conversation to long is not possible");
  }

  /**
   * Checks if this value is of type {@link ValueInt}
   * @return
   */
  public boolean isInt() {
    return false;
  }

  public int getInt() throws ExpressionException {
    throw new ExpressionException("Conversation to int is not possible");
  }

  public boolean getBoolean() {
    return false;
  }

  /**
   * Returns the string-representation of this type. (e.g. string, null, object, ...)
   * @return
   */
  public abstract String getType();

  public ValueList getArray() throws ExpressionException {
    throw new ExpressionException("Conversation to array is not possible");
  }

  /**
   * Checks, if this value is of type {@link ValueBoolean}
   * @return
   */
  public boolean isBoolean() {
    return false;
  }

  /**
   * Checks, if this value is of type {@link ValueTemporal}
   * @return
   */
  public boolean isTemporal() {
    return false;
  }

  /**
   *
   * @return
   */
  public Temporal getTemporal() {
    throw new ExpressionException("Conversation to temporal is not possible");
  }

  /**
   *
   * @return
   */
  public String getString() {
    return toString();
  }

  /**
   *
   * @return
   */
  public abstract Object get();

  @Override
  public int compareTo(Value o) {
    return ValueComparator.compare(this, o);
  }

  public boolean isLambda() {
    return false;
  }
}
