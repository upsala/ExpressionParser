package de.weinzierlstefan.expressionparser.value;

import java.util.HashMap;
import java.util.Map;

/**
 * A default-Implemention of ValueContainer
 */
public class DefaultValueContainer extends ValueContainer {
  private final Map<String, Value> valueMap = new HashMap<>();

  @Override
  public Value get(String name) {
    return valueMap.get(name);
  }

  @Override
  public boolean has(String name) {
    return valueMap.containsKey(name);
  }

  /**
   * Sets the {@link Value} of a variable, existing variables will be overwritten
   *
   * @param name
   * @param value
   */
  public void set(String name, Value value) {
    valueMap.put(name, value);
  }

  public void set(String name, Object value) {
    valueMap.put(name, create(value));
  }

  /**
   * Clears the Container
   */
  public void clear() {
    valueMap.clear();
  }

  /**
   * Removes a variable
   *
   * @param name
   */
  public void remove(String name) {
    valueMap.remove(name);
  }

  @Override
  public Object get() {
    throw new UnsupportedOperationException();
  }
}
