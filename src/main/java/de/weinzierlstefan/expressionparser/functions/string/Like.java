package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.*;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.util.regex.Pattern;

public class Like implements Function {
  @Override
  public String getName() {
    return "like";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.get(0).toString();
    String pattern = valueList.get(1).toString();

    Pattern p = getPattern(pattern);

    return Value.of(p.matcher(str).matches());
  }

  @Override
  public boolean parameterCount(int count) {
    return count>0;
  }

  private Pattern getPattern(String expr) {
    Pattern pattern = patternCache.get(expr);
    if (pattern==null) {
      String regex = quotemeta(expr);
      regex = regex.replace("_", ".").replace("%", ".*?");
      pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    }
    patternCache.put(expr, pattern);

    return pattern;
  }

  private String quotemeta(String s) {
    if (s == null) {
      throw new IllegalArgumentException("String cannot be null");
    }

    int len = s.length();
    if (len == 0) {
      return "";
    }

    StringBuilder sb = new StringBuilder(len * 2);
    for (int i = 0; i < len; i++) {
      char c = s.charAt(i);
      if ("[](){}.*+?$^|#\\".indexOf(c) != -1) {
        sb.append("\\");
      }
      sb.append(c);
    }
    return sb.toString();
  }

  private final LRUCache<String, Pattern> patternCache = new LRUCache<>();
}
