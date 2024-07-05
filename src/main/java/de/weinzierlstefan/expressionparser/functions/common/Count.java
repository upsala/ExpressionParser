package de.weinzierlstefan.expressionparser.functions.common;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.*;

import java.util.Map;

/**
 *
 */
public class Count implements Function {
  @Override
  public String getName() {
    return "count";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    Value value = valueList.get(0);

    if (valueList.size()>=2) {
      if (!valueList.isLambda(1)) {
        throw new ExpressionException("Count function expects a single lambda argument");
      }

      ValueLambda lambda = (ValueLambda)valueList.get(1);
      int count = 0;

      if (value.isArray()) {
        ValueList array = value.getArray();
        for(int i=0; i<array.size(); i++) {
          ValueList list = new ValueList();
          list.add(array.get(i));
          list.add(ValueInt.of(i));
          list.add(ValueArray.of(array));
          if (lambda.exec(list, executorContext).getBoolean()) {
            count++;
          }
        }
        return ValueInt.of(count);
      }

      if (value.isObject()) {
        Map<Value, Value> object = value.getMap();
        for(Map.Entry<Value, Value> entry : object.entrySet()) {
          ValueList list = new ValueList();
          list.add(entry.getValue());
          list.add(entry.getKey());
          list.add(ValueObject.of(object));
          if (lambda.exec(list, executorContext).getBoolean()) {
            count++;
          }
        }
      }

      if (value.isString()) {
        String string = value.getString();
        for(int i=0; i<string.length(); i++) {
          ValueList list = new ValueList();
          list.add(ValueString.of(string.substring(i, i+1)));
          list.add(ValueInt.of(i));
          list.add(ValueString.of(string));
          if (lambda.exec(list, executorContext).getBoolean()) {
            count++;
          }
        }
      }

    }

    if (value.isNull()) {
      return ValueInt.ZERO;
    }
    if (value.isArray()) {
      return ValueInt.of(value.getArray().size());
    }
    if (value.isObject()) {
      return ValueInt.of(value.getMap().size());
    }
    if (value.isString()) {
      return ValueInt.of(value.getString().length());
    }

    return ValueInt.of(1);
  }

  @Override
  public boolean parameterCount(int count) {
    return count ==1 || count==2;
  }

  @Override
  public boolean returnsNullOnNull() {
    return false;
  }

  @Override
  public boolean canHandleLambda() {
    return true;
  }
}
