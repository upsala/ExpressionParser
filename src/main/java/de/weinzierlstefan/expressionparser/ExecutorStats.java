package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.Value;

import java.util.HashSet;
import java.util.Set;

public class ExecutorStats {
  private final Set<String> variableSet = new HashSet<>();
  private final Set<Value> constantSet = new HashSet<>();
  private final Set<FunctionDefinition> functionSet = new HashSet<>();

  public void merge(ExecutorStats other) {
    if (other!=null) {
      variableSet.addAll(other.variableSet);
      constantSet.addAll(other.constantSet);
      functionSet.addAll(other.functionSet);
    }
  }

  public void addFunction(String name, int parameterCount) {
    functionSet.add(new FunctionDefinition(name, parameterCount));
  }

  public void addConstant(Value value) {
    constantSet.add(value);
  }

  public void addVariable(String name) {
    variableSet.add(name);
  }

  public Set<Value> getConstants() {
    return constantSet;
  }

  public Set<String> getVariables() {
    return variableSet;
  }

  public Set<FunctionDefinition> getFunctionSet() {
    return functionSet;
  }

  public record FunctionDefinition(String name, int parameterCount) {}
}
