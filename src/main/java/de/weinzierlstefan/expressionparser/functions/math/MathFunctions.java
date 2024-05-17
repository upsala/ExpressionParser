package de.weinzierlstefan.expressionparser.functions.math;

import de.weinzierlstefan.expressionparser.Function;

import java.util.ArrayList;
import java.util.Collection;


public class MathFunctions {
  public static Collection<Function> getFunctions() {
    Collection<Function> functionCollection = new ArrayList<>();

    functionCollection.add(new Abs());
    functionCollection.add(new ACos());
    functionCollection.add(new ACosR());
    functionCollection.add(new ASin());
    functionCollection.add(new ASinR());
    functionCollection.add(new ATan());
    functionCollection.add(new ATanR());
    functionCollection.add(new ATan2());
    functionCollection.add(new ATan2R());
    functionCollection.add(new Ceil());
    functionCollection.add(new Cos());
    functionCollection.add(new CosR());
    functionCollection.add(new Cot());
    functionCollection.add(new CotR());
    functionCollection.add(new Degrees());
    functionCollection.add(new Fact());
    functionCollection.add(new Floor());
    functionCollection.add(new Log());
    functionCollection.add(new Log2());
    functionCollection.add(new Log10());
    functionCollection.add(new Pow());
    functionCollection.add(new Radians());
    functionCollection.add(new Random());
    functionCollection.add(new Round());
    functionCollection.add(new Sec());
    functionCollection.add(new SecR());
    functionCollection.add(new Sign());
    functionCollection.add(new Sin());
    functionCollection.add(new SinR());
    functionCollection.add(new Sqrt());
    functionCollection.add(new Tan());
    functionCollection.add(new TanR());

    return functionCollection;
  }
}
