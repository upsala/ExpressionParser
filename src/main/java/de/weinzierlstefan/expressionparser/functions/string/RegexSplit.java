package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueArray;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueString;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegexSplit extends CommonRegexFunctions {

  @Override
  public String getName() {
    return "regexsplit";
  }

  @Override
  protected Value executeRegexFunction(String str, Pattern pattern, ValueList valueList) {
    int limit = -1;
    if (valueList.size() > 2) {
      if (!valueList.isNumber(2)) {
        throw new ExpressionException("Limit must be a number");
      }
      limit = valueList.getInt(2);
    }

    return ValueArray.of(
      Arrays
        .stream(pattern.split(str, limit))
        .map(ValueString::of)
        .collect(Collectors.toCollection(ValueList::new))
    );
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 2 || count == 3;
  }
}
