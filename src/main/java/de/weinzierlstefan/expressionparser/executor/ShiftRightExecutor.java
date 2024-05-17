package de.weinzierlstefan.expressionparser.executor;

import de.weinzierlstefan.expressionparser.Executor;
import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueInt;
import de.weinzierlstefan.expressionparser.value.ValueLong;
import de.weinzierlstefan.expressionparser.value.ValueNull;

public class ShiftRightExecutor implements Executor {
  private final Executor left;
  private final Executor right;

  public ShiftRightExecutor(Executor left, Executor right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public Value exec(ExecutorContext ctx) throws ExpressionException {
    Value leftValue = left.exec(ctx);
    Value rightValue = right.exec(ctx);

    if (leftValue.isNull() || rightValue.isNull()) {
      return ValueNull.INSTANCE;
    }

    if (rightValue.isNumber()) {
      int shift = rightValue.getInt();

      if (leftValue.isLong()) {
        return ValueLong.of(leftValue.getLong() >> shift);
      }

      if (leftValue.isInt()) {
        return ValueInt.of(leftValue.getInt() >> shift);
      }
    }

    throw new ExpressionException(
      String.format(
        "Shift right of '%s' and '%s' is not possible",
        leftValue.getType(),
        rightValue.getType()
      )
    );
  }

  @Override
  public String toString() {
    return left + ">>" + right;
  }
}
