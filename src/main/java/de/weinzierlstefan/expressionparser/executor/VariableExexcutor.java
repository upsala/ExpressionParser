package de.weinzierlstefan.expressionparser.executor;


import de.weinzierlstefan.expressionparser.Executor;
import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExecutorStats;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.value.Value;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VariableExexcutor implements Executor {
  private final static Pattern toStringPattern = Pattern.compile("[A-Z_][A-Z0-9_]*", Pattern.CASE_INSENSITIVE);
  private final String name;

  public VariableExexcutor(String name) {
    this.name = name;
  }

  @Override
  public Value exec(ExecutorContext ctx) throws ExpressionException {
    Value value = ctx.getVariable(name);

    if (value == null) {
      throw new ExpressionException("Variable not found: " + name);
    }

    return value;
  }

  @Override
  public ExecutorStats getExecutorStats() {
    ExecutorStats executorStats = new ExecutorStats();
    executorStats.addVariable(name);
    return executorStats;
  }

  @Override
  public String toString() {
    Matcher matcher = toStringPattern.matcher(name);
    return matcher.matches() ? name : "`" + name + "`";
  }
}
