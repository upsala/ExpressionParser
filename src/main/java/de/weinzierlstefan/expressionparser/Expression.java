package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueLambda;
import de.weinzierlstefan.expressionparser.value.ValueList;

/**
 *
 */
public class Expression {
  private final Executor executor;
  private ExecutorContext executorContext;

  Expression(Executor executor, ExecutorContext executorContext) {
    this.executor = executor;
    this.executorContext = executorContext;
  }

  /**
   * Sets a {@link ExecutorContext}, so it must not be used in eval.
   * @param executorContext
   */
  public void setExecutorContext(ExecutorContext executorContext) {
    this.executorContext = executorContext;
  }

  /**
   * Evaluates the expression and returns a Value
   *
   * @return Value
   * @throws ExpressionException
   */
  public Value eval() throws ExpressionException {
    return eval(null);
  }

  /**
   * Evaluates the expression and returns a {@link Value}, but uses the given {@link ExecutorContext} instead of the previous set context
   *
   * @return Value
   * @throws ExpressionException
   */
  public Value eval(ExecutorContext ctx) throws ExpressionException {
    if (ctx==null) {
      ctx = executorContext;
    }
    if (ctx==null) {
      ctx = ExecutorContext.getDefault();
    }

    var result = executor.exec(ctx);
    return ValueLambda.flat(result, ctx);
  }

  @Override
  public String toString() {
    return executor.toString();
  }

  /**
   * Returns {@link ExecutorStats} for this expression
   * @return
   */
  public ExecutorStats getExecutorStats() {
    return executor.getExecutorStats();
  }
}
