package de.weinzierlstefan.expressionparser.value;

import java.util.*;

public class ValueObject extends Value {
  public final static ValueObject EMPTY = new ValueObject(Map.of());
  private final Map<Value, Value> valueMap;

  private ValueObject(Map<? extends Value, ? extends Value> value) {
    this.valueMap = new HashMap<>(value);
  }

  public static ValueObject of(Map<? extends Value, ? extends Value> value) {
    return new ValueObject(value);
  }

  @Override
  public String getType() {
    return "object";
  }

  public void set(Value key, Value value) {
    valueMap.put(key, value);
  }

  public void set(Value key, Object value) {
    set(key, create(value));
  }

  public Value get(Value key) {
    return valueMap.get(key);
  }

  @Override
  public Map<Value, Value> getMap() {
    return valueMap;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ValueObject valueObject1)) return false;
    return Objects.equals(valueMap, valueObject1.valueMap);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(valueMap);
  }

  @Override
  public boolean isObject() {
    return true;
  }

  @Override
  public String toString() {
    StringJoiner stringJoiner = new StringJoiner(",", "{", "}");

    for (Map.Entry<Value, Value> entry : valueMap.entrySet()) {
      stringJoiner.add(entry.getKey() + ":" + entry.getValue().toString());
    }

    return stringJoiner.toString();
  }

  @Override
  public Object get() {
    return Collections.unmodifiableMap(valueMap);
  }
}
