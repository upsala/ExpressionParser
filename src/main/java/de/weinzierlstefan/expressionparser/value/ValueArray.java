package de.weinzierlstefan.expressionparser.value;

import de.weinzierlstefan.expressionparser.ExpressionException;

import java.util.*;
import java.util.stream.Collectors;

public class ValueArray extends Value {
  private final ValueList value;

  private ValueArray(ValueList value) {
    this.value = value;
  }

  public static ValueArray of(ValueList value) {
    return new ValueArray(value);
  }

  public static ValueArray of(List<Value> valueList) {
    return new ValueArray(new ValueList(valueList));
  }

  @Override
  public String getType() {
    return "array";
  }

  @Override
  public String toString() {
    return value
      .stream()
      .map(Objects::toString)
      .collect(Collectors.joining(",", "[", "]"));
  }

  @Override
  public boolean isArray() {
    return true;
  }

  @Override
  public ValueList getArray() throws ExpressionException {
    return value;
  }

  @Override
  public Map<Value, Value> getMap() {
    Map<Value, Value> map = new HashMap<>(value.size());
    for(int i=0; i<value.size(); i++) {
      map.put(ValueInt.of(i), value.get(i));
    }
    return map;
  }

  @Override
  public Object get() {
    return Collections.unmodifiableList(value);
  }
}
