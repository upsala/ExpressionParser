package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatch implements Function {
  @Override
  public String getName() {
    return "regexmatch";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.get(0).toString();
    String regex = valueList.get(1).toString();

    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(str);
    boolean b = m.find();

    return Value.of(b);
  }

  @Override
  public boolean parameterCount(int count) {
    return count>0;
  }
}
