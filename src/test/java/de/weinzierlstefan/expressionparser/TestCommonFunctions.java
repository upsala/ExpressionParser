package de.weinzierlstefan.expressionparser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCommonFunctions {
  @Test
  public void testBetween() throws ExpressionException {
    assertEquals("true", new DefaultExpressionParser().parse("between(10,20,30)").eval().toString());
    assertEquals("false", new DefaultExpressionParser().parse("between(10,0,30)").eval().toString());
    assertEquals("false", new DefaultExpressionParser().parse("between(10,40,30)").eval().toString());
  }

  @Test
  public void testBound() throws ExpressionException {
    assertEquals("20", new DefaultExpressionParser().parse("bound(10,20,30)").eval().toString());
    assertEquals("10", new DefaultExpressionParser().parse("bound(10,0,30)").eval().toString());
    assertEquals("30", new DefaultExpressionParser().parse("bound(10,40,30)").eval().toString());
  }

  @Test
  public void testIfNull() throws ExpressionException {
    assertEquals("[1,2,3]", new DefaultExpressionParser().parse("ifnull([1,2,3])").eval().toString());
    assertEquals("123", new DefaultExpressionParser().parse("ifnull(123)").eval().toString());
    //assertEquals("false", new DefaultExpressionParser().parse("ifnull(object())").eval().toString());
    assertEquals("abc", new DefaultExpressionParser().parse("ifnull('abc')").eval().toString());
    assertEquals("1", new DefaultExpressionParser().parse("ifnull(null,1)").eval().toString());
    assertEquals("1", new DefaultExpressionParser().parse("ifnull(null,null,1)").eval().toString());
    assertEquals("1", new DefaultExpressionParser().parse("ifnull(null,null,null,1)").eval().toString());
  }

  @Test
  public void testIsArray() throws ExpressionException {
    assertEquals("true", new DefaultExpressionParser().parse("isarray(array(1,2,3))").eval().toString());
    assertEquals("false", new DefaultExpressionParser().parse("isarray(123)").eval().toString());
    assertEquals("false", new DefaultExpressionParser().parse("isarray('abc')").eval().toString());
    assertEquals("false", new DefaultExpressionParser().parse("isarray(null)").eval().toString());
  }

  @Test
  public void testIsNull() throws ExpressionException {
    assertEquals("true", new DefaultExpressionParser().parse("isnull(null)").eval().toString());
    assertEquals("false", new DefaultExpressionParser().parse("isnull(array(1,2,3))").eval().toString());
    assertEquals("false", new DefaultExpressionParser().parse("isnull(123)").eval().toString());
    assertEquals("false", new DefaultExpressionParser().parse("isnull('abc')").eval().toString());
  }

  @Test
  public void testIsNumber() throws ExpressionException {
    assertEquals("false", new DefaultExpressionParser().parse("isnumber(array(1,2,3))").eval().toString());
    assertEquals("true", new DefaultExpressionParser().parse("isnumber(123)").eval().toString());
    assertEquals("false", new DefaultExpressionParser().parse("isnumber('abc')").eval().toString());
    assertEquals("false", new DefaultExpressionParser().parse("isnumber(null)").eval().toString());
  }

  @Test
  public void testIsString() throws ExpressionException {
    assertEquals("false", new DefaultExpressionParser().parse("isstring(array(1,2,3))").eval().toString());
    assertEquals("false", new DefaultExpressionParser().parse("isstring(123)").eval().toString());
    assertEquals("true", new DefaultExpressionParser().parse("isstring('abc')").eval().toString());
    assertEquals("false", new DefaultExpressionParser().parse("isstring(null)").eval().toString());
  }

  @Test
  public void testMax() throws ExpressionException {
    assertEquals("3", new DefaultExpressionParser().parse("max(1,2,3)").eval().toString());
    assertEquals("c", new DefaultExpressionParser().parse("max('a','b','c')").eval().toString());
    assertEquals("3", new DefaultExpressionParser().parse("max(1,2,3,NULL)").eval().toString());
  }

  @Test
  public void testMin() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("min(1,2,3)").eval().toString());
    assertEquals("a", new DefaultExpressionParser().parse("min('a','b','c')").eval().toString());
    assertEquals("1", new DefaultExpressionParser().parse("min(1,2,3,NULL)").eval().toString());
  }
}
