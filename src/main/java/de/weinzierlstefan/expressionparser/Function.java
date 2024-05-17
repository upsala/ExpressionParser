package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

/**
 * Base-Interface for all functions
 */
public interface Function {
  /**
   * The name of the function. It should not be changed.
   *
   * @return the name of the function
   */
  String getName();

  /**
   * Executes this function and returns a {@link Value}
   *
   * @param valueList the parameters for executing the function
   * @param executorContext the context for executing the function
   * @return {@link Value}
   * @throws ExpressionException
   */
  Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException;

  /**
   * Returns true if the provided parameter-count maches the requirements
   * execute will only be called, if this function returns true.
   *
   * @param count
   * @return
   */
  boolean parameterCount(int count);

  /**
   * If this method returns true, {@link #execute(ValueList, ExecutorContext)} will only be called, if all given values are not null
   *
   * @return
   */
  default boolean returnsNullOnNull() {
    return true;
  }
}
