### ExpressionParser

## Table of contents
1. [General Info](#general-info)
2. [Quick start](#quick-start)
3. [Variables](#variables)
4. [Functions](#functions)
    1. [Common-Functions](#common-functions)
    2. [Math-Functions](#math-functions)
    3. [String-Functions](#string-functions)
    4. [Date/Time-Functions](#datetime-functions)
    5. [Crypto-Functions](#crypto-functions)
    6. [Array-Functions](#array-functions)
    7. [Statistics-Functions](#statistics-functions)
    8. [Bit-Functions](#bit-functions)
5. [TODO](#todo) 
6. [Author and License](#author-and-license)

### General Info
ExpressionParser is a expression evaluator for Java, that allows to evaluate expressions, with a rich set of functions.

Key Features:
- Uses BigDecimal for calculation and result where possible
- Many difference datatypes (BigDecimal, Double, String, Temporal, List, Map, null, Boolean)
- No dependencies to external libraries
- Precision and rounding mode can be set
- Supports variables and variable-containers
- Standard boolean and mathematical operators
- Custom functions can be added at runtime
- Functions can be defined with a variable number of arguments
- A rich set of basic mathematical and boolean functions
- A rich set of functions for array-, string- and timestamp-manipulation
- Crypto- and statistic-functions
- Caching of expressions
- Allows variable-aliases (WITH)
- User can decide, which functions should be enabled by default

### Quick start
```java
System.out.println(new ExpressionParser().parse("1+2+3").eval()); //6

  
ExpressionParser parser = new ExpressionParser();
Expression expr = parser.parse("3*a");
expr.setVariable("a", Value.of(5));
Value result = expr.eval();

System.out.println(result); // 15
```

### Operators
| Function | Description |
|:--------------|:-------------|
| + - |  |
| * / % |  |
| && \|\| \^\^ |  |
| () |  |
| & \| ^ |  |
| != = > >= < <= |  |
| << >> |  |
| ! |  |
| ~ |  |
| [] |  |
| WITH(x AS y, ...) | |


### Variables
| Variable | Description |
|:--------------|:-------------:|
| E | 2.7... |
| PI | 3.14... |
| FALSE | 0 |
| TRUE | 1 |


### Functions
#### Common-Functions
| Function | Description |
|:--------------|:-------------|
| BETWEEN(low, x, high) | Is x between low and high? |
| BOUND(low, x, high) | Returns low if x<low, or returns high if x>high else return x |
| IFNULL(x, ...) | Returns the first value which is not null, if all values are null, null is returned |
| ISARRAY() | Is X a array? |
| ISNULL() | Is X = NULL? |
| ISNUMBER() | Is X a number? |
| ISSTRING() | Is X a string? |
| MAX(x, ...) | Returns the biggest value |
| MIN(str) | Returns the smallest value |

#### Math-Functions
| Function | Description |
|:--------------|:-------------|
| ABS(x) | Returns the absolute (non-negative) value of x |
| ACOS(x) | Returns the arcus cosinus of x in degrees |
| ACOSR(x) | Returns the arcus cosinus of x in radians |
| ASIN(x) | Returns the arcus sinus of x in degrees |
| ASINR(x) | Returns the arcus sinus of x in radians |
| ATAN(x) | Returns the arcus tangens of x in degrees |
| ATAN2(x, y) | Returns the arcus tangens of x/y in degrees |
| ATAN2R(x, y) | Returns the arcus tangens of x/y in radians |
| ATANR(x) | Returns the arcus tangens of x in radians |
| CEIL(x) | Rounds x up to the nearest integer |
| COS(x) | Returns the cosinus of x in degrees |
| COSR() | Returns the cosinus of x in radians |
| COT(x) | Returns the cotangens of x in degrees |
| COTR(x) | Returns the cotangens of x in radians |
| DEGREES(x) | Converts x from radians to degrees |
| FACT(x) | Retuns the factorial value of x. Will return 1 for 0 or a negative number |
| FLOOR(x) | Rounds x down to the nearest integer |
| LOG(x) | Returns the natural logarithm (base e) of x |
| LOG2(x) | Returns the binary logarithm (base 2) of x |
| LOG10(x) | Returns the common logarithm (base 10) of x |
| POW(x, y) | Returns the value of x raised to the power of y |
| RADIANS(x) | Converts x from degrees to radians |
| RANDOM() | Returns a random number between 0 and 1 |
| ROUND(x) |  |
| SEC() | Returns the secans of x in degrees |
| SECR() | Returns the cosinus of x in radians |
| SIGN(x) | Returns 0 if x is 0, -1 if x<0 and 1 if x>0 |
| SIN(x) | Returns the sinus of x in degrees |
| SINR(x) | Returns the sinus of x in radians | 
| SQRT(x) | Returns the square root of x |
| TAN(x) | Returns the tangens of x in degrees |
| TANR(x) | Returns the tangens of x in radians |

#### String-Functions
| Function | Description |
|:--------------|:-------------|
| CONCAT(str, ...) | Concatenate all values to a string |
| CONCATWS(sep, str, ...) | Concatenate all values to a string, with the given separator |
| ENDSWITH(str, search) | Returns true if str ends with search |
| FORMAT(str) |  |
| LEFT(str, x) | Returns the first x chars of str |
| LENGTH(str) | Returns the length of str |
| LIKE(x) |  |
| LOWER(str) | Converts the chars of str to lowercase letters |
| LPAD(x) |  |
| LTRIM(x) | Removes all whitespaces on the left side |
| REGEXFIND(x) |  |
| REGEXMATCH(x) |  |
| REGEXREPLACE(x) |  |
| REPEAT(str, x) | Repeats str x times |
| REPLACE(str, search, replace) |  |
| REVERSE(str) | Reverses str |
| RIGHT(str, x) | Returns the last x chars of str |
| RPAD(x) |  |
| RTRIM(x) | Removes all whitespaces on the right side |
| STARTSWITH(str, search) | Does str start with search? |
| SUBSTR(str, x, y) |  |
| SUBSTRING(str, x, y) |  |
| TRIM(str) | Removes all whitespaces on both sides of str |
| UPPER(str) | Converts the chars of str to uppercase letters |

#### Date/Time-Functions
| Function | Description |
|:--------------|:-------------|
| ADDDAY(ts, x) | Adds x days to timestamp ts |
| ADDHOUR(ts, x) | Adds x hours to timestamp ts |
| ADDMINUTE(ts, x) | Adds x minutes to timestamp ts |
| ADDMONTH(ts, x) | Adds x monthes to timestamp ts |
| ADDSECOND(ts, x) | Adds x seconds to timestamp ts |
| ADDYEAR(ts, x) | Adds x years to timestamp ts |
| DATE(&lt;<year&gt;, &lt;month&gt;, &lt;day&gt;) | Constructs a date with the given parameters |
| DATETIME(&lt;year&gt;, &lt;month&gt;, &lt;day&gt;, &lt;hour&gt;, &lt;minute&gt;, &lt;second&gt;, &lt;nanosecond&gt;) | Constructs a datetime with the given parameters |
| DAY(x) | Returns the day in month of date x (1-31) |
| DIFFDAY(ts1, ts2) | Returns the difference between ts1 and ts2 in days |
| DIFFHOUR(ts1, ts2) | Returns the difference between ts1 and ts2 in hours |
| DIFFMINUTE(ts1, ts2) | Returns the difference between ts1 and ts2 in minutes |
| DIFFMONTH(ts1, ts2) | Returns the difference between ts1 and ts2 in months |
| DIFFNANOSECOND(ts1, ts2) | Returns the difference between ts1 and ts2 in nanoseconds |
| DIFFSECOND(ts1, ts2) | Returns the difference between ts1 and ts2 in seconds |
| DIFFYEAR(ts1, ts2) | Returns the difference between ts1 and ts2 in years |
| FIRSTDAYOFMONTH(ts) | Returns the timestamp adjusted to the first day of the month |
| FIRSTDAYOFNEXTMONTH(ts) | Returns the timestamp adjusted to the first day of the next month |
| FIRSTDAYOFNEXTYEAR(ts) | Returns the timestamp adjusted to the first day of the next year  |
| FIRSTDAYOFYEAR(ts) | Returns the timestamp adjusted to the first day of the year |
| FIRSTINMONTH(ts) | Returns true if the given timestamp is the first day in month |
| HOUR(x) | Returns the hour of time x (0-23) |
| ISDATE(x) | Returns true if x is a date |
| ISDATETIME(x) | Returns true if x is a datetime |
| ISTIME(x) | Returns true if x is a time |
| LASTDAYOFMONTH(ts) | Returns the timestamp adjusted to the last day of the month |
| LASTDAYOFYEAR(ts) | Returns the timestamp adjusted to the last day of the year |
| MINUTE(x) | Returns the minute of time x (0-59) |
| MONTH(x) | Returns the month of date x (1-12) |
| NANOSECOND(x) | Returns the nanosecond of time x (0-999999999) |
| NOW(x) | Returns the current timestamp |
| SECOND(x) | Returns the second of time x (0-59) |
| SETDAY(x, y) | Returns a date where the day of x is set to y |
| SETHOUR(x, y) | Returns a time where the hour of x is set to y |
| SETMINUTE(x, y) | Returns a time where the minute of x is set to y |
| SETMONTH(x, y) | Returns a date where the month of x is set to y |
| SETNANOSECOND(x, y) | Returns a time where the nanosecond of x is set to y |
| SETSECOND(x, y) | Returns a time where the second of x is set to y |
| SETYEAR(x, y) | Returns a date where the year of x is set to y |
| SUBDAY(ts, x) | Subtract x days from timestamp ts |
| SUBHOUR(ts, x) | Subtract x hours from timestamp ts |
| SUBMINUTE(ts, x) | Subtract x minutes from timestamp ts |
| SUBMONTH(ts, x) | Subtract x months from timestamp ts |
| SUBNANOSECOND(ts, x) | Subtract x nanoseconds from timestamp ts |
| SUBSECOND(ts, x) | Subtract x seconds from timestamp ts |
| SUBYEAR(ts, x) | Subtract x years from timestamp ts |
| TIME(&lt;hour&gt;, &lt;minute&gt;, &lt;second&gt;, &lt;nanosecond&gt;) | Constructs a time with the given parameters |
| WEEK(x) | Returns the ISO-week of date x (1-53) |
| YEAR(x) | Returns the year of date x |

#### Crypto-Functions
| Function | Description |
|:--------------|:-------------|
| CRC32(str, ...) | Calculates the crc32 of the given values |
| MD5(str, ...) | Calculates the md5 of the given values |
| SHA1(str, ...) | Calculates the sha1 of the given values |
| SHA256(str, ...) | Calculates the sha256 of the given values |
| UUID() | Generates a UUID |

#### Array-Functions
| Function | Description |
|:--------------|:-------------|
| ARRAY(...) | Builds an array, with the provided values |
| ARRAYCONCAT(arr, ...) |  |
| ARRAYCOUNT(arr) | Returns the length of the array |
| ARRAYDIFF(arr) | |
| ARRAYDISTINCT(arr) | Returns an array, where all values are unique |
| ARRAYFLAT(arr) |  |
| ARRAYGET(str) |  |
| ARRAYINCLUDES(arr, x) | Is x included in arr? |
| ARRAYINDEXOF(arr) |  |
| ARRAYINSERT(arr, x, y) |  |
| ARRAYINTERSECT(arr, ...) | Returns an array with the common values of all given arrays |
| ARRAYJOIN(arr) | |
| ARRAYKEYS(arr) | Returns the keys of arr as array |
| ARRAYLASTINDEXOF(arr, x) | Returns the position of the last x in arr |
| ARRAYREPLACE(arr) | |
| ARRAYREVERSE(arr) |  |
| ARRAYROTATE(arr) | |
| ARRAYSET(arr, x, y) | |
| ARRAYSLICE(arr) |  |
| ARRAYSORT(arr) | Sorts arr |
| ARRAYSWAP(arr, x, y) | Swaps the values of the keys x and y |
| ARRAYUNION(arr, ...) | |
| ARRAYVALUES() | Returns the values of the array |

#### Statistics-Functions
| Function | Description |
|:--------------|:-------------|
| CP(lsl, osl, arr) | Calculates the process capability index |
| CPK(lsl, osl, arr) | Calculates the process capability index |
| KURTOSIS(arr) | Calculates the kurtosis of the givven array |
| MEAN(arr) | Calculates the arithmetic mean of the given array |
| MODE(arr) | Calculates the mode of the given array |
| PERCENTILE(arr, pct) | Calculates the percentile of the given array |
| RANGE(arr) | Returns the difference of the max and the min value in the array |
| SKEWNESS(arr) | Calculates the skewness of the given array |
| STD(arr) | Calculates the the standard deviation of the given array |
| SUM(arr) | Returns the summary of all values, nulls are ignored |
| VAR(arr) | Calculates the variance of the given array |

#### Bit-Functions
| Function | Description |
|:--------------|:-------------|
| clearBit(x, pos, ...) | Clears the bit of x at all given positions |
| extractBits(x, start, end) | Copy the bits from x from position start to end |
| invertBit(x, pos, ...) | Inverts the bit of x at all given positions |
| setBit(x, pos, ...) | Sets the bit of x at all given positions |
| testBit(x, pos) | Tests the bit of x at the given position |


### TODO
- This README
- API-Documentation
- Recursive With-Functions

### Author and License
Copyright 2021 by Weinzierl Stefan