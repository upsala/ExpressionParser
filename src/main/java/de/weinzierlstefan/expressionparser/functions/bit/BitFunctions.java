package de.weinzierlstefan.expressionparser.functions.bit;

import de.weinzierlstefan.expressionparser.Function;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 */
public class BitFunctions {
  public static Collection<Function> getFunctions() {
    Collection<Function> functionCollection = new ArrayList<>();

    functionCollection.add(new ClearBit());
    functionCollection.add(new ExtractBits());
    functionCollection.add(new InvertBit());
    functionCollection.add(new SetBit());
    functionCollection.add(new TestBit());

    return functionCollection;
  }
}
