package de.weinzierlstefan.expressionparser.functions.array;

import de.weinzierlstefan.expressionparser.Function;

import java.util.ArrayList;
import java.util.Collection;


public class ArrayFunctions {
  public static Collection<Function> getFunctions() {
    Collection<Function> functionCollection = new ArrayList<>();

    functionCollection.add(new Array());
    functionCollection.add(new ArrayCall());
    functionCollection.add(new ArrayConcat());
    functionCollection.add(new ArrayDiff());
    functionCollection.add(new ArrayDistinct());
    functionCollection.add(new ArrayFilter());
    functionCollection.add(new ArrayFind());
    functionCollection.add(new ArrayFindLast());
    functionCollection.add(new ArrayFlat());
    functionCollection.add(new ArrayGet());
    functionCollection.add(new ArrayIncludes());
    functionCollection.add(new ArrayIndexOf());
    functionCollection.add(new ArrayInsert());
    functionCollection.add(new ArrayIntersect());
    functionCollection.add(new ArrayJoin());
    functionCollection.add(new ArrayLastIndexOf());
    functionCollection.add(new ArrayReduce());
    functionCollection.add(new ArrayReplace());
    functionCollection.add(new ArrayReverse());
    functionCollection.add(new ArrayRotate());
    functionCollection.add(new ArrayMap());
    functionCollection.add(new ArraySample());
    functionCollection.add(new ArraySet());
    functionCollection.add(new ArrayShuffle());
    functionCollection.add(new ArraySlice());
    functionCollection.add(new ArraySort());
    functionCollection.add(new ArraySwap());
    functionCollection.add(new ArrayUnion());

    return functionCollection;
  }
}
