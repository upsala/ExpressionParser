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
public class Cpk implements Function {
  @Override
  public String getName() {
    return "cpk";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    if (!valueList.isNumber(0) || !valueList.isNumber(1)) {
      throw new ExpressionException("USG and OSG must be numbers");
    }
    ValueList list = valueList.getArray(2);

    // cpk=min(avg-usg,osg-avg)/(3*std)

    double usg = valueList.getDouble(0);
    double osg = valueList.getDouble(1);

    double avg = StatisticTools.mean(list);
    double std = StatisticTools.std(list);

    double usg1 = avg - usg;
    double osg1 = osg - avg;

    double min = Math.min(usg1, osg1);

    double cpk = min / (std * 3);

    return ValueDouble.of(cpk);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 3;
  }
}
