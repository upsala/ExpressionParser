package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFind implements Function {
  @Override
  public String getName() {
    return "regexfind";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.getString(0);
    String regex = valueList.getString(1);

    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(str);
    if (m.find()) {
      return Value.of(m.group());
    }

    return Value.of("");
  }

  @Override
  public boolean parameterCount(int count) {
    return count>0;
  }
}
