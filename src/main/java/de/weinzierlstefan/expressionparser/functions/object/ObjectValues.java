package de.weinzierlstefan.expressionparser.functions.object;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueArray;
import de.weinzierlstefan.expressionparser.value.ValueList;


public class ObjectValues implements Function {
  @Override
  public String getName() {
    return "objectvalues";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value objValue = valueList.get(0);
    if (!objValue.isObject()) {
      throw new ExpressionException("Value must be a object");
    }

    return ValueArray.of(
      new ValueList(
        objValue
          .getMap()
          .values()
      )
    );
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
