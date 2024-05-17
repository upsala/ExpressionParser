package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.tools.LRUCache;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.util.regex.Pattern;

abstract class CommonRegexFunctions implements Function {
  private final static int CACHE_SIZE = 100;
  private final static LRUCache<String, Pattern> cache = new LRUCache<>(CACHE_SIZE);

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.getString(0);
    String regex = valueList.getString(1);

    Pattern pattern = cache.get(regex);
    if (pattern == null) {
      pattern = Pattern.compile(regex);
      cache.put(regex, pattern);
    }

    return executeRegexFunction(str, pattern, valueList);
  }

  protected abstract Value executeRegexFunction(String str, Pattern pattern, ValueList valueList);
}
