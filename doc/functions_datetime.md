
#### Date/Time-Functions
| Function                                                                                                             | Description                                                       |
|:---------------------------------------------------------------------------------------------------------------------|:------------------------------------------------------------------|
| ADDDAY(ts, x)                                                                                                        | Adds x days to timestamp ts                                       |
| ADDHOUR(ts, x)                                                                                                       | Adds x hours to timestamp ts                                      |
| ADDMINUTE(ts, x)                                                                                                     | Adds x minutes to timestamp ts                                    |
| ADDMONTH(ts, x)                                                                                                      | Adds x monthes to timestamp ts                                    |
| ADDNANOSECOND(ts, x)                                                                                                 | Add x nanoseconds to timestamp ts                                 |
| ADDSECOND(ts, x)                                                                                                     | Adds x seconds to timestamp ts                                    |
| ADDYEAR(ts, x)                                                                                                       | Adds x years to timestamp ts                                      |
| DATE(&lt;<year&gt;, &lt;month&gt;, &lt;day&gt;)                                                                      | Constructs a date with the given parameters                       |
| DATETIME(&lt;year&gt;, &lt;month&gt;, &lt;day&gt;, &lt;hour&gt;, &lt;minute&gt;, &lt;second&gt;, &lt;nanosecond&gt;) | Constructs a datetime with the given parameters                   |
| DAY(x)                                                                                                               | Returns the day in month of date x (1-31)                         |
| DIFFDAY(ts1, ts2)                                                                                                    | Returns the difference between ts1 and ts2 in days                |
| DIFFHOUR(ts1, ts2)                                                                                                   | Returns the difference between ts1 and ts2 in hours               |
| DIFFMINUTE(ts1, ts2)                                                                                                 | Returns the difference between ts1 and ts2 in minutes             |
| DIFFMONTH(ts1, ts2)                                                                                                  | Returns the difference between ts1 and ts2 in months              |
| DIFFNANOSECOND(ts1, ts2)                                                                                             | Returns the difference between ts1 and ts2 in nanoseconds         |
| DIFFSECOND(ts1, ts2)                                                                                                 | Returns the difference between ts1 and ts2 in seconds             |
| DIFFYEAR(ts1, ts2)                                                                                                   | Returns the difference between ts1 and ts2 in years               |
| FIRSTDAYOFMONTH(ts)                                                                                                  | Returns the timestamp adjusted to the first day of the month      |
| FIRSTDAYOFNEXTMONTH(ts)                                                                                              | Returns the timestamp adjusted to the first day of the next month |
| FIRSTDAYOFNEXTYEAR(ts)                                                                                               | Returns the timestamp adjusted to the first day of the next year  |
| FIRSTDAYOFYEAR(ts)                                                                                                   | Returns the timestamp adjusted to the first day of the year       |
| FIRSTINMONTH(ts)                                                                                                     | Returns true if the given timestamp is the first day in month     |
| HOUR(x)                                                                                                              | Returns the hour of time x (0-23)                                 |
| ISDATE(x)                                                                                                            | Returns true if x is a date                                       |
| ISDATETIME(x)                                                                                                        | Returns true if x is a datetime                                   |
| ISTIME(x)                                                                                                            | Returns true if x is a time                                       |
| LASTDAYOFMONTH(ts)                                                                                                   | Returns the timestamp adjusted to the last day of the month       |
| LASTDAYOFYEAR(ts)                                                                                                    | Returns the timestamp adjusted to the last day of the year        |
| MINUTE(x)                                                                                                            | Returns the minute of time x (0-59)                               |
| MONTH(x)                                                                                                             | Returns the month of date x (1-12)                                |
| NANOSECOND(x)                                                                                                        | Returns the nanosecond of time x (0-999999999)                    |
| NOW(x)                                                                                                               | Returns the current timestamp                                     |
| SECOND(x)                                                                                                            | Returns the second of time x (0-59)                               |
| SETDAY(x, y)                                                                                                         | Returns a date where the day of x is set to y                     |
| SETHOUR(x, y)                                                                                                        | Returns a time where the hour of x is set to y                    |
| SETMINUTE(x, y)                                                                                                      | Returns a time where the minute of x is set to y                  |
| SETMONTH(x, y)                                                                                                       | Returns a date where the month of x is set to y                   |
| SETNANOSECOND(x, y)                                                                                                  | Returns a time where the nanosecond of x is set to y              |
| SETSECOND(x, y)                                                                                                      | Returns a time where the second of x is set to y                  |
| SETYEAR(x, y)                                                                                                        | Returns a date where the year of x is set to y                    |
| SUBDAY(ts, x)                                                                                                        | Subtract x days from timestamp ts                                 |
| SUBHOUR(ts, x)                                                                                                       | Subtract x hours from timestamp ts                                |
| SUBMINUTE(ts, x)                                                                                                     | Subtract x minutes from timestamp ts                              |
| SUBMONTH(ts, x)                                                                                                      | Subtract x months from timestamp ts                               |
| SUBNANOSECOND(ts, x)                                                                                                 | Subtract x nanoseconds from timestamp ts                          |
| SUBSECOND(ts, x)                                                                                                     | Subtract x seconds from timestamp ts                              |
| SUBYEAR(ts, x)                                                                                                       | Subtract x years from timestamp ts                                |
| TIME(&lt;hour&gt;, &lt;minute&gt;, &lt;second&gt;, &lt;nanosecond&gt;)                                               | Constructs a time with the given parameters                       |
| TRUNCATEDTODAY(ts)                                                                                                   | Truncates ts to days                                              |
| TRUNCATEDTOHOUR(ts)                                                                                                  | Truncates ts to hours                                             |
| TRUNCATEDTOMINUTE(ts)                                                                                                | Truncates ts to minutes                                           |
| TRUNCATEDTOMONTH(ts)                                                                                                 | Truncates ts to monthes                                           |
| TRUNCATEDTOSECOND(ts)                                                                                                | Truncates ts to seconds                                           |
| TRUNCATEDTOYEAR(ts)                                                                                                  | Truncates ts to years                                             |
| WEEK(x)                                                                                                              | Returns the ISO-week of date x (1-53)                             |
| YEAR(x)                                                                                                              | Returns the year of date x                                        |
