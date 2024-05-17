package de.weinzierlstefan.expressionparser.functions.statistics;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueDouble;
import de.weinzierlstefan.expressionparser.value.ValueList;

/**
 *
 */
public class Cp implements Function {
  @Override
  public String getName() {
    return "cp";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    if (!valueList.isNumber(0) || !valueList.isNumber(1)) {
      throw new ExpressionException("USG and OSG must be numbers");
    }
    ValueList list = valueList.getArray(2);

    // cp=(osg-usg)/(6*std)

    double usg = valueList.getDouble(0);
    double osg = valueList.getDouble(1);

    double std = StatisticTools.std(list);

    double diff = osg - usg;

    double cp = diff / (std * 6);

    return ValueDouble.of(cp);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 3;
  }

}
