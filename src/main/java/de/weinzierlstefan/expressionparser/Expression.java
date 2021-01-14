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
   * Evaluates the expression and returns a Value
   * @return Value
   * @throws ExpressionException
   */
  public Value eval(ExecutorContext ctx) throws ExpressionException {
    return executor.exec(ctx);
  }

  /**
   * Adds a @Value as variable, which has a higher priority than the Variables from the @ExpressionParser
   * @param name
   * @param value
   */
  public void setVariable(String name, Value value) {
    defaultValueContainer.set(name, value);
  }

  /**
   * Adds a @VariableHolder, which has a higher priority than the @VariableHolder from the @ExpressionParser
   * @param valueContainer
   */
  public void addValueContainer(ValueContainer valueContainer) {
    executorContext.addValueContainer(valueContainer);
  }

  private final Executor executor;
  private final ExecutorContext executorContext;
  private final DefaultValueContainer defaultValueContainer = new DefaultValueContainer();
}
