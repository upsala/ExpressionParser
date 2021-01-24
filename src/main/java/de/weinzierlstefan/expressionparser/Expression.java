package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueContainer;

/**
 *
 */
public class Expression {
  Expression(Executor executor, ExecutorContext ctx) {
    this.executor = executor;
    this.executorContext = new ExecutorContext(ctx);
    this.executorContext.addValueContainer(defaultValueContainer);
  }

  /**
   * Evaluates the expression and returns a Value
   * @return Value
   * @throws ExpressionException
   */
  public Value eval() throws ExpressionException {
    return executor.exec(executorContext);
  }

  /**
   * Evaluates the expression and returns a {@link Value}
   * @return Value
   * @throws ExpressionException
   */
  public Value eval(ExecutorContext ctx) throws ExpressionException {
    return executor.exec(ctx);
  }

  /**
   * Adds a {@link Value} as variable, which has a higher priority than the Variables from the {@link ExpressionParser}
   * @param name
   * @param value
   */
  public void setVariable(String name, Value value) {
    defaultValueContainer.set(name, value);
  }

  /**
   * Adds a {@link ValueContainer}, which has a higher priority than the {@link ValueContainer} from the {@link ExpressionParser}
   * @param valueContainer
   */
  public void addValueContainer(ValueContainer valueContainer) {
    executorContext.addValueContainer(valueContainer);
  }

  private final Executor executor;
  private final ExecutorContext executorContext;
  private final DefaultValueContainer defaultValueContainer = new DefaultValueContainer();
}
