package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

/**
 * Base-Interface for all functions
 */
public interface Function {
  /**
   * The name of the function. It should not be changed.
   * @return
   */
  String getName();

  /**
   * Executes this function and returns a @Value
   * @param valueList
   * @param executorContext
   * @return
   * @throws ExpressionException
   */
  Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException;

  /**
   * Returns true if the provided parameter-count maches the requirements
   * execute will only be called, if this function returns true.
   * @param count
   * @return
   */
  boolean parameterCount(int count);

  /**
   * If this method returns true, the execute will only be called, if all given values are not null
   * @return
   */
  default boolean returnsNullOnNull() { return true; }
}
