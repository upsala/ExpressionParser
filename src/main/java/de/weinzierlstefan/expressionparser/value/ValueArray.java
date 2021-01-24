package de.weinzierlstefan.expressionparser.value;

import java.util.*;

public class ValueArray extends Value {

  private ValueArray(Collection<Value> valueCollection) {
    int key=0;
    for(Value value : valueCollection) {
      valueMap.put(Value.of(key++), value);
    }
  }

  private ValueArray(Map<Value, Value> valueMap) {
    this.valueMap.putAll(valueMap);
  }

  public static ValueArray of(Collection<Value> valueCollection) {
    return new ValueArray(valueCollection);
  }

  public static ValueArray of(Map<Value, Value> valueMap) {
    return new ValueArray(valueMap);
  }

  @Override
  public int compareTo(Value v2) {
    return 0; //TODO...
  }

  @Override
  public boolean isArray() {
    return true;
  }

  public String toString() {
    StringJoiner joiner = new StringJoiner(",", "[", "]");

    int size = valueMap.size();
    int matched = 0;
    for(int i=0; i<size; ++i) {
      if (valueMap.containsKey(Value.of(i))) {
        matched++;
      } else {
        break;
      }
    }
    if (matched==size) {
      valueMap.forEach((k,v)->{
        joiner.add(v.toString());
      });
    } else {
      valueMap.forEach((k,v)->{
        joiner.add(k.toString()+"=>"+v.toString());
      });
    }

    return joiner.toString();
  }

  public ValueList toArray() { return new ValueList(valueMap.values()); }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ValueArray)) return false;
    ValueArray that = (ValueArray) o;
    return Objects.equals(valueMap, that.valueMap);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueMap);
  }

  public Value get(Value key) {
    return valueMap.get(key);
  }

  public ValueList values() { return toArray(); }
  public ValueList keys() { return new ValueList(valueMap.keySet()); }

  public Map<Value, Value> toMap() { return valueMap; };

  private final TreeMap<Value, Value> valueMap = new TreeMap<>();
}
