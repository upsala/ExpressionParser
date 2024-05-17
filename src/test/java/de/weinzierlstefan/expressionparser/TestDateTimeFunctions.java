package de.weinzierlstefan.expressionparser;

import org.junit.jupiter.api.Test;

import java.time.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestDateTimeFunctions {
  @Test
  public void testAddDay() throws ExpressionException {
    assertEquals("2020-03-06T07:09:11", new DefaultExpressionParser().parse("addday(datetime(2020,3,5,7,9,11),1)").eval().getString());
    //assertEquals("2020-03-04 07:09:11", new DefaultExpressionParser().parse("addday(datetime(2020,3,5,7,9,11),-1)").eval().getString());
  }

  @Test
  public void testAddHour() throws ExpressionException {
    assertEquals("2020-03-05T08:09:11", new DefaultExpressionParser().parse("addhour(datetime(2020,3,5,7,9,11),1)").eval().getString());
  }

  @Test
  public void testAddNanoSecond() throws ExpressionException {
    assertEquals("2020-03-05T07:09:11.000000001", new DefaultExpressionParser().parse("addnanosecond(datetime(2020,3,5,7,9,11), 1)").eval().getString());
    assertEquals("07:09:11.000000001", new DefaultExpressionParser().parse("addnanosecond(time(7,9,11), 1)").eval().getString());
  }

  @Test
  public void testAddMinute() throws ExpressionException {
    assertEquals("2020-03-05T07:10:11", new DefaultExpressionParser().parse("addminute(datetime(2020,3,5,7,9,11),1)").eval().getString());
  }

  @Test
  public void testAddMonth() throws ExpressionException {
    assertEquals("2020-04-05T07:09:11", new DefaultExpressionParser().parse("addmonth(datetime(2020,3,5,7,9,11),1)").eval().getString());
  }

  @Test
  public void testAddSecond() throws ExpressionException {
    assertEquals("2020-03-05T07:09:12", new DefaultExpressionParser().parse("addsecond(datetime(2020,3,5,7,9,11),1)").eval().getString());
  }

  @Test
  public void testAddYear() throws ExpressionException {
    assertEquals("2021-03-05T07:09:11", new DefaultExpressionParser().parse("addyear(datetime(2020,3,5,7,9,11),1)").eval().getString());
  }

  @Test
  public void testDate() throws ExpressionException {
    assertEquals("2020-03-05", new DefaultExpressionParser().parse("date(2020,3,5)").eval().getString());
  }

  @Test
  public void testDateTime() throws ExpressionException {
    //assertEquals("1", new DefaultExpressionParser().parse("datetime()").eval().getString());
    assertEquals("2020-01-01T00:00:00", new DefaultExpressionParser().parse("datetime(2020)").eval().getString());
    assertEquals("2020-03-01T00:00:00", new DefaultExpressionParser().parse("datetime(2020,3)").eval().getString());
    assertEquals("2020-03-05T00:00:00", new DefaultExpressionParser().parse("datetime(2020,3,5)").eval().getString());
    assertEquals("2020-03-05T07:00:00", new DefaultExpressionParser().parse("datetime(2020,3,5,7)").eval().getString());
    assertEquals("2020-03-05T07:09:00", new DefaultExpressionParser().parse("datetime(2020,3,5,7,9)").eval().getString());
    assertEquals("2020-03-05T07:09:11", new DefaultExpressionParser().parse("datetime(2020,3,5,7,9,11)").eval().getString());
    assertEquals("2020-03-05T07:09:11.123456789", new DefaultExpressionParser().parse("datetime(2020,3,5,7,9,11,123456789)").eval().getString());
  }

  @Test
  public void testDay() throws ExpressionException {
    assertEquals("5", new DefaultExpressionParser().parse("day(datetime(2020,3,5,7,9,11))").eval().getString());
  }

  @Test
  public void testDiffDay() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("diffday(datetime(2020,3,5,7,9,11),datetime(2020,3,6,7,9,11))").eval().getString());
    assertEquals("-1", new DefaultExpressionParser().parse("diffday(datetime(2020,3,5,7,9,11),datetime(2020,3,4,7,9,11))").eval().getString());
  }

  @Test
  public void testDiffHour() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("diffhour(datetime(2020,3,5,7,9,11),datetime(2020,3,5,8,9,11))").eval().getString());
    assertEquals("-1", new DefaultExpressionParser().parse("diffhour(datetime(2020,3,5,7,9,11),datetime(2020,3,5,6,9,11))").eval().getString());
  }

  @Test
  public void testDiffMinute() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("diffminute(datetime(2020,3,5,7,9,11),datetime(2020,3,5,7,10,11))").eval().getString());
    assertEquals("-1", new DefaultExpressionParser().parse("diffminute(datetime(2020,3,5,7,9,11),datetime(2020,3,5,7,8,11))").eval().getString());
  }

  @Test
  public void testDiffMonth() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("diffmonth(datetime(2020,3,5,7,9,11),datetime(2020,4,5,7,9,11))").eval().getString());
    assertEquals("-1", new DefaultExpressionParser().parse("diffmonth(datetime(2020,3,5,7,9,11),datetime(2020,2,5,7,9,11))").eval().getString());
  }

  @Test
  public void testDiffNanoSecond() throws ExpressionException {
    assertEquals("100", new DefaultExpressionParser().parse("diffnanosecond(datetime(2020,3,5,7,9,11,100),datetime(2020,3,5,7,9,11,200))").eval().getString());
    assertEquals("-100", new DefaultExpressionParser().parse("diffnanosecond(datetime(2020,3,5,7,9,11,200),datetime(2020,3,5,7,9,11,100))").eval().getString());
  }

  @Test
  public void testDiffSecond() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("diffsecond(datetime(2020,3,5,7,9,11),datetime(2020,3,5,7,9,12))").eval().getString());
    assertEquals("-1", new DefaultExpressionParser().parse("diffsecond(datetime(2020,3,5,7,9,11),datetime(2020,3,5,7,9,10))").eval().getString());
  }

  @Test
  public void testDiffYear() throws ExpressionException {
    assertEquals("1", new DefaultExpressionParser().parse("diffyear(datetime(2020,3,5,7,9,11),datetime(2021,3,5,7,9,11))").eval().getString());
    assertEquals("-1", new DefaultExpressionParser().parse("diffyear(datetime(2020,3,5,7,9,11),datetime(2019,3,5,7,9,11))").eval().getString());
  }

  @Test
  public void testFirstDayOfMonth() throws ExpressionException {
    assertEquals("2020-03-01T07:09:11", new DefaultExpressionParser().parse("firstdayofmonth(datetime(2020,3,5,7,9,11))").eval().getString());
  }

  @Test
  public void testFirstDayOfNextMonth() throws ExpressionException {
    assertEquals("2020-04-01T07:09:11", new DefaultExpressionParser().parse("firstdayofnextmonth(datetime(2020,3,5,7,9,11))").eval().getString());
  }

  @Test
  public void testFirstDayOfNextYear() throws ExpressionException {
    assertEquals("2021-01-01T07:09:11", new DefaultExpressionParser().parse("firstdayofnextyear(datetime(2020,3,5,7,9,11))").eval().getString());
  }

  @Test
  public void testFirstDayOfYear() throws ExpressionException {
    assertEquals("2020-01-01T07:09:11", new DefaultExpressionParser().parse("firstdayofyear(datetime(2020,3,5,7,9,11))").eval().getString());
  }

  @Test
  public void testFirstInMonth() throws ExpressionException {
    assertEquals("2020-03-02T07:09:11", new DefaultExpressionParser().parse("firstinmonth(datetime(2020,3,5,7,9,11), 'MONDAY')").eval().getString());
    assertEquals("2020-03-01T07:09:11", new DefaultExpressionParser().parse("firstinmonth(datetime(2020,3,1,7,9,11), 'sunday')").eval().getString());
  }

  @Test
  public void testHour() throws ExpressionException {
    assertEquals("7", new DefaultExpressionParser().parse("hour(datetime(2020,3,5,7,9,11))").eval().getString());
  }

  @Test
  public void testIsDate() throws ExpressionException {
    assertEquals("true", new DefaultExpressionParser().parse("isdate(date(2020,3,5))").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("isdate(time(7,9,11))").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("isdate(datetime(2020,3,5,7,9,11))").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("isdate(123)").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("isdate('abc')").eval().getString());
  }

  @Test
  public void testIsDateTime() throws ExpressionException {
    assertEquals("false", new DefaultExpressionParser().parse("isdatetime(date(2020,3,5))").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("isdatetime(time(7,9,11))").eval().getString());
    assertEquals("true", new DefaultExpressionParser().parse("isdatetime(datetime(2020,3,5,7,9,11))").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("isdatetime(123)").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("isdatetime('abc')").eval().getString());
  }

  @Test
  public void testIsTime() throws ExpressionException {
    assertEquals("false", new DefaultExpressionParser().parse("istime(date(2020,3,5))").eval().getString());
    assertEquals("true", new DefaultExpressionParser().parse("istime(time(7,9,11))").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("istime(datetime(2020,3,5,7,9,11))").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("istime(123)").eval().getString());
    assertEquals("false", new DefaultExpressionParser().parse("istime('abc')").eval().getString());
  }

  @Test
  public void testLastDayOfMonth() throws ExpressionException {
    assertEquals("2020-03-31T07:09:11", new DefaultExpressionParser().parse("lastdayofmonth(datetime(2020,3,5,7,9,11))").eval().getString());
  }

  @Test
  public void testLastDayOfYear() throws ExpressionException {
    assertEquals("2020-12-31T07:09:11", new DefaultExpressionParser().parse("lastdayofyear(datetime(2020,3,5,7,9,11))").eval().getString());
    assertEquals("2020-12-31", new DefaultExpressionParser().parse("lastdayofyear(date(2020,3,5))").eval().getString());
  }

  @Test
  public void testNanosecond() throws ExpressionException {
    assertEquals("0", new DefaultExpressionParser().parse("nanosecond(datetime(2020,3,5,7,9,11))").eval().getString());
    assertEquals("333", new DefaultExpressionParser().parse("nanosecond(datetime(2020,3,5,7,9,11,333))").eval().getString());
    assertEquals("333", new DefaultExpressionParser().parse("nanosecond(time(7,9,11,333))").eval().getString());
  }

  @Test
  public void testMinute() throws ExpressionException {
    assertEquals("9", new DefaultExpressionParser().parse("minute(datetime(2020,3,5,7,9,11))").eval().getString());
  }

  @Test
  public void testMonth() throws ExpressionException {
    assertEquals("3", new DefaultExpressionParser().parse("month(datetime(2020,3,5,7,9,11))").eval().getString());
  }

  @Test
  public void testNow() throws ExpressionException {
    assertDoesNotThrow(()->new DefaultExpressionParser().parse("now()").eval());
  }

  @Test
  public void testSecond() throws ExpressionException {
    assertEquals("11", new DefaultExpressionParser().parse("second(datetime(2020,3,5,7,9,11))").eval().getString());
    assertEquals("11", new DefaultExpressionParser().parse("second(time(7,9,11))").eval().getString());
    assertEquals("0", new DefaultExpressionParser().parse("second(date(2020,3,5))").eval().getString());
  }

  @Test
  public void testSetDay() throws ExpressionException {
    assertEquals("2020-03-01T07:09:11", new DefaultExpressionParser().parse("setday(datetime(2020,3,5,7,9,11), 1)").eval().getString());
    assertEquals("2020-03-01", new DefaultExpressionParser().parse("setday(date(2020,3,5), 1)").eval().getString());
  }

  @Test
  public void testSetHour() throws ExpressionException {
    assertEquals("2020-03-05T01:09:11", new DefaultExpressionParser().parse("sethour(datetime(2020,3,5,7,9,11), 1)").eval().getString());
    assertEquals("01:09:11", new DefaultExpressionParser().parse("sethour(time(7,9,11), 1)").eval().getString());
  }

  @Test
  public void testSetMinute() throws ExpressionException {
    assertEquals("2020-03-05T07:01:11", new DefaultExpressionParser().parse("setminute(datetime(2020,3,5,7,9,11), 1)").eval().getString());
    assertEquals("07:01:11", new DefaultExpressionParser().parse("setminute(time(7,9,11), 1)").eval().getString());
  }

  @Test
  public void testSetMonth() throws ExpressionException {
    assertEquals("2020-01-05T07:09:11", new DefaultExpressionParser().parse("setmonth(datetime(2020,3,5,7,9,11), 1)").eval().getString());
    assertEquals("2020-01-05", new DefaultExpressionParser().parse("setmonth(date(2020,3,5), 1)").eval().getString());
  }

  @Test
  public void testSetNanoSecond() throws ExpressionException {
    assertEquals("2020-03-05T07:09:11.000000001", new DefaultExpressionParser().parse("setnanosecond(datetime(2020,3,5,7,9,11), 1)").eval().getString());
    assertEquals("07:09:11.000000001", new DefaultExpressionParser().parse("setnanosecond(time(7,9,11), 1)").eval().getString());
  }

  @Test
  public void testSetSecond() throws ExpressionException {
    assertEquals("2020-03-05T07:09:01", new DefaultExpressionParser().parse("setsecond(datetime(2020,3,5,7,9,11), 1)").eval().getString());
    assertEquals("07:09:01", new DefaultExpressionParser().parse("setsecond(time(7,9,11), 1)").eval().getString());
  }

  @Test
  public void testSetYear() throws ExpressionException {
    assertEquals("0001-03-05T07:09:11", new DefaultExpressionParser().parse("setyear(datetime(2020,3,5,7,9,11), 1)").eval().getString());
    assertEquals("0001-03-05", new DefaultExpressionParser().parse("setyear(date(2020,3,5), 1)").eval().getString());
  }

  @Test
  public void testSubDay() throws ExpressionException {
    assertEquals("2020-03-04T07:09:11", new DefaultExpressionParser().parse("subday(datetime(2020,3,5,7,9,11), 1)").eval().getString());
    assertEquals("2020-03-04", new DefaultExpressionParser().parse("subday(date(2020,3,5), 1)").eval().getString());
  }

  @Test
  public void testSubHour() throws ExpressionException {
    assertEquals("2020-03-05T06:09:11", new DefaultExpressionParser().parse("subhour(datetime(2020,3,5,7,9,11), 1)").eval().getString());
    assertEquals("06:09:11", new DefaultExpressionParser().parse("subhour(time(7,9,11), 1)").eval().getString());
  }

  @Test
  public void testSubMinute() throws ExpressionException {
    assertEquals("2020-03-05T07:08:11", new DefaultExpressionParser().parse("subminute(datetime(2020,3,5,7,9,11), 1)").eval().getString());
    assertEquals("07:08:11", new DefaultExpressionParser().parse("subminute(time(7,9,11), 1)").eval().getString());
  }

  @Test
  public void testSubMonth() throws ExpressionException {
    assertEquals("2020-02-05T07:09:11", new DefaultExpressionParser().parse("submonth(datetime(2020,3,5,7,9,11), 1)").eval().getString());
    assertEquals("2020-02-05", new DefaultExpressionParser().parse("submonth(date(2020,3,5), 1)").eval().getString());
  }

  @Test
  public void testSubNanoSecond() throws ExpressionException {
    assertEquals("2020-03-05T07:09:10.999999999", new DefaultExpressionParser().parse("subnanosecond(datetime(2020,3,5,7,9,11), 1)").eval().getString());
    assertEquals("07:09:10.999999999", new DefaultExpressionParser().parse("subnanosecond(time(7,9,11), 1)").eval().getString());
  }

  @Test
  public void testSubSecond() throws ExpressionException {
    assertEquals("2020-03-05T07:09:10", new DefaultExpressionParser().parse("subsecond(datetime(2020,3,5,7,9,11), 1)").eval().getString());
    assertEquals("07:09:10", new DefaultExpressionParser().parse("subsecond(time(7,9,11), 1)").eval().getString());
  }

  @Test
  public void testSubYear() throws ExpressionException {
    assertEquals("2019-03-05T07:09:11", new DefaultExpressionParser().parse("subyear(datetime(2020,3,5,7,9,11), 1)").eval().getString());
    assertEquals("2019-03-05", new DefaultExpressionParser().parse("subyear(date(2020,3,5), 1)").eval().getString());
  }

  @Test
  public void testTime() throws ExpressionException {
    assertEquals("07:09:11", new DefaultExpressionParser().parse("time(7,9,11)").eval().getString());
    assertEquals("07:09:11.123456789", new DefaultExpressionParser().parse("time(7,9,11,123456789)").eval().getString());

    Exception exception = assertThrows(ExpressionException.class, () -> new DefaultExpressionParser().parse("time(7,9,61)").eval());
    assertEquals("Second is not valid", exception.getMessage());
  }

  @Test
  public void testWeek() throws ExpressionException {
    assertEquals("10", new DefaultExpressionParser().parse("week(datetime(2020,3,5,7,9,11))").eval().getString());
  }

  @Test
  public void testYear() throws ExpressionException {
    assertEquals("2020", new DefaultExpressionParser().parse("year(datetime(2020,3,5,7,9,11))").eval().getString());
  }

  @Test
  public void testTruncatedTo() throws ExpressionException {
    ExpressionParser expressionParser = new DefaultExpressionParser();

    expressionParser.setVariable("ts", LocalDateTime.of(2001, 2, 3, 4, 5, 6, 7));
    assertEquals(LocalDateTime.of(2001,2,3,4,5,6), expressionParser.parse("truncatedtosecond(ts)").eval().getTemporal());
    assertEquals(LocalDateTime.of(2001,2,3,4,5,0), expressionParser.parse("truncatedtominute(ts)").eval().getTemporal());
    assertEquals(LocalDateTime.of(2001,2,3,4,0,0), expressionParser.parse("truncatedtohour(ts)").eval().getTemporal());
    assertEquals(LocalDateTime.of(2001,2,3,0,0,0), expressionParser.parse("truncatedtoday(ts)").eval().getTemporal());
    assertEquals(LocalDateTime.of(2001,2,1,0,0,0), expressionParser.parse("truncatedtomonth(ts)").eval().getTemporal());
    assertEquals(LocalDateTime.of(2001,1,1,0,0,0), expressionParser.parse("truncatedtoyear(ts)").eval().getTemporal());

    expressionParser.setVariable("ts", LocalDate.of(2001, 2, 3));
    assertEquals(LocalDate.of(2001,2,3), expressionParser.parse("truncatedtosecond(ts)").eval().getTemporal());
    assertEquals(LocalDate.of(2001,2,3), expressionParser.parse("truncatedtominute(ts)").eval().getTemporal());
    assertEquals(LocalDate.of(2001,2,3), expressionParser.parse("truncatedtohour(ts)").eval().getTemporal());
    assertEquals(LocalDate.of(2001,2,3), expressionParser.parse("truncatedtoday(ts)").eval().getTemporal());
    assertEquals(LocalDate.of(2001,2,1), expressionParser.parse("truncatedtomonth(ts)").eval().getTemporal());
    assertEquals(LocalDate.of(2001,1,1), expressionParser.parse("truncatedtoyear(ts)").eval().getTemporal());

    expressionParser.setVariable("ts", LocalTime.of(4, 5, 6, 7));
    assertEquals(LocalTime.of(4,5,6), expressionParser.parse("truncatedtosecond(ts)").eval().getTemporal());
    assertEquals(LocalTime.of(4,5,0), expressionParser.parse("truncatedtominute(ts)").eval().getTemporal());
    assertEquals(LocalTime.of(4,0,0), expressionParser.parse("truncatedtohour(ts)").eval().getTemporal());
    assertEquals(LocalTime.of(0,0,0), expressionParser.parse("truncatedtoday(ts)").eval().getTemporal());
    assertEquals(LocalTime.of(0,0,0), expressionParser.parse("truncatedtomonth(ts)").eval().getTemporal());
    assertEquals(LocalTime.of(0,0,0), expressionParser.parse("truncatedtoyear(ts)").eval().getTemporal());

    ZoneOffset zoneOffset = ZoneOffset.ofHours(0);
    expressionParser.setVariable("ts", OffsetDateTime.of(2001, 2, 3, 4, 5, 6, 7, zoneOffset));
    assertEquals(OffsetDateTime.of(2001,2,3,4,5,6,0, zoneOffset), expressionParser.parse("truncatedtosecond(ts)").eval().getTemporal());
    assertEquals(OffsetDateTime.of(2001,2,3,4,5,0,0, zoneOffset), expressionParser.parse("truncatedtominute(ts)").eval().getTemporal());
    assertEquals(OffsetDateTime.of(2001,2,3,4,0,0,0, zoneOffset), expressionParser.parse("truncatedtohour(ts)").eval().getTemporal());
    assertEquals(OffsetDateTime.of(2001,2,3,0,0,0,0, zoneOffset), expressionParser.parse("truncatedtoday(ts)").eval().getTemporal());
    assertEquals(OffsetDateTime.of(2001,2,1,0,0,0,0, zoneOffset), expressionParser.parse("truncatedtomonth(ts)").eval().getTemporal());
    assertEquals(OffsetDateTime.of(2001,1,1,0,0,0,0, zoneOffset), expressionParser.parse("truncatedtoyear(ts)").eval().getTemporal());

    expressionParser.setVariable("ts", OffsetTime.of(4, 5, 6, 7, zoneOffset));
    assertEquals(OffsetTime.of(4,5,6,0, zoneOffset), expressionParser.parse("truncatedtosecond(ts)").eval().getTemporal());
    assertEquals(OffsetTime.of(4,5,0,0, zoneOffset), expressionParser.parse("truncatedtominute(ts)").eval().getTemporal());
    assertEquals(OffsetTime.of(4,0,0,0, zoneOffset), expressionParser.parse("truncatedtohour(ts)").eval().getTemporal());
    assertEquals(OffsetTime.of(0,0,0,0, zoneOffset), expressionParser.parse("truncatedtoday(ts)").eval().getTemporal());
    assertEquals(OffsetTime.of(0,0,0,0, zoneOffset), expressionParser.parse("truncatedtomonth(ts)").eval().getTemporal());
    assertEquals(OffsetTime.of(0,0,0,0, zoneOffset), expressionParser.parse("truncatedtoyear(ts)").eval().getTemporal());

    expressionParser.setVariable("ts", ZonedDateTime.of(2001, 2, 3, 4, 5, 6, 7, zoneOffset));
    assertEquals(ZonedDateTime.of(2001,2,3,4,5,6,0, zoneOffset), expressionParser.parse("truncatedtosecond(ts)").eval().getTemporal());
    assertEquals(ZonedDateTime.of(2001,2,3,4,5,0,0, zoneOffset), expressionParser.parse("truncatedtominute(ts)").eval().getTemporal());
    assertEquals(ZonedDateTime.of(2001,2,3,4,0,0,0, zoneOffset), expressionParser.parse("truncatedtohour(ts)").eval().getTemporal());
    assertEquals(ZonedDateTime.of(2001,2,3,0,0,0,0, zoneOffset), expressionParser.parse("truncatedtoday(ts)").eval().getTemporal());
    assertEquals(ZonedDateTime.of(2001,2,1,0,0,0,0, zoneOffset), expressionParser.parse("truncatedtomonth(ts)").eval().getTemporal());
    assertEquals(ZonedDateTime.of(2001,1,1,0,0,0,0, zoneOffset), expressionParser.parse("truncatedtoyear(ts)").eval().getTemporal());

    expressionParser.setVariable("ts", Instant.ofEpochMilli(2001));
    assertEquals(Instant.ofEpochMilli(2000), expressionParser.parse("truncatedtosecond(ts)").eval().getTemporal());
    assertEquals(Instant.ofEpochMilli(0), expressionParser.parse("truncatedtominute(ts)").eval().getTemporal());
    assertEquals(Instant.ofEpochMilli(0), expressionParser.parse("truncatedtohour(ts)").eval().getTemporal());
    assertEquals(Instant.ofEpochMilli(0), expressionParser.parse("truncatedtoday(ts)").eval().getTemporal());
    //assertEquals(Instant.ofEpochMilli(0), expressionParser.parse("truncatedtomonth(ts)").eval().getTemporal());
    //assertEquals(Instant.ofEpochMilli(0), expressionParser.parse("truncatedtoyear(ts)").eval().getTemporal());

  }
}
