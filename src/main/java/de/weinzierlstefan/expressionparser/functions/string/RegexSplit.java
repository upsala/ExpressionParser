package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class RegexSplit implements Function {
  @Override
  public String getName() {
    return "regexsplit";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.getString(0);
    String pattern = valueList.getString(1);

    int limit=-1;
    if (valueList.size()>2) {
      if (!valueList.isNumber(2)) {
        throw new ExpressionException("Limit must be a number");
      }
      limit = (int)valueList.getLong(2);
    }

    String[] result = str.split(pattern, limit);
    ValueList resultList = new ValueList(result.length);
    for (String s : result) {
      resultList.add(Value.of(s));
    }

    return Value.of(resultList);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==2 || count==3;
  }
}
