package de.weinzierlstefan.expressionparser.executor;

import de.weinzierlstefan.expressionparser.Executor;
import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;

public record ObjectEntryExecutor(Executor key, Executor value) implements Executor {

  @Override
  public Value exec(ExecutorContext ctx) throws ExpressionException {
    throw new ExpressionException("Internal error");
  }

  @Override
  public String toString() {
    return key + ":" + value;
  }
}
