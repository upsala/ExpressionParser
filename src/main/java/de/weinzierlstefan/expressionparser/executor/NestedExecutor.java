package de.weinzierlstefan.expressionparser.executor;

import de.weinzierlstefan.expressionparser.Executor;
import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;

public class NestedExecutor implements Executor {
  private final Executor child;

  public NestedExecutor(Executor child) {
    this.child = child;
  }

  @Override
  public Value exec(ExecutorContext ctx) throws ExpressionException {
    return child.exec(ctx);
  }

  @Override
  public String toString() {
    return "(" + child + ")";
  }
}
