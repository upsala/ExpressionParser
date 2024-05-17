package de.weinzierlstefan.expressionparser.executor;

import de.weinzierlstefan.expressionparser.Executor;
import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.*;

public class PowerExecutor implements Executor {
  private final Executor left;
  private final Executor right;

  public PowerExecutor(Executor left, Executor right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public Value exec(ExecutorContext ctx) throws ExpressionException {
    Value leftValue = left.exec(ctx);
    Value rightValue = right.exec(ctx);

    if (leftValue.isNull() || rightValue.isNull()) {
      return ValueNull.INSTANCE;
    }

    if (leftValue.isDouble() || rightValue.isDouble()) {
      return ValueDouble.of(Math.pow(leftValue.getDouble(), rightValue.getDouble()));
    }

    if (leftValue.isLong() || rightValue.isLong()) {
      return ValueLong.bistFitOf(Math.pow(leftValue.getLong(), rightValue.getLong()));
    }

    if (leftValue.isInt() || rightValue.isInt()) {
      return ValueInt.bistFitOf(Math.pow(leftValue.getInt(), rightValue.getInt()));
    }

    throw new ExpressionException(
      String.format(
        "Power of '%s' and '%s' is not possible",
        leftValue.getType(),
        rightValue.getType()
      )
    );
  }

  @Override
  public String toString() {
    return left + "**" + right;
  }
}
