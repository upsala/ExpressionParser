package de.weinzierlstefan.expressionparser.value;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * A List of Values, which additional helper functions
 */
public class ValueList extends ArrayList<Value> {
  public ValueList() {
  }

  public ValueList(int size) {
    super(size);
  }

  public ValueList(Collection<? extends Value> c) {
    super(c);
  }

  /**
   * Are all entries in the list of type Array?
   *
   * @return
   */
  public boolean allIsArray() {
    return stream().allMatch(Value::isArray);
  }

  /**
   * Are all entries in the list of type Boolean?
   *
   * @return
   */
  public boolean allIsBoolean() {
    return stream().allMatch(Value::isBoolean);
  }

  /**
   * Are all entries in the list of type Double?
   *
   * @return
   */
  public boolean allIsDouble() {
    return stream().allMatch(Value::isDouble);
  }

  /**
   * Are all entries in the list of type Long?
   *
   * @return
   */
  public boolean allIsLong() {
    return stream().allMatch(Value::isLong);
  }

  /**
   * Are all entries in the list of type Number?
   *
   * @return
   */
  public boolean allIsNumber() {
    return stream().allMatch(Value::isNumber);
  }

  /**
   * Are all entries in the list of type String?
   *
   * @return
   */
  public boolean allIsString() {
    return stream().allMatch(Value::isString);
  }

  /**
   * Are all entries in the list of type Temporal?
   *
   * @return
   */
  public boolean allIsTemporal() {
    return stream().allMatch(Value::isTemporal);
  }

  public boolean allIsObject() {
    return stream().allMatch(Value::isObject);
  }

  /**
   * Are all entries in the list of type Null?
   *
   * @return
   */
  public boolean allIsNull() {
    return stream().allMatch(Value::isNull);
  }

  /**
   * Is any of the entries in the list of type Null?
   *
   * @return
   */
  public boolean anyNull() {
    return stream().anyMatch(Value::isNull);
  }

  /**
   * Get the element at position index as double
   *
   * @param index
   * @return
   */
  public double getDouble(int index) {
    return get(index).getDouble();
  }

  /**
   * Get the element at position index as Array
   *
   * @param index
   * @return
   */
  public ValueList getArray(int index) {
    return get(index).getArray();
  }

  /**
   * Get the element at position index as Array
   *
   * @param index
   * @return
   */
  public Map<Value, Value> getMap(int index) {
    return get(index).getMap();
  }

  /**
   * Get the element at position index as String
   *
   * @param index
   * @return
   */
  public String getString(int index) {
    return get(index).getString();
  }

  /**
   * Get the element at position index as Long
   *
   * @param index
   * @return
   */
  public long getLong(int index) {
    return get(index).getLong();
  }

  /**
   * Get the element at position index as Temporal
   *
   * @param index
   * @return
   */
  public Temporal getTemporal(int index) {
    return get(index).getTemporal();
  }

  /**
   * Get the element at position index as Boolean
   *
   * @param index
   * @return
   */
  public boolean getBoolean(int index) {
    return get(index).getBoolean();
  }

  /**
   * Is the element at position index of type Number?
   *
   * @param index
   * @return
   */
  public boolean isNumber(int index) {
    if (index >= 0 && index < size()) {
      return get(index).isNumber();
    }
    return false;
  }

  /**
   * Is the element at position index of type Array?
   *
   * @param index
   * @return
   */
  public boolean isArray(int index) {
    if (index >= 0 && index < size()) {
      return get(index).isArray();
    }
    return false;
  }

  /**
   * Is the element at position index of type Null?
   *
   * @param index
   * @return
   */
  public boolean isNull(int index) {
    if (index >= 0 && index < size()) {
      return get(index).isNull();
    }
    return false;
  }

  /**
   * Is the element at position index of type String?
   *
   * @param index
   * @return
   */
  public boolean isString(int index) {
    if (index >= 0 && index < size()) {
      return get(index).isString();
    }
    return false;
  }

  /**
   * Is the element at position index of type Boolean?
   *
   * @param index
   * @return
   */
  public boolean isBoolean(int index) {
    if (index >= 0 && index < size()) {
      return get(index).isBoolean();
    }
    return false;
  }

  public int getInt(int index) {
    return get(index).getInt();
  }

  public boolean isMap(int index) {
    return get(index).isObject();
  }


}
