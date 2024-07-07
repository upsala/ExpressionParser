package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.Value;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestParser {
  private Value parse(String expression) {
    ExecutorContext context = new DefaultExecutorContext();
    return ExpressionParser.parse(expression, context).eval();
  }
  
  @Test
  public void testLiterals() throws ExpressionException {
    assertEquals("123", parse("123").toString());
    assertEquals("15", parse("0b1111").toString());
    assertEquals("43981", parse("0xabcd").toString());
    assertEquals("'abc'", parse("\"abc\"").toString());
    assertEquals("'abc'", parse("'abc'").toString());
    assertEquals("123.456", parse("123.456").toString());
    assertEquals("'ab\\\"c'", parse("\"ab\\\"c\"").toString());
  }

  @Test
  public void testArithmetic() throws ExpressionException {
    assertEquals("3", parse("1+2").toString());
    assertEquals("2", parse("3-1").toString());
    assertEquals("6", parse("2*3").toString());
    assertEquals("3", parse("21/7").toString());
    assertEquals("2", parse("27%5").toString());
    assertEquals("-23", parse("-23").toString());
    assertEquals("'ab'", parse("'a'+'b'").toString());
  }

  @Test
  public void testAdd() throws ExpressionException {
    assertEquals("3", parse("1+2").toString());
    assertEquals("6", parse("1+2+3").toString());
    assertEquals("NULL", parse("1+NULL").toString());
    assertEquals("NULL", parse("NULL+1").toString());

    assertEquals("'ab'", parse("'a'+'b'").toString());
    assertEquals("NULL", parse("'a'+NULL").toString());
    assertEquals("NULL", parse("NULL+'b'").toString());
  }

  @Test
  public void testSub() throws ExpressionException {
    assertEquals("3", parse("5-2").toString());
    assertEquals("6", parse("20-5-9").toString());
    assertEquals("NULL", parse("1-NULL").toString());
    assertEquals("NULL", parse("NULL-1").toString());
  }

  @Test
  public void testMul() throws ExpressionException {
    assertEquals("12", parse("3*4").toString());
    assertEquals("24", parse("2*3*4").toString());
    assertEquals("NULL", parse("3*NULL").toString());
    assertEquals("NULL", parse("NULL*3").toString());

    Exception exception = assertThrows(
      ExpressionException.class,
      () -> parse("1*'a'")
    );
    assertEquals("Multiplication of 'int' and 'string' is not possible", exception.getMessage());
  }

  @Test
  public void testDiv() throws ExpressionException {
    assertEquals("5", parse("10/2").toString());
    assertEquals("5", parse("100/4/5").toString());
    assertEquals("2.5", parse("10./4").toString());
    assertEquals("2.5", parse("10/4.").toString());
    assertEquals("2", parse("10/4").toString());
    assertEquals("NULL", parse("10/NULL").toString());
    assertEquals("NULL", parse("NULL/10").toString());

    Exception exception = assertThrows(
      ExpressionException.class,
      () -> parse("1/'a'")
    );
    assertEquals("Division of 'int' and 'string' is not possible", exception.getMessage());
  }

  @Test
  public void testMod() throws ExpressionException {
    assertEquals("1", parse("10%3").toString());
    assertEquals("1", parse("100%24%3").toString());
    assertEquals("2", parse("10%4").toString());
    assertEquals("NULL", parse("10%NULL").toString());
    assertEquals("NULL", parse("NULL%10").toString());

    Exception exception = assertThrows(
      ExpressionException.class,
      () -> parse("1%'a'")
    );
    assertEquals("Modulo of 'int' and 'string' is not possible", exception.getMessage());
  }

  @Test
  public void testNeg() throws ExpressionException {
    assertEquals("-10", parse("-10").toString());
    assertEquals("10", parse("--10").toString());
    assertEquals("-2.5", parse("-2.5").toString());
    assertEquals("NULL", parse("-NULL").toString());
    assertEquals("1", parse("4+-3").toString());

    Exception exception = assertThrows(
      ExpressionException.class,
      () -> parse("-'a'")
    );
    assertEquals("Negation of 'string' is not possible", exception.getMessage());
  }

  @Test
  public void testBitShift() throws ExpressionException {
    assertEquals("16", parse("1<<4").toString());
    assertEquals("NULL", parse("NULL<<4").toString());
    assertEquals("NULL", parse("1<<NULL").toString());

    assertEquals("2", parse("16>>3").toString());
    assertEquals("NULL", parse("NULL>>3").toString());
    assertEquals("NULL", parse("16>>NULL").toString());

    Exception exception = assertThrows(
      ExpressionException.class,
      () -> parse("1<<'a'")
    );
    assertEquals("Shift left of 'int' and 'string' is not possible", exception.getMessage());

    exception = assertThrows(
      ExpressionException.class,
      () -> parse("1>>'a'")
    );
    assertEquals("Shift right of 'int' and 'string' is not possible", exception.getMessage());
  }

  @Test
  public void testCompare() throws ExpressionException {
    assertEquals("true", parse("1<4").toString());
    assertEquals("false", parse("4<1").toString());
    assertEquals("NULL", parse("4<NULL").toString());
    assertEquals("NULL", parse("NULL<4").toString());

    assertEquals("true", parse("4>1").toString());
    assertEquals("false", parse("1>4").toString());
    assertEquals("NULL", parse("4>NULL").toString());
    assertEquals("NULL", parse("NULL>4").toString());

    assertEquals("true", parse("1<=4").toString());
    assertEquals("false", parse("4<=1").toString());
    assertEquals("true", parse("4<=4").toString());
    assertEquals("NULL", parse("4<=NULL").toString());
    assertEquals("NULL", parse("NULL<=4").toString());

    assertEquals("false", parse("1>=4").toString());
    assertEquals("true", parse("4>=1").toString());
    assertEquals("true", parse("4>=4").toString());
    assertEquals("NULL", parse("4>=NULL").toString());
    assertEquals("NULL", parse("NULL>=4").toString());

    assertEquals("false", parse("1==4").toString());
    assertEquals("true", parse("4==4").toString());
    assertEquals("NULL", parse("4==NULL").toString());
    assertEquals("NULL", parse("NULL==4").toString());

    assertEquals("true", parse("1<>4").toString());
    assertEquals("false", parse("4<>4").toString());
    assertEquals("NULL", parse("4<>NULL").toString());
    assertEquals("NULL", parse("NULL<>4").toString());
  }

  @Test
  public void testVariable() throws ExpressionException {
    assertEquals("true", parse("true").toString());
    assertEquals("true", parse("TRUE").toString());
    assertEquals("true", parse("TrUe").toString());
    assertEquals("NULL", parse("null").toString());
  }

  @Test
  public void testWith() throws ExpressionException {
    assertEquals("1", parse("WITH(1 AS a, a)").toString());
    assertEquals("2", parse("WITH(1 AS a, a+1)").toString());
    assertEquals("3", parse("WITH(1 AS a, 2 AS b, a+b)").toString());
    assertEquals("4", parse("WITH(3 AS c, (1+c))").toString());
  }

  //@Disabled("Must be reapaired")
  @Test
  public void testWithRecursive() throws ExpressionException {
    assertEquals("6", parse("WITH(3 AS c, WITH(1 AS a, 2 AS b, a+b+c))").toString());
    assertEquals("3", parse("WITH(1 AS a, WITH(2 AS c, c) AS b, a+b)").toString());
    assertEquals("3", parse("WITH(WITH(1 AS c, c) AS a, WITH(2 AS c, c) AS b, a+b)").toString());
  }

  @Test
  public void testAND() throws ExpressionException {
    assertEquals("1", parse("1 && 1").toString());
    assertEquals("2", parse("2 && 2").toString());
    assertEquals("0", parse("2 && 0").toString());
    assertEquals("0", parse("0 && 2").toString());
    assertEquals("1", parse("1 && 1 AND 1").toString());
    assertEquals("2", parse("1 && 2").toString());
    assertEquals("NULL", parse("NULL && 1").toString());
    assertEquals("NULL", parse("1 && NULL").toString());
  }

  @Test
  public void testOR() throws ExpressionException {
    assertEquals("1", parse("1 || 1").toString());
    assertEquals("2", parse("2 || 2").toString());
    assertEquals("2", parse("2 || 0").toString());
    assertEquals("2", parse("0 || 2").toString());
    assertEquals("1", parse("1 || 1 || 1").toString());
    assertEquals("1", parse("1 || 2").toString());
    assertEquals("2", parse("NULL || 2").toString());
    assertEquals("2", parse("2 || NULL").toString());
  }

  @Test
  public void testXOR() throws ExpressionException {
    assertEquals("false", parse("1 ^^ 1").toString());
    assertEquals("false", parse("2 ^^ 2").toString());
    assertEquals("true", parse("2 ^^ 0").toString());
    assertEquals("true", parse("0 ^^ 2").toString());
    assertEquals("true", parse("1 ^^ 1 ^^ 1").toString());
  }

  @Test
  public void testNOT() throws ExpressionException {
    assertEquals("true", parse("!0").toString());
    assertEquals("false", parse("!1").toString());
    assertEquals("true", parse("!!1").toString());
    assertEquals("NULL", parse("!NULL").toString());
  }

  @Test
  public void testBitAND() throws ExpressionException {
    assertEquals("0", parse("1 & 14").toString());
    assertEquals("1", parse("1 & 15").toString());
    assertEquals("15", parse("15 & 31").toString());
    assertEquals("NULL", parse("NULL & 31").toString());
    assertEquals("NULL", parse("15 & NULL").toString());
  }

  @Test
  public void testBitOR() throws ExpressionException {
    assertEquals("15", parse("1 | 14").toString());
    assertEquals("15", parse("14 | 1").toString());
    assertEquals("31", parse("15 | 31").toString());
    assertEquals("NULL", parse("NULL | 31").toString());
    assertEquals("NULL", parse("15 | NULL").toString());
  }

  @Test
  public void testBitXOR() throws ExpressionException {
    assertEquals("15", parse("1 ^ 14").toString());
    assertEquals("15", parse("14 ^ 1").toString());
    assertEquals("16", parse("15 ^ 31").toString());
    assertEquals("NULL", parse("NULL ^ 31").toString());
    assertEquals("NULL", parse("15 ^ NULL").toString());
  }

  @Test
  public void testBitNOT() throws ExpressionException {
    assertEquals("-1", parse("~0").toString());
    assertEquals("-2", parse("~1").toString());
    assertEquals("NULL", parse("~NULL").toString());
    //assertEquals("0", parse("(~0xffff)^0xffff").toString());
  }

  @Test
  public void testUnary() throws ExpressionException {
    assertEquals("-1", parse("-1").toString());
    assertEquals("1", parse("--1").toString());
    assertEquals("-1", parse("---1").toString());
    assertEquals("-1", parse("-+1").toString());
    assertEquals("-1", parse("---+++1").toString());
  }

  @Test
  public void testBracket() throws ExpressionException {
    assertEquals("1", parse("(1)").toString());
    assertEquals("1", parse("((1))").toString());
    assertEquals("4", parse("((1)+((2+1)))").toString());
  }

  @Test
  public void testArray() throws ExpressionException {
    assertEquals("[1,2,3]", parse("[1,2,3]").toString());
    assertEquals("['a','b','c']", parse("['a','b','c']").toString());
    assertEquals("[[1]]", parse("[[1]]").toString());
    assertEquals("[[1,2,3]]", parse("[[1,2,3]]").toString());
    assertEquals("[[1,2,3],4]", parse("[[1,2,3],4]").toString());
    assertEquals("[NULL,2,3]", parse("[NULL,2,3]").toString());
  }

  @Test
  public void testArraySuffix() throws ExpressionException {
    assertEquals("[2]", parse("[1,2,3][1]").toString());
    assertEquals("[2,3]", parse("[1,2,3][2,1]").toString());
    assertEquals("[3]", parse("[1,2,3][2,1][1]").toString());
    assertEquals("[2]", parse("([1,2,3])[1]").toString());
    assertEquals("[]", parse("[1,2,3][4]").toString());
    assertEquals("['a','b']", parse("['a','b','c'][0,1]").toString());
  }

  @Test
  public void testNestedFunction() throws ExpressionException {
    assertEquals("1", parse("Round(abs(Sign(-100)))").toString());
  }

  @Test
  public void testTernary() throws ExpressionException {
    assertEquals("2", parse("true ? 2 : 3").toString());
    assertEquals("3", parse("false ? 2 : 3").toString());
    assertEquals("2", parse("2 ? : 3").toString());
    assertEquals("3", parse("NULL ? : 3").toString());
    assertEquals("4", parse("false?:4").toString());
  }

  @Test
  public void testPower() throws ExpressionException {
    assertEquals("9", parse("3**2").toString());
    assertEquals("16", parse("2**2**2").toString());
  }

  @Test
  public void testObject() throws ExpressionException {
    assertEquals("{}", parse("{}").toString());
    assertEquals("{1:2}", parse("{1:2}").toString());
    assertEquals("{1:2,3:4}", parse("{1:2,3:4}").toString());
    assertEquals("{'a':1}", parse("{'a':1}").toString());
    assertEquals("{1:{},2:[]}", parse("{1:{},2:[]}").toString());
  }

  @Test
  public void testLambda() throws ExpressionException {
    assertEquals("1", parse("()->1").toString());
    assertEquals("1", parse("(()->1)").toString());
    assertEquals("3", parse("()->1+()->2").toString());
    assertEquals("1", parse("()->3-()->2").toString());
    assertEquals("6", parse("()->2*()->3").toString());
    assertEquals("2", parse("()->6/()->3").toString());
    assertEquals("1", parse("()->7%()->3").toString());
    assertEquals("5", parse("max(()->5, ()->4)").toString());
    assertEquals("true", parse("()->3>()->2").toString());
    assertEquals("false", parse("()->3<()->2").toString());
    assertEquals("false", parse("()->3==()->2").toString());
    assertEquals("true", parse("()->3!=()->2").toString());
    assertEquals("true", parse("()->3>=()->2").toString());
    assertEquals("false", parse("()->3<=()->2").toString());
    assertEquals("[3]", parse("(()->[1,2,3])[2]").toString());
    assertEquals("[2]", parse("[1,2,3][()->1]").toString());
    //assertEquals("[2,3]", parse("[1,2,3][()->1..()->2]").toString()); //TODO: Not possible to test currently, because of an other bug
    assertEquals("1", parse("()->true?()->1:()->2").toString());
    assertEquals("2", parse("()->false?()->1:()->2").toString());
    assertEquals("[1,2]", parse("[()->1,()->2]").toString());
    assertEquals("{1:2}", parse("{()->1:()->2}").toString());
    assertEquals("3", parse("with(()->1 as a, a+()->2)").toString());
  }
}
