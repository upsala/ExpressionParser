package de.weinzierlstefan.expressionparser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCryptoFunctions {
  @Test
  public void testCrc32() throws ExpressionException {
    assertEquals("d87f7e0c", new DefaultExpressionParser().parse("crc32('test')").eval().getString());
  }

  @Test
  public void testMd5() throws ExpressionException {
    assertEquals("098f6bcd4621d373cade4e832627b4f6", new DefaultExpressionParser().parse("md5('test')").eval().getString());
  }

  @Test
  public void testSha1() throws ExpressionException {
    assertEquals("a94a8fe5ccb19ba61c4c0873d391e987982fbbd3", new DefaultExpressionParser().parse("sha1('test')").eval().getString());
  }

  @Test
  public void testSha256() throws ExpressionException {
    assertEquals("9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08", new DefaultExpressionParser().parse("sha256('test')").eval().getString());
  }

  @Test
  public void testUuid() throws ExpressionException {
    assertEquals("36", new DefaultExpressionParser().parse("length(uuid())").eval().getString());
  }
}
