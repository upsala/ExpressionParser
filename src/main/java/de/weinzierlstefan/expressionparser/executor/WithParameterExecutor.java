package de.weinzierlstefan.expressionparser.executor;

import de.weinzierlstefan.expressionparser.Executor;
import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExecutorStats;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;

public record WithParameterExecutor(String id, Executor executor) implements Executor {
  @Override
  public Value exec(ExecutorContext ctx) throws ExpressionException {
    throw new ExpressionException("Internal error");
  }

  @Override
  public ExecutorStats getExecutorStats() {
    return null;
  }

  @Override
  public String toString() {
    return executor + " AS " + id;
  }

  public String getId() {
    return id;
  }

  public Executor getExecutor() {
    return executor;
  }
}
