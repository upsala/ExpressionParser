package de.weinzierlstefan.expressionparser.executor;

import de.weinzierlstefan.expressionparser.Executor;
import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueBoolean;

public class BoolXorExecutor implements Executor {
  private final Executor left;
  private final Executor right;

  public BoolXorExecutor(Executor left, Executor right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public Value exec(ExecutorContext ctx) throws ExpressionException {
    Value leftValue = left.exec(ctx);
    Value rightValue = right.exec(ctx);

    return ValueBoolean.of(leftValue.getBoolean() != rightValue.getBoolean());
  }

  @Override
  public String toString() {
    return left + "^^" + right;
  }
}
