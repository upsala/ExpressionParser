package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueArray;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueString;

import java.util.regex.Pattern;

public class Split implements Function {
  @Override
  public String getName() {
    return "split";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.getString(0);
    String pattern = valueList.getString(1);

    int limit = -1;
    if (valueList.size() > 2) {
      if (!valueList.isNumber(2)) {
        throw new ExpressionException("Limit must be a number");
      }
      limit = valueList.getInt(2);
    }

    String[] result = str.split(Pattern.quote(pattern), limit);
    ValueList resultList = new ValueList();
    for (String s : result) {
      resultList.add(ValueString.of(s));
    }

    return ValueArray.of(resultList);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 2 || count == 3;
  }
}
