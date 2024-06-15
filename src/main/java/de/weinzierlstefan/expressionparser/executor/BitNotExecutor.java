package de.weinzierlstefan.expressionparser.executor;

import de.weinzierlstefan.expressionparser.Executor;
import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExecutorStats;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueInt;
import de.weinzierlstefan.expressionparser.value.ValueLong;
import de.weinzierlstefan.expressionparser.value.ValueNull;

/**
 *
 */
public class BitNotExecutor implements Executor {
  private final Executor right;

  /**
   *
   * @param right
   */
  public BitNotExecutor(Executor right) {
    this.right = right;
  }

  @Override
  public Value exec(ExecutorContext ctx) throws ExpressionException {
    Value rightValue = right.exec(ctx);

    if (rightValue.isNull()) {
      return ValueNull.INSTANCE;
    }

    if (rightValue.isLong()) {
      return ValueLong.of(~rightValue.getLong());
    }
    if (rightValue.isInt()) {
      return ValueInt.of(~rightValue.getInt());
    }

    throw new ExpressionException("Value must be a number");
  }

  @Override
  public ExecutorStats getExecutorStats() {
    return right.getExecutorStats();
  }

  @Override
  public String toString() {
    return "~" + right;
  }
}
