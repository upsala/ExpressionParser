package de.weinzierlstefan.expressionparser.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Operation {
  public static final int INTEGER_LITERAL = 0;
  public static final int ADD = 1;
  public static final int SUB = 2;
  public static final int MUL = 3;
  public static final int DIV = 4;
  public static final int NEGATE = 5;
  public static final int HEX_LITERAL = 6;
  public static final int REAL_LITERAL = 7;
  public static final int BINARY_LITERAL = 8;
  public static final int SIMPLE_STRING_LITERAL = 9;
  public static final int DOUBLE_STRING_LITERAL = 10;
  public static final int FUNCTION_CALL = 11;
  public static final int MOD = 12;
  public static final int SHIFT_LEFT = 13;
  public static final int SHIFT_RIGHT = 14;
  public static final int CMP_EQ = 15;
  public static final int CMP_NE = 16;
  public static final int CMP_LT = 17;
  public static final int CMP_LE = 18;
  public static final int CMP_GT = 19;
  public static final int CMP_GE = 20;
  public static final int BOOL_AND = 21;
  public static final int BOOL_OR = 22;
  public static final int BOOL_XOR = 23;
  public static final int BIT_AND = 24;
  public static final int BIT_OR = 25;
  public static final int BIT_XOR = 26;
  public static final int BIT_NOT = 27;
  public static final int BOOL_NOT = 28;
  public static final int TERNARY = 29;
  public static final int VARIABLE = 31;
  public static final int WITH = 32;
  public static final int AS = 33;
  public static final int VARIABLE_ESC = 34;
  public static final int SIMPLE_NAME_SUFFIX = 35;
  public static final int COMPLEX_NAME_SUFFIX = 36;
  public static final int ARRAY_LIST = 37;
  public static final int SUFFIXED = 38;
  public static final int ARRAY_ENTRY = 39;

  public Operation(int type) {
    this.type = type;
    this.value = null;
  }

  public Operation(int type, String value) {
    this.type = type;
    this.value = value;
  }

  public Operation(int type, Operation... operations) {
    this.type = type;
    this.value = null;
    for(Operation op : operations) {
      operationList.add(op);
    }
  }

  public Operation(int type, String value, Collection<Operation> operationCollection) {
    this.type = type;
    this.value = value;
    operationList.addAll(operationCollection);
  }

  public Operation(int type, String value, Operation... operations) {
    this.type = type;
    this.value = value;
    operationList.addAll(List.of(operations));
  }

  public Operation(int type, Collection<Operation> operationCollection) {
    this.type = type;
    this.value = null;
    operationList.addAll(operationCollection);
  }

  public void addOperation(Operation... operations) {
    operationList.addAll(List.of(operations));
  }

  public List<Operation> getOperationList() {
    return operationList;
  }

  public int getType() {
    return type;
  }

  public String getValue() {
    return value;
  }

  public String toString() {
    StringBuilder buffer = new StringBuilder();

    buffer.append(type);
    buffer.append(":");
    if (value!=null) {
      buffer.append(' ');
      buffer.append(value);
    }
    if (!operationList.isEmpty()) {
      boolean first = false;
      buffer.append(" {");
      for (Operation op : operationList) {
        if (first) {
          buffer.append(", ");
        }
        buffer.append(op.toString());

        first = true;
      }
      buffer.append("}");
    }

    //buffer.append("\n");

    return buffer.toString();
  }

  private final List<Operation> operationList = new ArrayList<>();

  private final int type;

  private final String value;
}
