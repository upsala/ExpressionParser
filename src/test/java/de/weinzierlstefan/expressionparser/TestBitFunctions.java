package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.Value;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBitFunctions {
  private Value parse(String expression) {
    ExecutorContext context = new DefaultExecutorContext();
    return ExpressionParser.parse(expression, context).eval();
  }
  
  @Test
  public void testClearBit() throws ExpressionException {
    assertEquals("65534", parse("clearbit(0xffff, 0)").toString());
    assertEquals("65514", parse("clearbit(0xffff, 0, 2, 4)").toString());
    assertEquals("65535", parse("clearbit(0xffff, -1)").toString());
  }

  @Test
  public void testExtractBits() throws ExpressionException {
    assertEquals("255", parse("extractbits(0xffff, 0, 7)").toString());
    assertEquals("85", parse("extractbits(0xAAAA, 1, 8)").toString());
    assertEquals("120", parse("extractbits(0xf0f0, 1, 8)").toString());
    assertEquals("30", parse("extractbits(0xf0f0, 8, 1)").toString());
  }

  @Test
  public void testInvertBit() throws ExpressionException {
    assertEquals("1", parse("invertbit(0, 0)").toString());
    assertEquals("21", parse("invertbit(0, 0, 2, 4)").toString());
    assertEquals("65534", parse("invertbit(0xffff, 0)").toString());
    assertEquals("65514", parse("invertbit(0xffff, 0, 2, 4)").toString());
    assertEquals("0", parse("invertbit(0, -1)").toString());
  }

  @Test
  public void testSetBit() throws ExpressionException {
    assertEquals("1", parse("setbit(0, 0)").toString());
    assertEquals("21", parse("setbit(0, 0, 2, 4)").toString());
    assertEquals("0", parse("setbit(0, -1)").toString());
  }

  @Test
  public void testTestBit() throws ExpressionException {
    assertEquals("false", parse("testbit(0,0)").toString());
    assertEquals("true", parse("testbit(0xff,0)").toString());
  }

}
