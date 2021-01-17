package de.weinzierlstefan.expressionparser.functions.statistics;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.math.BigDecimal;

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

    BigDecimal usg = valueList.getBigDecimal(0);
    BigDecimal osg = valueList.getBigDecimal(1);

    BigDecimal avg = StatisticTools.mean(list, executorContext);
    BigDecimal std = StatisticTools.std(list, executorContext);

    BigDecimal usg1 = avg.subtract(usg, executorContext.getMathContext());
    BigDecimal osg1 = osg.subtract(avg, executorContext.getMathContext());

    BigDecimal min = usg1.min(osg1);

    BigDecimal cpk = min.divide(std.multiply(BigDecimal.valueOf(3), executorContext.getMathContext()), executorContext.getMathContext());

    return Value.of(cpk);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==3;
  }
}
