package de.weinzierlstefan.expressionparser.functions.string;

import de.weinzierlstefan.expressionparser.Function;

import java.util.ArrayList;
import java.util.Collection;

public class StringFunctions {
  public static Collection<Function> getFunctions() {
    Collection<Function> functionCollection = new ArrayList<>();

    functionCollection.add(new CharAt());
    functionCollection.add(new Concat());
    functionCollection.add(new ConcatWs());
    functionCollection.add(new EndsWith());
    functionCollection.add(new Format());
    functionCollection.add(new Includes());
    functionCollection.add(new IndexOf());
    functionCollection.add(new IsBlank());
    functionCollection.add(new LastIndexOf());
    functionCollection.add(new Left());
    functionCollection.add(new Length());
    functionCollection.add(new Like());
    functionCollection.add(new Lower());
    functionCollection.add(new LPad());
    functionCollection.add(new LTrim());
    functionCollection.add(new RegexFind());
    functionCollection.add(new RegexMatch());
    functionCollection.add(new RegexReplace());
    functionCollection.add(new RegexSplit());
    functionCollection.add(new Repeat());
    functionCollection.add(new Replace());
    functionCollection.add(new Reverse());
    functionCollection.add(new Right());
    functionCollection.add(new RPad());
    functionCollection.add(new RTrim());
    functionCollection.add(new Split());
    functionCollection.add(new StartsWith());
    functionCollection.add(new Substr());
    functionCollection.add(new Substring());
    functionCollection.add(new Trim());
    functionCollection.add(new Upper());

    return functionCollection;
  }
}
