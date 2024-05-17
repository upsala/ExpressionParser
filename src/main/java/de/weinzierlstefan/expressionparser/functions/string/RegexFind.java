package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueString;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFind extends CommonRegexFunctions {
  @Override
  public String getName() {
    return "regexfind";
  }

  @Override
  protected Value executeRegexFunction(String str, Pattern pattern, ValueList valueList) {
    Matcher matcher = pattern.matcher(str);
    return matcher.find() ? ValueString.of(matcher.group()) : ValueString.EMPTY;
  }

  @Override
  public boolean parameterCount(int count) {
    return count > 0;
  }
}
