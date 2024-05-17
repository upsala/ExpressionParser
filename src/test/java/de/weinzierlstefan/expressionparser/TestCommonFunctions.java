package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.ValueInt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCommonFunctions {
  @Test
  public void testBetween() throws ExpressionException {
    assertEquals("true", new DefaultExpressionParser().parse("between(10,20,30)").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("between(10,0,30)").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("between(10,40,30)").eval().getString());
  }

  @Test
  public void testBound() throws ExpressionException {
    assertEquals("20", new DefaultExpressionParser().parse("bound(10,20,30)").eval().getString());
    assertEquals("10", new DefaultExpressionParser().parse("bound(10,0,30)").eval().getString());
    assertEquals("30", new DefaultExpressionParser().parse("bound(10,40,30)").eval().getString());
  }

  @Test
  public void testCount() throws ExpressionException {
    assertEquals(5, new DefaultExpressionParser().parse("count([1,2,3,4,5])").eval().getInt());
    assertEquals(3, new DefaultExpressionParser().parse("count({1:2,3:4,5:6})").eval().getInt());
    assertEquals(4, new DefaultExpressionParser().parse("count('test')").eval().getInt());
    assertEquals(0, new DefaultExpressionParser().parse("count(null)").eval().getInt());
    assertEquals(1, new DefaultExpressionParser().parse("count(5)").eval().getInt());
    assertEquals(1, new DefaultExpressionParser().parse("count(5.0)").eval().getInt());
  }

  @Test
  public void testIfNull() throws ExpressionException {
    assertEquals("[1,2,3]", new DefaultExpressionParser().parse("ifnull([1,2,3])").eval().getString());
    assertEquals("123", new DefaultExpressionParser().parse("ifnull(123)").eval().getString());
    //assertEquals("false", new DefaultExpressionParser().parse("ifnull(object())").eval().getString());
    assertEquals("abc", new DefaultExpressionParser().parse("ifnull('abc')").eval().getString());
    assertEquals("1", new DefaultExpressionParser().parse("ifnull(null,1)").eval().getString());
    assertEquals("1", new DefaultExpressionParser().parse("ifnull(null,null,1)").eval().getString());
    assertEquals("1", new DefaultExpressionParser().parse("ifnull(null,null,null,1)").eval().getString());
  }

  @Test
  public void testIsArray() throws ExpressionException {
    assertEquals("true", new DefaultExpressionParser().parse("isarray(array(1,2,3))").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("isarray(123)").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("isarray('abc')").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("isarray(null)").eval().getString());
  }

  @Test
  public void testIsNull() throws ExpressionException {
    assertEquals("true", new DefaultExpressionParser().parse("isnull(null)").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("isnull(array(1,2,3))").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("isnull(123)").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("isnull('abc')").eval().getString());
  }

  @Test
  public void testIsNumber() throws ExpressionException {
    assertEquals("false", new DefaultExpressionParser().parse("isnumber(array(1,2,3))").eval().getString());
    assertEquals("true", new DefaultExpressionParser().parse("isnumber(123)").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("isnumber('abc')").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("isnumber(null)").eval().getString());
  }

  @Test
  public void testIsString() throws ExpressionException {
    assertEquals("false", new DefaultExpressionParser().parse("isstring(array(1,2,3))").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("isstring(123)").eval().getString());
    assertEquals("true", new DefaultExpressionParser().parse("isstring('abc')").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("isstring(null)").eval().getString());
  }

  @Test
  public void testMax() throws ExpressionException {
    assertEquals("3", new DefaultExpressionParser().parse("max(1,2,3)").eval().getString());
    assertEquals("c", new DefaultExpressionParser().parse("max('a','b','c')").eval().getString());
    assertEquals("3", new DefaultExpressionParser().parse("max(1,2,3,NULL)").eval().getString());
  }

  @Test
  public void testMin() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("min(1,2,3)").eval().getString());
    assertEquals("a", new DefaultExpressionParser().parse("min('a','b','c')").eval().getString());
    assertEquals("1", new DefaultExpressionParser().parse("min(1,2,3,NULL)").eval().getString());
  }

  @Test
  public void testVarExists() throws ExpressionException {
    ExpressionParser expressionParser = new DefaultExpressionParser();
    expressionParser.setVariable("abc", ValueInt.of(2));
    expressionParser.setVariable("a1", ValueInt.of(3));
    expressionParser.setVariable("a2", ValueInt.of(4));

    assertEquals(true, expressionParser.parse("varexists('abc')").eval().getBoolean());
    assertEquals(false, expressionParser.parse("varexists('a')").eval().getBoolean());
    assertEquals(true, expressionParser.parse("varexists('abc','a1','a2')").eval().getBoolean());
    assertEquals(false, expressionParser.parse("varexists('abc','a1','a2','b1')").eval().getBoolean());
  }
}


