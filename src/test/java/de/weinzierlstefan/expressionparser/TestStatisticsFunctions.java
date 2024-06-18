package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.Value;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStatisticsFunctions {
  private Value parse(String expression) {
    ExecutorContext context = new DefaultExecutorContext();
    return ExpressionParser.parse(expression, context).eval();
  }

  private Value parse(String expression, ExecutorContext context) {
    return ExpressionParser.parse(expression, context).eval();
  }

  @Test
  public void testCp() throws ExpressionException {
    assertEquals("0.40825", parse("round(cp(1,3,[1,2,3]),5)").toString());
  }

  @Test
  public void testCpk() throws ExpressionException {
    assertEquals("0.40825", parse("round(cpk(1,3,[1,2,3]),5)").toString());
  }

  @Test
  public void testKurtosis() throws ExpressionException {
    assertEquals(9, parse("round(kurtosis([1,1,2,2,3,3]),5)").getDouble());
  }

  @Test
  public void testMean() throws ExpressionException {
    assertEquals(2, parse("mean([1,2,3])").getDouble());
    assertEquals(1, parse("mean([1])").getDouble());
  }

  @Test
  public void testMode() throws ExpressionException {
    assertEquals("3", parse("mode([1,2,3,3])").toString());
    assertEquals("1", parse("mode([1])").toString());
  }

  @Test
  public void testPercentile() throws ExpressionException {
    ExecutorContext ctx = new DefaultExecutorContext();
    Value array = Value.create(List.of(9,12,28,55,63,82,91,92,96,97));
    ctx.setVariable("a", array);

    assertEquals(9, parse("percentile(a,0)", ctx).getDouble());
    assertEquals(20, parse("percentile(a,.25)", ctx).getDouble()); //TODO: Should be 28 (Qalculate & Wikipedia)
    assertEquals(72.5, parse("percentile(a,.5)", ctx).getDouble());
    assertEquals(91.5, parse("percentile(a,.75)", ctx).getDouble()); //TODO: Should be 92 (Qalculate & Wikipedia)
    assertEquals(97, parse("percentile(a,1)", ctx).getDouble());
  }

  @Test
  public void testRange() throws ExpressionException {
    assertEquals("2", parse("range([1,2,3,3])").toString());
  }

  @Test
  public void testSkewness() throws ExpressionException {
    //assertEquals("1.97353", parse("round(skewness([100,1,2,3,4,5]),5)").toString());
  }

  @Test
  public void testStd() throws ExpressionException {
    assertEquals("0.8165", parse("round(std([1,2,3]),5)").toString());
  }

  @Test
  public void testSum() throws ExpressionException {
    assertEquals(6, parse("sum([1,2,3])").getDouble());
  }

  @Test
  public void testVar() throws ExpressionException {
    assertEquals("0.66667", parse("round(var([1,2,3]),5)").toString());
  }
}
