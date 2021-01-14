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
    if (!valueList.get(0).isNumber() || !valueList.get(1).isNumber()) {
      throw new ExpressionException("USG and OSG must be numbers");
    }
    ValueList list = valueList.get(2).toArray();

    // cp=(osg-usg)/(6*std)

    BigDecimal usg = valueList.get(0).toBigDecimal();
    BigDecimal osg = valueList.get(1).toBigDecimal();

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
