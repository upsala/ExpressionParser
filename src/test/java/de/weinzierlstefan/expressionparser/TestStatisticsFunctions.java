package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.Value;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStatisticsFunctions {
  @Test
  public void testCp() throws ExpressionException {
    assertEquals("0.40825", new DefaultExpressionParser().parse("round(cp(1,3,[1,2,3]),5)").eval().toString());
  }

  @Test
  public void testCpk() throws ExpressionException {
    assertEquals("0.40825", new DefaultExpressionParser().parse("round(cpk(1,3,[1,2,3]),5)").eval().toString());
  }

  @Test
  public void testKurtosis() throws ExpressionException {
    assertEquals(9, new DefaultExpressionParser().parse("round(kurtosis([1,1,2,2,3,3]),5)").eval().getDouble());
  }

  @Test
  public void testMean() throws ExpressionException {
    assertEquals(2, new DefaultExpressionParser().parse("mean([1,2,3])").eval().getDouble());
    assertEquals(1, new DefaultExpressionParser().parse("mean([1])").eval().getDouble());
  }

  @Test
  public void testMode() throws ExpressionException {
    assertEquals("3", new DefaultExpressionParser().parse("mode([1,2,3,3])").eval().toString());
    assertEquals("1", new DefaultExpressionParser().parse("mode([1])").eval().toString());
  }

  @Test
  public void testPercentile() throws ExpressionException {
    ExpressionParser expressionParser = new DefaultExpressionParser();
    Value array = Value.create(List.of(9,12,28,55,63,82,91,92,96,97));
    expressionParser.setVariable("a", array);

    assertEquals(9, expressionParser.parse("percentile(a,0)").eval().getDouble());
    assertEquals(20, expressionParser.parse("percentile(a,.25)").eval().getDouble()); //TODO: Should be 28 (Qalculate & Wikipedia)
    assertEquals(72.5, expressionParser.parse("percentile(a,.5)").eval().getDouble());
    assertEquals(91.5, expressionParser.parse("percentile(a,.75)").eval().getDouble()); //TODO: Should be 92 (Qalculate & Wikipedia)
    assertEquals(97, expressionParser.parse("percentile(a,1)").eval().getDouble());
  }

  @Test
  public void testRange() throws ExpressionException {
    assertEquals("2", new DefaultExpressionParser().parse("range([1,2,3,3])").eval().toString());
  }

  @Test
  public void testSkewness() throws ExpressionException {
    //assertEquals("1.97353", new DefaultExpressionParser().parse("round(skewness([100,1,2,3,4,5]),5)").eval().toString());
  }

  @Test
  public void testStd() throws ExpressionException {
    assertEquals("0.8165", new DefaultExpressionParser().parse("round(std([1,2,3]),5)").eval().toString());
  }

  @Test
  public void testSum() throws ExpressionException {
    assertEquals(6, new DefaultExpressionParser().parse("sum([1,2,3])").eval().getDouble());
  }

  @Test
  public void testVar() throws ExpressionException {
    assertEquals("0.66667", new DefaultExpressionParser().parse("round(var([1,2,3]),5)").eval().toString());
  }
}
