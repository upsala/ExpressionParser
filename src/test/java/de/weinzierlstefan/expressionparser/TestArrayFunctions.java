package de.weinzierlstefan.expressionparser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestArrayFunctions {

  @Test
  public void testArray() throws ExpressionException {
    assertEquals("[]", new DefaultExpressionParser().parse("array()").eval().toString());
    assertEquals("[1,2,3]", new DefaultExpressionParser().parse("array(1,2,3)").eval().toString());
  }

  @Test
  public void testArrayConcat() throws ExpressionException {
    assertEquals("[1,2,3]", new DefaultExpressionParser().parse("arrayconcat(1,2,3)").eval().toString());
    assertEquals("[1,2,3]", new DefaultExpressionParser().parse("arrayconcat(array(1,2,3))").eval().toString());
    assertEquals("[1,2,3,4,5,6]", new DefaultExpressionParser().parse("arrayconcat(array(1,2,3),array(4,5,6))").eval().toString());
    assertEquals("[1,2,3,4]", new DefaultExpressionParser().parse("arrayconcat(array(1,2,3),4)").eval().toString());
    assertEquals("[1,2,3,4]", new DefaultExpressionParser().parse("arrayconcat(1,array(2,3,4))").eval().toString());
  }

  @Test
  public void testArrayCount() throws ExpressionException {
    assertEquals("0",new DefaultExpressionParser().parse("arraycount(array())").eval().toString());
    assertEquals("3",new DefaultExpressionParser().parse("arraycount([1,2,3])").eval().toString());
    assertEquals("1",new DefaultExpressionParser().parse("arraycount([[1,2,3]])").eval().toString());
  }

  @Test
  public void testArrayDiff() throws ExpressionException {
    assertEquals("[1,2]", new DefaultExpressionParser().parse("arraydiff([1,2,3],[3,4,5])").eval().toString());
  }

  @Test
  public void testArrayDistinct() throws ExpressionException {
    assertEquals("[1]", new DefaultExpressionParser().parse("arraydistinct([1,1,1])").eval().toString());
  }

  @Test
  public void testArrayFlat() throws ExpressionException {
    assertEquals("[1,2,3,4]", new DefaultExpressionParser().parse("arrayflat(array(1,2,array(3,4)))").eval().toString());
    assertEquals("[1,2,3,4]", new DefaultExpressionParser().parse("arrayflat(array(1,2,array(3,array(4))))").eval().toString());
  }

  @Test
  public void testArrayFlip() throws ExpressionException {
    assertEquals("[a=>0,b=>1,c=>2]", new DefaultExpressionParser().parse("arrayflip(['a','b','c'])").eval().toString());
    assertEquals("[1=>0,2=>1,3=>2,4=>3]", new DefaultExpressionParser().parse("arrayflip([1,2,3,4])").eval().toString());
  }

  @Test
  public void testArrayGet() throws ExpressionException {
    assertEquals("2", new DefaultExpressionParser().parse("arrayget([1,2,3], 1)").eval().toString());
  }

  @Test
  public void testArrayIncludes() throws ExpressionException {
    assertEquals("true", new DefaultExpressionParser().parse("arrayincludes([1,2,3], 1)").eval().toString());
    assertEquals("false", new DefaultExpressionParser().parse("arrayincludes([1,2,3], 4)").eval().toString());
  }

  @Test
  public void testArrayIndexOf() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("arrayindexof([1,2,3], 2)").eval().toString());
    assertEquals("-1", new DefaultExpressionParser().parse("arrayindexof([1,2,3], 4)").eval().toString());
    assertEquals("1", new DefaultExpressionParser().parse("arrayindexof([1,2,2,3], 2)").eval().toString());
  }

  @Test
  public void testArrayInsert() throws ExpressionException {
    assertEquals("[1,5,2,3]", new DefaultExpressionParser().parse("arrayinsert([1,2,3], 1, 5)").eval().toString());
  }

  @Test
  public void testArrayIntersect() throws ExpressionException {
    assertEquals("[3]", new DefaultExpressionParser().parse("arrayintersect([1,2,3],[3,4,5])").eval().toString());
  }

  @Test
  public void testArrayJoin() throws ExpressionException {
    assertEquals("123", new DefaultExpressionParser().parse("arrayjoin([1,2,3])").eval().toString());
    assertEquals("1-2-3", new DefaultExpressionParser().parse("arrayjoin([1,2,3],'-')").eval().toString());
  }

  @Test
  public void testArrayKeys() throws ExpressionException {
    assertEquals("[a,2]", new DefaultExpressionParser().parse("arraykeys(['a'=>1,2=>3])").eval().toString());
  }

  @Test
  public void testArrayLastIndexOf() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("arraylastindexof([1,2,3], 2)").eval().toString());
    assertEquals("-1", new DefaultExpressionParser().parse("arraylastindexof([1,2,3], 4)").eval().toString());
    assertEquals("2", new DefaultExpressionParser().parse("arraylastindexof([1,2,2,3], 2)").eval().toString());
  }

  @Test
  public void testArrayReplace() throws ExpressionException {
    assertEquals("[1,2,5]", new DefaultExpressionParser().parse("arrayreplace([1,2,3],3,5)").eval().toString());
  }

  @Test
  public void testArrayReverse() throws ExpressionException {
    assertEquals("[3,2,1]", new DefaultExpressionParser().parse("arrayreverse([1,2,3])").eval().toString());
  }

  @Test
  public void testArrayRotate() throws ExpressionException {
    assertEquals("[1,2,3]", new DefaultExpressionParser().parse("arrayrotate([1,2,3],0)").eval().toString());
    assertEquals("[3,1,2]", new DefaultExpressionParser().parse("arrayrotate([1,2,3],1)").eval().toString());
    assertEquals("[2,3,1]", new DefaultExpressionParser().parse("arrayrotate([1,2,3],-1)").eval().toString());
  }

  @Test
  public void testArraySet() throws ExpressionException {
    assertEquals("[1,5,3]", new DefaultExpressionParser().parse("arrayset([1,2,3],1,5)").eval().toString());
  }

  @Test
  public void testArrayShuffle() throws ExpressionException {
    assertNotEquals("[1,2,3,4,5,6,7,8,9,10]", new DefaultExpressionParser().parse("arrayshuffle([1,2,3,4,5,6,7,8,9,10])").eval().toString());
  }

  @Test
  public void testArraySlice() throws ExpressionException {
    assertEquals("[4,5,6]", new DefaultExpressionParser().parse("arrayslice([1,2,3,4,5,6,7],3,5)").eval().toString());
  }

  @Test
  public void testArraySort() throws ExpressionException {
    assertEquals("[]",new DefaultExpressionParser().parse("arraysort(array())").eval().toString());
    assertEquals("[1,2,3]",new DefaultExpressionParser().parse("arraysort(array(1,3,2))").eval().toString());
    assertEquals("[[1,3,2]]",new DefaultExpressionParser().parse("arraysort(array(array(1,3,2)))").eval().toString());
  }

  @Test
  public void testArraySwap() throws ExpressionException {
    assertEquals("[5,7,6]", new DefaultExpressionParser().parse("arrayswap([5,6,7],1,2)").eval().toString());
  }

  @Test
  public void testArrayUnion() throws ExpressionException {
    assertEquals("[1,2,3,4,5]", new DefaultExpressionParser().parse("arrayunion([1,2,3],[3,4,5])").eval().toString());
  }

  @Test
  public void testArrayValues() throws ExpressionException {
    assertEquals("[1,3]", new DefaultExpressionParser().parse("arrayvalues(['a'=>1,2=>3])").eval().toString());
  }

}
