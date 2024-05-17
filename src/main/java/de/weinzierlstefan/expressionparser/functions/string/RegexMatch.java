package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueBoolean;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.util.regex.Pattern;

public class RegexMatch extends CommonRegexFunctions {

  @Override
  public String getName() {
    return "regexmatch";
  }

  @Override
  protected Value executeRegexFunction(String str, Pattern pattern, ValueList valueList) {
    return ValueBoolean.of(pattern.matcher(str).find());
  }

  @Override
  public boolean parameterCount(int count) {
    return count > 0;
  }
}
