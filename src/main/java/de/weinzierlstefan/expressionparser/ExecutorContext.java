package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.DefaultValueContainer;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueContainer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReference;

/**
 * A context-class for the {@link Executor}, which holds a map of functions and all variables,
 * which are needed during exalution of a {@link Expression}
 */
public class ExecutorContext {
  private final static AtomicReference<ExecutorContext> defaultExecutorContext = new AtomicReference<>(new ExecutorContext());
  private final ExecutorContext parentContext;
  private ValueContainer valueContainer = new DefaultValueContainer();
  private Map<String, Function> functionMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
  private Map<String, Object> optionMap = new HashMap<>();

  public ExecutorContext() {
    parentContext = null;
  }

  /**
   * Constructs a copy of an other {@link ExecutorContext}
   *
   * @param parentCtx
   */
  public ExecutorContext(ExecutorContext parentCtx) {
    this.parentContext = parentCtx;
  }

  public static ExecutorContext getDefault() {
    return defaultExecutorContext.get();
  }

  public static void setDefault(ExecutorContext defaultExecutorContext) {
    ExecutorContext.defaultExecutorContext.set(defaultExecutorContext);
  }

  /**
   * Searches for the Variable 'name' in the internal {@link ValueContainer}-List and returns its value or null.
   *
   * @param name
   * @return value or null
   */
  public Value getVariable(String name) {
    var value = valueContainer.get(name);

    if (value == null && parentContext != null) {
      value = parentContext.getVariable(name);
    }

    return value;
  }

  /**
   * Searches for a {@link Function} with a given name
   *
   * @param name
   * @return {@link Function} or null
   */
  public Function getFunction(String name) {
    Function function = functionMap.get(name);
    if (function == null && parentContext != null) {
      function = parentContext.getFunction(name);
    }
    return function;
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
   * @param functions
   */
  public void addFunctions(Collection<Function> functions) {
    functions.forEach(this::addFunction);
  }

  /**
   * Adds a {@link ValueContainer} to the list
   *
   * @param valueContainer
   */
  public void setValueContainer(ValueContainer valueContainer) {
    this.valueContainer = valueContainer;
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
   * Checks if a given variable exists in the internal lists
   *
   * @param name
   * @return true, if a variable with the given name is found
   */
  public boolean hasVariable(String name) {
    var has = valueContainer.has(name);
    if (!has && parentContext != null) {
      has = parentContext.hasVariable(name);
    }

    return has;
  }

  public Object getOption(String name) {
    Object option = optionMap.get(name);
    if (option == null && parentContext != null) {
      option = parentContext.getOption(name);
    }
    return option;
  }

  public void setOption(String name, Object value) {
    optionMap.put(name, value);
  }

  public ExecutorContext getParentContext() {
    return parentContext;
  }

  public void setVariable(String name, Value value) {
    valueContainer.set(name, value);
  }

  public void setVariable(String name, Object value) {
    valueContainer.set(name, Value.create(value));
  }
}
