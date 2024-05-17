package de.weinzierlstefan.expressionparser.functions.statistics;

import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;

class StatisticTools {

  static double sum(ValueList list) throws ExpressionException {
    double sum = 0;
    for (Value value : list) {
      if (!value.isNumber()) {
        throw new ExpressionException("Values must be numbers");
      }
      sum = sum + value.getDouble();
    }

    return sum;
  }

  static double mean(ValueList list) throws ExpressionException {

    double sum = StatisticTools.sum(list);

    return sum / list.size();
  }

  static double std(ValueList list) throws ExpressionException {
    double var = StatisticTools.var(list);

    return Math.sqrt(var);
  }

  static double var(ValueList list) throws ExpressionException {
    double avg = StatisticTools.mean(list);

    double sum = 0;

    for (Value value : list) {
      sum += Math.pow(value.getDouble() - avg, 2);
    }

    return sum / list.size();
  }
}
