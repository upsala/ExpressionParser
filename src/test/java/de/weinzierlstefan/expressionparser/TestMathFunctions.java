package de.weinzierlstefan.expressionparser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMathFunctions {
  @Test
  public void testAbs() throws ExpressionException {
    assertEquals("123", new DefaultExpressionParser().parse("abs(123)").eval().getString());
    assertEquals("123", new DefaultExpressionParser().parse("abs(-123)").eval().getString());
  }

  @Test
  public void testACos() throws ExpressionException {
    assertEquals(60, new DefaultExpressionParser().parse("round(acos(0.5),5)").eval().getDouble());
  }

  @Test
  public void testACosR() throws ExpressionException {
    assertEquals("1.0472", new DefaultExpressionParser().parse("round(acosr(0.5),5)").eval().getString());
  }

  @Test
  public void testASin() throws ExpressionException {
    assertEquals(30, new DefaultExpressionParser().parse("round(asin(0.5),5)").eval().getDouble());
  }

  @Test
  public void testASinR() throws ExpressionException {
    assertEquals("0.5236", new DefaultExpressionParser().parse("round(asinr(0.5),5)").eval().getString());
  }

  @Test
  public void testATan() throws ExpressionException {
    assertEquals(45, new DefaultExpressionParser().parse("atan(1)").eval().getDouble());
  }

  @Test
  public void testATan2() throws ExpressionException {
    assertEquals(45, new DefaultExpressionParser().parse("atan2(2,2)").eval().getDouble());
  }

  @Test
  public void testATan2R() throws ExpressionException {
    assertEquals("1.10715", new DefaultExpressionParser().parse("round(atan2r(10,5),5)").eval().getString());
  }

  @Test
  public void testATanR() throws ExpressionException {
    assertEquals(1, new DefaultExpressionParser().parse("round(atanr(pi/2),2)").eval().getDouble());
  }

  @Test
  public void testCeil() throws ExpressionException {
    assertEquals(1, new DefaultExpressionParser().parse("ceil(1)").eval().getDouble());
    assertEquals(2, new DefaultExpressionParser().parse("ceil(1.234)").eval().getDouble());
    assertEquals(2, new DefaultExpressionParser().parse("ceil(1.23456789)").eval().getDouble());
    assertEquals(13, new DefaultExpressionParser().parse("ceil(12.34)").eval().getDouble());
  }

  @Test
  public void testCos() throws ExpressionException {
    assertEquals("0.5", new DefaultExpressionParser().parse("round(cos(60),5)").eval().getString());
  }

  @Test
  public void testCosR() throws ExpressionException {
    assertEquals("0.87758", new DefaultExpressionParser().parse("round(cosr(0.5),5)").eval().getString());
  }

  @Test
  public void testCot() throws ExpressionException {
    assertEquals(1, new DefaultExpressionParser().parse("round(cot(45),5)").eval().getDouble());
  }

  @Test
  public void testCotR() throws ExpressionException {
    assertEquals(0, new DefaultExpressionParser().parse("round(cotr(pi/2),5)").eval().getDouble());
  }

  @Test
  public void testDegrees() throws ExpressionException {
    assertEquals(180, new DefaultExpressionParser().parse("degrees(pi)").eval().getDouble());
  }

  @Test
  public void testFact() throws ExpressionException {
    assertEquals(120, new DefaultExpressionParser().parse("fact(5)").eval().getDouble());

    Exception exception = assertThrows(ExpressionException.class, () -> new DefaultExpressionParser().parse("fact(-1)").eval().getString());
    assertEquals("Value must be positiv", exception.getMessage());
  }

  @Test
  public void testFloor() throws ExpressionException {
    assertEquals(1, new DefaultExpressionParser().parse("floor(1)").eval().getDouble());
    assertEquals(1, new DefaultExpressionParser().parse("floor(1.234)").eval().getDouble());
    assertEquals(1, new DefaultExpressionParser().parse("floor(1.23456789)").eval().getDouble());
    assertEquals(12, new DefaultExpressionParser().parse("floor(12.34)").eval().getDouble());
  }

  @Test
  public void testLog() throws ExpressionException {
    assertEquals(1, new DefaultExpressionParser().parse("log(e)").eval().getDouble());
  }

  @Test
  public void testLog2() throws ExpressionException {
    assertEquals(3, new DefaultExpressionParser().parse("log2(8)").eval().getDouble());
  }

  @Test
  public void testLog10() throws ExpressionException {
    assertEquals(2, new DefaultExpressionParser().parse("log10(100)").eval().getDouble());
  }

  @Test
  public void testPow() throws ExpressionException {
    assertEquals(16, new DefaultExpressionParser().parse("pow(2,4)").eval().getDouble());
    assertEquals(0.0625, new DefaultExpressionParser().parse("pow(2,-4)").eval().getDouble());
    assertEquals(0, new DefaultExpressionParser().parse("pow(0,4)").eval().getDouble());
    assertEquals(1, new DefaultExpressionParser().parse("pow(2,0)").eval().getDouble());
    assertEquals(16, new DefaultExpressionParser().parse("pow(-2,4)").eval().getDouble());
  }

  @Test
  public void testRadians() throws ExpressionException {
    assertEquals("3.14159", new DefaultExpressionParser().parse("round(radians(180),5)").eval().getString());
  }

  @Test
  public void testRandom() throws ExpressionException {
    double result = new DefaultExpressionParser().parse("random()").eval().getDouble();
    assertTrue(result>=0 && result<1);
  }

  @Test
  public void testRound() throws ExpressionException {
    assertEquals(1, new DefaultExpressionParser().parse("round(1.234)").eval().getDouble());
    assertEquals("1.2", new DefaultExpressionParser().parse("round(1.234,1)").eval().getString());
    assertEquals("1.2345679", new DefaultExpressionParser().parse("round(1.23456789,7)").eval().getString());
    assertEquals(10, new DefaultExpressionParser().parse("round(12.34,-1)").eval().getDouble());
  }

  @Test
  public void testSec() throws ExpressionException {
    assertEquals(2, new DefaultExpressionParser().parse("round(sec(60),5)").eval().getDouble());
  }

  @Test
  public void testSecR() throws ExpressionException {
    assertEquals(-1, new DefaultExpressionParser().parse("secr(pi)").eval().getDouble());
  }

  @Test
  public void testSign() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("sign(100)").eval().getString());
    assertEquals("0", new DefaultExpressionParser().parse("sign(0)").eval().getString());
    assertEquals("-1", new DefaultExpressionParser().parse("sign(-100)").eval().getString());
  }

  @Test
  public void testSin() throws ExpressionException {
    assertEquals(1, new DefaultExpressionParser().parse("sin(90)").eval().getDouble());
  }

  @Test
  public void testSinR() throws ExpressionException {
    assertEquals(1, new DefaultExpressionParser().parse("sinr(pi/2)").eval().getDouble());
  }

  @Test
  public void testSqrt() throws ExpressionException {
    assertEquals(0, new DefaultExpressionParser().parse("sqrt(0)").eval().getDouble());
    assertEquals(3, new DefaultExpressionParser().parse("sqrt(9)").eval().getDouble());

    Exception exception = assertThrows(ExpressionException.class, () -> new DefaultExpressionParser().parse("sqrt(-9)").eval().getString());
    assertEquals("Cannot sqrt a negative number", exception.getMessage());
  }

  @Test
  public void testTan() throws ExpressionException {
    assertEquals(1, new DefaultExpressionParser().parse("round(tan(45),5)").eval().getDouble());
  }

  @Test
  public void testTanR() throws ExpressionException {
    assertEquals(1, new DefaultExpressionParser().parse("round(tanr(pi/4),5)").eval().getDouble());
  }
}
