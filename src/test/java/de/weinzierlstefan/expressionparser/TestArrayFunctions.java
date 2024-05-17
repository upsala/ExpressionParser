package de.weinzierlstefan.expressionparser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestArrayFunctions {

  @Test
  public void testArray() throws ExpressionException {
    ExpressionParser parser = new DefaultExpressionParser();

    assertEquals("[]", parser.parse("array()").eval().getString());
    assertEquals("[1,2,3]", parser.parse("array(1,2,3)").eval().getString());
  }

  @Test
  public void testArrayConcat() throws ExpressionException {
    ExpressionParser parser = new DefaultExpressionParser();

    assertEquals("[1,2,3]", parser.parse("arrayconcat(1,2,3)").eval().getString());
    assertEquals("[1,2,3]", parser.parse("arrayconcat(array(1,2,3))").eval().getString());
    assertEquals("[1,2,3,4,5,6]", parser.parse("arrayconcat(array(1,2,3),array(4,5,6))").eval().getString());
    assertEquals("[1,2,3,4]", parser.parse("arrayconcat(array(1,2,3),4)").eval().getString());
    assertEquals("[1,2,3,4]", parser.parse("arrayconcat(1,array(2,3,4))").eval().getString());
  }

  @Test
  public void testArrayDiff() throws ExpressionException {
    ExpressionParser parser = new DefaultExpressionParser();

    assertEquals("[1,2]", parser.parse("arraydiff([1,2,3],[3,4,5])").eval().getString());

    Exception exception = assertThrows(
      ExpressionException.class,
      () -> parser.parse("arraydiff(1, [])").eval()
    );
    assertEquals("Conversation to array is not possible", exception.getMessage());

    exception = assertThrows(
      ExpressionException.class,
      () -> parser.parse("arraydiff([], 1)").eval()
    );
    assertEquals("Conversation to array is not possible", exception.getMessage());
  }

  @Test
  public void testArrayDistinct() throws ExpressionException {
    ExpressionParser parser = new DefaultExpressionParser();

    assertEquals("[1]", parser.parse("arraydistinct([1,1,1])").eval().getString());
    assertEquals("[1,2,3]", parser.parse("arraydistinct([1,2,2,3,3,3])").eval().getString());
  }

  @Test
  public void testArrayFlat() throws ExpressionException {
    ExpressionParser parser = new DefaultExpressionParser();

    assertEquals("[1,2,3,4]", parser.parse("arrayflat(array(1,2,array(3,4)))").eval().getString());
    assertEquals("[1,2,3,4]", parser.parse("arrayflat(array(1,2,array(3,array(4))))").eval().getString());
  }

  @Test
  public void testArrayGet() throws ExpressionException {
    ExpressionParser parser = new DefaultExpressionParser();

    assertEquals("2", parser.parse("arrayget([1,2,3], 1)").eval().getString());
  }

  @Test
  public void testArrayIncludes() throws ExpressionException {
    ExpressionParser parser = new DefaultExpressionParser();

    assertEquals("true", parser.parse("arrayincludes([1,2,3], 1)").eval().getString());
    assertEquals("false", parser.parse("arrayincludes([1,2,3], 4)").eval().getString());
  }

  @Test
  public void testArrayIndexOf() throws ExpressionException {
    ExpressionParser parser = new DefaultExpressionParser();

    assertEquals("1", parser.parse("arrayindexof([1,2,3], 2)").eval().getString());
    assertEquals("-1", parser.parse("arrayindexof([1,2,3], 4)").eval().getString());
    assertEquals("1", parser.parse("arrayindexof([1,2,2,3], 2)").eval().getString());
  }

  @Test
  public void testArrayInsert() throws ExpressionException {
    ExpressionParser parser = new DefaultExpressionParser();

    assertEquals("[1,5,2,3]", parser.parse("arrayinsert([1,2,3], 1, 5)").eval().getString());
  }

  @Test
  public void testArrayIntersect() throws ExpressionException {
    ExpressionParser parser = new DefaultExpressionParser();

    assertEquals("[3]", parser.parse("arrayintersect([1,2,3],[3,4,5])").eval().getString());
  }

  @Test
  public void testArrayJoin() throws ExpressionException {
    ExpressionParser parser = new DefaultExpressionParser();

    assertEquals("123", parser.parse("arrayjoin([1,2,3])").eval().getString());
    assertEquals("1-2-3", parser.parse("arrayjoin([1,2,3],'-')").eval().getString());
  }

  @Test
  public void testArrayLastIndexOf() throws ExpressionException {
    ExpressionParser parser = new DefaultExpressionParser();

    assertEquals("1", parser.parse("arraylastindexof([1,2,3], 2)").eval().getString());
    assertEquals("-1", parser.parse("arraylastindexof([1,2,3], 4)").eval().getString());
    assertEquals("2", parser.parse("arraylastindexof([1,2,2,3], 2)").eval().getString());
  }

  @Test
  public void testArrayReplace() throws ExpressionException {
    ExpressionParser parser = new DefaultExpressionParser();

    assertEquals("[1,2,5]", parser.parse("arrayreplace([1,2,3],3,5)").eval().getString());
  }

  @Test
  public void testArrayReverse() throws ExpressionException {
    ExpressionParser parser = new DefaultExpressionParser();

    assertEquals("[3,2,1]", parser.parse("arrayreverse([1,2,3])").eval().getString());
  }

  @Test
  public void testArrayRotate() throws ExpressionException {
    ExpressionParser parser = new DefaultExpressionParser();

    assertEquals("[1,2,3]", parser.parse("arrayrotate([1,2,3],0)").eval().getString());
    assertEquals("[3,1,2]", parser.parse("arrayrotate([1,2,3],1)").eval().getString());
    assertEquals("[2,3,1]", parser.parse("arrayrotate([1,2,3],-1)").eval().getString());
  }

  @Test
  public void testArraySet() throws ExpressionException {
    ExpressionParser parser = new DefaultExpressionParser();

    assertEquals("[1,5,3]", parser.parse("arrayset([1,2,3],1,5)").eval().getString());
  }

  @Test
  public void testArrayShuffle() throws ExpressionException {
    ExpressionParser parser = new DefaultExpressionParser();

    assertNotEquals("[1,2,3,4,5,6,7,8,9,10]", parser.parse("arrayshuffle([1,2,3,4,5,6,7,8,9,10])").eval().getString());
  }

  @Test
  public void testArraySlice() throws ExpressionException {
    ExpressionParser parser = new DefaultExpressionParser();

    assertEquals("[4,5,6]", parser.parse("arrayslice([1,2,3,4,5,6,7],3,5)").eval().getString());
  }

  @Test
  public void testArraySort() throws ExpressionException {
    ExpressionParser parser = new DefaultExpressionParser();

    assertEquals("[]", parser.parse("arraysort(array())").eval().getString());
    assertEquals("[1,2,3]",parser.parse("arraysort(array(1,3,2))").eval().getString());
    assertEquals("[[1,3,2]]",parser.parse("arraysort(array(array(1,3,2)))").eval().getString());
  }

  @Test
  public void testArraySwap() throws ExpressionException {
    ExpressionParser parser = new DefaultExpressionParser();

    assertEquals("[5,7,6]", parser.parse("arrayswap([5,6,7],1,2)").eval().getString());
  }

  @Test
  public void testArrayUnion() throws ExpressionException {
    ExpressionParser parser = new DefaultExpressionParser();

    assertEquals("[1,2,3,4,5]", parser.parse("arrayunion([1,2,3],[3,4,5])").eval().getString());
  }

}
