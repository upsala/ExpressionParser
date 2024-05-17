package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueDouble;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class Fact implements Function {
  @Override
  public String getName() {
    return "fact";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value numberValue = valueList.get(0);
    if (!numberValue.isNumber()) {
      throw new ExpressionException("Value must be a number");
    }

    int number = numberValue.getInt();

    if (number < 0) {
      throw new ExpressionException("Value must be positiv");
    }

    double factorial = 1;
    try {
      for (int i = 2; i <= number; i++) {
        factorial *= i;
      }
      return ValueDouble.of(factorial);
    } catch (Exception ex) {
      throw new ExpressionException("Overflow");
    }
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
