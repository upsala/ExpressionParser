package de.weinzierlstefan.expressionparser.value;

/**
 * A Container for dynamic values
 */
public abstract class ValueContainer extends Value {
  /**
   * Gets the {@link Value} of a variable
   *
   * @param name
   * @return
   */
  public abstract Value get(String name);

  public abstract void set(String name, Value value);

  /**
   * returns true, if a variable with the name exists
   * @param name
   * @return
   */
  public abstract boolean has(String name);

  @Override
  public boolean isArray() {
    return true;
  }

  @Override
  public boolean isObject() {
    return true;
  }

  @Override
  public String getType() {
    return "container";
  }
}
