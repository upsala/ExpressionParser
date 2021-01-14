package de.weinzierlstefan.expressionparser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStringFunctions {

  @Test
  public void testCharAt() throws ExpressionException {
    assertEquals("b", new DefaultExpressionParser().parse("charat('abc',1)").eval().toString());
  }

  @Test
  public void testConcat() throws ExpressionException {
    assertEquals("123", new DefaultExpressionParser().parse("concat(1,2,3)").eval().toString());
    assertEquals("abc123", new DefaultExpressionParser().parse("concat('abc',123)").eval().toString());
  }

  @Test
  public void testConcatWs() throws ExpressionException {
    assertEquals("1,2,3", new DefaultExpressionParser().parse("concatWs(',', 1,2,3)").eval().toString());
    assertEquals("abc,123", new DefaultExpressionParser().parse("concatWs(',', 'abc',123)").eval().toString());
  }

  @Test
  public void testEndsWith() throws ExpressionException {
    assertEquals("true", new DefaultExpressionParser().parse("endswith('abc', 'c')").eval().toString());
    assertEquals("false", new DefaultExpressionParser().parse("endswith('abc', 'a')").eval().toString());
  }

  @Test
  public void testFormat() throws ExpressionException {
    assertEquals("abc", new DefaultExpressionParser().parse("format('a%c', 'b')").eval().toString());
    assertEquals("abc1", new DefaultExpressionParser().parse("format('a%c%', 'b', 1)").eval().toString());
    assertEquals("abc1", new DefaultExpressionParser().parse("format('a%c%', 'b', 1, 2)").eval().toString());
    assertEquals("abc", new DefaultExpressionParser().parse("format('abc', 'b', 1, 2)").eval().toString());
  }

  @Test
  public void testIncludes() throws ExpressionException {
    assertEquals("true", new DefaultExpressionParser().parse("includes('abcdef', 'de')").eval().toString());
    assertEquals("false", new DefaultExpressionParser().parse("includes('abcdef', 'ee')").eval().toString());
  }

  @Test
  public void testIndexOf() throws ExpressionException {
    assertEquals("3", new DefaultExpressionParser().parse("indexof('abcdef', 'de')").eval().toString());
    assertEquals("-1", new DefaultExpressionParser().parse("indexof('abcdef', 'ee')").eval().toString());
    assertEquals("3", new DefaultExpressionParser().parse("indexof('abcdefde', 'de')").eval().toString());
  }

  @Test
  public void testIsBlank() throws ExpressionException {
    assertEquals("true", new DefaultExpressionParser().parse("isblank('')").eval().toString());
    assertEquals("true", new DefaultExpressionParser().parse("isblank('  ')").eval().toString());
    assertEquals("false", new DefaultExpressionParser().parse("isblank('abc')").eval().toString());
    assertEquals("false", new DefaultExpressionParser().parse("isblank(' a ')").eval().toString());
  }

  @Test
  public void testIsEmpty() throws ExpressionException {
    assertEquals("true", new DefaultExpressionParser().parse("isempty('')").eval().toString());
    assertEquals("false", new DefaultExpressionParser().parse("isempty('  ')").eval().toString());
    assertEquals("false", new DefaultExpressionParser().parse("isempty('abc')").eval().toString());
  }

  @Test
  public void testLastIndexOf() throws ExpressionException {
    assertEquals("3", new DefaultExpressionParser().parse("lastindexof('abcdef', 'de')").eval().toString());
    assertEquals("-1", new DefaultExpressionParser().parse("lastindexof('abcdef', 'ee')").eval().toString());
    assertEquals("6", new DefaultExpressionParser().parse("lastindexof('abcdefde', 'de')").eval().toString());
  }

  @Test
  public void testLeft() throws ExpressionException {
    assertEquals("ab", new DefaultExpressionParser().parse("left('abc', 2)").eval().toString());
    assertEquals("abc", new DefaultExpressionParser().parse("left('abc', 4)").eval().toString());
  }

  @Test
  public void testLength() throws ExpressionException {
    assertEquals("3", new DefaultExpressionParser().parse("length('abc')").eval().toString());
    assertEquals("5", new DefaultExpressionParser().parse("length(12345)").eval().toString());
  }

  @Test
  public void testLike() throws ExpressionException {
    assertEquals("false", new DefaultExpressionParser().parse("like('abc','a')").eval().toString());
    assertEquals("true", new DefaultExpressionParser().parse("like('abc','a%')").eval().toString());
    assertEquals("true", new DefaultExpressionParser().parse("like('abc','a__')").eval().toString());
    assertEquals("false", new DefaultExpressionParser().parse("like('abc','a_')").eval().toString());
  }

  @Test
  public void testLower() throws ExpressionException {
    assertEquals("abc", new DefaultExpressionParser().parse("lower('ABC')").eval().toString());
  }

  @Test
  public void testLPad() throws ExpressionException {
    assertEquals("   abc", new DefaultExpressionParser().parse("lpad('abc', 6)").eval().toString());
    assertEquals("...abc", new DefaultExpressionParser().parse("lpad('abc', 6, '.')").eval().toString());
    assertEquals("abc", new DefaultExpressionParser().parse("lpad('abc', 2)").eval().toString());
  }

  @Test
  public void testLTrim() throws ExpressionException {
    assertEquals("abc  ", new DefaultExpressionParser().parse("ltrim('  abc  ')").eval().toString());
    assertEquals("abc33", new DefaultExpressionParser().parse("ltrim('33abc33','3')").eval().toString());
  }

  @Test
  public void testRegexFind() throws ExpressionException {
    assertEquals("12", new DefaultExpressionParser().parse("regexfind('abc12','[0-9]+')").eval().toString());
    assertEquals("", new DefaultExpressionParser().parse("regexfind('abc12','^[0-9]+')").eval().toString());
  }

  @Test
  public void testRegexMatch() throws ExpressionException {
    assertEquals("true", new DefaultExpressionParser().parse("regexmatch('abc12','[0-9]+')").eval().toString());
    assertEquals("false", new DefaultExpressionParser().parse("regexmatch('abc12','^[0-9]+')").eval().toString());
    assertEquals("true", new DefaultExpressionParser().parse("regexmatch('abc12','^[a-z0-9]+$')").eval().toString());
  }

  @Test
  public void testRegexReplace() throws ExpressionException {
    assertEquals("abcde", new DefaultExpressionParser().parse("regexreplace('abc12','[0-9]+', 'de')").eval().toString());
  }

  @Test
  public void testRegexSplit() throws ExpressionException {
    assertEquals("[a,b,c,]", new DefaultExpressionParser().parse("regexsplit('abc', '')").eval().toString());
    assertEquals("[a,b,c]", new DefaultExpressionParser().parse("regexsplit('a,b,c',',')").eval().toString());
    assertEquals("[a,b,c]", new DefaultExpressionParser().parse("regexsplit('a123b555c','[0-9]+')").eval().toString());
    assertEquals("[a,b-c]", new DefaultExpressionParser().parse("regexsplit('a-b-c','-',2)").eval().toString());
  }

  @Test
  public void testRepeat() throws ExpressionException {
    assertEquals("aaaaa", new DefaultExpressionParser().parse("repeat('a',5)").eval().toString());
    assertEquals("ababab", new DefaultExpressionParser().parse("repeat('ab',3)").eval().toString());
  }

  @Test
  public void testReplace() throws ExpressionException {
    assertEquals("1bc", new DefaultExpressionParser().parse("replace('abc','a','1')").eval().toString());
    assertEquals("12c", new DefaultExpressionParser().parse("replace('abc','ab','12')").eval().toString());
  }

  @Test
  public void testReverse() throws ExpressionException {
    assertEquals("cba", new DefaultExpressionParser().parse("reverse('abc')").eval().toString());
  }

  @Test
  public void testRight() throws ExpressionException {
    assertEquals("bc", new DefaultExpressionParser().parse("right('abc', 2)").eval().toString());
    assertEquals("abc", new DefaultExpressionParser().parse("right('abc', 4)").eval().toString());
  }

  @Test
  public void testRPad() throws ExpressionException {
    assertEquals("abc   ", new DefaultExpressionParser().parse("rpad('abc', 6)").eval().toString());
    assertEquals("abc...", new DefaultExpressionParser().parse("rpad('abc', 6, '.')").eval().toString());
    assertEquals("abc", new DefaultExpressionParser().parse("rpad('abc', 2)").eval().toString());
  }

  @Test
  public void testRTrim() throws ExpressionException {
    assertEquals("  abc", new DefaultExpressionParser().parse("rtrim('  abc  ')").eval().toString());
    assertEquals("33abc", new DefaultExpressionParser().parse("rtrim('33abc33','3')").eval().toString());
  }

  @Test
  public void testSplit() throws ExpressionException {
    assertEquals("[a,b,c,]", new DefaultExpressionParser().parse("split('abc', '')").eval().toString());
    assertEquals("[a,b,c]", new DefaultExpressionParser().parse("split('a,b,c',',')").eval().toString());
    assertEquals("[abc]", new DefaultExpressionParser().parse("split('abc',',')").eval().toString());
    assertEquals("[a,b-c]", new DefaultExpressionParser().parse("split('a-b-c','-',2)").eval().toString());
  }

  @Test
  public void testStartsWith() throws ExpressionException {
    assertEquals("true", new DefaultExpressionParser().parse("startswith('abc', 'a')").eval().toString());
    assertEquals("false", new DefaultExpressionParser().parse("startswith('abc', 'b')").eval().toString());
  }

  @Test
  public void testSubstr() throws ExpressionException {
    assertEquals("fghij", new DefaultExpressionParser().parse("substr('abcdefghijklmn', 5, 5)").eval().toString());
    assertEquals("jklmn", new DefaultExpressionParser().parse("substr('abcdefghijklmn', -5)").eval().toString());
    assertEquals("bc", new DefaultExpressionParser().parse("substr('abc', 1, 10)").eval().toString());
    assertEquals("jklmn", new DefaultExpressionParser().parse("substr('abcdefghijklmn', -5)").eval().toString());
    assertEquals("jklmn", new DefaultExpressionParser().parse("substr('abcdefghijklmn', -5, 10)").eval().toString());
  }

  @Test
  public void testSubstring() throws ExpressionException {
    assertEquals("", new DefaultExpressionParser().parse("substring('abcdefghijklmn', 5, 5)").eval().toString());
    assertEquals("abcdefghijklmn", new DefaultExpressionParser().parse("substring('abcdefghijklmn', -5)").eval().toString());
    assertEquals("bc", new DefaultExpressionParser().parse("substring('abc', 1, 10)").eval().toString());
    assertEquals("abcdefghijklmn", new DefaultExpressionParser().parse("substring('abcdefghijklmn', -5)").eval().toString());
    assertEquals("abcdefghij", new DefaultExpressionParser().parse("substring('abcdefghijklmn', -5, 10)").eval().toString());
  }

  @Test
  public void testTrim() throws ExpressionException {
    assertEquals("abc", new DefaultExpressionParser().parse("trim('  abc  ')").eval().toString());
    assertEquals("a b c", new DefaultExpressionParser().parse("trim('  a b c  ')").eval().toString());
  }

  @Test
  public void testUpper() throws ExpressionException {
    assertEquals("ABC", new DefaultExpressionParser().parse("upper('abc')").eval().toString());
  }
}
