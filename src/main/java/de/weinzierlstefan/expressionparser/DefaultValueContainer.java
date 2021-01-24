package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * A default-Implemention of ValueContainer
 */
public class DefaultValueContainer extends ValueContainer {
  @Override
  public Value get(String name) {
    return valueMap.get(name);
  }

  /**
   * Sets the {@link Value} of a variable, existing variables will be overwritten
   * @param name
   * @param value
   */
  public void set(String name, Value value) {
    valueMap.put(name, value);
  }

  /**
   * Clears the Container
   */
  public void clear() {
    valueMap.clear();
  }

  /**
   * Removes a variable
   * @param name
   */
  public void remove(String name) {
    valueMap.remove(name);
  }

  private final Map<String, Value> valueMap = new HashMap<>();
}
