package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueContainer;

import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A context-class for the {@link Executor}, which holds the {@link MathContext} and all variables,
 * which are needed during exalution of a {@link Expression}
 */
public class ExecutorContext {
  public ExecutorContext() {
    this.mathContext = MathContext.DECIMAL64;
  }

  /**
   * Constructs a copy of an other {@link ExecutorContext}
   * @param otherCtx
   */
  public ExecutorContext(ExecutorContext otherCtx) {
    this.mathContext = otherCtx.mathContext;
    this.valueContainerList.addAll(otherCtx.valueContainerList);
  }

  /**
   * Gets the {@link MathContext}
   * @return
   */
  public MathContext getMathContext() {
    return mathContext;
  }

  /**
   * Sets the {@link MathContext}
   * @param mathContext
   */
  public void setMathContext(MathContext mathContext) {
    this.mathContext = mathContext;
  }

  /**
   * Searches for the Variable 'name' in the internal {@link ValueContainer}-List and returns its value or null.
   * @param name
   * @return
   */
  public Value getVariable(String name) {
    name = name.toLowerCase();
    for(int i = valueContainerList.size()-1; i>=0; i--) {
      Value value = valueContainerList.get(i).get(name);
      if (value!=null) {
        return value;
      }
    }

    return null;
  }

  /**
   * Adds a {@link ValueContainer} to the list
   * @param valueContainer
   */
  public void addValueContainer(ValueContainer valueContainer) {
    valueContainerList.add(valueContainer);
  }

  /**
   * Adds a collection of {@link ValueContainer} to the list
   * @param valueContainerList
   */
  public void addValueContainers(Collection<ValueContainer> valueContainerList) {
    this.valueContainerList.addAll(valueContainerList);
  }

  private MathContext mathContext;

  private final List<ValueContainer> valueContainerList = new ArrayList<>();

}
