package de.weinzierlstefan.expressionparser.executor;

import de.weinzierlstefan.expressionparser.Executor;
import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExecutorStats;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.*;

public class ModuloExecutor implements Executor {
  private final Executor left;
  private final Executor right;

  public ModuloExecutor(Executor left, Executor right) {
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

    if (leftValue.isNumber() && rightValue.isNumber()) {
      if (leftValue.isDouble() || rightValue.isDouble()) {
        return ValueDouble.of(leftValue.getDouble() % rightValue.getDouble());
      }

      if (leftValue.isLong() || rightValue.isLong()) {
        return ValueLong.of(leftValue.getLong() % rightValue.getLong());
      }

      if (leftValue.isInt() || rightValue.isInt()) {
        return ValueInt.of(leftValue.getInt() % rightValue.getInt());
      }
    }

    throw new ExpressionException(
      String.format(
        "Modulo of '%s' and '%s' is not possible",
        leftValue.getType(),
        rightValue.getType()
      )
    );
  }

  @Override
  public ExecutorStats getExecutorStats() {
    ExecutorStats executorStats = left.getExecutorStats();
    executorStats.merge(right.getExecutorStats());
    return executorStats;
  }

  @Override
  public String toString() {
    return left + "%" + right;
  }
}
