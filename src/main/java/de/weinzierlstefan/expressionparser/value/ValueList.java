package de.weinzierlstefan.expressionparser.value;

import java.util.ArrayList;
import java.util.Collection;

public class ValueList extends ArrayList<Value> {
  public ValueList() {
  }

  public ValueList(int size) {
    super(size);
  }

  public ValueList(Collection<? extends Value> c) {
    super(c);
  }

  public boolean allIsArray() {
    return stream().allMatch(Value::isArray);
  }

  public boolean allIsBoolean() {
    return stream().allMatch(Value::isBoolean);
  }

  public boolean allIsDouble() {
    return stream().allMatch(Value::isDouble);
  }

  public boolean allIsLong() {
    return stream().allMatch(Value::isLong);
  }

  public boolean allIsNumber() {
    return stream().allMatch(Value::isNumber);
  }

  public boolean allIsString() {
    return stream().allMatch(Value::isString);
  }

  public boolean allIsTemporal() {
    return stream().allMatch(Value::isTemporal);
  }

  public boolean allIsNull() {
    return stream().allMatch(Value::isNull);
  }

  public boolean anyNull() { return stream().anyMatch(Value::isNull); }
}
