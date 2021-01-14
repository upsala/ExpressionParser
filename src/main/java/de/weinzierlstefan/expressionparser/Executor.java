package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.Value;

public interface Executor {
  Value exec(ExecutorContext ctx) throws ExpressionException;
}
