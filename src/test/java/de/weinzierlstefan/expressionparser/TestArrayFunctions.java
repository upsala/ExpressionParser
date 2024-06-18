package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.Value;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestArrayFunctions {

  private Value parse(String expression) {
    ExecutorContext context = new DefaultExecutorContext();
    return ExpressionParser.parse(expression, context).eval();
  }
  
  @Test
  public void testArray() throws ExpressionException {
    assertEquals("[]", parse("array()").getString());
    assertEquals("[1,2,3]", parse("array(1,2,3)").getString());
  }

  @Test
  public void testArrayConcat() throws ExpressionException {
    assertEquals("[1,2,3]", parse("arrayconcat(1,2,3)").getString());
    assertEquals("[1,2,3]", parse("arrayconcat(array(1,2,3))").getString());
    assertEquals("[1,2,3,4,5,6]", parse("arrayconcat(array(1,2,3),array(4,5,6))").getString());
    assertEquals("[1,2,3,4]", parse("arrayconcat(array(1,2,3),4)").getString());
    assertEquals("[1,2,3,4]", parse("arrayconcat(1,array(2,3,4))").getString());
  }

  @Test
  public void testArrayDiff() throws ExpressionException {
    assertEquals("[1,2]", parse("arraydiff([1,2,3],[3,4,5])").getString());

    Exception exception = assertThrows(
      ExpressionException.class,
      () -> parse("arraydiff(1, [])")
    );
    assertEquals("Conversation to array is not possible", exception.getMessage());

    exception = assertThrows(
      ExpressionException.class,
      () -> parse("arraydiff([], 1)")
    );
    assertEquals("Conversation to array is not possible", exception.getMessage());
  }

  @Test
  public void testArrayDistinct() throws ExpressionException {
    assertEquals("[1]", parse("arraydistinct([1,1,1])").getString());
    assertEquals("[1,2,3]", parse("arraydistinct([1,2,2,3,3,3])").getString());
  }

  @Test
  public void testArrayFlat() throws ExpressionException {
    assertEquals("[1,2,3,4]", parse("arrayflat(array(1,2,array(3,4)))").getString());
    assertEquals("[1,2,3,4]", parse("arrayflat(array(1,2,array(3,array(4))))").getString());
  }

  @Test
  public void testArrayGet() throws ExpressionException {
    assertEquals("2", parse("arrayget([1,2,3], 1)").getString());
  }

  @Test
  public void testArrayIncludes() throws ExpressionException {
    assertEquals("true", parse("arrayincludes([1,2,3], 1)").getString());
    assertEquals("false", parse("arrayincludes([1,2,3], 4)").getString());
  }

  @Test
  public void testArrayIndexOf() throws ExpressionException {
    assertEquals("1", parse("arrayindexof([1,2,3], 2)").getString());
    assertEquals("-1", parse("arrayindexof([1,2,3], 4)").getString());
    assertEquals("1", parse("arrayindexof([1,2,2,3], 2)").getString());
  }

  @Test
  public void testArrayInsert() throws ExpressionException {
    assertEquals("[1,5,2,3]", parse("arrayinsert([1,2,3], 1, 5)").getString());
  }

  @Test
  public void testArrayIntersect() throws ExpressionException {
    assertEquals("[3]", parse("arrayintersect([1,2,3],[3,4,5])").getString());
  }

  @Test
  public void testArrayJoin() throws ExpressionException {
    assertEquals("123", parse("arrayjoin([1,2,3])").getString());
    assertEquals("1-2-3", parse("arrayjoin([1,2,3],'-')").getString());
  }

  @Test
  public void testArrayLastIndexOf() throws ExpressionException {
    assertEquals("1", parse("arraylastindexof([1,2,3], 2)").getString());
    assertEquals("-1", parse("arraylastindexof([1,2,3], 4)").getString());
    assertEquals("2", parse("arraylastindexof([1,2,2,3], 2)").getString());
  }

  @Test
  public void testArrayReplace() throws ExpressionException {
    assertEquals("[1,2,5]", parse("arrayreplace([1,2,3],3,5)").getString());
  }

  @Test
  public void testArrayReverse() throws ExpressionException {
    assertEquals("[3,2,1]", parse("arrayreverse([1,2,3])").getString());
  }

  @Test
  public void testArrayRotate() throws ExpressionException {
    assertEquals("[1,2,3]", parse("arrayrotate([1,2,3],0)").getString());
    assertEquals("[3,1,2]", parse("arrayrotate([1,2,3],1)").getString());
    assertEquals("[2,3,1]", parse("arrayrotate([1,2,3],-1)").getString());
  }

  @Test
  public void testArraySet() throws ExpressionException {
    assertEquals("[1,5,3]", parse("arrayset([1,2,3],1,5)").getString());
  }

  @Test
  public void testArrayShuffle() throws ExpressionException {
    assertNotEquals("[1,2,3,4,5,6,7,8,9,10]", parse("arrayshuffle([1,2,3,4,5,6,7,8,9,10])").getString());
  }

  @Test
  public void testArraySlice() throws ExpressionException {
    assertEquals("[4,5,6]", parse("arrayslice([1,2,3,4,5,6,7],3,5)").getString());
  }

  @Test
  public void testArraySort() throws ExpressionException {
    assertEquals("[]", parse("arraysort(array())").getString());
    assertEquals("[1,2,3]",parse("arraysort(array(1,3,2))").getString());
    assertEquals("[[1,3,2]]",parse("arraysort(array(array(1,3,2)))").getString());
  }

  @Test
  public void testArraySwap() throws ExpressionException {
    assertEquals("[5,7,6]", parse("arrayswap([5,6,7],1,2)").getString());
  }

  @Test
  public void testArrayUnion() throws ExpressionException {
    assertEquals("[1,2,3,4,5]", parse("arrayunion([1,2,3],[3,4,5])").getString());
  }

}
