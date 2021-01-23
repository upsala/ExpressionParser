package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.functions.array.ArrayFunctions;
import de.weinzierlstefan.expressionparser.functions.bit.BitFunctions;
import de.weinzierlstefan.expressionparser.functions.common.CommonFunctions;
import de.weinzierlstefan.expressionparser.functions.crypto.CryptoFunctions;
import de.weinzierlstefan.expressionparser.functions.datetime.DateTimeFunctions;
import de.weinzierlstefan.expressionparser.functions.math.MathFunctions;
import de.weinzierlstefan.expressionparser.functions.statistics.StatisticsFunctions;
import de.weinzierlstefan.expressionparser.functions.string.StringFunctions;
import de.weinzierlstefan.expressionparser.value.Value;

/**
 * Creates @ExpressionParser which contains all Functions
 */
public class DefaultExpressionParser extends ExpressionParser {
  public DefaultExpressionParser() {
    super();
    init();
  }

  private void init() {
    addFunctions(StringFunctions.getFunctions());
    addFunctions(MathFunctions.getFunctions());
    addFunctions(CommonFunctions.getFunctions());
    addFunctions(DateTimeFunctions.getFunctions());
    addFunctions(ArrayFunctions.getFunctions());
    addFunctions(CryptoFunctions.getFunctions());
    addFunctions(StatisticsFunctions.getFunctions());
    addFunctions(BitFunctions.getFunctions());

    setVariable("true", Value.of(true));
    setVariable("false", Value.of(false));
    setVariable("pi", Value.of(Math.PI));
    setVariable("e", Value.of(Math.E));
  }
}
