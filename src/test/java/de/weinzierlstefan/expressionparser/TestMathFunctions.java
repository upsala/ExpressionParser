package de.weinzierlstefan.expressionparser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMathFunctions {
  @Test
  public void testAbs() throws ExpressionException {
    assertEquals("123", new DefaultExpressionParser().parse("abs(123)").eval().toString());
    assertEquals("123", new DefaultExpressionParser().parse("abs(-123)").eval().toString());
  }

  @Test
  public void testACos() throws ExpressionException {
    assertEquals("60", new DefaultExpressionParser().parse("acos(0.5)").eval().toString());
  }

  @Test
  public void testACosR() throws ExpressionException {
    assertEquals("1.0472", new DefaultExpressionParser().parse("round(acosr(0.5),5)").eval().toString());
  }

  @Test
  public void testASin() throws ExpressionException {
    assertEquals("30", new DefaultExpressionParser().parse("asin(0.5)").eval().toString());
  }

  @Test
  public void testASinR() throws ExpressionException {
    assertEquals("0.5236", new DefaultExpressionParser().parse("round(asinr(0.5),5)").eval().toString());
  }

  @Test
  public void testATan() throws ExpressionException {
    assertEquals("45", new DefaultExpressionParser().parse("atan(1)").eval().toString());
  }

  @Test
  public void testATan2() throws ExpressionException {
    assertEquals("45", new DefaultExpressionParser().parse("atan2(2,2)").eval().toString());
  }

  @Test
  public void testATan2R() throws ExpressionException {
    assertEquals("1.10715", new DefaultExpressionParser().parse("round(atan2r(10,5),5)").eval().toString());
  }

  @Test
  public void testATanR() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("round(atanr(PI/2),2)").eval().toString());
  }

  @Test
  public void testCeil() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("ceil(1)").eval().toString());
    assertEquals("2", new DefaultExpressionParser().parse("ceil(1.234)").eval().toString());
    assertEquals("2", new DefaultExpressionParser().parse("ceil(1.23456789)").eval().toString());
    assertEquals("13", new DefaultExpressionParser().parse("ceil(12.34)").eval().toString());
  }

  @Test
  public void testCos() throws ExpressionException {
    assertEquals("0.5", new DefaultExpressionParser().parse("round(cos(60),5)").eval().toString());
  }

  @Test
  public void testCosR() throws ExpressionException {
    assertEquals("0.87758", new DefaultExpressionParser().parse("round(cosr(0.5),5)").eval().toString());
  }

  @Test
  public void testCot() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("cot(45)").eval().toString());
  }

  @Test
  public void testCotR() throws ExpressionException {
    assertEquals("0", new DefaultExpressionParser().parse("round(cotr(PI/2),5)").eval().toString());
  }

  @Test
  public void testDegrees() throws ExpressionException {
    assertEquals("180", new DefaultExpressionParser().parse("degrees(PI)").eval().toString());
  }

  @Test
  public void testFact() throws ExpressionException {
    assertEquals("120", new DefaultExpressionParser().parse("fact(5)").eval().toString());

    Exception exception = assertThrows(ExpressionException.class, () -> new DefaultExpressionParser().parse("fact(-1)").eval().toString());
    assertEquals("Value must be positiv", exception.getMessage());
  }

  @Test
  public void testFloor() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("floor(1)").eval().toString());
    assertEquals("1", new DefaultExpressionParser().parse("floor(1.234)").eval().toString());
    assertEquals("1", new DefaultExpressionParser().parse("floor(1.23456789)").eval().toString());
    assertEquals("12", new DefaultExpressionParser().parse("floor(12.34)").eval().toString());
  }

  @Test
  public void testLog() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("log(e)").eval().toString());
  }

  @Test
  public void testLog2() throws ExpressionException {
    assertEquals("3", new DefaultExpressionParser().parse("log2(8)").eval().toString());
  }

  @Test
  public void testLog10() throws ExpressionException {
    assertEquals("2", new DefaultExpressionParser().parse("log10(100)").eval().toString());
  }

  @Test
  public void testPow() throws ExpressionException {
    assertEquals("16", new DefaultExpressionParser().parse("pow(2,4)").eval().toString());
    assertEquals("0.0625", new DefaultExpressionParser().parse("pow(2,-4)").eval().toString());
    assertEquals("0", new DefaultExpressionParser().parse("pow(0,4)").eval().toString());
    assertEquals("1", new DefaultExpressionParser().parse("pow(2,0)").eval().toString());
    assertEquals("16", new DefaultExpressionParser().parse("pow(-2,4)").eval().toString());
  }

  @Test
  public void testRadians() throws ExpressionException {
    assertEquals("3.14159", new DefaultExpressionParser().parse("round(radians(180),5)").eval().toString());
  }

  @Test
  public void testRandom() throws ExpressionException {
    double result = new DefaultExpressionParser().parse("random()").eval().toDouble();
    assertTrue(result>=0 && result<1);
  }

  @Test
  public void testRound() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("round(1.234)").eval().toString());
    assertEquals("1.2", new DefaultExpressionParser().parse("round(1.234,1)").eval().toString());
    assertEquals("1.2345679", new DefaultExpressionParser().parse("round(1.23456789,7)").eval().toString());
    assertEquals("1E+1", new DefaultExpressionParser().parse("round(12.34,-1)").eval().toString());
  }

  @Test
  public void testSec() throws ExpressionException {
    assertEquals("2", new DefaultExpressionParser().parse("round(sec(60),5)").eval().toString());
  }

  @Test
  public void testSecR() throws ExpressionException {
    assertEquals("-1", new DefaultExpressionParser().parse("secr(PI)").eval().toString());
  }

  @Test
  public void testSign() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("sign(100)").eval().toString());
    assertEquals("0", new DefaultExpressionParser().parse("sign(0)").eval().toString());
    assertEquals("-1", new DefaultExpressionParser().parse("sign(-100)").eval().toString());
  }

  @Test
  public void testSin() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("sin(90)").eval().toString());
  }

  @Test
  public void testSinR() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("sinr(PI/2)").eval().toString());
  }

  @Test
  public void testSqrt() throws ExpressionException {
    assertEquals("0", new DefaultExpressionParser().parse("sqrt(0)").eval().toString());
    assertEquals("3", new DefaultExpressionParser().parse("sqrt(9)").eval().toString());

    Exception exception = assertThrows(ExpressionException.class, () -> new DefaultExpressionParser().parse("sqrt(-9)").eval().toString());
    assertEquals("Value must be not negativ", exception.getMessage());
  }

  @Test
  public void testTan() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("tan(45)").eval().toString());
  }

  @Test
  public void testTanR() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("round(tanr(PI/4),5)").eval().toString());
  }
}
