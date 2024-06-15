package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueInt;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TestExecutor {
  @Test
  public void testStats() throws ExpressionException {
    String txt = "(a+b-c*d/e%f)||(1<2>3<=4>=5!=6==7)&&f1()&&f1(1)&&f1(1,2)&&f2(1,2,3)^^WITH(3 AS c, WITH(8 AS a, 9 AS b, 10+b+c))+{11:12}+[13,14,15]+(17<<18>>19)+(16?20:21)";
    var executorStats = new ExpressionParser().parse(txt).getExecutorStats();

    Set<Value> refConstantSet = new HashSet<>();
    for(int i=1; i<=21; ++i) {
      refConstantSet.add(ValueInt.of(i));
    }

    Set<ExecutorStats.FunctionDefinition> refFunctionSet = new HashSet<>();
    refFunctionSet.add(new ExecutorStats.FunctionDefinition("f1", 0));
    refFunctionSet.add(new ExecutorStats.FunctionDefinition("f1", 2));
    refFunctionSet.add(new ExecutorStats.FunctionDefinition("f2", 3));
    refFunctionSet.add(new ExecutorStats.FunctionDefinition("f1", 1));

    assertEquals(refConstantSet, executorStats.getConstants());
    assertEquals(Set.of("a","b","c","d","e","f"), executorStats.getVariables());
    assertEquals(refFunctionSet, executorStats.getFunctionSet());
  }

}
