package de.weinzierlstefan.expressionparser.functions.bit;

import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.ValueList;

abstract class CommonBitFunction implements Function {

  static long getMask(ValueList valueList) {
    long mask = 0;
    for (int i = 1; i < valueList.size(); ++i) {
      int pos = valueList.getInt(i);

      if (pos >= 0) {
        mask = mask | (1L << pos);
      }
    }
    return mask;
  }

  @Override
  public boolean parameterCount(int count) {
    return count > 1;
  }
}
