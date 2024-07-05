package de.weinzierlstefan.expressionparser.executor;

import de.weinzierlstefan.expressionparser.Executor;
import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExecutorStats;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueLambda;

public class BoolOrExecutor implements Executor {
  private final Executor left;
  private final Executor right;

  public BoolOrExecutor(Executor left, Executor right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public Value exec(ExecutorContext ctx) throws ExpressionException {
    Value leftValue = left.exec(ctx);

    leftValue = ValueLambda.flat(leftValue, ctx);

    if (leftValue.getBoolean()) {
      return leftValue;
    }

    return right.exec(ctx);
  }

  @Override
  public ExecutorStats getExecutorStats() {
    ExecutorStats executorStats = left.getExecutorStats();
    executorStats.merge(right.getExecutorStats());
    return executorStats;
  }

  @Override
  public String toString() {
    return left + "||" + right;
  }
}
