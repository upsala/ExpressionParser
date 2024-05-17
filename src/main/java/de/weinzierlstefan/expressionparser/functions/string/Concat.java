package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueString;

import java.util.stream.Collectors;


/**
 * Treat all Values as Strings and concatenate them together.
 */
public class Concat implements Function {
  @Override
  public String getName() {
    return "concat";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    return ValueString.of(
      valueList
        .stream()
        .filter(v -> !v.isNull())
        .map(Value::getString)
        .collect(Collectors.joining())
    );
  }

  @Override
  public boolean parameterCount(int count) {
    return true;
  }

  @Override
  public boolean returnsNullOnNull() {
    return false;
  }
}
