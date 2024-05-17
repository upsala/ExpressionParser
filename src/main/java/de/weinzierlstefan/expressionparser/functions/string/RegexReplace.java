package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueString;

import java.util.regex.Pattern;

public class RegexReplace extends CommonRegexFunctions {
  @Override
  public String getName() {
    return "regexreplace";
  }

  @Override
  protected Value executeRegexFunction(String str, Pattern pattern, ValueList valueList) {
    String newValue = valueList.getString(2);

    return ValueString.of(pattern.matcher(str).replaceAll(newValue));
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 3;
  }
}
