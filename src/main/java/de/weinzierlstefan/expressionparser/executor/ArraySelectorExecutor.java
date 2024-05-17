package de.weinzierlstefan.expressionparser.executor;


import de.weinzierlstefan.expressionparser.Executor;
import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 */
public class ArraySelectorExecutor implements Executor {
  private final Executor parent;

  // [1]  [1,2,3]  [1,2..5,7] //Ruby-Like
  private final List<Executor> executorList;

  public ArraySelectorExecutor(Executor parent, List<Executor> executorList) {
    this.parent = parent;
    this.executorList = executorList;
  }

  private static ValueString handleString(String string, List<Range> rangeList) {
    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < string.length(); i++) {
      if (inRange(ValueInt.of(i), rangeList)) {
        stringBuilder.append(string.charAt(i));
      }
    }

    return ValueString.of(stringBuilder);
  }

  private static boolean inRange(Value value, List<Range> rangeList) {
    return rangeList
      .stream()
      .anyMatch((range) -> {
        var fc = value.compareTo(range.from());
        var tc = value.compareTo(range.to());

        return (fc >= 0 && tc <= 0) || (fc <= 0 && tc >= 0);
      });
  }

  private static ValueObject handleMap(Map<Value, Value> map, List<Range> rangeList) {
    Map<Value, Value> resultMap = new HashMap<>();

    for (Value key : map.keySet()) {
      if (inRange(key, rangeList)) {
        resultMap.put(key, map.get(key));
      }
    }

    return ValueObject.of(resultMap);
  }

  private static ValueArray handleArray(ValueList array, List<Range> rangeList) {
    List<Value> resultList = new ArrayList<>();

    for (int i = 0; i < array.size(); i++) {
      if (inRange(ValueInt.of(i), rangeList)) {
        resultList.add(array.get(i));
      }
    }

    return ValueArray.of(resultList);
  }

  @Override
  public Value exec(ExecutorContext ctx) throws ExpressionException {
    Value parentValue = parent.exec(ctx);

    if (parentValue.isNull()) {
      return ValueNull.INSTANCE;
    }

    var rangeList = executorList
      .stream()
      .map((entry) -> {
        if (entry instanceof ArraySelectorEntryExecutor arraySelectorEntryExecutor) {
          var from = arraySelectorEntryExecutor.from().exec(ctx);
          return new Range(
            from,
            arraySelectorEntryExecutor.to() == null ? from : arraySelectorEntryExecutor.to().exec(ctx)
          );
        } else {
          throw new ExpressionException("Internal error");
        }
      })
      .toList();

    if (parentValue.isArray()) {
      return handleArray(parentValue.getArray(), rangeList);
    }
    if (parentValue.isObject()) {
      return handleMap(parentValue.getMap(), rangeList);
    }
    if (parentValue.isString()) {
      return handleString(parentValue.getString(), rangeList);
    }

    throw new ExpressionException(
      String.format(
        "Selection of '%s' not supported",
        parentValue.getType()
      )
    );
  }

  @Override
  public String toString() {
    return parent + executorList
      .stream()
      .map(Object::toString)
      .collect(Collectors.joining(",", "[", "]"));
  }

  private record Range(Value from, Value to) {
  }
}
