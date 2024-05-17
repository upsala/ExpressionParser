package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueString;

import java.util.stream.Collectors;


/**
 * Treat all Values as Strings and concatenate them together. The first value is used as separator
 */
public class ConcatWs implements Function {
  @Override
  public String getName() {
    return "concatws";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String ws = valueList.getString(0);

    return ValueString.of(
      valueList
        .stream()
        .skip(1)
        .filter(v -> !v.isNull())
        .map(Value::getString)
        .collect(Collectors.joining(ws))
    );
  }

  @Override
  public boolean parameterCount(int count) {
    return count > 1;
  }

  @Override
  public boolean returnsNullOnNull() {
    return false;
  }
}
