package de.weinzierlstefan.expressionparser.functions.statistics;

import de.weinzierlstefan.expressionparser.Function;

import java.util.ArrayList;
import java.util.Collection;

public class StatisticsFunctions {
  public static Collection<Function> getFunctions() {
    Collection<Function> functionCollection = new ArrayList<>();

    functionCollection.add(new Cp());
    functionCollection.add(new Cpk());
    functionCollection.add(new Kurtosis());
    functionCollection.add(new Mean());
    functionCollection.add(new Mode());
    functionCollection.add(new Percentile());
    functionCollection.add(new Range());
    functionCollection.add(new Skewness());
    functionCollection.add(new Std());
    functionCollection.add(new Sum());
    functionCollection.add(new Var());

    return functionCollection;
  }
}
