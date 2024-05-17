package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueString;

import java.util.stream.Collectors;

public class ArrayJoin implements Function {
  @Override
  public String getName() {
    return "arrayjoin";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList list = valueList.getArray(0);
    if (list == null) {
      throw new ExpressionException("First parameter must be a array");
    }

    String separator = "";
    if (valueList.size()>1) {
      separator = valueList.getString(1);
    }

    return ValueString.of(
      list
        .stream()
        .map(Value::getString)
        .collect(Collectors.joining(separator))
      );
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1 || count == 2;
  }
}
