package de.weinzierlstefan.expressionparser.functions.crypto;

import de.weinzierlstefan.expressionparser.ExecutorContext;
import de.weinzierlstefan.expressionparser.ExpressionException;
import de.weinzierlstefan.expressionparser.Function;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueList;
import de.weinzierlstefan.expressionparser.value.ValueString;

import java.util.zip.CRC32;

/**
 *
 */
public class Crc32 implements Function {
  @Override
  public String getName() {
    return "crc32";
  }

  @Override
  public Value execute(ValueList valueList, ExecutorContext executorContext) throws ExpressionException {
    String str = valueList.getString(0);

    CRC32 crc = new CRC32();
    crc.update(str.getBytes());

    String enc = Long.toHexString(crc.getValue());

    return ValueString.of(enc);
  }

  @Override
  public boolean parameterCount(int count) {
    return count == 1;
  }
}
