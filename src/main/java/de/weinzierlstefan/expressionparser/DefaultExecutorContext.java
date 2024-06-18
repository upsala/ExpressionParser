package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.functions.array.ArrayFunctions;
import de.weinzierlstefan.expressionparser.functions.bit.BitFunctions;
import de.weinzierlstefan.expressionparser.functions.common.CommonFunctions;
import de.weinzierlstefan.expressionparser.functions.crypto.CryptoFunctions;
import de.weinzierlstefan.expressionparser.functions.datetime.DateTimeFunctions;
import de.weinzierlstefan.expressionparser.functions.math.MathFunctions;
import de.weinzierlstefan.expressionparser.functions.object.ObjectFunctions;
import de.weinzierlstefan.expressionparser.functions.statistics.StatisticsFunctions;
import de.weinzierlstefan.expressionparser.functions.string.StringFunctions;
import de.weinzierlstefan.expressionparser.value.DefaultValueContainer;
import de.weinzierlstefan.expressionparser.value.ValueBoolean;
import de.weinzierlstefan.expressionparser.value.ValueDouble;

/**
 * A ExecutorContext, where all functions from this library are set
 */
public class DefaultExecutorContext extends ExecutorContext {
  public DefaultExecutorContext() {
    init();
  }

  public DefaultExecutorContext(ExecutorContext parentCtx) {
    super(parentCtx);
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
    addFunctions(ObjectFunctions.getFunctions());

    DefaultValueContainer container = new DefaultValueContainer();
    container.set("true", ValueBoolean.TRUE);
    container.set("false", ValueBoolean.FALSE);
    container.set("pi", ValueDouble.of(Math.PI));
    container.set("e", ValueDouble.of(Math.E));

    setValueContainer(container);
  }


}
