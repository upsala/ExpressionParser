package de.weinzierlstefan.expressionparser.executor;

import de.weinzierlstefan.expressionparser.Executor;
import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExecutorStats;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.*;

public class NegateExecutor implements Executor {
  private final Executor right;

  public NegateExecutor(Executor right) {
    this.right = right;
  }

  @Override
  public Value exec(ExecutorContext ctx) throws ExpressionException {
    Value rightValue = right.exec(ctx);

    if (rightValue.isNull()) {
      return ValueNull.INSTANCE;
    }

    if (rightValue.isDouble()) {
      return ValueDouble.of(-rightValue.getDouble());
    }

    if (rightValue.isLong()) {
      return ValueLong.of(-rightValue.getLong());
    }

    if (rightValue.isInt()) {
      return ValueInt.of(-rightValue.getInt());
    }

    throw new ExpressionException(
      String.format(
        "Negation of '%s' is not possible",
        rightValue.getType()
      )
    );
  }

  @Override
  public ExecutorStats getExecutorStats() {
    return right.getExecutorStats();
  }

  @Override
  public String toString() {
    return "-" + right;
  }
}
