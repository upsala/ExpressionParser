package de.weinzierlstefan.expressionparser.value;

import java.util.Objects;

public class ValueString extends Value {

  public final static ValueString EMPTY = new ValueString("");
  private final String value;

  private ValueString(String value) {
    if (value == null) {
      throw new NullPointerException("value is null");
    }
    this.value = value;
  }

  public static ValueString of(String value) {
    if (value.isEmpty()) {
      return ValueString.EMPTY;
    }

    return new ValueString(value);
  }

  public static ValueString of(StringBuilder stringBuilder) {
    return of(stringBuilder.toString());
  }

  @Override
  public String toString() {
    String v = value;
    int singleQuoted = 0;
    int doubleQuoted = 0;
    for (int i = 0; i < v.length(); ++i) {
      char c = v.charAt(i);
      if (c == '"') {
        doubleQuoted++;
      } else if (c == '\'') {
        singleQuoted++;
      }
    }

    if (singleQuoted > doubleQuoted) {
      return '"' + v.replace("\"", "\\\"") + '"';
    }

    return "'" + value.replace("'", "\\'") + "'";
  }

  @Override
  public boolean isString() {
    return true;
  }

  public boolean getBoolean() {
    return !value.isEmpty();
  }

  public long getLong() {
    try {
      return Long.parseLong(value);
    } catch (NumberFormatException ex) {
      return 0;
    }
  }

  public double getDouble() {
    try {
      return Double.parseDouble(value);
    } catch (NumberFormatException ex) {
      return 0;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ValueString that)) return false;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

  @Override
  public String getType() {
    return "string";
  }

  @Override
  public String getString() {
    return value;
  }

  @Override
  public Object get() {
    return value;
  }
}
