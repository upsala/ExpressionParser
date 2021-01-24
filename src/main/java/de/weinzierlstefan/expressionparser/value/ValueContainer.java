package de.weinzierlstefan.expressionparser.value;

/**
 * A Container for dynamic values
 */
public abstract class ValueContainer extends Value {
  /**
   * Gets the {@link Value} of a variable
   * @param name
   * @return
   */
  public abstract Value get(String name);

  @Override
  public int getType() {
    return Value.CONTAINER;
  }

  @Override
  public boolean isArray() {
    return true;
  }

  @Override
  public int compareTo(Value v2) { return -1; }
}
