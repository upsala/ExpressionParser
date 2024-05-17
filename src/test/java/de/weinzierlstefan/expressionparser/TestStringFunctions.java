package de.weinzierlstefan.expressionparser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStringFunctions {

  @Test
  public void testCharAt() throws ExpressionException {
    assertEquals("b", new DefaultExpressionParser().parse("charat('abc',1)").eval().getString());
  }

  @Test
  public void testConcat() throws ExpressionException {
    assertEquals("123", new DefaultExpressionParser().parse("concat(1,2,3)").eval().getString());
    assertEquals("abc123", new DefaultExpressionParser().parse("concat('abc',123)").eval().getString());
  }

  @Test
  public void testConcatWs() throws ExpressionException {
    assertEquals("1,2,3", new DefaultExpressionParser().parse("concatWs(',', 1,2,3)").eval().getString());
    assertEquals("abc,123", new DefaultExpressionParser().parse("concatWs(',', 'abc',123)").eval().getString());
  }

  @Test
  public void testEndsWith() throws ExpressionException {
    assertEquals("true", new DefaultExpressionParser().parse("endswith('abc', 'c')").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("endswith('abc', 'a')").eval().getString());
  }

  @Test
  public void testFormat() throws ExpressionException {
    assertEquals("abc", new DefaultExpressionParser().parse("format('a%c', 'b')").eval().getString());
    assertEquals("abc1", new DefaultExpressionParser().parse("format('a%c%', 'b', 1)").eval().getString());
    assertEquals("abc1", new DefaultExpressionParser().parse("format('a%c%', 'b', 1, 2)").eval().getString());
    assertEquals("abc", new DefaultExpressionParser().parse("format('abc', 'b', 1, 2)").eval().getString());
  }

  @Test
  public void testIncludes() throws ExpressionException {
    assertEquals("true", new DefaultExpressionParser().parse("includes('abcdef', 'de')").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("includes('abcdef', 'ee')").eval().getString());
  }

  @Test
  public void testIndexOf() throws ExpressionException {
    assertEquals("3", new DefaultExpressionParser().parse("indexof('abcdef', 'de')").eval().getString());
    assertEquals("-1", new DefaultExpressionParser().parse("indexof('abcdef', 'ee')").eval().getString());
    assertEquals("3", new DefaultExpressionParser().parse("indexof('abcdefde', 'de')").eval().getString());
  }

  @Test
  public void testIsBlank() throws ExpressionException {
    assertEquals("true", new DefaultExpressionParser().parse("isblank('')").eval().getString());
    assertEquals("true", new DefaultExpressionParser().parse("isblank('  ')").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("isblank('abc')").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("isblank(' a ')").eval().getString());
  }

  @Test
  public void testIsEmpty() throws ExpressionException {
    assertEquals("true", new DefaultExpressionParser().parse("isempty('')").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("isempty('  ')").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("isempty('abc')").eval().getString());
  }

  @Test
  public void testLastIndexOf() throws ExpressionException {
    assertEquals("3", new DefaultExpressionParser().parse("lastindexof('abcdef', 'de')").eval().getString());
    assertEquals("-1", new DefaultExpressionParser().parse("lastindexof('abcdef', 'ee')").eval().getString());
    assertEquals("6", new DefaultExpressionParser().parse("lastindexof('abcdefde', 'de')").eval().getString());
  }

  @Test
  public void testLeft() throws ExpressionException {
    assertEquals("ab", new DefaultExpressionParser().parse("left('abc', 2)").eval().getString());
    assertEquals("abc", new DefaultExpressionParser().parse("left('abc', 4)").eval().getString());
  }

  @Test
  public void testLength() throws ExpressionException {
    assertEquals("3", new DefaultExpressionParser().parse("length('abc')").eval().getString());
    assertEquals("5", new DefaultExpressionParser().parse("length(12345)").eval().getString());
  }

  @Test
  public void testLike() throws ExpressionException {
    assertEquals("false", new DefaultExpressionParser().parse("like('abc','a')").eval().getString());
    assertEquals("true", new DefaultExpressionParser().parse("like('abc','a%')").eval().getString());
    assertEquals("true", new DefaultExpressionParser().parse("like('abc','a__')").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("like('abc','a_')").eval().getString());
  }

  @Test
  public void testLower() throws ExpressionException {
    assertEquals("abc", new DefaultExpressionParser().parse("lower('ABC')").eval().getString());
  }

  @Test
  public void testLPad() throws ExpressionException {
    assertEquals("   abc", new DefaultExpressionParser().parse("lpad('abc', 6)").eval().getString());
    assertEquals("...abc", new DefaultExpressionParser().parse("lpad('abc', 6, '.')").eval().getString());
    assertEquals("abc", new DefaultExpressionParser().parse("lpad('abc', 2)").eval().getString());
  }

  @Test
  public void testLTrim() throws ExpressionException {
    assertEquals("abc  ", new DefaultExpressionParser().parse("ltrim('  abc  ')").eval().getString());
    assertEquals("abc33", new DefaultExpressionParser().parse("ltrim('33abc33','3')").eval().getString());
  }

  @Test
  public void testRegexFind() throws ExpressionException {
    assertEquals("12", new DefaultExpressionParser().parse("regexfind('abc12','[0-9]+')").eval().getString());
    assertEquals("", new DefaultExpressionParser().parse("regexfind('abc12','^[0-9]+')").eval().getString());
  }

  @Test
  public void testRegexMatch() throws ExpressionException {
    assertEquals("true", new DefaultExpressionParser().parse("regexmatch('abc12','[0-9]+')").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("regexmatch('abc12','^[0-9]+')").eval().getString());
    assertEquals("true", new DefaultExpressionParser().parse("regexmatch('abc12','^[a-z0-9]+$')").eval().getString());
  }

  @Test
  public void testRegexReplace() throws ExpressionException {
    assertEquals("abcde", new DefaultExpressionParser().parse("regexreplace('abc12','[0-9]+', 'de')").eval().getString());
  }

  @Test
  public void testRegexSplit() throws ExpressionException {
    assertEquals("['a','b','c','']", new DefaultExpressionParser().parse("regexsplit('abc', '')").eval().getString());
    assertEquals("['a','b','c']", new DefaultExpressionParser().parse("regexsplit('a,b,c',',')").eval().getString());
    assertEquals("['a','b','c']", new DefaultExpressionParser().parse("regexsplit('a123b555c','[0-9]+')").eval().getString());
    assertEquals("['a','b-c']", new DefaultExpressionParser().parse("regexsplit('a-b-c','-',2)").eval().getString());
  }

  @Test
  public void testRepeat() throws ExpressionException {
    assertEquals("aaaaa", new DefaultExpressionParser().parse("repeat('a',5)").eval().getString());
    assertEquals("ababab", new DefaultExpressionParser().parse("repeat('ab',3)").eval().getString());
  }

  @Test
  public void testReplace() throws ExpressionException {
    assertEquals("1bc", new DefaultExpressionParser().parse("replace('abc','a','1')").eval().getString());
    assertEquals("12c", new DefaultExpressionParser().parse("replace('abc','ab','12')").eval().getString());
  }

  @Test
  public void testReverse() throws ExpressionException {
    assertEquals("cba", new DefaultExpressionParser().parse("reverse('abc')").eval().getString());
  }

  @Test
  public void testRight() throws ExpressionException {
    assertEquals("bc", new DefaultExpressionParser().parse("right('abc', 2)").eval().getString());
    assertEquals("abc", new DefaultExpressionParser().parse("right('abc', 4)").eval().getString());
  }

  @Test
  public void testRPad() throws ExpressionException {
    assertEquals("abc   ", new DefaultExpressionParser().parse("rpad('abc', 6)").eval().getString());
    assertEquals("abc...", new DefaultExpressionParser().parse("rpad('abc', 6, '.')").eval().getString());
    assertEquals("abc", new DefaultExpressionParser().parse("rpad('abc', 2)").eval().getString());
  }

  @Test
  public void testRTrim() throws ExpressionException {
    assertEquals("  abc", new DefaultExpressionParser().parse("rtrim('  abc  ')").eval().getString());
    assertEquals("33abc", new DefaultExpressionParser().parse("rtrim('33abc33','3')").eval().getString());
  }

  @Test
  public void testSplit() throws ExpressionException {
    assertEquals("['a','b','c','']", new DefaultExpressionParser().parse("split('abc', '')").eval().getString());
    assertEquals("['a','b','c']", new DefaultExpressionParser().parse("split('a,b,c',',')").eval().getString());
    assertEquals("['abc']", new DefaultExpressionParser().parse("split('abc',',')").eval().getString());
    assertEquals("['a','b-c']", new DefaultExpressionParser().parse("split('a-b-c','-',2)").eval().getString());
  }

  @Test
  public void testStartsWith() throws ExpressionException {
    assertEquals("true", new DefaultExpressionParser().parse("startswith('abc', 'a')").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("startswith('abc', 'b')").eval().getString());
  }

  @Test
  public void testSubstr() throws ExpressionException {
    assertEquals("fghij", new DefaultExpressionParser().parse("substr('abcdefghijklmn', 5, 5)").eval().getString());
    assertEquals("jklmn", new DefaultExpressionParser().parse("substr('abcdefghijklmn', -5)").eval().getString());
    assertEquals("bc", new DefaultExpressionParser().parse("substr('abc', 1, 10)").eval().getString());
    assertEquals("jklmn", new DefaultExpressionParser().parse("substr('abcdefghijklmn', -5)").eval().getString());
    assertEquals("jklmn", new DefaultExpressionParser().parse("substr('abcdefghijklmn', -5, 10)").eval().getString());
  }

  @Test
  public void testSubstring() throws ExpressionException {
    assertEquals("", new DefaultExpressionParser().parse("substring('abcdefghijklmn', 5, 5)").eval().getString());
    assertEquals("abcdefghijklmn", new DefaultExpressionParser().parse("substring('abcdefghijklmn', -5)").eval().getString());
    assertEquals("bc", new DefaultExpressionParser().parse("substring('abc', 1, 10)").eval().getString());
    assertEquals("abcdefghijklmn", new DefaultExpressionParser().parse("substring('abcdefghijklmn', -5)").eval().getString());
    assertEquals("abcdefghij", new DefaultExpressionParser().parse("substring('abcdefghijklmn', -5, 10)").eval().getString());
  }

  @Test
  public void testTrim() throws ExpressionException {
    assertEquals("abc", new DefaultExpressionParser().parse("trim('  abc  ')").eval().getString());
    assertEquals("a b c", new DefaultExpressionParser().parse("trim('  a b c  ')").eval().getString());
  }

  @Test
  public void testUpper() throws ExpressionException {
    assertEquals("ABC", new DefaultExpressionParser().parse("upper('abc')").eval().getString());
  }
}
