package de.weinzierlstefan.expressionparser.value;

public class ValueNull extends Value {
  public static final Value INSTANCE = new ValueNull();

  private ValueNull() {
  }

  @Override
  public boolean isNull() {
    return true;
  }

  @Override
  public String getType() {
    return "null";
  }

  @Override
  public String toString() {
    return "NULL";
  }

  @Override
  public boolean equals(Object o) {
    return o instanceof ValueNull;
  }

  @Override
  public Object get() {
    return null;
  }
}
