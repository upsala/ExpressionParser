package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class ArrayJoin implements Function {
  @Override
  public String getName() {
    return "arrayjoin";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList list = valueList.get(0).toArray();
    if (list==null) {
      throw new ExpressionException("First parameter must be a array");
    }

    StringBuilder builder = new StringBuilder();
    boolean first = true;
    for(Value value : list) {
      if (!first && valueList.size()>1) {
        builder.append(valueList.get(1).toString());
      }
      first = false;
      builder.append(value.toString());
    }

    return Value.of(builder.toString());
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1 || count==2;
  }
}
