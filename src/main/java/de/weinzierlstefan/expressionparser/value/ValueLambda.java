package de.weinzierlstefan.expressionparser.value;

import de.weinzierlstefan.expressionparser.Executor;
import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;

import java.util.List;
import java.util.stream.Collectors;

public class ValueLambda extends Value {

  private final Executor executor;
  private final List<String> parameter;
  private final static ValueList EMPTY_LIST = new ValueList();

  public ValueLambda(Executor executor, List<String> parameter) {
    this.executor = executor;
    this.parameter = parameter;
  }

  public static Value flat(Value value, ExecutorContext ctx) {
    while (value.isLambda()) {
      value = ((ValueLambda)value).exec(EMPTY_LIST, ctx);
    }
    return value;
  }

  @Override
  public String getType() {
    return "lambda";
  }

  @Override
  public Object get() {
    return null;
  }

  public Executor getExecutor() {
    return executor;
  }

  public List<String> getParameter() {
    return parameter;
  }

  public Value exec(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ExecutorContext subContext = new ExecutorContext(executorContext);
    for(int i=0; i<parameter.size(); i++) {
      String name = parameter.get(i);
      Value value = i<valueList.size() ? valueList.get(i) : ValueNull.INSTANCE;
      subContext.setVariable(name, value);
    }

    return executor.exec(subContext);
  }

  @Override
  public String toString() {
    return "("+parameter.stream().collect(Collectors.joining(","))+")->"+executor.toString();
  }

  @Override
  public boolean isLambda() {
    return true;
  }
}
