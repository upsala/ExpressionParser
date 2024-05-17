package de.weinzierlstefan.expressionparser.functions.statistics;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.*;

import java.util.Optional;


public class Range implements Function {
  @Override
  public String getName() {
    return "range";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    if (valueList.size() == 1 && valueList.isArray(0)) {
      valueList = valueList.getArray(0);
    }

    if (!valueList.allIsNumber()) {
      throw new ExpressionException("Values must be numbers");
    }

    Optional<Value> maxResult = valueList.stream().max(Value::compareTo);
    Optional<Value> minResult = valueList.stream().min(Value::compareTo);

    if (maxResult.isEmpty() || minResult.isEmpty()) {
      return ValueNull.INSTANCE;
    }

    Value maxValue = maxResult.get();
    Value minValue = minResult.get();

    if (maxValue.isDouble() || minValue.isDouble()) {
      var max = maxValue.getDouble();
      var min = minValue.getDouble();

      return ValueDouble.of(max - min);
    }

    if (maxValue.isLong() || minValue.isLong()) {
      var max = maxValue.getLong();
      var min = minValue.getLong();

      return ValueLong.of(max - min);
    }

    if (maxValue.isInt() || minValue.isInt()) {
      var max = maxValue.getInt();
      var min = minValue.getInt();

      return ValueInt.of(max - min);
    }

    throw new ExpressionException("Unsupported range");
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
