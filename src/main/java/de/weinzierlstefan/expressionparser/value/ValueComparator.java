package de.weinzierlstefan.expressionparser.value;

import java.util.Map;
import java.util.TreeSet;

class ValueComparator {

  static int compare(Value o1, Value o2) {
    if (o1.isNull() || o2.isNull()) {
      return -1;
    }

    if ((o1.isNumber() || o1.isBoolean()) && (o2.isNumber() || o2.isBoolean())) {
      return compareNumbers(o1, o2);
    }

    if (o1.isArray() && o2.isArray()) {
      return compareArrays(o1.getArray(), o2.getArray());
    }
    if (o1.isObject() && o2.isObject()) {
      return compareObjects(o1.getMap(), o2.getMap());
    }

    if ((o1.isArray() && o2.isObject()) || (o1.isObject() && o2.isArray())) {
      return compareObjects(o1.getMap(), o2.getMap());
    }

    return o1.getString().compareTo(o2.getString());
  }

  private static int compareNumbers(Value o1, Value o2) {
    long n1 = 0;
    double d1;
    boolean compareDouble = false;

    if (o1.isBoolean()) {
      n1 = o1.getBoolean() ? 1 : 0;
    } else if (o1.isInt()) {
      n1 = o1.getInt();
    } else if (o1.isLong()) {
      n1 = o1.getLong();
    }
    if (o1.isDouble()) {
      d1 = o1.getDouble();
      compareDouble = true;
    } else {
      d1 = n1;
    }


    long n2 = 0;
    double d2;
    if (o2.isBoolean()) {
      n2 = o2.getBoolean() ? 1 : 0;
    } else if (o2.isInt()) {
      n2 = o2.getInt();
    } else if (o1.isLong()) {
      n2 = o2.getLong();
    }
    if (o2.isDouble()) {
      d2 = o2.getDouble();
      compareDouble = true;
    } else {
      d2 = n2;
    }

    if (compareDouble) {
      return Double.compare(d1, d2);
    }

    return Long.compare(n1, n2);
  }

  private static int compareObjects(Map<Value, Value> o1, Map<Value, Value> o2) {
    TreeSet<Value> keys = new TreeSet<>(o1.keySet());
    keys.addAll(o2.keySet());

    for(Value key : keys) {
      Value value1 = o1.get(key);
      Value value2 = o2.get(key);

      if (value1==null) {
        return -1;
      }
      if (value2==null) {
        return 1;
      }

      int c = compare(value1, value2);
      if (c!=0) {
        return c;
      }
    }

    return Integer.compare(o1.size(), o2.size());
  }

  private static int compareArrays(ValueList a1, ValueList a2) {
    if (a1.size() < a2.size()) {
      return -1;
    }
    if (a1.size() > a2.size()) {
      return 1;
    }

    for (int i = 0; i < a1.size(); i++) {
      int c = compare(a1.get(i), a2.get(i));
      if (c != 0) {
        return c;
      }
    }

    return 0;
  }
}
