package de.weinzierlstefan.expressionparser.executor;

import de.weinzierlstefan.expressionparser.Executor;
import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExecutorStats;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.*;

public class BitXorExecutor implements Executor {
  private final Executor left;
  private final Executor right;

  public BitXorExecutor(Executor left, Executor right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public Value exec(ExecutorContext ctx) throws ExpressionException {
    Value leftValue = left.exec(ctx);
    Value rightValue = right.exec(ctx);

    leftValue = ValueLambda.flat(leftValue, ctx);
    rightValue = ValueLambda.flat(rightValue, ctx);

    if (leftValue.isNull() || rightValue.isNull()) {
      return ValueNull.INSTANCE;
    }

    if (leftValue.isLong() || rightValue.isLong()) {
      return ValueLong.of(leftValue.getLong() ^ rightValue.getLong());
    }

    if (leftValue.isInt() || rightValue.isInt()) {
      return ValueInt.of(leftValue.getInt() ^ rightValue.getInt());
    }

    if (leftValue.isBoolean() || rightValue.isBoolean()) {
      return ValueBoolean.of(leftValue.getBoolean() ^ rightValue.getBoolean());
    }

    throw new ExpressionException("Values must be numbers");
  }

  @Override
  public ExecutorStats getExecutorStats() {
    ExecutorStats executorStats = left.getExecutorStats();
    executorStats.merge(right.getExecutorStats());
    return executorStats;
  }

  @Override
  public String toString() {
    return left + "^" + right;
  }
}
