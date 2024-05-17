package de.weinzierlstefan.expressionparser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestParser {
  @Test
  public void testLiterals() throws ExpressionException {
    assertEquals("123", new ExpressionParser().parse("123").eval().toString());
    assertEquals("15", new ExpressionParser().parse("0b1111").eval().toString());
    assertEquals("43981", new ExpressionParser().parse("0xabcd").eval().toString());
    assertEquals("'abc'", new ExpressionParser().parse("\"abc\"").eval().toString());
    assertEquals("'abc'", new ExpressionParser().parse("'abc'").eval().toString());
    assertEquals("123.456", new ExpressionParser().parse("123.456").eval().toString());
    assertEquals("'ab\\\"c'", new ExpressionParser().parse("\"ab\\\"c\"").eval().toString());
  }

  @Test
  public void testArithmetic() throws ExpressionException {
    assertEquals("3", new ExpressionParser().parse("1+2").eval().toString());
    assertEquals("2", new ExpressionParser().parse("3-1").eval().toString());
    assertEquals("6", new ExpressionParser().parse("2*3").eval().toString());
    assertEquals("3", new ExpressionParser().parse("21/7").eval().toString());
    assertEquals("2", new ExpressionParser().parse("27%5").eval().toString());
    assertEquals("-23", new ExpressionParser().parse("-23").eval().toString());
    assertEquals("'ab'", new ExpressionParser().parse("'a'+'b'").eval().toString());
  }

  @Test
  public void testAdd() throws ExpressionException {
    assertEquals("3", new ExpressionParser().parse("1+2").eval().toString());
    assertEquals("6", new ExpressionParser().parse("1+2+3").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("1+NULL").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("NULL+1").eval().toString());

    assertEquals("'ab'", new ExpressionParser().parse("'a'+'b'").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("'a'+NULL").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("NULL+'b'").eval().toString());
  }

  @Test
  public void testSub() throws ExpressionException {
    assertEquals("3", new ExpressionParser().parse("5-2").eval().toString());
    assertEquals("6", new ExpressionParser().parse("20-5-9").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("1-NULL").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("NULL-1").eval().toString());
  }

  @Test
  public void testMul() throws ExpressionException {
    assertEquals("12", new ExpressionParser().parse("3*4").eval().toString());
    assertEquals("24", new ExpressionParser().parse("2*3*4").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("3*NULL").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("NULL*3").eval().toString());

    Exception exception = assertThrows(
      ExpressionException.class,
      () -> new ExpressionParser().parse("1*'a'").eval()
    );
    assertEquals("Multiplication of 'int' and 'string' is not possible", exception.getMessage());
  }

  @Test
  public void testDiv() throws ExpressionException {
    assertEquals("5", new ExpressionParser().parse("10/2").eval().toString());
    assertEquals("5", new ExpressionParser().parse("100/4/5").eval().toString());
    assertEquals("2.5", new ExpressionParser().parse("10./4").eval().toString());
    assertEquals("2.5", new ExpressionParser().parse("10/4.").eval().toString());
    assertEquals("2", new ExpressionParser().parse("10/4").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("10/NULL").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("NULL/10").eval().toString());

    Exception exception = assertThrows(
      ExpressionException.class,
      () -> new ExpressionParser().parse("1/'a'").eval()
    );
    assertEquals("Division of 'int' and 'string' is not possible", exception.getMessage());
  }

  @Test
  public void testMod() throws ExpressionException {
    assertEquals("1", new ExpressionParser().parse("10%3").eval().toString());
    assertEquals("1", new ExpressionParser().parse("100%24%3").eval().toString());
    assertEquals("2", new ExpressionParser().parse("10%4").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("10%NULL").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("NULL%10").eval().toString());

    Exception exception = assertThrows(
      ExpressionException.class,
      () -> new ExpressionParser().parse("1%'a'").eval()
    );
    assertEquals("Modulo of 'int' and 'string' is not possible", exception.getMessage());
  }

  @Test
  public void testNeg() throws ExpressionException {
    assertEquals("-10", new ExpressionParser().parse("-10").eval().toString());
    assertEquals("10", new ExpressionParser().parse("--10").eval().toString());
    assertEquals("-2.5", new ExpressionParser().parse("-2.5").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("-NULL").eval().toString());
    assertEquals("1", new ExpressionParser().parse("4+-3").eval().toString());

    Exception exception = assertThrows(
      ExpressionException.class,
      () -> new ExpressionParser().parse("-'a'").eval()
    );
    assertEquals("Negation of 'string' is not possible", exception.getMessage());
  }

  @Test
  public void testBitShift() throws ExpressionException {
    assertEquals("16", new ExpressionParser().parse("1<<4").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("NULL<<4").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("1<<NULL").eval().toString());

    assertEquals("2", new ExpressionParser().parse("16>>3").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("NULL>>3").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("16>>NULL").eval().toString());

    Exception exception = assertThrows(
      ExpressionException.class,
      () -> new ExpressionParser().parse("1<<'a'").eval()
    );
    assertEquals("Shift left of 'int' and 'string' is not possible", exception.getMessage());

    exception = assertThrows(
      ExpressionException.class,
      () -> new ExpressionParser().parse("1>>'a'").eval()
    );
    assertEquals("Shift right of 'int' and 'string' is not possible", exception.getMessage());
  }

  @Test
  public void testCompare() throws ExpressionException {
    assertEquals("true", new ExpressionParser().parse("1<4").eval().toString());
    assertEquals("false", new ExpressionParser().parse("4<1").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("4<NULL").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("NULL<4").eval().toString());

    assertEquals("true", new ExpressionParser().parse("4>1").eval().toString());
    assertEquals("false", new ExpressionParser().parse("1>4").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("4>NULL").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("NULL>4").eval().toString());

    assertEquals("true", new ExpressionParser().parse("1<=4").eval().toString());
    assertEquals("false", new ExpressionParser().parse("4<=1").eval().toString());
    assertEquals("true", new ExpressionParser().parse("4<=4").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("4<=NULL").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("NULL<=4").eval().toString());

    assertEquals("false", new ExpressionParser().parse("1>=4").eval().toString());
    assertEquals("true", new ExpressionParser().parse("4>=1").eval().toString());
    assertEquals("true", new ExpressionParser().parse("4>=4").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("4>=NULL").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("NULL>=4").eval().toString());

    assertEquals("false", new ExpressionParser().parse("1==4").eval().toString());
    assertEquals("true", new ExpressionParser().parse("4==4").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("4==NULL").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("NULL==4").eval().toString());

    assertEquals("true", new ExpressionParser().parse("1<>4").eval().toString());
    assertEquals("false", new ExpressionParser().parse("4<>4").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("4<>NULL").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("NULL<>4").eval().toString());
  }

  @Test
  public void testVariable() throws ExpressionException {
    assertEquals("true", new ExpressionParser().parse("true").eval().toString());
    assertEquals("true", new ExpressionParser().parse("TRUE").eval().toString());
    assertEquals("true", new ExpressionParser().parse("TrUe").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("null").eval().toString());
  }

  @Test
  public void testWith() throws ExpressionException {
    assertEquals("1", new ExpressionParser().parse("WITH(1 AS a, a)").eval().toString());
    assertEquals("2", new ExpressionParser().parse("WITH(1 AS a, a+1)").eval().toString());
    assertEquals("3", new ExpressionParser().parse("WITH(1 AS a, 2 AS b, a+b)").eval().toString());
    assertEquals("4", new ExpressionParser().parse("WITH(3 AS c, (1+c))").eval().toString());
  }

  //@Disabled("Must be reapaired")
  @Test
  public void testWithRecursive() throws ExpressionException {
    assertEquals("6", new ExpressionParser().parse("WITH(3 AS c, WITH(1 AS a, 2 AS b, a+b+c))").eval().toString());
    assertEquals("3", new ExpressionParser().parse("WITH(1 AS a, WITH(2 AS c, c) AS b, a+b)").eval().toString());
    assertEquals("3", new ExpressionParser().parse("WITH(WITH(1 AS c, c) AS a, WITH(2 AS c, c) AS b, a+b)").eval().toString());
  }

  @Test
  public void testAND() throws ExpressionException {
    assertEquals("1", new ExpressionParser().parse("1 && 1").eval().toString());
    assertEquals("2", new ExpressionParser().parse("2 && 2").eval().toString());
    assertEquals("0", new ExpressionParser().parse("2 && 0").eval().toString());
    assertEquals("0", new ExpressionParser().parse("0 && 2").eval().toString());
    assertEquals("1", new ExpressionParser().parse("1 && 1 AND 1").eval().toString());
    assertEquals("2", new ExpressionParser().parse("1 && 2").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("NULL && 1").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("1 && NULL").eval().toString());
  }

  @Test
  public void testOR() throws ExpressionException {
    assertEquals("1", new ExpressionParser().parse("1 || 1").eval().toString());
    assertEquals("2", new ExpressionParser().parse("2 || 2").eval().toString());
    assertEquals("2", new ExpressionParser().parse("2 || 0").eval().toString());
    assertEquals("2", new ExpressionParser().parse("0 || 2").eval().toString());
    assertEquals("1", new ExpressionParser().parse("1 || 1 || 1").eval().toString());
    assertEquals("1", new ExpressionParser().parse("1 || 2").eval().toString());
    assertEquals("2", new ExpressionParser().parse("NULL || 2").eval().toString());
    assertEquals("2", new ExpressionParser().parse("2 || NULL").eval().toString());
  }

  @Test
  public void testXOR() throws ExpressionException {
    assertEquals("false", new ExpressionParser().parse("1 ^^ 1").eval().toString());
    assertEquals("false", new ExpressionParser().parse("2 ^^ 2").eval().toString());
    assertEquals("true", new ExpressionParser().parse("2 ^^ 0").eval().toString());
    assertEquals("true", new ExpressionParser().parse("0 ^^ 2").eval().toString());
    assertEquals("true", new ExpressionParser().parse("1 ^^ 1 ^^ 1").eval().toString());
  }

  @Test
  public void testNOT() throws ExpressionException {
    assertEquals("true", new ExpressionParser().parse("!0").eval().toString());
    assertEquals("false", new ExpressionParser().parse("!1").eval().toString());
    assertEquals("true", new ExpressionParser().parse("!!1").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("!NULL").eval().toString());
  }

  @Test
  public void testBitAND() throws ExpressionException {
    assertEquals("0", new ExpressionParser().parse("1 & 14").eval().toString());
    assertEquals("1", new ExpressionParser().parse("1 & 15").eval().toString());
    assertEquals("15", new ExpressionParser().parse("15 & 31").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("NULL & 31").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("15 & NULL").eval().toString());
  }

  @Test
  public void testBitOR() throws ExpressionException {
    assertEquals("15", new ExpressionParser().parse("1 | 14").eval().toString());
    assertEquals("15", new ExpressionParser().parse("14 | 1").eval().toString());
    assertEquals("31", new ExpressionParser().parse("15 | 31").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("NULL | 31").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("15 | NULL").eval().toString());
  }

  @Test
  public void testBitXOR() throws ExpressionException {
    assertEquals("15", new ExpressionParser().parse("1 ^ 14").eval().toString());
    assertEquals("15", new ExpressionParser().parse("14 ^ 1").eval().toString());
    assertEquals("16", new ExpressionParser().parse("15 ^ 31").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("NULL ^ 31").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("15 ^ NULL").eval().toString());
  }

  @Test
  public void testBitNOT() throws ExpressionException {
    assertEquals("-1", new ExpressionParser().parse("~0").eval().toString());
    assertEquals("-2", new ExpressionParser().parse("~1").eval().toString());
    assertEquals("NULL", new ExpressionParser().parse("~NULL").eval().toString());
    //assertEquals("0", new ExpressionParser().parse("(~0xffff)^0xffff").eval().toString());
  }

  @Test
  public void testUnary() throws ExpressionException {
    assertEquals("-1", new ExpressionParser().parse("-1").eval().toString());
    assertEquals("1", new ExpressionParser().parse("--1").eval().toString());
    assertEquals("-1", new ExpressionParser().parse("---1").eval().toString());
    assertEquals("-1", new ExpressionParser().parse("-+1").eval().toString());
    assertEquals("-1", new ExpressionParser().parse("---+++1").eval().toString());
  }

  @Test
  public void testBracket() throws ExpressionException {
    assertEquals("1", new ExpressionParser().parse("(1)").eval().toString());
    assertEquals("1", new ExpressionParser().parse("((1))").eval().toString());
    assertEquals("4", new ExpressionParser().parse("((1)+((2+1)))").eval().toString());
  }

  @Test
  public void testArray() throws ExpressionException {
    assertEquals("[1,2,3]", new ExpressionParser().parse("[1,2,3]").eval().toString());
    assertEquals("['a','b','c']", new ExpressionParser().parse("['a','b','c']").eval().toString());
    assertEquals("[[1]]", new ExpressionParser().parse("[[1]]").eval().toString());
    assertEquals("[[1,2,3]]", new ExpressionParser().parse("[[1,2,3]]").eval().toString());
    assertEquals("[[1,2,3],4]", new ExpressionParser().parse("[[1,2,3],4]").eval().toString());
    assertEquals("[NULL,2,3]", new ExpressionParser().parse("[NULL,2,3]").eval().toString());
  }

  @Test
  public void testArraySuffix() throws ExpressionException {
    assertEquals("[2]", new ExpressionParser().parse("[1,2,3][1]").eval().toString());
    assertEquals("[2,3]", new ExpressionParser().parse("[1,2,3][2,1]").eval().toString());
    assertEquals("[3]", new ExpressionParser().parse("[1,2,3][2,1][1]").eval().toString());
    assertEquals("[2]", new ExpressionParser().parse("([1,2,3])[1]").eval().toString());
    assertEquals("[]", new ExpressionParser().parse("[1,2,3][4]").eval().toString());
    assertEquals("['a','b']", new ExpressionParser().parse("['a','b','c'][0,1]").eval().toString());
  }

  @Test
  public void testNestedFunction() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("round(abs(sign(-100)))").eval().toString());
  }

  @Test
  public void testTernary() throws ExpressionException {
    assertEquals("2", new DefaultExpressionParser().parse("true ? 2 : 3").eval().toString());
    assertEquals("3", new DefaultExpressionParser().parse("false ? 2 : 3").eval().toString());
    assertEquals("2", new DefaultExpressionParser().parse("2 ? : 3").eval().toString());
    assertEquals("3", new DefaultExpressionParser().parse("NULL ? : 3").eval().toString());
    assertEquals("4", new DefaultExpressionParser().parse("false?:4").eval().toString());
  }

  @Test
  public void testPower() throws ExpressionException {
    assertEquals("9", new DefaultExpressionParser().parse("3**2").eval().toString());
    assertEquals("16", new DefaultExpressionParser().parse("2**2**2").eval().toString());
  }

  @Test
  public void testObject() throws ExpressionException {
    assertEquals("{}", new DefaultExpressionParser().parse("{}").eval().toString());
    assertEquals("{1:2}", new DefaultExpressionParser().parse("{1:2}").eval().toString());
    assertEquals("{1:2,3:4}", new DefaultExpressionParser().parse("{1:2,3:4}").eval().toString());
    assertEquals("{'a':1}", new DefaultExpressionParser().parse("{'a':1}").eval().toString());
    assertEquals("{1:{},2:[]}", new DefaultExpressionParser().parse("{1:{},2:[]}").eval().toString());
  }
}
