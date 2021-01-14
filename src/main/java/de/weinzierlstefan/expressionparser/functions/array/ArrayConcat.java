package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class ArrayConcat implements Function {
  @Override
  public String getName() {
    return "arrayconcat";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList result = new ValueList();
    for(Value value : valueList) {
      if (value.isArray()) {
        result.addAll(value.toArray());
      } else {
        result.add(value);
      }
    }

    return Value.of(result);
  }

  @Override
  public boolean parameterCount(int count) {
    return count>=0;
  }
}
