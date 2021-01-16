package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.util.StringJoiner;

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

    StringJoiner joiner = new StringJoiner(ws);
    for(int i=1; i<valueList.size(); ++i) {
      Value v = valueList.get(i);
      if (!v.isNull()) {
        joiner.add(v.toString());
      }
    }

    return Value.of(joiner.toString());
  }

  @Override
  public boolean parameterCount(int count) {
    return count>1;
  }

  @Override
  public boolean returnsNullOnNull() {
    return false;
  }
}
