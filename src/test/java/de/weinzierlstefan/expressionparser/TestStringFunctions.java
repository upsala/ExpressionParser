package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.Value;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStringFunctions {
  private Value parse(String expression) {
    ExecutorContext context = new DefaultExecutorContext();
    return ExpressionParser.parse(expression, context).eval();
  }

  @Test
  public void testCharAt() throws ExpressionException {
    assertEquals("b", parse("charat('abc',1)").getString());
  }

  @Test
  public void testConcat() throws ExpressionException {
    assertEquals("123", parse("concat(1,2,3)").getString());
    assertEquals("abc123", parse("concat('abc',123)").getString());
  }

  @Test
  public void testConcatWs() throws ExpressionException {
    assertEquals("1,2,3", parse("concatWs(',', 1,2,3)").getString());
    assertEquals("abc,123", parse("concatWs(',', 'abc',123)").getString());
  }

  @Test
  public void testEndsWith() throws ExpressionException {
    assertEquals("true", parse("endswith('abc', 'c')").getString());
    assertEquals("false", parse("endswith('abc', 'a')").getString());
  }

  @Test
  public void testFormat() throws ExpressionException {
    assertEquals("abc", parse("format('a%c', 'b')").getString());
    assertEquals("abc1", parse("format('a%c%', 'b', 1)").getString());
    assertEquals("abc1", parse("format('a%c%', 'b', 1, 2)").getString());
    assertEquals("abc", parse("format('abc', 'b', 1, 2)").getString());
  }

  @Test
  public void testIncludes() throws ExpressionException {
    assertEquals("true", parse("includes('abcdef', 'de')").getString());
    assertEquals("false", parse("includes('abcdef', 'ee')").getString());
  }

  @Test
  public void testIndexOf() throws ExpressionException {
    assertEquals("3", parse("indexof('abcdef', 'de')").getString());
    assertEquals("-1", parse("indexof('abcdef', 'ee')").getString());
    assertEquals("3", parse("indexof('abcdefde', 'de')").getString());
  }

  @Test
  public void testIsBlank() throws ExpressionException {
    assertEquals("true", parse("isblank('')").getString());
    assertEquals("true", parse("isblank('  ')").getString());
    assertEquals("false", parse("isblank('abc')").getString());
    assertEquals("false", parse("isblank(' a ')").getString());
  }

  @Test
  public void testIsEmpty() throws ExpressionException {
    assertEquals("true", parse("isempty('')").getString());
    assertEquals("false", parse("isempty('  ')").getString());
    assertEquals("false", parse("isempty('abc')").getString());
  }

  @Test
  public void testLastIndexOf() throws ExpressionException {
    assertEquals("3", parse("lastindexof('abcdef', 'de')").getString());
    assertEquals("-1", parse("lastindexof('abcdef', 'ee')").getString());
    assertEquals("6", parse("lastindexof('abcdefde', 'de')").getString());
  }

  @Test
  public void testLeft() throws ExpressionException {
    assertEquals("ab", parse("left('abc', 2)").getString());
    assertEquals("abc", parse("left('abc', 4)").getString());
  }

  @Test
  public void testLength() throws ExpressionException {
    assertEquals("3", parse("length('abc')").getString());
    assertEquals("5", parse("length(12345)").getString());
  }

  @Test
  public void testLike() throws ExpressionException {
    assertEquals("false", parse("like('abc','a')").getString());
    assertEquals("true", parse("like('abc','a%')").getString());
    assertEquals("true", parse("like('abc','a__')").getString());
    assertEquals("false", parse("like('abc','a_')").getString());
  }

  @Test
  public void testLower() throws ExpressionException {
    assertEquals("abc", parse("lower('ABC')").getString());
  }

  @Test
  public void testLPad() throws ExpressionException {
    assertEquals("   abc", parse("lpad('abc', 6)").getString());
    assertEquals("...abc", parse("lpad('abc', 6, '.')").getString());
    assertEquals("abc", parse("lpad('abc', 2)").getString());
  }

  @Test
  public void testLTrim() throws ExpressionException {
    assertEquals("abc  ", parse("ltrim('  abc  ')").getString());
    assertEquals("abc33", parse("ltrim('33abc33','3')").getString());
  }

  @Test
  public void testRegexFind() throws ExpressionException {
    assertEquals("12", parse("regexfind('abc12','[0-9]+')").getString());
    assertEquals("", parse("regexfind('abc12','^[0-9]+')").getString());
  }

  @Test
  public void testRegexMatch() throws ExpressionException {
    assertEquals("true", parse("regexmatch('abc12','[0-9]+')").getString());
    assertEquals("false", parse("regexmatch('abc12','^[0-9]+')").getString());
    assertEquals("true", parse("regexmatch('abc12','^[a-z0-9]+$')").getString());
  }

  @Test
  public void testRegexReplace() throws ExpressionException {
    assertEquals("abcde", parse("regexreplace('abc12','[0-9]+', 'de')").getString());
  }

  @Test
  public void testRegexSplit() throws ExpressionException {
    assertEquals("['a','b','c','']", parse("regexsplit('abc', '')").getString());
    assertEquals("['a','b','c']", parse("regexsplit('a,b,c',',')").getString());
    assertEquals("['a','b','c']", parse("regexsplit('a123b555c','[0-9]+')").getString());
    assertEquals("['a','b-c']", parse("regexsplit('a-b-c','-',2)").getString());
  }

  @Test
  public void testRepeat() throws ExpressionException {
    assertEquals("aaaaa", parse("repeat('a',5)").getString());
    assertEquals("ababab", parse("repeat('ab',3)").getString());
  }

  @Test
  public void testReplace() throws ExpressionException {
    assertEquals("1bc", parse("replace('abc','a','1')").getString());
    assertEquals("12c", parse("replace('abc','ab','12')").getString());
  }

  @Test
  public void testReverse() throws ExpressionException {
    assertEquals("cba", parse("reverse('abc')").getString());
  }

  @Test
  public void testRight() throws ExpressionException {
    assertEquals("bc", parse("right('abc', 2)").getString());
    assertEquals("abc", parse("right('abc', 4)").getString());
  }

  @Test
  public void testRPad() throws ExpressionException {
    assertEquals("abc   ", parse("rpad('abc', 6)").getString());
    assertEquals("abc...", parse("rpad('abc', 6, '.')").getString());
    assertEquals("abc", parse("rpad('abc', 2)").getString());
  }

  @Test
  public void testRTrim() throws ExpressionException {
    assertEquals("  abc", parse("rtrim('  abc  ')").getString());
    assertEquals("33abc", parse("rtrim('33abc33','3')").getString());
  }

  @Test
  public void testSplit() throws ExpressionException {
    assertEquals("['a','b','c','']", parse("split('abc', '')").getString());
    assertEquals("['a','b','c']", parse("split('a,b,c',',')").getString());
    assertEquals("['abc']", parse("split('abc',',')").getString());
    assertEquals("['a','b-c']", parse("split('a-b-c','-',2)").getString());
  }

  @Test
  public void testStartsWith() throws ExpressionException {
    assertEquals("true", parse("startswith('abc', 'a')").getString());
    assertEquals("false", parse("startswith('abc', 'b')").getString());
    assertEquals("true", parse("startswith('abcdef', 'd', 3)").getString());
  }

  @Test
  public void testSubstr() throws ExpressionException {
    assertEquals("fghij", parse("substr('abcdefghijklmn', 5, 5)").getString());
    assertEquals("jklmn", parse("substr('abcdefghijklmn', -5)").getString());
    assertEquals("bc", parse("substr('abc', 1, 10)").getString());
    assertEquals("jklmn", parse("substr('abcdefghijklmn', -5)").getString());
    assertEquals("jklmn", parse("substr('abcdefghijklmn', -5, 10)").getString());
  }

  @Test
  public void testSubstring() throws ExpressionException {
    assertEquals("", parse("substring('abcdefghijklmn', 5, 5)").getString());
    assertEquals("abcdefghijklmn", parse("substring('abcdefghijklmn', -5)").getString());
    assertEquals("bc", parse("substring('abc', 1, 10)").getString());
    assertEquals("abcdefghijklmn", parse("substring('abcdefghijklmn', -5)").getString());
    assertEquals("abcdefghij", parse("substring('abcdefghijklmn', -5, 10)").getString());
  }

  @Test
  public void testTrim() throws ExpressionException {
    assertEquals("abc", parse("trim('  abc  ')").getString());
    assertEquals("a b c", parse("trim('  a b c  ')").getString());
  }

  @Test
  public void testUpper() throws ExpressionException {
    assertEquals("ABC", parse("upper('abc')").getString());
  }
}
