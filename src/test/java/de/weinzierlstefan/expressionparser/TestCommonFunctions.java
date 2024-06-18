package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueInt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCommonFunctions {
  private Value parse(String expression) {
    ExecutorContext context = new DefaultExecutorContext();
    return ExpressionParser.parse(expression, context).eval();
  }

  private Value parse(String expression, ExecutorContext context) {
    return ExpressionParser.parse(expression, context).eval();
  }
  
  @Test
  public void testBetween() throws ExpressionException {
    assertEquals("true", parse("between(10,20,30)").getString());
    assertEquals("false", parse("between(10,0,30)").getString());
    assertEquals("false", parse("between(10,40,30)").getString());
  }

  @Test
  public void testBound() throws ExpressionException {
    assertEquals("20", parse("bound(10,20,30)").getString());
    assertEquals("10", parse("bound(10,0,30)").getString());
    assertEquals("30", parse("bound(10,40,30)").getString());
  }

  @Test
  public void testCount() throws ExpressionException {
    assertEquals(5, parse("count([1,2,3,4,5])").getInt());
    assertEquals(3, parse("count({1:2,3:4,5:6})").getInt());
    assertEquals(4, parse("count('test')").getInt());
    assertEquals(0, parse("count(null)").getInt());
    assertEquals(1, parse("count(5)").getInt());
    assertEquals(1, parse("count(5.0)").getInt());
  }

  @Test
  public void testIfNull() throws ExpressionException {
    assertEquals("[1,2,3]", parse("ifnull([1,2,3])").getString());
    assertEquals("123", parse("ifnull(123)").getString());
    //assertEquals("false", parse("ifnull(object())").getString());
    assertEquals("abc", parse("ifnull('abc')").getString());
    assertEquals("1", parse("ifnull(null,1)").getString());
    assertEquals("1", parse("ifnull(null,null,1)").getString());
    assertEquals("1", parse("ifnull(null,null,null,1)").getString());
  }

  @Test
  public void testIsArray() throws ExpressionException {
    assertEquals("true", parse("isarray(array(1,2,3))").getString());
    assertEquals("false", parse("isarray(123)").getString());
    assertEquals("false", parse("isarray('abc')").getString());
    assertEquals("false", parse("isarray(null)").getString());
  }

  @Test
  public void testIsNull() throws ExpressionException {
    assertEquals("true", parse("isnull(null)").getString());
    assertEquals("false", parse("isnull(array(1,2,3))").getString());
    assertEquals("false", parse("isnull(123)").getString());
    assertEquals("false", parse("isnull('abc')").getString());
  }

  @Test
  public void testIsNumber() throws ExpressionException {
    assertEquals("false", parse("isnumber(array(1,2,3))").getString());
    assertEquals("true", parse("isnumber(123)").getString());
    assertEquals("false", parse("isnumber('abc')").getString());
    assertEquals("false", parse("isnumber(null)").getString());
  }

  @Test
  public void testIsString() throws ExpressionException {
    assertEquals("false", parse("isstring(array(1,2,3))").getString());
    assertEquals("false", parse("isstring(123)").getString());
    assertEquals("true", parse("isstring('abc')").getString());
    assertEquals("false", parse("isstring(null)").getString());
  }

  @Test
  public void testMax() throws ExpressionException {
    assertEquals("3", parse("max(1,2,3)").getString());
    assertEquals("c", parse("max('a','b','c')").getString());
    assertEquals("3", parse("max(1,2,3,NULL)").getString());
  }

  @Test
  public void testMin() throws ExpressionException {
    assertEquals("1", parse("min(1,2,3)").getString());
    assertEquals("a", parse("min('a','b','c')").getString());
    assertEquals("1", parse("min(1,2,3,NULL)").getString());
  }

  @Test
  public void testVarExists() throws ExpressionException {
    ExecutorContext ctx = new DefaultExecutorContext();

    ctx.setVariable("abc", ValueInt.of(2));
    ctx.setVariable("a1", ValueInt.of(3));
    ctx.setVariable("a2", ValueInt.of(4));

    assertEquals(true, parse("varexists('abc')", ctx).getBoolean());
    assertEquals(false, parse("varexists('a')", ctx).getBoolean());
    assertEquals(true, parse("varexists('abc','a1','a2')", ctx).getBoolean());
    assertEquals(false, parse("varexists('abc','a1','a2','b1')", ctx).getBoolean());
  }
}


