package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.value.Value;
import org.junit.jupiter.api.Test;

import java.time.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestDateTimeFunctions {
  private Value parse(String expression) {
    ExecutorContext context = new DefaultExecutorContext();
    return ExpressionParser.parse(expression, context).eval();
  }

  private Value parse(String expression, ExecutorContext context) {
    return ExpressionParser.parse(expression, context).eval();
  }
  
  @Test
  public void testAddDay() throws ExpressionException {
    assertEquals("2020-03-06T07:09:11", parse("addday(datetime(2020,3,5,7,9,11),1)").getString());
    //assertEquals("2020-03-04 07:09:11", parse("addday(datetime(2020,3,5,7,9,11),-1)").getString());
  }

  @Test
  public void testAddHour() throws ExpressionException {
    assertEquals("2020-03-05T08:09:11", parse("addhour(datetime(2020,3,5,7,9,11),1)").getString());
  }

  @Test
  public void testAddNanoSecond() throws ExpressionException {
    assertEquals("2020-03-05T07:09:11.000000001", parse("addnanosecond(datetime(2020,3,5,7,9,11), 1)").getString());
    assertEquals("07:09:11.000000001", parse("addnanosecond(time(7,9,11), 1)").getString());
  }

  @Test
  public void testAddMinute() throws ExpressionException {
    assertEquals("2020-03-05T07:10:11", parse("addminute(datetime(2020,3,5,7,9,11),1)").getString());
  }

  @Test
  public void testAddMonth() throws ExpressionException {
    assertEquals("2020-04-05T07:09:11", parse("addmonth(datetime(2020,3,5,7,9,11),1)").getString());
  }

  @Test
  public void testAddSecond() throws ExpressionException {
    assertEquals("2020-03-05T07:09:12", parse("addsecond(datetime(2020,3,5,7,9,11),1)").getString());
  }

  @Test
  public void testAddYear() throws ExpressionException {
    assertEquals("2021-03-05T07:09:11", parse("addyear(datetime(2020,3,5,7,9,11),1)").getString());
  }

  @Test
  public void testDate() throws ExpressionException {
    assertEquals("2020-03-05", parse("date(2020,3,5)").getString());
  }

  @Test
  public void testDateTime() throws ExpressionException {
    //assertEquals("1", parse("datetime()").getString());
    assertEquals("2020-01-01T00:00:00", parse("datetime(2020)").getString());
    assertEquals("2020-03-01T00:00:00", parse("datetime(2020,3)").getString());
    assertEquals("2020-03-05T00:00:00", parse("datetime(2020,3,5)").getString());
    assertEquals("2020-03-05T07:00:00", parse("datetime(2020,3,5,7)").getString());
    assertEquals("2020-03-05T07:09:00", parse("datetime(2020,3,5,7,9)").getString());
    assertEquals("2020-03-05T07:09:11", parse("datetime(2020,3,5,7,9,11)").getString());
    assertEquals("2020-03-05T07:09:11.123456789", parse("datetime(2020,3,5,7,9,11,123456789)").getString());
  }

  @Test
  public void testDay() throws ExpressionException {
    assertEquals("5", parse("day(datetime(2020,3,5,7,9,11))").getString());
  }

  @Test
  public void testDiffDay() throws ExpressionException {
    assertEquals("1", parse("diffday(datetime(2020,3,5,7,9,11),datetime(2020,3,6,7,9,11))").getString());
    assertEquals("-1", parse("diffday(datetime(2020,3,5,7,9,11),datetime(2020,3,4,7,9,11))").getString());
  }

  @Test
  public void testDiffHour() throws ExpressionException {
    assertEquals("1", parse("diffhour(datetime(2020,3,5,7,9,11),datetime(2020,3,5,8,9,11))").getString());
    assertEquals("-1", parse("diffhour(datetime(2020,3,5,7,9,11),datetime(2020,3,5,6,9,11))").getString());
  }

  @Test
  public void testDiffMinute() throws ExpressionException {
    assertEquals("1", parse("diffminute(datetime(2020,3,5,7,9,11),datetime(2020,3,5,7,10,11))").getString());
    assertEquals("-1", parse("diffminute(datetime(2020,3,5,7,9,11),datetime(2020,3,5,7,8,11))").getString());
  }

  @Test
  public void testDiffMonth() throws ExpressionException {
    assertEquals("1", parse("diffmonth(datetime(2020,3,5,7,9,11),datetime(2020,4,5,7,9,11))").getString());
    assertEquals("-1", parse("diffmonth(datetime(2020,3,5,7,9,11),datetime(2020,2,5,7,9,11))").getString());
  }

  @Test
  public void testDiffNanoSecond() throws ExpressionException {
    assertEquals("100", parse("diffnanosecond(datetime(2020,3,5,7,9,11,100),datetime(2020,3,5,7,9,11,200))").getString());
    assertEquals("-100", parse("diffnanosecond(datetime(2020,3,5,7,9,11,200),datetime(2020,3,5,7,9,11,100))").getString());
  }

  @Test
  public void testDiffSecond() throws ExpressionException {
    assertEquals("1", parse("diffsecond(datetime(2020,3,5,7,9,11),datetime(2020,3,5,7,9,12))").getString());
    assertEquals("-1", parse("diffsecond(datetime(2020,3,5,7,9,11),datetime(2020,3,5,7,9,10))").getString());
  }

  @Test
  public void testDiffYear() throws ExpressionException {
    assertEquals("1", parse("diffyear(datetime(2020,3,5,7,9,11),datetime(2021,3,5,7,9,11))").getString());
    assertEquals("-1", parse("diffyear(datetime(2020,3,5,7,9,11),datetime(2019,3,5,7,9,11))").getString());
  }

  @Test
  public void testFirstDayOfMonth() throws ExpressionException {
    assertEquals("2020-03-01T07:09:11", parse("firstdayofmonth(datetime(2020,3,5,7,9,11))").getString());
  }

  @Test
  public void testFirstDayOfNextMonth() throws ExpressionException {
    assertEquals("2020-04-01T07:09:11", parse("firstdayofnextmonth(datetime(2020,3,5,7,9,11))").getString());
  }

  @Test
  public void testFirstDayOfNextYear() throws ExpressionException {
    assertEquals("2021-01-01T07:09:11", parse("firstdayofnextyear(datetime(2020,3,5,7,9,11))").getString());
  }

  @Test
  public void testFirstDayOfYear() throws ExpressionException {
    assertEquals("2020-01-01T07:09:11", parse("firstdayofyear(datetime(2020,3,5,7,9,11))").getString());
  }

  @Test
  public void testFirstInMonth() throws ExpressionException {
    assertEquals("2020-03-02T07:09:11", parse("firstinmonth(datetime(2020,3,5,7,9,11), 'MONDAY')").getString());
    assertEquals("2020-03-01T07:09:11", parse("firstinmonth(datetime(2020,3,1,7,9,11), 'sunday')").getString());
  }

  @Test
  public void testHour() throws ExpressionException {
    assertEquals("7", parse("hour(datetime(2020,3,5,7,9,11))").getString());
  }

  @Test
  public void testIsDate() throws ExpressionException {
    assertEquals("true", parse("isdate(date(2020,3,5))").getString());
    assertEquals("false", parse("isdate(time(7,9,11))").getString());
    assertEquals("false", parse("isdate(datetime(2020,3,5,7,9,11))").getString());
    assertEquals("false", parse("isdate(123)").getString());
    assertEquals("false", parse("isdate('abc')").getString());
  }

  @Test
  public void testIsDateTime() throws ExpressionException {
    assertEquals("false", parse("isdatetime(date(2020,3,5))").getString());
    assertEquals("false", parse("isdatetime(time(7,9,11))").getString());
    assertEquals("true", parse("isdatetime(datetime(2020,3,5,7,9,11))").getString());
    assertEquals("false", parse("isdatetime(123)").getString());
    assertEquals("false", parse("isdatetime('abc')").getString());
  }

  @Test
  public void testIsTime() throws ExpressionException {
    assertEquals("false", parse("istime(date(2020,3,5))").getString());
    assertEquals("true", parse("istime(time(7,9,11))").getString());
    assertEquals("false", parse("istime(datetime(2020,3,5,7,9,11))").getString());
    assertEquals("false", parse("istime(123)").getString());
    assertEquals("false", parse("istime('abc')").getString());
  }

  @Test
  public void testLastDayOfMonth() throws ExpressionException {
    assertEquals("2020-03-31T07:09:11", parse("lastdayofmonth(datetime(2020,3,5,7,9,11))").getString());
  }

  @Test
  public void testLastDayOfYear() throws ExpressionException {
    assertEquals("2020-12-31T07:09:11", parse("lastdayofyear(datetime(2020,3,5,7,9,11))").getString());
    assertEquals("2020-12-31", parse("lastdayofyear(date(2020,3,5))").getString());
  }

  @Test
  public void testNanosecond() throws ExpressionException {
    assertEquals("0", parse("nanosecond(datetime(2020,3,5,7,9,11))").getString());
    assertEquals("333", parse("nanosecond(datetime(2020,3,5,7,9,11,333))").getString());
    assertEquals("333", parse("nanosecond(time(7,9,11,333))").getString());
  }

  @Test
  public void testMinute() throws ExpressionException {
    assertEquals("9", parse("minute(datetime(2020,3,5,7,9,11))").getString());
  }

  @Test
  public void testMonth() throws ExpressionException {
    assertEquals("3", parse("month(datetime(2020,3,5,7,9,11))").getString());
  }

  @Test
  public void testNow() throws ExpressionException {
    assertDoesNotThrow(()->parse("now()"));
  }

  @Test
  public void testSecond() throws ExpressionException {
    assertEquals("11", parse("second(datetime(2020,3,5,7,9,11))").getString());
    assertEquals("11", parse("second(time(7,9,11))").getString());
    assertEquals("0", parse("second(date(2020,3,5))").getString());
  }

  @Test
  public void testSetDay() throws ExpressionException {
    assertEquals("2020-03-01T07:09:11", parse("setday(datetime(2020,3,5,7,9,11), 1)").getString());
    assertEquals("2020-03-01", parse("setday(date(2020,3,5), 1)").getString());
  }

  @Test
  public void testSetHour() throws ExpressionException {
    assertEquals("2020-03-05T01:09:11", parse("sethour(datetime(2020,3,5,7,9,11), 1)").getString());
    assertEquals("01:09:11", parse("sethour(time(7,9,11), 1)").getString());
  }

  @Test
  public void testSetMinute() throws ExpressionException {
    assertEquals("2020-03-05T07:01:11", parse("setminute(datetime(2020,3,5,7,9,11), 1)").getString());
    assertEquals("07:01:11", parse("setminute(time(7,9,11), 1)").getString());
  }

  @Test
  public void testSetMonth() throws ExpressionException {
    assertEquals("2020-01-05T07:09:11", parse("setmonth(datetime(2020,3,5,7,9,11), 1)").getString());
    assertEquals("2020-01-05", parse("setmonth(date(2020,3,5), 1)").getString());
  }

  @Test
  public void testSetNanoSecond() throws ExpressionException {
    assertEquals("2020-03-05T07:09:11.000000001", parse("setnanosecond(datetime(2020,3,5,7,9,11), 1)").getString());
    assertEquals("07:09:11.000000001", parse("setnanosecond(time(7,9,11), 1)").getString());
  }

  @Test
  public void testSetSecond() throws ExpressionException {
    assertEquals("2020-03-05T07:09:01", parse("setsecond(datetime(2020,3,5,7,9,11), 1)").getString());
    assertEquals("07:09:01", parse("setsecond(time(7,9,11), 1)").getString());
  }

  @Test
  public void testSetYear() throws ExpressionException {
    assertEquals("0001-03-05T07:09:11", parse("setyear(datetime(2020,3,5,7,9,11), 1)").getString());
    assertEquals("0001-03-05", parse("setyear(date(2020,3,5), 1)").getString());
  }

  @Test
  public void testSubDay() throws ExpressionException {
    assertEquals("2020-03-04T07:09:11", parse("subday(datetime(2020,3,5,7,9,11), 1)").getString());
    assertEquals("2020-03-04", parse("subday(date(2020,3,5), 1)").getString());
  }

  @Test
  public void testSubHour() throws ExpressionException {
    assertEquals("2020-03-05T06:09:11", parse("subhour(datetime(2020,3,5,7,9,11), 1)").getString());
    assertEquals("06:09:11", parse("subhour(time(7,9,11), 1)").getString());
  }

  @Test
  public void testSubMinute() throws ExpressionException {
    assertEquals("2020-03-05T07:08:11", parse("subminute(datetime(2020,3,5,7,9,11), 1)").getString());
    assertEquals("07:08:11", parse("subminute(time(7,9,11), 1)").getString());
  }

  @Test
  public void testSubMonth() throws ExpressionException {
    assertEquals("2020-02-05T07:09:11", parse("submonth(datetime(2020,3,5,7,9,11), 1)").getString());
    assertEquals("2020-02-05", parse("submonth(date(2020,3,5), 1)").getString());
  }

  @Test
  public void testSubNanoSecond() throws ExpressionException {
    assertEquals("2020-03-05T07:09:10.999999999", parse("subnanosecond(datetime(2020,3,5,7,9,11), 1)").getString());
    assertEquals("07:09:10.999999999", parse("subnanosecond(time(7,9,11), 1)").getString());
  }

  @Test
  public void testSubSecond() throws ExpressionException {
    assertEquals("2020-03-05T07:09:10", parse("subsecond(datetime(2020,3,5,7,9,11), 1)").getString());
    assertEquals("07:09:10", parse("subsecond(time(7,9,11), 1)").getString());
  }

  @Test
  public void testSubYear() throws ExpressionException {
    assertEquals("2019-03-05T07:09:11", parse("subyear(datetime(2020,3,5,7,9,11), 1)").getString());
    assertEquals("2019-03-05", parse("subyear(date(2020,3,5), 1)").getString());
  }

  @Test
  public void testTime() throws ExpressionException {
    assertEquals("07:09:11", parse("time(7,9,11)").getString());
    assertEquals("07:09:11.123456789", parse("time(7,9,11,123456789)").getString());

    Exception exception = assertThrows(ExpressionException.class, () -> parse("time(7,9,61)"));
    assertEquals("Second is not valid", exception.getMessage());
  }

  @Test
  public void testWeek() throws ExpressionException {
    assertEquals("10", parse("week(datetime(2020,3,5,7,9,11))").getString());
  }

  @Test
  public void testYear() throws ExpressionException {
    assertEquals("2020", parse("year(datetime(2020,3,5,7,9,11))").getString());
  }

  @Test
  public void testTruncatedTo() throws ExpressionException {
    ExecutorContext executorContext = new DefaultExecutorContext();

    executorContext.setVariable("ts", LocalDateTime.of(2001, 2, 3, 4, 5, 6, 7));
    assertEquals(LocalDateTime.of(2001,2,3,4,5,6), parse("truncatedtosecond(ts)", executorContext).getTemporal());
    assertEquals(LocalDateTime.of(2001,2,3,4,5,0), parse("truncatedtominute(ts)", executorContext).getTemporal());
    assertEquals(LocalDateTime.of(2001,2,3,4,0,0), parse("truncatedtohour(ts)", executorContext).getTemporal());
    assertEquals(LocalDateTime.of(2001,2,3,0,0,0), parse("truncatedtoday(ts)", executorContext).getTemporal());
    assertEquals(LocalDateTime.of(2001,2,1,0,0,0), parse("truncatedtomonth(ts)", executorContext).getTemporal());
    assertEquals(LocalDateTime.of(2001,1,1,0,0,0), parse("truncatedtoyear(ts)", executorContext).getTemporal());

    executorContext.setVariable("ts", LocalDate.of(2001, 2, 3));
    assertEquals(LocalDate.of(2001,2,3), parse("truncatedtosecond(ts)", executorContext).getTemporal());
    assertEquals(LocalDate.of(2001,2,3), parse("truncatedtominute(ts)", executorContext).getTemporal());
    assertEquals(LocalDate.of(2001,2,3), parse("truncatedtohour(ts)", executorContext).getTemporal());
    assertEquals(LocalDate.of(2001,2,3), parse("truncatedtoday(ts)", executorContext).getTemporal());
    assertEquals(LocalDate.of(2001,2,1), parse("truncatedtomonth(ts)", executorContext).getTemporal());
    assertEquals(LocalDate.of(2001,1,1), parse("truncatedtoyear(ts)", executorContext).getTemporal());

    executorContext.setVariable("ts", LocalTime.of(4, 5, 6, 7));
    assertEquals(LocalTime.of(4,5,6), parse("truncatedtosecond(ts)", executorContext).getTemporal());
    assertEquals(LocalTime.of(4,5,0), parse("truncatedtominute(ts)", executorContext).getTemporal());
    assertEquals(LocalTime.of(4,0,0), parse("truncatedtohour(ts)", executorContext).getTemporal());
    assertEquals(LocalTime.of(0,0,0), parse("truncatedtoday(ts)", executorContext).getTemporal());
    assertEquals(LocalTime.of(0,0,0), parse("truncatedtomonth(ts)", executorContext).getTemporal());
    assertEquals(LocalTime.of(0,0,0), parse("truncatedtoyear(ts)", executorContext).getTemporal());

    ZoneOffset zoneOffset = ZoneOffset.ofHours(0);
    executorContext.setVariable("ts", OffsetDateTime.of(2001, 2, 3, 4, 5, 6, 7, zoneOffset));
    assertEquals(OffsetDateTime.of(2001,2,3,4,5,6,0, zoneOffset), parse("truncatedtosecond(ts)", executorContext).getTemporal());
    assertEquals(OffsetDateTime.of(2001,2,3,4,5,0,0, zoneOffset), parse("truncatedtominute(ts)", executorContext).getTemporal());
    assertEquals(OffsetDateTime.of(2001,2,3,4,0,0,0, zoneOffset), parse("truncatedtohour(ts)", executorContext).getTemporal());
    assertEquals(OffsetDateTime.of(2001,2,3,0,0,0,0, zoneOffset), parse("truncatedtoday(ts)", executorContext).getTemporal());
    assertEquals(OffsetDateTime.of(2001,2,1,0,0,0,0, zoneOffset), parse("truncatedtomonth(ts)", executorContext).getTemporal());
    assertEquals(OffsetDateTime.of(2001,1,1,0,0,0,0, zoneOffset), parse("truncatedtoyear(ts)", executorContext).getTemporal());

    executorContext.setVariable("ts", OffsetTime.of(4, 5, 6, 7, zoneOffset));
    assertEquals(OffsetTime.of(4,5,6,0, zoneOffset), parse("truncatedtosecond(ts)", executorContext).getTemporal());
    assertEquals(OffsetTime.of(4,5,0,0, zoneOffset), parse("truncatedtominute(ts)", executorContext).getTemporal());
    assertEquals(OffsetTime.of(4,0,0,0, zoneOffset), parse("truncatedtohour(ts)", executorContext).getTemporal());
    assertEquals(OffsetTime.of(0,0,0,0, zoneOffset), parse("truncatedtoday(ts)", executorContext).getTemporal());
    assertEquals(OffsetTime.of(0,0,0,0, zoneOffset), parse("truncatedtomonth(ts)", executorContext).getTemporal());
    assertEquals(OffsetTime.of(0,0,0,0, zoneOffset), parse("truncatedtoyear(ts)", executorContext).getTemporal());

    executorContext.setVariable("ts", ZonedDateTime.of(2001, 2, 3, 4, 5, 6, 7, zoneOffset));
    assertEquals(ZonedDateTime.of(2001,2,3,4,5,6,0, zoneOffset), parse("truncatedtosecond(ts)", executorContext).getTemporal());
    assertEquals(ZonedDateTime.of(2001,2,3,4,5,0,0, zoneOffset), parse("truncatedtominute(ts)", executorContext).getTemporal());
    assertEquals(ZonedDateTime.of(2001,2,3,4,0,0,0, zoneOffset), parse("truncatedtohour(ts)", executorContext).getTemporal());
    assertEquals(ZonedDateTime.of(2001,2,3,0,0,0,0, zoneOffset), parse("truncatedtoday(ts)", executorContext).getTemporal());
    assertEquals(ZonedDateTime.of(2001,2,1,0,0,0,0, zoneOffset), parse("truncatedtomonth(ts)", executorContext).getTemporal());
    assertEquals(ZonedDateTime.of(2001,1,1,0,0,0,0, zoneOffset), parse("truncatedtoyear(ts)", executorContext).getTemporal());

    executorContext.setVariable("ts", Instant.ofEpochMilli(2001));
    assertEquals(Instant.ofEpochMilli(2000), parse("truncatedtosecond(ts)", executorContext).getTemporal());
    assertEquals(Instant.ofEpochMilli(0), parse("truncatedtominute(ts)", executorContext).getTemporal());
    assertEquals(Instant.ofEpochMilli(0), parse("truncatedtohour(ts)", executorContext).getTemporal());
    assertEquals(Instant.ofEpochMilli(0), parse("truncatedtoday(ts)", executorContext).getTemporal());
    //assertEquals(Instant.ofEpochMilli(0), parse("truncatedtomonth(ts)", executorContext).getTemporal());
    //assertEquals(Instant.ofEpochMilli(0), parse("truncatedtoyear(ts)", executorContext).getTemporal());

  }
}
