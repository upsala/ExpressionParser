package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestValue {
  @Test
  public void testNull() throws ExpressionException {
    assertTrue(ValueNull.INSTANCE.isNull());
    assertTrue(Value.of((String)null).isNull());
    assertTrue(Value.of((BigDecimal) null).isNull());
    assertTrue(Value.of((BigInteger) null).isNull());
    assertTrue(Value.of((Temporal) null).isNull());
    assertTrue(Value.of((Collection<Value>) null).isNull());
    assertTrue(Value.of((Map<Value, Value>) null).isNull());
    assertTrue(new DefaultExpressionParser().parse("NULL").eval().isNull());

    assertFalse(ValueLong.of(0).isNull());
    assertFalse(ValueDouble.of(0).isNull());
    assertFalse(ValueBigDecimal.of(0).isNull());
    assertFalse(ValueString.of("").isNull());
    assertFalse(ValueArray.of(List.of()).isNull());
    assertFalse(ValueArray.of(Map.of()).isNull());
    assertFalse(ValueTemporal.of(LocalDateTime.now()).isNull());
    assertFalse(ValueBoolean.of(false).isNull());
    assertFalse(Value.of(0).isNull());
  }

  @Test
  public void testLong() {
    assertTrue(ValueLong.of(1).isLong());
    assertTrue(Value.of(1).isLong());
    assertTrue(Value.of(BigDecimal.valueOf(1)).isLong());
    assertTrue(Value.of(BigDecimal.valueOf(Long.MAX_VALUE)).isLong());
    assertTrue(Value.of(BigDecimal.valueOf(Long.MIN_VALUE)).isLong());
    assertTrue(Value.of(BigInteger.valueOf(Long.MAX_VALUE)).isLong());
    assertTrue(Value.of(BigInteger.valueOf(Long.MIN_VALUE)).isLong());

    assertFalse(Value.of(BigDecimal.valueOf(Long.MAX_VALUE).add(BigDecimal.ONE)).isLong());
    assertFalse(Value.of(BigDecimal.valueOf(Long.MIN_VALUE).subtract(BigDecimal.ONE)).isLong());
  }

  @Test
  public void testEquals() {
    assertTrue(ValueNull.INSTANCE.equals(ValueNull.INSTANCE));
    assertTrue(ValueNull.INSTANCE.equals(Value.of((BigDecimal) null)));
    assertTrue(ValueNull.INSTANCE.equals(Value.of((String) null)));

    assertTrue(ValueLong.of(1).equals(Value.of(1)));
  }
}
