package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueArray;
import de.weinzierlstefan.expressionparser.value.ValueList;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.random.RandomGenerator;

public class ArraySample implements Function {

  @Override
  public String getName() {
    return "arraysample";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    ValueList list = valueList.getArray(0);

    int sampleSize = valueList.getInt(1);

    if (sampleSize<0) {
      throw new ExpressionException("Sample size must be greater than zero");
    }

    if (sampleSize>=list.size()) {
      return ValueArray.of(list);
    }

    RandomGenerator randomGenerator = RandomGenerator.getDefault();

    List<Integer> positionList = new ArrayList<>();
    for(int i=0; i<list.size(); i++) {
      positionList.add(i);
    }

    BitSet bitSet = new BitSet(valueList.size());
    int setBitCount = 0;
    while(setBitCount<sampleSize) {
      int pos = positionList.remove(randomGenerator.nextInt(positionList.size()));
      bitSet.set(pos);
      setBitCount++;
    }

    ValueList resultList = new ValueList(sampleSize);
    bitSet
      .stream()
      .forEach((i)->{
        resultList.add(list.get(i));
      });

    return ValueArray.of(resultList);
  }

  @Override
  public boolean parameterCount(int count) {
    return count==2;
  }
}
