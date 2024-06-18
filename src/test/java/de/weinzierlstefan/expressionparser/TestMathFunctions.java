package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.Value;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMathFunctions {
  private Value parse(String expression) {
    ExecutorContext context = new DefaultExecutorContext();
    return ExpressionParser.parse(expression, context).eval();
  }
  
  @Test
  public void testAbs() throws ExpressionException {
    assertEquals("123", parse("abs(123)").getString());
    assertEquals("123", parse("abs(-123)").getString());
  }

  @Test
  public void testACos() throws ExpressionException {
    assertEquals(60, parse("round(acos(0.5),5)").getDouble());
  }

  @Test
  public void testACosR() throws ExpressionException {
    assertEquals("1.0472", parse("round(acosr(0.5),5)").getString());
  }

  @Test
  public void testASin() throws ExpressionException {
    assertEquals(30, parse("round(asin(0.5),5)").getDouble());
  }

  @Test
  public void testASinR() throws ExpressionException {
    assertEquals("0.5236", parse("round(asinr(0.5),5)").getString());
  }

  @Test
  public void testATan() throws ExpressionException {
    assertEquals(45, parse("atan(1)").getDouble());
  }

  @Test
  public void testATan2() throws ExpressionException {
    assertEquals(45, parse("atan2(2,2)").getDouble());
  }

  @Test
  public void testATan2R() throws ExpressionException {
    assertEquals("1.10715", parse("round(atan2r(10,5),5)").getString());
  }

  @Test
  public void testATanR() throws ExpressionException {
    assertEquals(1, parse("round(atanr(pi/2),2)").getDouble());
  }

  @Test
  public void testCeil() throws ExpressionException {
    assertEquals(1, parse("ceil(1)").getDouble());
    assertEquals(2, parse("ceil(1.234)").getDouble());
    assertEquals(2, parse("ceil(1.23456789)").getDouble());
    assertEquals(13, parse("ceil(12.34)").getDouble());
  }

  @Test
  public void testCos() throws ExpressionException {
    assertEquals("0.5", parse("round(cos(60),5)").getString());
  }

  @Test
  public void testCosR() throws ExpressionException {
    assertEquals("0.87758", parse("round(cosr(0.5),5)").getString());
  }

  @Test
  public void testCot() throws ExpressionException {
    assertEquals(1, parse("round(cot(45),5)").getDouble());
  }

  @Test
  public void testCotR() throws ExpressionException {
    assertEquals(0, parse("round(cotr(pi/2),5)").getDouble());
  }

  @Test
  public void testDegrees() throws ExpressionException {
    assertEquals(180, parse("degrees(pi)").getDouble());
  }

  @Test
  public void testFact() throws ExpressionException {
    assertEquals(120, parse("fact(5)").getDouble());

    Exception exception = assertThrows(ExpressionException.class, () -> parse("fact(-1)").getString());
    assertEquals("Value must be positiv", exception.getMessage());
  }

  @Test
  public void testFloor() throws ExpressionException {
    assertEquals(1, parse("floor(1)").getDouble());
    assertEquals(1, parse("floor(1.234)").getDouble());
    assertEquals(1, parse("floor(1.23456789)").getDouble());
    assertEquals(12, parse("floor(12.34)").getDouble());
  }

  @Test
  public void testLog() throws ExpressionException {
    assertEquals(1, parse("log(e)").getDouble());
  }

  @Test
  public void testLog2() throws ExpressionException {
    assertEquals(3, parse("log2(8)").getDouble());
  }

  @Test
  public void testLog10() throws ExpressionException {
    assertEquals(2, parse("log10(100)").getDouble());
  }

  @Test
  public void testPow() throws ExpressionException {
    assertEquals(16, parse("pow(2,4)").getDouble());
    assertEquals(0.0625, parse("pow(2,-4)").getDouble());
    assertEquals(0, parse("pow(0,4)").getDouble());
    assertEquals(1, parse("pow(2,0)").getDouble());
    assertEquals(16, parse("pow(-2,4)").getDouble());
  }

  @Test
  public void testRadians() throws ExpressionException {
    assertEquals("3.14159", parse("round(radians(180),5)").getString());
  }

  @Test
  public void testRandom() throws ExpressionException {
    double result = parse("random()").getDouble();
    assertTrue(result>=0 && result<1);
  }

  @Test
  public void testRound() throws ExpressionException {
    assertEquals(1, parse("round(1.234)").getDouble());
    assertEquals("1.2", parse("round(1.234,1)").getString());
    assertEquals("1.2345679", parse("round(1.23456789,7)").getString());
    assertEquals(10, parse("round(12.34,-1)").getDouble());
  }

  @Test
  public void testSec() throws ExpressionException {
    assertEquals(2, parse("round(sec(60),5)").getDouble());
  }

  @Test
  public void testSecR() throws ExpressionException {
    assertEquals(-1, parse("secr(pi)").getDouble());
  }

  @Test
  public void testSign() throws ExpressionException {
    assertEquals("1", parse("sign(100)").getString());
    assertEquals("0", parse("sign(0)").getString());
    assertEquals("-1", parse("sign(-100)").getString());
  }

  @Test
  public void testSin() throws ExpressionException {
    assertEquals(1, parse("sin(90)").getDouble());
  }

  @Test
  public void testSinR() throws ExpressionException {
    assertEquals(1, parse("sinr(pi/2)").getDouble());
  }

  @Test
  public void testSqrt() throws ExpressionException {
    assertEquals(0, parse("sqrt(0)").getDouble());
    assertEquals(3, parse("sqrt(9)").getDouble());

    Exception exception = assertThrows(ExpressionException.class, () -> parse("sqrt(-9)").getString());
    assertEquals("Cannot sqrt a negative number", exception.getMessage());
  }

  @Test
  public void testTan() throws ExpressionException {
    assertEquals(1, parse("round(tan(45),5)").getDouble());
  }

  @Test
  public void testTanR() throws ExpressionException {
    assertEquals(1, parse("round(tanr(pi/4),5)").getDouble());
  }
}
