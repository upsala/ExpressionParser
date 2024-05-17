package de.weinzierlstefan.expressionparser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestObjectFunctions {

  @Test
  public void testObject() throws ExpressionException {
    assertEquals("{}", new DefaultExpressionParser().parse("object()").eval().getString());
    assertEquals("{1:2,3:4}", new DefaultExpressionParser().parse("object(1,2,3,4)").eval().getString());
  }

  @Test
  public void testObjectFlip() throws ExpressionException {
    assertEquals("{2:1,4:3}", new DefaultExpressionParser().parse("objectflip({1:2,3:4})").eval().getString());
  }

  @Test
  public void testObjectKeys() throws ExpressionException {
    assertEquals("[]", new DefaultExpressionParser().parse("objectkeys({})").eval().getString());
    assertEquals("[1,3]", new DefaultExpressionParser().parse("objectkeys({1:2,3:4})").eval().getString());
  }

  @Test
  public void testObjectMerge() throws ExpressionException {
    assertTrue(new DefaultExpressionParser().parse("objectmerge(object(1,2,3,4),object(5,6))==object(1,2,3,4,5,6)").eval().getBoolean());
    assertTrue(new DefaultExpressionParser().parse("objectmerge(object(1,2,3,4),object(5,6),object(7,8))==object(1,2,3,4,5,6,7,8)").eval().getBoolean());
  }

  @Test
  public void testObjectRemoveKeys() throws ExpressionException {
    assertEquals("{1:2}", new DefaultExpressionParser().parse("objectremovekeys(object(1,2,3,4),3)").eval().getString());
    assertEquals("{1:2}", new DefaultExpressionParser().parse("objectremovekeys(object(1,2,3,4),0,3)").eval().getString());
  }

  @Test
  public void testObjectSet() throws ExpressionException {
    assertEquals("{1:2}", new DefaultExpressionParser().parse("objectset(object(),1,2)").eval().getString());
    assertEquals("{1:3}", new DefaultExpressionParser().parse("objectset(object(1,2),1,3)").eval().getString());
  }

  @Test
  public void testObjectValues() throws ExpressionException {
    assertEquals("[]", new DefaultExpressionParser().parse("objectvalues(object())").eval().getString());
    assertEquals("[2,4]", new DefaultExpressionParser().parse("objectvalues(object(1,2,3,4))").eval().getString());
  }
}
