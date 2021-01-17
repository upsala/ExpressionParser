package de.weinzierlstefan.expressionparser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBitFunctions {
  @Test
  public void testClearBit() throws ExpressionException {
    assertEquals("65534", new DefaultExpressionParser().parse("clearbit(0xffff, 0)").eval().toString());
    assertEquals("65514", new DefaultExpressionParser().parse("clearbit(0xffff, 0, 2, 4)").eval().toString());
    assertEquals("65535", new DefaultExpressionParser().parse("clearbit(0xffff, -1)").eval().toString());
  }

  @Test
  public void testExtractBits() throws ExpressionException {
    assertEquals("255", new DefaultExpressionParser().parse("extractbits(0xffff, 0, 7)").eval().toString());
    assertEquals("85", new DefaultExpressionParser().parse("extractbits(0xAAAA, 1, 8)").eval().toString());
    assertEquals("120", new DefaultExpressionParser().parse("extractbits(0xf0f0, 1, 8)").eval().toString());
    assertEquals("30", new DefaultExpressionParser().parse("extractbits(0xf0f0, 8, 1)").eval().toString());
  }

  @Test
  public void testInvertBit() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("invertbit(0, 0)").eval().toString());
    assertEquals("21", new DefaultExpressionParser().parse("invertbit(0, 0, 2, 4)").eval().toString());
    assertEquals("65534", new DefaultExpressionParser().parse("invertbit(0xffff, 0)").eval().toString());
    assertEquals("65514", new DefaultExpressionParser().parse("invertbit(0xffff, 0, 2, 4)").eval().toString());
    assertEquals("0", new DefaultExpressionParser().parse("invertbit(0, -1)").eval().toString());
  }

  @Test
  public void testSetBit() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("setbit(0, 0)").eval().toString());
    assertEquals("21", new DefaultExpressionParser().parse("setbit(0, 0, 2, 4)").eval().toString());
    assertEquals("0", new DefaultExpressionParser().parse("setbit(0, -1)").eval().toString());
  }

  @Test
  public void testTestBit() throws ExpressionException {
    assertEquals("false", new DefaultExpressionParser().parse("testbit(0,0)").eval().toString());
    assertEquals("true", new DefaultExpressionParser().parse("testbit(0xff,0)").eval().toString());
  }

}
