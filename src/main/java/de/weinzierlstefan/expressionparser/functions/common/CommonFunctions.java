package de.weinzierlstefan.expressionparser.functions.common;

import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.functions.array.ArrayDistinct;

import java.util.ArrayList;
import java.util.Collection;

public class CommonFunctions {
  public static Collection<Function> getFunctions() {
    Collection<Function> functionCollection = new ArrayList<>();

    functionCollection.add(new Between());
    functionCollection.add(new Bound());
    functionCollection.add(new IfNull());
    functionCollection.add(new IsArray());
    functionCollection.add(new IsNull());
    functionCollection.add(new IsNumber());
    functionCollection.add(new IsString());
    functionCollection.add(new ArrayDistinct());
    functionCollection.add(new Max());
    functionCollection.add(new Min());

    return functionCollection;
  }
}
