package de.weinzierlstefan.expressionparser.executor;

import de.weinzierlstefan.expressionparser.*;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueLambda;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueNull;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class FunctionExecutor implements Executor {
  private final String name;
  private final List<Executor> executorList;

  public FunctionExecutor(String name, List<Executor> executorList) {
    this.name = name.toLowerCase(Locale.ROOT);
    this.executorList = executorList;
  }

  @Override
  public Value exec(ExecutorContext ctx) throws ExpressionException {
    Function func = ctx.getFunction(name);
    if (func == null) {
      throw new ExpressionException("Unknown function: " + name);
    }

    if (!func.parameterCount(executorList.size())) {
      throw new ExpressionException("Wrong parameter count for function: " + name);
    }

    ValueList valueList = executorList
      .stream()
      .map(e -> e.exec(ctx))
      .collect(Collectors.toCollection(ValueList::new));

    if (func.returnsNullOnNull() && valueList.anyNull()) {
      return ValueNull.INSTANCE;
    }

    if (!func.canHandleLambda() && valueList.anyLambda()) {
      valueList = valueList
        .stream()
        .map((v)->ValueLambda.flat(v, ctx))
        .collect(Collectors.toCollection(ValueList::new));
    }

    return func.execute(valueList, ctx);
  }

  @Override
  public ExecutorStats getExecutorStats() {
    ExecutorStats executorStats = new ExecutorStats();
    executorStats.addFunction(name, executorList.size());
    executorList.stream().map(Executor::getExecutorStats).forEach(executorStats::merge);
    return executorStats;
  }

  @Override
  public String toString() {
    return executorList
      .stream()
      .map(Object::toString)
      .collect(Collectors.joining(",", name + "(", ")"));
  }
}
