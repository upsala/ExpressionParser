package de.weinzierlstefan.expressionparser.value;

public abstract class ValueNumber extends Value {
  public static ValueNumber bistFitOf(double value) {
    if ((int) (value) == value) {
      return ValueInt.of((int) value);
    }
    if ((long) (value) == value) {
      return ValueLong.of((long) value);
    }
    return ValueDouble.of(value);
  }

  public static ValueNumber bistFitOf(long value) {
    if ((int) (value) == value) {
      return ValueInt.of((int) value);
    }

    return ValueLong.of(value);
  }

  public static ValueNumber bistFitOf(int value) {
    return ValueInt.of(value);
  }

  @Override
  public boolean isNumber() {
    return true;
  }
}
