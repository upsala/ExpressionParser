package de.weinzierlstefan.expressionparser.functions.crypto;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueString;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Sha1 implements Function {
  @Override
  public String getName() {
    return "sha1";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    MessageDigest md;
    try {
      md = MessageDigest.getInstance("SHA1");
    } catch (NoSuchAlgorithmException e) {
      throw new ExpressionException(e);
    }

    for (Value value : valueList) {
      md.update(value.getString().getBytes());
    }
    byte[] digest = md.digest();
    BigInteger bigInt = new BigInteger(1, digest);
    String hashtext = bigInt.toString(16);
    hashtext = "0".repeat(40 - hashtext.length()) + hashtext;
    return ValueString.of(hashtext);
  }

  @Override
  public boolean parameterCount(int count) {
    return count >= 0;
  }
}
