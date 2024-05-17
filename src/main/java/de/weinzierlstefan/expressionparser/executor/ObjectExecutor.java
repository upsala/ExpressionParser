package de.weinzierlstefan.expressionparser.executor;

import de.weinzierlstefan.expressionparser.Executor;
import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectExecutor implements Executor {
  private final List<Executor> executorList;

  public ObjectExecutor(List<Executor> executorList) {
    this.executorList = executorList;
  }

  @Override
  public Value exec(ExecutorContext ctx) throws ExpressionException {
    Map<Value, Value> valueMap = new HashMap<>();

    for (Executor executor : executorList) {
      if (executor instanceof ObjectEntryExecutor objectEntryExecutor) {
        Value key = objectEntryExecutor.key().exec(ctx);
        Value value = objectEntryExecutor.value().exec(ctx);
        valueMap.put(key, value);
      } else {
        throw new ExpressionException("Object executor does not implement " + executor.getClass().getName());
      }
    }

    return ValueObject.of(valueMap);
  }
}
