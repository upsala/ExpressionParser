package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueContainer;

import java.util.*;

/**
 * A context-class for the {@link Executor}, which holds a map of functions and all variables,
 * which are needed during exalution of a {@link Expression}
 */
public class ExecutorContext {
  private final List<ValueContainer> valueContainerList = new ArrayList<>();
  private Map<String, Function> functionMap = new HashMap<>();
  private Locale locale = Locale.getDefault();

  public ExecutorContext() {
  }

  /**
   * Constructs a copy of an other {@link ExecutorContext}
   *
   * @param otherCtx
   */
  public ExecutorContext(ExecutorContext otherCtx) {
    this.valueContainerList.addAll(otherCtx.valueContainerList);
    this.functionMap = new HashMap<>(otherCtx.functionMap);
    this.locale = otherCtx.getLocale();
  }

  /**
   * Searches for the Variable 'name' in the internal {@link ValueContainer}-List and returns its value or null.
   *
   * @param name
   * @return value or null
   */
  public Value getVariable(String name) {
    for (int i = valueContainerList.size() - 1; i >= 0; i--) {
      Value value = valueContainerList.get(i).get(name);
      if (value != null) {
        return value;
      }
    }

    return null;
  }

  /**
   * Searches for a {@link Function} with a given name
   *
   * @param name
   * @return {@link Function} or null
   */
  public Function getFunction(String name) {
    return functionMap.get(name);
  }

  /**
   * Adds a {@link Function} to the internal map
   *
   * @param function
   */
  public void addFunction(Function function) {
    functionMap.put(function.getName(), function);
  }

  /**
   * Adds a {@link ValueContainer} to the list
   *
   * @param valueContainer
   */
  public void addValueContainer(ValueContainer valueContainer) {
    valueContainerList.add(valueContainer);
  }

  /**
   * Adds a collection of {@link ValueContainer} to the list
   *
   * @param valueContainerList
   */
  public void addValueContainers(Collection<ValueContainer> valueContainerList) {
    this.valueContainerList.addAll(valueContainerList);
  }

  /**
   * Overwrites the interval function-map with the given map
   *
   * @param functionMap
   */
  public void setFunctionMap(Map<String, Function> functionMap) {
    this.functionMap = functionMap;
  }

  /**
   * Retrieves the current set {@link Locale} which is used for different string-functions
   *
   * @return
   */
  public Locale getLocale() {
    return locale;
  }

  /**
   * Sets a {@link Locale} for different String-Functions
   *
   * @param locale
   */
  public void setLocale(Locale locale) {
    this.locale = locale;
  }

  /**
   * Checks if a given variable exists in the internal lists
   *
   * @param name
   * @return true, if a variable with the given name is found
   */
  public boolean hasVariable(String name) {
    for (int i = valueContainerList.size() - 1; i >= 0; i--) {
      if (valueContainerList.get(i).has(name)) {
        return true;
      }
    }

    return false;
  }
}
