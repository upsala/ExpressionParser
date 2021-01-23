package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.Value;

interface Executor {
  Value exec(ExecutorContext ctx) throws ExpressionException;
}
