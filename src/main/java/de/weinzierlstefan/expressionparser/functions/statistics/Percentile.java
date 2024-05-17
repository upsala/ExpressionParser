package de.weinzierlstefan.expressionparser.functions.statistics;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueDouble;
import de.weinzierlstefan.expressionparser.value.ValueList;


public class Percentile implements Function {
  @Override
  public String getName() {
    return "percentile";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {

    Value value1 = valueList.get(0);
    Value value2 = valueList.get(1);

    if (!value1.isArray()) {
      throw new ExpressionException("First Parameter must be a array");
    }
    if (!value2.isNumber()) {
      throw new ExpressionException("Second Parameter must be a number");
    }

    var array = value1.getArray();
    var position = value2.getDouble();

    if (!array.allIsNumber()) {
      throw new ExpressionException("All values in the list must be a number");
    }

    var sortedValues = array
      .stream()
      .map(Value::getDouble)
      .sorted()
      .toList();

    int size = sortedValues.size();

    int pos1 = Math.min(size - 1, Math.max(0, (int) Math.floor(size * position) - 1));
    int pos2 = Math.min(size - 1, Math.max(0, (int) Math.floor(size * position)));

    if (size % 2 == 0) {
      return ValueDouble.of((sortedValues.get(pos1) + sortedValues.get(pos2)) * .5);
    } else {
      return ValueDouble.of(sortedValues.get(pos1));
    }
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 2;
  }
}

//TODO: Allow 3. parameter like in R (https://www.rdocumentation.org/packages/stats/versions/3.6.2/topics/quantile)
