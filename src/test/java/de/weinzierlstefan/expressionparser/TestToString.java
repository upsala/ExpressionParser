package de.weinzierlstefan.expressionparser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestToString {

  @Test
  public void testAdd() {
    assertEquals("1+1", new ExpressionParser().parse("1+1").toString());
    assertEquals("1+2+3", new ExpressionParser().parse("1+2+3").toString());
  }

  @Test
  public void testArray() {
    assertEquals("[]", new ExpressionParser().parse("[]").toString());
    assertEquals("[1]", new ExpressionParser().parse("[1]").toString());
    assertEquals("[1, 2]", new ExpressionParser().parse("[1,2]").toString());
    assertEquals("[1, 2, 3]", new ExpressionParser().parse("[1,2,3]").toString());
  }

  @Test
  public void testArraySelector() {
    assertEquals("[][1]", new ExpressionParser().parse("[][1]").toString());
    assertEquals("[1][1,2]", new ExpressionParser().parse("[1][1,2]").toString());
    assertEquals("[1][1,2,3]", new ExpressionParser().parse("[1][1,2,3]").toString());
    assertEquals("[1][1+1]", new ExpressionParser().parse("[1][1+1]").toString());
    assertEquals("[1][2][3]", new ExpressionParser().parse("[1][2][3]").toString());
    assertEquals("[][1,5-8,10]", new ExpressionParser().parse("[][1,5-8,10]").toString());
    assertEquals("[][10-3]", new ExpressionParser().parse("[][10-3]").toString());
  }

  @Test
  public void testBitAnd() {
    assertEquals("1&1", new ExpressionParser().parse("1&1").toString());
    assertEquals("1&2&3", new ExpressionParser().parse("1&2&3").toString());
  }

  @Test
  public void testBitNot() {
    assertEquals("~1", new ExpressionParser().parse("~1").toString());
    assertEquals("~~1", new ExpressionParser().parse("~~1").toString());
  }

  @Test
  public void testBitOr() {
    assertEquals("1|1", new ExpressionParser().parse("1|1").toString());
    assertEquals("1|2|3", new ExpressionParser().parse("1|2|3").toString());
  }

  @Test
  public void testBitXor() {
    assertEquals("1^1", new ExpressionParser().parse("1^1").toString());
    assertEquals("1^2^3", new ExpressionParser().parse("1^2^3").toString());
  }

  @Test
  public void testBoolAnd() {
    assertEquals("1&&1", new ExpressionParser().parse("1&&1").toString());
    assertEquals("1&&2&&3", new ExpressionParser().parse("1&&2&&3").toString());
  }

  @Test
  public void testBoolNot() {
    assertEquals("!1", new ExpressionParser().parse("!1").toString());
    assertEquals("!!1", new ExpressionParser().parse("!!1").toString());
  }

  @Test
  public void testBoolOr() {
    assertEquals("1||1", new ExpressionParser().parse("1||1").toString());
    assertEquals("1||2||3", new ExpressionParser().parse("1||2||3").toString());
  }

  @Test
  public void testBoolXor() {
    assertEquals("1^^1", new ExpressionParser().parse("1^^1").toString());
    assertEquals("1^^2^^3", new ExpressionParser().parse("1^^2^^3").toString());
  }

  @Test
  public void testCompEQ() {
    assertEquals("1==1", new ExpressionParser().parse("1==1").toString());
    assertEquals("1==2==3", new ExpressionParser().parse("1==2==3").toString());
  }

  @Test
  public void testCompGE() {
    assertEquals("1>=1", new ExpressionParser().parse("1>=1").toString());
    assertEquals("1>=2>=3", new ExpressionParser().parse("1>=2>=3").toString());
  }

  @Test
  public void testCompGT() {
    assertEquals("1>1", new ExpressionParser().parse("1>1").toString());
    assertEquals("1>2>3", new ExpressionParser().parse("1>2>3").toString());
  }

  @Test
  public void testCompLE() {
    assertEquals("1<=1", new ExpressionParser().parse("1<=1").toString());
    assertEquals("1<=2<=3", new ExpressionParser().parse("1<=2<=3").toString());
  }

  @Test
  public void testCompLT() {
    assertEquals("1<1", new ExpressionParser().parse("1<1").toString());
    assertEquals("1<2<3", new ExpressionParser().parse("1<2<3").toString());
  }

  @Test
  public void testCompNE() {
    assertEquals("1<>1", new ExpressionParser().parse("1<>1").toString());
    assertEquals("1<>2<>3", new ExpressionParser().parse("1<>2<>3").toString());
  }

  @Test
  public void testDiv() {
    assertEquals("1/1", new ExpressionParser().parse("1/1").toString());
    assertEquals("1/2/3", new ExpressionParser().parse("1/2/3").toString());
  }

  @Test
  public void testFunction() {
    assertEquals("sin(1)", new ExpressionParser().parse("sin(1)").toString());
    assertEquals("max(1,2,3)", new ExpressionParser().parse("max(1,2,3)").toString());
    assertEquals("max(1,min(2,3))", new ExpressionParser().parse("max(1,min(2,3))").toString());
  }

  @Test
  public void testModulo() {
    assertEquals("1%1", new ExpressionParser().parse("1%1").toString());
    assertEquals("1%2%3", new ExpressionParser().parse("1%2%3").toString());
  }

  @Test
  public void testMul() {
    assertEquals("1*1", new ExpressionParser().parse("1*1").toString());
    assertEquals("1*2*3", new ExpressionParser().parse("1*2*3").toString());
  }

  @Test
  public void testNegate() {
    assertEquals("-1", new ExpressionParser().parse("-1").toString());
    assertEquals("--1", new ExpressionParser().parse("--1").toString());
  }

  @Test
  public void testNested() {
    assertEquals("1", new ExpressionParser().parse("(1)").toString());
    assertEquals("1", new ExpressionParser().parse("((1))").toString());
    assertEquals("(1+1)", new ExpressionParser().parse("(1+1)").toString());
    assertEquals("(1+1)", new ExpressionParser().parse("((1+1))").toString());
  }

  @Test
  public void testPower() {
    assertEquals("1**2", new ExpressionParser().parse("1**2").toString());
    assertEquals("1**2**3", new ExpressionParser().parse("1**2**3").toString());
  }

  @Test
  public void testShiftLeft() {
    assertEquals("1<<2", new ExpressionParser().parse("1<<2").toString());
    assertEquals("1<<2<<3", new ExpressionParser().parse("1<<2<<3").toString());
  }

  @Test
  public void testShiftRight() {
    assertEquals("1>>2", new ExpressionParser().parse("1>>2").toString());
    assertEquals("1>>2>>3", new ExpressionParser().parse("1>>2>>3").toString());
  }

  @Test
  public void testSub() {
    assertEquals("1-2", new ExpressionParser().parse("1-2").toString());
    assertEquals("1-2-3", new ExpressionParser().parse("1-2-3").toString());
  }

  @Test
  public void testTernary() {
    assertEquals("1?2:3", new ExpressionParser().parse("1?2:3").toString());
    assertEquals("1?2?3:4:5", new ExpressionParser().parse("1?2?3:4:5").toString());
    assertEquals("1?:2", new ExpressionParser().parse("1?:2").toString());
  }


  @Test
  public void testValue() {
    assertEquals("1", new ExpressionParser().parse("1").toString());
    assertEquals("1.1", new ExpressionParser().parse("1.1").toString());
    assertEquals("11.0", new ExpressionParser().parse("1.1e1").toString());
    assertEquals("a", new ExpressionParser().parse("a").toString());
    assertEquals("abc", new ExpressionParser().parse("abc").toString());
    assertEquals("ABC", new ExpressionParser().parse("ABC").toString());
    assertEquals("`A B C`", new ExpressionParser().parse("`A B C`").toString());
    assertEquals("_ABC", new ExpressionParser().parse("_ABC").toString());
    assertEquals("_ABC123abc", new ExpressionParser().parse("_ABC123abc").toString());
    assertEquals("'abc'", new ExpressionParser().parse("'abc'").toString());
    assertEquals("'abc'", new ExpressionParser().parse("\"abc\"").toString());
  }

  @Test
  public void testWith() {
    assertEquals("WITH(1 AS a, a)", new ExpressionParser().parse("with(1 as a,a)").toString());
  }

  @Test
  public void testCombined() {
    assertEquals("1+2*3-4/5%6**7>>8<<9|1&2^3&&4||5^^6?7:8<9>1>=2<=3==4<>5+WITH(1 AS a, 2 AS b, a+b)*(3+4)", new ExpressionParser().parse("1+2*3-4/5%6**7>>8<<9|1&2^3&&4||5^^6?7:8<9>1>=2<=3==4<>5+with(1 as a, 2 as b, a+b)*(3+4)").toString());
  }
}
