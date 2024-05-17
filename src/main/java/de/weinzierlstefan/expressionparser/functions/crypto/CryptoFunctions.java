package de.weinzierlstefan.expressionparser.functions.crypto;

import de.weinzierlstefan.expressionparser.Function;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 */
public class CryptoFunctions {
  /**
   *
   * @return
   */
  public static Collection<Function> getFunctions() {
    Collection<Function> functionCollection = new ArrayList<>();

    functionCollection.add(new Crc32());
    functionCollection.add(new Md5());
    functionCollection.add(new Sha1());
    functionCollection.add(new Sha256());
    functionCollection.add(new Uuid());

    return functionCollection;
  }
}
