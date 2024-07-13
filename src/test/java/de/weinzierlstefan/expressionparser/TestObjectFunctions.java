package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.Value;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestObjectFunctions {
  private Value parse(String expression) {
    ExecutorContext context = new DefaultExecutorContext();
    return ExpressionParser.parse(expression, context).eval();
  }

  @Test
  public void testObject() throws ExpressionException {
    assertEquals("{}", parse("object()").getString());
    assertEquals("{1:2,3:4}", parse("object(1,2,3,4)").getString());
  }

  @Test
  public void testObjectFlip() throws ExpressionException {
    //assertEquals("{2:1,4:3}", parse("objectflip({1:2,3:4})").getString());
    assertEquals("{2:1}", parse("objectflip({1:2})").getString());
  }

  @Test
  public void testObjectKeys() throws ExpressionException {
    assertEquals("[]", parse("objectkeys({})").getString());
    assertEquals("[1,3]", parse("objectkeys({1:2,3:4})").getString());
  }

  @Test
  public void testObjectMerge() throws ExpressionException {
    assertTrue(parse("objectmerge(object(1,2,3,4),object(5,6))==object(1,2,3,4,5,6)").getBoolean());
    assertTrue(parse("objectmerge(object(1,2,3,4),object(5,6),object(7,8))==object(1,2,3,4,5,6,7,8)").getBoolean());
  }

  @Test
  public void testObjectRemoveKeys() throws ExpressionException {
    assertEquals("{1:2}", parse("objectremovekeys(object(1,2,3,4),3)").getString());
    assertEquals("{1:2}", parse("objectremovekeys(object(1,2,3,4),0,3)").getString());
  }

  @Test
  public void testObjectSet() throws ExpressionException {
    assertEquals("{1:2}", parse("objectset(object(),1,2)").getString());
    assertEquals("{1:3}", parse("objectset(object(1,2),1,3)").getString());
  }

  @Test
  public void testObjectValues() throws ExpressionException {
    assertEquals("[]", parse("objectvalues(object())").getString());
    assertEquals("[2,4]", parse("objectvalues(object(1,2,3,4))").getString());
  }

  @Test
  public void testObjectFilter() throws ExpressionException {
    assertEquals("{5:6,3:4}", parse("objectfilter({1:2,3:4,5:6}, (v)->v>3)").getString());
    assertEquals("{5:6,3:4}", parse("objectfilter({1:2,3:4,5:6}, (v,k)->k>1)").getString());
  }

  @Test
  public void testObjectFind() throws ExpressionException {
    assertEquals("4", parse("objectfind({1:2,3:4,5:6}, (v)->v>3)").getString());
    assertEquals("2", parse("objectfind({1:2,3:4,5:6}, (v,i)->i==1)").getString());
  }

  @Test
  public void testObjectMap() throws ExpressionException {
    assertEquals("{1:4,3:8,5:12}", parse("objectmap({1:2,3:4,5:6}, (v)->v*2)").getString());
    assertEquals("{1:2,3:12,5:30}", parse("objectmap({1:2,3:4,5:6}, (v,k)->v*k)").getString());
  }

  @Test
  public void testObjectReduce() throws ExpressionException {
    assertEquals("12", parse("objectreduce({1:2,3:4,5:6},(a,v)->a+v,0)").getString());
    assertEquals("21", parse("objectreduce({1:2,3:4,5:6},(a,v,k)->a+v+k,0)").getString());
    assertEquals("121", parse("objectreduce({1:2,3:4,5:6},(a,v,k)->a+v+k,100)").getString());
  }

}
