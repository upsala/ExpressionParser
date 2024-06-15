package de.weinzierlstefan.expressionparser.executor;

import de.weinzierlstefan.expressionparser.Executor;
import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExecutorStats;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;

/**
 *
 * @param from
 * @param to
 */
public record ArraySelectorEntryExecutor(Executor from, Executor to) implements Executor {
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
    if (to == null) {
      return from.toString();
    }

    return from + ".." + to;
  }
}
