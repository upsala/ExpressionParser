package de.weinzierlstefan.expressionparser.executor;

import de.weinzierlstefan.expressionparser.Executor;
import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;

/**
 *
 */
public class BoolAndExecutor implements Executor {
  private final Executor left;
  private final Executor right;

  /**
   *
   * @param left
   * @param right
   */
  public BoolAndExecutor(Executor left, Executor right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public Value exec(ExecutorContext ctx) throws ExpressionException {
    Value leftValue = left.exec(ctx);

    if (!leftValue.getBoolean()) {
      return leftValue;
    }

    return right.exec(ctx);
  }

  @Override
  public String toString() {
    return left + "&&" + right;
  }
}
