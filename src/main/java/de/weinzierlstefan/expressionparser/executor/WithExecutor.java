package de.weinzierlstefan.expressionparser.executor;

import de.weinzierlstefan.expressionparser.Executor;
import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExecutorStats;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.DefaultValueContainer;
import de.weinzierlstefan.expressionparser.value.Value;

import java.util.List;
import java.util.StringJoiner;

public class WithExecutor implements Executor {
  private final List<WithParameterExecutor> parameterList;
  private final Executor executor;

  public WithExecutor(List<WithParameterExecutor> parameterList, Executor executor) {
    this.parameterList = parameterList;
    this.executor = executor;
  }

  @Override
  public Value exec(ExecutorContext ctx) throws ExpressionException {
    ExecutorContext childContext = new ExecutorContext(ctx);
    DefaultValueContainer valueContainer = new DefaultValueContainer();

    parameterList.forEach((e) -> {
      Value value = e.getExecutor().exec(ctx);
      valueContainer.set(e.getId(), value);
    });

    childContext.addValueContainer(valueContainer);

    return executor.exec(childContext);
  }

  @Override
  public ExecutorStats getExecutorStats() {
    ExecutorStats executorStats = executor.getExecutorStats();
    parameterList.forEach((e) -> {
      executorStats.merge(e.getExecutor().getExecutorStats());
    });
    return executorStats;
  }

  @Override
  public String toString() {
    StringJoiner joiner = new StringJoiner(", ", "WITH(", ")");
    parameterList.forEach((e) -> joiner.add(e.toString()));

    joiner.add(executor.toString());

    return joiner.toString();
  }
}
