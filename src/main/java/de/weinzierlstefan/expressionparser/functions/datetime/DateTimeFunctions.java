package de.weinzierlstefan.expressionparser.functions.datetime;

import de.weinzierlstefan.expressionparser.Function;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 */
public class DateTimeFunctions {

  /**
   *
   * @return
   */
  public static Collection<Function> getFunctions() {
    Collection<Function> functionCollection = new ArrayList<>();

    functionCollection.add(new AddDay());
    functionCollection.add(new AddHour());
    functionCollection.add(new AddNanoSecond());
    functionCollection.add(new AddMinute());
    functionCollection.add(new AddMonth());
    functionCollection.add(new AddNanoSecond());
    functionCollection.add(new AddSecond());
    functionCollection.add(new AddYear());
    functionCollection.add(new Date());
    functionCollection.add(new DateTime());
    functionCollection.add(new Day());
    functionCollection.add(new DiffDay());
    functionCollection.add(new DiffHour());
    functionCollection.add(new DiffMinute());
    functionCollection.add(new DiffMonth());
    functionCollection.add(new DiffNanoSecond());
    functionCollection.add(new DiffSecond());
    functionCollection.add(new DiffYear());
    functionCollection.add(new Hour());
    functionCollection.add(new FirstDayOfMonth());
    functionCollection.add(new FirstDayOfNextMonth());
    functionCollection.add(new FirstDayOfNextYear());
    functionCollection.add(new FirstDayOfYear());
    functionCollection.add(new FirstInMonth());
    functionCollection.add(new IsDate());
    functionCollection.add(new IsDateTime());
    functionCollection.add(new IsTime());
    functionCollection.add(new LastDayOfMonth());
    functionCollection.add(new LastDayOfYear());
    functionCollection.add(new Nanosecond());
    functionCollection.add(new Minute());
    functionCollection.add(new Month());
    functionCollection.add(new Now());
    functionCollection.add(new Second());
    functionCollection.add(new SetDay());
    functionCollection.add(new SetHour());
    functionCollection.add(new SetMinute());
    functionCollection.add(new SetMonth());
    functionCollection.add(new SetNanoSecond());
    functionCollection.add(new SetSecond());
    functionCollection.add(new SetYear());
    functionCollection.add(new SubDay());
    functionCollection.add(new SubHour());
    functionCollection.add(new SubMinute());
    functionCollection.add(new SubMonth());
    functionCollection.add(new SubNanoSecond());
    functionCollection.add(new SubSecond());
    functionCollection.add(new SubYear());
    functionCollection.add(new Time());
    functionCollection.add(new TruncatedToDay());
    functionCollection.add(new TruncatedToHour());
    functionCollection.add(new TruncatedToMinute());
    functionCollection.add(new TruncatedToYear());
    functionCollection.add(new TruncatedToMonth());
    functionCollection.add(new TruncatedToSecond());
    functionCollection.add(new Week());
    functionCollection.add(new Year());

    return functionCollection;
  }
}
