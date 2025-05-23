package de.weinzierlstefan.expressionparser.executor;

import de.weinzierlstefan.expressionparser.Executor;
import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExecutorStats;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueArray;
import de.weinzierlstefan.expressionparser.value.ValueLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayExecutor implements Executor {
  private final List<Executor> executorList;

  public ArrayExecutor(List<Executor> executorList) {
    this.executorList = executorList;
  }

  @Override
  public Value exec(ExecutorContext ctx) throws ExpressionException {
    List<Value> valueList = new ArrayList<>();
    for (Executor executor : executorList) {
      valueList.add(
        ValueLambda.flat(
          executor.exec(ctx),
          ctx
        )
      );
    }

    return ValueArray.of(valueList);
  }

  @Override
  public ExecutorStats getExecutorStats() {
    ExecutorStats executorStats = new ExecutorStats();
    for(Executor executor : executorList) {
      executorStats.merge(executor.getExecutorStats());
    }
    return executorStats;
  }

  @Override
  public String toString() {
    return executorList
      .stream()
      .map(Object::toString)
      .collect(Collectors.joining(", ", "[", "]"));
  }
}
