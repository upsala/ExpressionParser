package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.tools.LRUCache;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueBoolean;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.util.regex.Pattern;

public class Like implements Function {
  private static final LRUCache<String, Pattern> patternCache = new LRUCache<>();

  @Override
  public String getName() {
    return "like";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.getString(0);
    String pattern = valueList.getString(1);

    Pattern p = getPattern(pattern);

    return ValueBoolean.of(p.matcher(str).matches());
  }

  @Override
  public boolean parameterCount(int count) {
    return count > 0;
  }

  private static Pattern getPattern(String expr) {
    Pattern pattern = patternCache.get(expr);
    if (pattern == null) {
      String regex = quotemeta(expr);
      regex = regex.replaceAll("_", ".").replaceAll("%", ".*?");
      pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    }
    patternCache.put(expr, pattern);

    return pattern;
  }

  private static String quotemeta(String s) {
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
}
