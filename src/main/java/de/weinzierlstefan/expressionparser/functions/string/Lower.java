package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueString;

import java.util.Locale;

/**
 * Returns the string, where all characters are translated to lower-case.
 */
public class Lower implements Function {
  @Override
  public String getName() {
    return "lower";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.getString(0);

    Locale locale = Locale.ROOT;
    if (executorContext.getOption("locale") instanceof Locale l) {
      locale = l;
    }

    return ValueString.of(str.toLowerCase(locale));
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
