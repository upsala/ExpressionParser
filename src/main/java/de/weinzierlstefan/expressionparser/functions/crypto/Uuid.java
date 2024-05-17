package de.weinzierlstefan.expressionparser.functions.crypto;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueString;

import java.util.UUID;


public class Uuid implements Function {
  @Override
  public String getName() {
    return "uuid";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    UUID uuid = UUID.randomUUID();

    return ValueString.of(uuid.toString());
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 0;
  }
}
