package de.weinzierlstefan.expressionparser.functions.statistics;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.math.BigDecimal;

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

    BigDecimal usg = valueList.getBigDecimal(0);
    BigDecimal osg = valueList.getBigDecimal(1);

    BigDecimal std = StatisticTools.std(list, executorContext);

    BigDecimal diff = osg.subtract(usg, executorContext.getMathContext());

    BigDecimal cp = diff.divide(std.multiply(BigDecimal.valueOf(6), executorContext.getMathContext()), executorContext.getMathContext());

    return Value.of(cp);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==3;
  }

}
