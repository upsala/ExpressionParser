package de.weinzierlstefan.expressionparser.value;

public abstract class ValueNumber extends Value {

  ValueNumber() {
    super();
  }

  @Override
  public boolean isNumber() {
    return true;
  }

  @Override
  public int getType() {
    return NUMBER;
  }
}
