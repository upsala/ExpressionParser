package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueContainer;

import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExecutorContext {
  public ExecutorContext() {
    this.mathContext = MathContext.DECIMAL64;
  }

  public ExecutorContext(ExecutorContext otherCtx) {
    this.mathContext = otherCtx.mathContext;
    this.valueContainerList.addAll(otherCtx.valueContainerList);
  }

  public MathContext getMathContext() {
    return mathContext;
  }

  public void setMathContext(MathContext mathContext) {
    this.mathContext = mathContext;
  }

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

  public void addValueContainer(ValueContainer valueContainer) {
    valueContainerList.add(valueContainer);
  }

  public void addValueContainers(Collection<ValueContainer> valueContainerList) {
    this.valueContainerList.addAll(valueContainerList);
  }

  private MathContext mathContext;

  private final List<ValueContainer> valueContainerList = new ArrayList<>();

}
