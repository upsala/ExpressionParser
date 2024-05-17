
### Datatypes
| Type | Java-Typ    | Description                                                                                         |
|:----|:------------|:----------------------------------------------------------------------------------------------------|
| ValueNull | null        |                                                                                                     |
| ValueBoolean | Boolean     |                                                                                                     |
| ValueInt | Integer     |                                                                                                     |
| ValueLong | Long        |                                                                                                     |
| ValueDouble | Double      |                                                                                                     |
| ValueString | String      |                                                                                                     |
| ValueArray | List<Value> |                                                                                                     |
| ValueObject | Map<Value, Value> |                                                                                                     |
| ValueTemporal | Temporal | Storage for LocalDate, LocalDateTime, LocalTime, OffsetDateTime, OffsetTime, ZonedDateTime, Instant |

All types can be created with Value.create(...). For example:
```java
var value1 = Value.create(null); 
value1.isNull(); // true
value1.getType(); // null

var value2 = Value.create(27);
value2.isInt(); // true
value2.getType(); // int
value2.getInt(); // 27
if (value2 instanceof ValueInt) {
  System.out.println("Is a ValueInt");  
}

var value3 = Value.create(List.of(1, 2, "test"));
value3.isArray(); // true
value3.getType(); // array
if (value3.getArray().get(0) instanceof ValueInt i) {
  System.out.println(i.getInt());  
}

```