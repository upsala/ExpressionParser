package de.weinzierlstefan.expressionparser.functions.statistics;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueNull;

import java.math.BigDecimal;
import java.util.Optional;

public class Range implements Function {
  @Override
  public String getName() {
    return "range";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    if (valueList.size()==1 && valueList.get(0).isArray()) {
      valueList=valueList.get(0).toArray();
    }

    if (!valueList.allIsNumber()) {
      throw new ExpressionException("Values must be numbers");
    }

    Optional<Value> maxResult = valueList.stream().max(Value::compareTo);
    Optional<Value> minResult = valueList.stream().min(Value::compareTo);

    if (maxResult.isEmpty() || minResult.isEmpty()) {
      return ValueNull.INSTANCE;
    }

    BigDecimal max = maxResult.get().toBigDecimal();
    BigDecimal min = minResult.get().toBigDecimal();

    return Value.of(max.subtract(min, executorContext.getMathContext()));
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
