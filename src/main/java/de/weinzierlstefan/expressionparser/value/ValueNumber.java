package de.weinzierlstefan.expressionparser.value;

public abstract class ValueNumber extends Value {

  protected ValueNumber() {
  }

  @Override
  public boolean isNumber() {
    return true;
  }
}
