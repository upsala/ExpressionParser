package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.LRUCache;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

public class Split implements Function {
  @Override
  public String getName() {
    return "split";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.get(0).toString();
    String pattern = getPattern(valueList.get(1).toString());

    int limit=-1;
    if (valueList.size()>2) {
      if (!valueList.get(2).isNumber()) {
        throw new ExpressionException("Limit must be a number");
      }
      limit = (int)valueList.get(2).toLong();
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

  private String getPattern(String expr) {
    String pattern = patternCache.get(expr);
    if (pattern==null) {
      pattern = quotemeta(expr);
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

  private final LRUCache<String, String> patternCache = new LRUCache<>();
}
