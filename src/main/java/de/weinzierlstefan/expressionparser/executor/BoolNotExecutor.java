package de.weinzierlstefan.expressionparser.executor;

import de.weinzierlstefan.expressionparser.Executor;
import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExecutorStats;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueBoolean;
import de.weinzierlstefan.expressionparser.value.ValueNull;

public class BoolNotExecutor implements Executor {
  private final Executor child;

  public BoolNotExecutor(Executor child) {
    this.child = child;
  }

  @Override
  public Value exec(ExecutorContext ctx) throws ExpressionException {
    Value childValue = child.exec(ctx);

    if (childValue.isNull()) {
      return ValueNull.INSTANCE;
    }

    return ValueBoolean.of(!childValue.getBoolean());
  }

  @Override
  public ExecutorStats getExecutorStats() {
    return child.getExecutorStats();
  }

  @Override
  public String toString() {
    return "!" + child;
  }
}
