package de.weinzierlstefan.expressionparser.executor;

import de.weinzierlstefan.expressionparser.Executor;
import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExecutorStats;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueLambda;

public class TernaryExecutor implements Executor {
  private final Executor condition;
  private final Executor exec1;
  private final Executor exec2;

  public TernaryExecutor(Executor condition, Executor exec1, Executor exec2) {
    this.condition = condition;
    this.exec1 = exec1;
    this.exec2 = exec2;
  }

  @Override
  public Value exec(ExecutorContext ctx) throws ExpressionException {
    Value conditionValue = condition.exec(ctx);

    conditionValue = ValueLambda.flat(conditionValue, ctx);

    if (conditionValue.getBoolean()) {
      if (exec1 == null) { //Emulates elvis-operator
        return conditionValue;
      }
      return exec1.exec(ctx);
    } else {
      return exec2.exec(ctx);
    }
  }

  @Override
  public ExecutorStats getExecutorStats() {
    ExecutorStats executorStats = condition.getExecutorStats();
    executorStats.merge(exec1.getExecutorStats());
    executorStats.merge(exec2.getExecutorStats());
    return executorStats;
  }

  @Override
  public String toString() {
    return condition + "?" + (exec1 == null ? "" : exec1) + ":" + exec2;
  }
}
