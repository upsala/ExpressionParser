package de.weinzierlstefan.expressionparser.executor;

import de.weinzierlstefan.expressionparser.Executor;
import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExecutorStats;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;

public class ValueExecutor implements Executor {
  private final Value value;

  public ValueExecutor(Value value) {
    this.value = value;
  }

  @Override
  public Value exec(ExecutorContext ctx) throws ExpressionException {
    return value;
  }

  @Override
  public ExecutorStats getExecutorStats() {
    ExecutorStats executorStats = new ExecutorStats();
    executorStats.addConstant(value);
    return executorStats;
  }

  @Override
  public String toString() {
    return value.toString();
  }
}
