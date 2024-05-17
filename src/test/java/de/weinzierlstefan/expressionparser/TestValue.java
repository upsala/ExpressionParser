package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TestValue {
  @Test
  public void testCreate() throws ExpressionException {
    assertEquals(ValueNull.INSTANCE, Value.create(null));
    assertEquals(ValueInt.of(1), Value.create(1));
    assertEquals(ValueInt.of(1), Value.create((byte)1));
    assertEquals(ValueInt.of(1), Value.create((short)1));
    assertEquals(ValueInt.of(1), Value.create((char)1));
    assertEquals(ValueLong.of(2), Value.create(2L));
    assertEquals(ValueDouble.of(3.14), Value.create(3.14));
    assertEquals(ValueDouble.of(3.14f), Value.create(3.14f));
    assertEquals(ValueBoolean.of(true), Value.create(true));
    assertEquals(ValueBoolean.of(false), Value.create(false));
    assertEquals(ValueString.of("test"), Value.create("test"));
    assertEquals(ValueTemporal.of(LocalDate.of(2004,2,1)), Value.create(LocalDate.of(2004,2,1)));
    assertEquals(ValueTemporal.of(LocalTime.of(1,2,3)), Value.create(LocalTime.of(1,2,3)));
    assertEquals(ValueTemporal.of(LocalDateTime.of(2004,2,1,4,5,6)), Value.create(LocalDateTime.of(2004,2,1,4,5,6)));

    Value arrayValue = Value.create(List.of(1,2,3,4));
    assertEquals("array", arrayValue.getType());
    assertEquals(ValueInt.of(1), arrayValue.getArray().get(0));
    assertEquals(ValueInt.of(2), arrayValue.getArray().get(1));
    assertEquals(ValueInt.of(3), arrayValue.getArray().get(2));
    assertEquals(ValueInt.of(4), arrayValue.getArray().get(3));

    Value objectValue = Value.create(Map.of(1,2,3,4));
    assertEquals("object", objectValue.getType());
    assertEquals(ValueInt.of(2), objectValue.getMap().get(ValueInt.of(1)));
    assertEquals(ValueInt.of(4), objectValue.getMap().get(ValueInt.of(3)));

    var exception = assertThrows(ExpressionException.class, ()->Value.create(Map.of(1,2,(short)1, 2)));
    assertEquals("Duplicate key: 1", exception.getMessage());
  }

  @Test
  public void testGet() throws ExpressionException {
    assertEquals(77, ValueInt.of(77).get());
    assertEquals(Long.MAX_VALUE, ValueLong.of(Long.MAX_VALUE).get());
    assertEquals(Double.MAX_VALUE, ValueDouble.of(Double.MAX_VALUE).get());
    assertEquals(true, ValueBoolean.of(true).get());
    assertEquals(false, ValueBoolean.of(false).get());
    assertEquals("test", ValueString.of("test").get());
    assertNull(ValueNull.INSTANCE.get());
  }
}
