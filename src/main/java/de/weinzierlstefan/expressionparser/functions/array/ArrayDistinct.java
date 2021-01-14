package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class ArrayDistinct implements Function {
  @Override
  public String getName() {
    return "arraydistinct";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {


    ValueList resultList = new ValueList();

    for(Value value : valueList.get(0).toArray()) {
      if (!resultList.contains(value)) {
        resultList.add(value);
      }
    }


    //resultList.addAll(valueList.get(0).toArray().stream().distinct().collect(Collectors.toList()));

    return Value.of(resultList);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==1;
  }
}
