package de.weinzierlstefan.expressionparser.executor;


import de.weinzierlstefan.expressionparser.Executor;
import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueBoolean;
import de.weinzierlstefan.expressionparser.value.ValueNull;

/**
 *
 */
public class CompNEExecutor implements Executor {
  private final Executor left;
  private final Executor right;

  /**
   *
   * @param left
   * @param right
   */
  public CompNEExecutor(Executor left, Executor right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public Value exec(ExecutorContext ctx) throws ExpressionException {
    Value valueLeft = left.exec(ctx);
    Value valueRight = right.exec(ctx);

    if (valueLeft.isNull() || valueRight.isNull()) {
      return ValueNull.INSTANCE;
    }

    return ValueBoolean.of(valueLeft.compareTo(valueRight) != 0);
  }

  @Override
  public String toString() {
    return left + "<>" + right;
  }
}
