package de.weinzierlstefan.expressionparser.value;

public class ValueNull extends Value {
  public static final Value INSTANCE = new ValueNull();

  @Override
  public int compareTo(Value v2) {
    if (v2 instanceof ValueNull) {
      return 0;
    }
    return -1;
  }

  @Override
  public int getType() {
    return NULL;
  }

  @Override
  public boolean isNull() { return true; }

  @Override
  public boolean toBoolean() {
    return false;
  }

  @Override
  public String toString() {
    return "NULL";
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof ValueNull) {
      return true;
    }
    return false;
  }
}
