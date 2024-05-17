package de.weinzierlstefan.expressionparser.functions.object;

import de.weinzierlstefan.expressionparser.Function;

import java.util.ArrayList;
import java.util.Collection;


public class ObjectFunctions {
  public static Collection<Function> getFunctions() {
    Collection<Function> functionCollection = new ArrayList<>();

    functionCollection.add(new ObjectCreator());
    functionCollection.add(new ObjectFlip());
    functionCollection.add(new ObjectKeys());
    functionCollection.add(new ObjectMerge());
    functionCollection.add(new ObjectRemoveKeys());
    functionCollection.add(new ObjectSet());
    functionCollection.add(new ObjectValues());

    return functionCollection;
  }
}
