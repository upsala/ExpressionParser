package de.weinzierlstefan.expressionparser;

import org.junit.jupiter.api.Test;

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
    assertEquals("9", new DefaultExpressionParser().parse("round(kurtosis([1,1,2,2,3,3]),5)").eval().toString());
  }

  @Test
  public void testMean() throws ExpressionException {
    assertEquals("2", new DefaultExpressionParser().parse("mean([1,2,3])").eval().toString());
    assertEquals("1", new DefaultExpressionParser().parse("mean([1])").eval().toString());
  }

  @Test
  public void testModus() throws ExpressionException {
    assertEquals("3", new DefaultExpressionParser().parse("modus([1,2,3,3])").eval().toString());
    assertEquals("1", new DefaultExpressionParser().parse("modus([1])").eval().toString());
  }

  @Test
  public void testPercentile() throws ExpressionException {
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
    assertEquals("6", new DefaultExpressionParser().parse("sum([1,2,3])").eval().toString());
  }

  @Test
  public void testVar() throws ExpressionException {
    assertEquals("0.66667", new DefaultExpressionParser().parse("round(var([1,2,3]),5)").eval().toString());
  }
}
