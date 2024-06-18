package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.Value;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCryptoFunctions {
  private Value parse(String expression) {
    ExecutorContext context = new DefaultExecutorContext();
    return ExpressionParser.parse(expression, context).eval();
  }
  
  @Test
  public void testCrc32() throws ExpressionException {
    assertEquals("d87f7e0c", parse("crc32('test')").getString());
  }

  @Test
  public void testMd5() throws ExpressionException {
    assertEquals("098f6bcd4621d373cade4e832627b4f6", parse("md5('test')").getString());
  }

  @Test
  public void testSha1() throws ExpressionException {
    assertEquals("a94a8fe5ccb19ba61c4c0873d391e987982fbbd3", parse("sha1('test')").getString());
  }

  @Test
  public void testSha256() throws ExpressionException {
    assertEquals("9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08", parse("sha256('test')").getString());
  }

  @Test
  public void testUuid() throws ExpressionException {
    assertEquals("36", parse("length(uuid())").getString());
  }
}
