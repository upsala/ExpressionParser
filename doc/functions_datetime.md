## Date/Time-Functions
- [AddDay](#AddDay): Adds x days to timestamp ts                                       
- [AddHour](#AddHour): Adds x hours to timestamp ts                                      
- [AddMinute](#AddMinute): Adds x minutes to timestamp ts                                    
- [AddMonth](#AddMonth): Adds x monthes to timestamp ts                                    
- [AddNanoSecond](#AddNanoSecond): Add x nanoseconds to timestamp ts                                 
- [AddSecond](#AddSecond) Adds x seconds to timestamp ts                                    
- [AddYear](#AddYear) Adds x years to timestamp ts                                      
- [Date](#Date) Constructs a date with the given parameters                       
- [DateTime](#DateTime) Constructs a datetime with the given parameters                   
- [Day](#Day) Returns the day in month of date x (1-31)                         
- [DiffDay](#DiffDay) Returns the difference between ts1 and ts2 in days                
- [DiffHour](#DiffHour) Returns the difference between ts1 and ts2 in hours               
- [DiffMinute](#DiffMinute) Returns the difference between ts1 and ts2 in minutes             
- [DiffMonth](#DiffMonth) Returns the difference between ts1 and ts2 in months              
- [DiffNanoSecond](#DiffNanoSecond) Returns the difference between ts1 and ts2 in nanoseconds         
- [DiffSecond](#DiffSecond) Returns the difference between ts1 and ts2 in seconds             
- [DiffYear](#DiffYear) Returns the difference between ts1 and ts2 in years               
- [FirstDayOfMonth](#FirstDayOfMonth) Returns the timestamp adjusted to the first day of the month      
- [FirstDayOfNextMonth](#FirstDayOfNextMonth) Returns the timestamp adjusted to the first day of the next month 
- [FirstDayOfNextYear](#FirstDayOfNextYear) Returns the timestamp adjusted to the first day of the next year  
- [FirstDayOfYear](#FirstDayOfYear) Returns the timestamp adjusted to the first day of the year       
- [FirstInMonth](#FirstInMonth) Returns true if the given timestamp is the first day in month     
- [Hour](#Hour) Returns the hour of time x (0-23)                                 
- [IsDate](#IsDate) Returns true if x is a date                                       
- [IsDateTime](#IsDateTime) Returns true if x is a datetime                                   
- [IsTime](#IsTime) Returns true if x is a time                                       
- [LastDayOfMonth](#LastDayOfMonth) Returns the timestamp adjusted to the last day of the month       
- [LastDayOfYear](#LastDayOfYear) Returns the timestamp adjusted to the last day of the year        
- [Minute](#Minute) Returns the minute of time x (0-59)                               
- [Month](#Month) Returns the month of date x (1-12)                                
- [NanoSecond](#NanoSecond) Returns the nanosecond of time x (0-999999999)                    
- [Now](#Now) Returns the current timestamp                                     
- [Second](#Second) Returns the second of time x (0-59)                               
- [SetDay](#SetDay) Returns a date where the day of x is set to y                     
- [SetHour](#SetHour) Returns a time where the hour of x is set to y                    
- [SetMinute](#SetMinute) Returns a time where the minute of x is set to y                  
- [SetMonth](#SetMonth) Returns a date where the month of x is set to y                   
- [SetNanoSecond](#SetNanoSecond) Returns a time where the nanosecond of x is set to y              
- [SetSecond](#SetSecond) Returns a time where the second of x is set to y                  
- [SetYear](#SetYear) Returns a date where the year of x is set to y                    
- [SubDay](#SubDay) Subtract x days from timestamp ts                                 
- [SubHour](#SubHour) Subtract x hours from timestamp ts                                
- [SubMinute](#SubMinute) Subtract x minutes from timestamp ts                              
- [SubMonth](#SubMonth) Subtract x months from timestamp ts                               
- [SubNanoSecond](#SubNanoSecond) Subtract x nanoseconds from timestamp ts                          
- [SubSecond](#SubSecond): Subtract x seconds from timestamp ts                              
- [SubYear](#SubYear): Subtract x years from timestamp ts                                
- [Time](#Time): Constructs a time with the given parameters                       
- [TruncatedToDay](#TruncatedToDay): Truncates ts to days                                              
- [TruncatedToHour](#TruncatedToHour) Truncates ts to hours                                             
- [TruncatedToMinute](#TruncatedToMinute) Truncates ts to minutes                                           
- [TruncatedToMonth](#TruncatedToMonth) Truncates ts to monthes                                           
- [TruncatedToSecond](#TruncatedToSecond) Truncates ts to seconds                                           
- [TruncatedToYear](#TruncatedToYear): Truncates ts to years                                             
- [Week](#Week): Returns the ISO-week of date x (1-53)                             
- [Year](#Year): Returns the year of date x                                        




### AddDay
    Syntax: AddDay(ts, x)                                                                                                        
Adds x days to timestamp ts

    AddDay(Date(2024,7,14),5) => '2024-07-19'
    AddDay(DateTime(2024,7,14,8,27,35),5) => '2024-0719T08:27:35'
    AddDay(Date(2023,12,28),5) => '2024-01-02'

### AddHour
    Syntax: AddHour(ts, x)                                                                                                    
Adds x hours to timestamp ts

### AddMinute
    Syntax: AddMinute(ts, x)                                                                                                  
Adds x minutes to timestamp ts

### AddMonth
    Syntax: AddMonth(ts, x)                                                                                                   
Adds x monthes to timestamp ts

### AddNanoSecond
    Syntax: AddNanoSecond(ts, x)                                                                                              
Add x nanoseconds to timestamp ts

### AddSecond
    Syntax: AddSecond(ts, x)                                                                                                     
Adds x seconds to timestamp ts

### AddYear
    Syntax: AddYear(ts, x)                                                                                                      
Adds x years to timestamp ts

### Date
    Syntax: Date(&lt;year&gt;, &lt;month&gt;, &lt;day&gt;)                                                                      
Constructs a date with the given parameters

    Date(2023, 12, 31) => '2023-12-31'
    Date(2024, 2, 29) => '2024-02-29'

### DateTime
    Syntax: DateTime(&lt;year&gt;, &lt;month&gt;, &lt;day&gt;, &lt;hour&gt;, &lt;minute&gt;, &lt;second&gt;, &lt;nanosecond&gt;) 
Constructs a datetime with the given parameters. The nanosecond parameter is optional.

    DateTime(2023, 12, 31, 23, 59, 59) => '2023-12-31T23:59:59'
    DateTime(2024, 1, 1, 0, 0, 0) => '2024-01-01T00:00:00'
    DateTime(2024, 2, 29, 12, 30, 45, 500000000) => '2024-02-29T12:30:45.5'

### Day
    Syntax: Day(x)                                                                                                               
Returns the day in month of date x (1-31)

    Day(Date(2023, 12, 31)) => 31
    Day(DateTime(2024, 2, 29, 12, 0, 0)) => 29

### DiffDay
    Syntax: DiffDay(ts1, ts2)                                                                                                    
Returns the difference between ts1 and ts2 in days

### DiffHour
    Syntax: DiffHour(ts1, ts2)                                                                                                   
Returns the difference between ts1 and ts2 in hours

### DiffMinute
    Syntax: DiffMinute(ts1, ts2)                                                                                                 
Returns the difference between ts1 and ts2 in minutes

### DiffMonth
    Syntax: DiffMonth(ts1, ts2)                                                                                                  
Returns the difference between ts1 and ts2 in months

### DiffNanoSecond
    Syntax: DiffNanoSecond(ts1, ts2)                                                                                             
Returns the difference between ts1 and ts2 in nanoseconds

### DiffSecond
    Syntax: DiffSecond(ts1, ts2)                                                                                                 
Returns the difference between ts1 and ts2 in seconds

### DiffYear
    Syntax: DiffYear(ts1, ts2)                                                                                                   
Returns the difference between ts1 and ts2 in years

### FirstDayOfMonth
    Syntax: FirstDayOfMonth(ts)                                                                                                  
Returns the timestamp adjusted to the first day of the month

### FirstDayOfNextMonth
    Syntax: FirstDayOfNextMonth(ts)                                                                                              
Returns the timestamp adjusted to the first day of the next month

### FirstDayOfNextYear
    Syntax: FirstDayOfNextYear(ts)                                                                                               
Returns the timestamp adjusted to the first day of the next year

### FirstDayOfYear
    Syntax: FirstDayOfYear(ts)                                                                                                   
Returns the timestamp adjusted to the first day of the year

### FirstInMonth
    Syntax: FirstInMonth(ts)                                                                                                     
Returns true if the given timestamp is the first day in month

### Hour
    Syntax: Hour(x)                                                                                                              
Returns the hour of time x (0-23)

### IsDate
    Syntax: IsDate(x)                                                                                                            
Returns true if x is a date

    IsDate(Date(2023, 12, 31)) => true
    IsDate(DateTime(2023, 12, 31, 12, 0, 0)) => false
    IsDate("2023-12-31") => false

### IsDateTime
    Syntax: IsDateTime(x)                                                                                                        
Returns true if x is a datetime

### IsTime
    Syntax: IsTime(x)                                                                                                            
Returns true if x is a time

### LastDayOfMonth
    Syntax: LastDayOfMonth(ts)                                                                                                   
Returns the timestamp adjusted to the last day of the month

### LastDayOfYear
    Syntax: LastDayOfYear(ts)                                                                                                    
Returns the timestamp adjusted to the last day of the year

### Minute
    Syntax: Minute(x)                                                                                                            
Returns the minute of time x (0-59)

### Month
    Syntax: Month(x)                                                                                                             
Returns the month of date x (1-12)

    Month(Date(2023, 12, 31)) => 12
    Month(DateTime(2024, 2, 29, 12, 0, 0)) => 2

### NanoSecond
    Syntax: NanoSecond(x)                                                                                                        
Returns the nanosecond of time x (0-999999999)

### Now
    Syntax: Now()                                                                                                               
Returns the current timestamp as a datetime object

    Now() => '2023-07-14T15:30:45.123' (example output, actual result will be the current date and time)

### Second
    Syntax: Second(x)                                                                                                            
Returns the second of time x (0-59)

### SetDay
    Syntax: SetDay(x, y)                                                                                                         
Returns a date where the day of x is set to y

### SetHour
    Syntax: SetHour(x, y)                                                                                                        
Returns a time where the hour of x is set to y

### SetMinute
    Syntax: SetMinute(x, y)                                                                                                      
Returns a time where the minute of x is set to y

### SetMonth
    Syntax: SetMonth(x, y)                                                                                                       
Returns a date where the month of x is set to y

### SetNanoSecond
    Syntax: SetNanoSecond(x, y)                                                                                                  
Returns a time where the nanosecond of x is set to y

### SetSecond
    Syntax: SetSecond(x, y)                                                                                                      
Returns a time where the second of x is set to y

### SetYear
    Syntax: SetYear(x, y)                                                                                                        
Returns a date where the year of x is set to y

### SubDay
    Syntax: SubDay(ts, x)                                                                                                        
Subtract x days from timestamp ts

### SubHour
    Syntax: SubHour(ts, x)                                                                                                       
Subtract x hours from timestamp ts

### SubMinute
    Syntax: SubMinute(ts, x)                                                                                                     
Subtract x minutes from timestamp ts

### SubMonth
    Syntax: SubMonth(ts, x)                                                                                                      
Subtract x months from timestamp ts

### SubNanoSecond
    Syntax: SubNanoSecond(ts, x)                                                                                                 
Subtract x nanoseconds from timestamp ts

### SubSecond
    Syntax: SubSecond(ts, x)                                                                                                     
Subtract x seconds from timestamp ts

### SubYear
    Syntax: SubYear(ts, x)                                                                                                       
Subtract x years from timestamp ts

### Time
    Syntax: Time(&lt;hour&gt;, &lt;minute&gt;, &lt;second&gt;, &lt;nanosecond&gt;)                                               
Constructs a time with the given parameters. The nanosecond parameter is optional.

    Time(12, 30, 45) => '12:30:45'
    Time(23, 59, 59) => '23:59:59'
    Time(9, 5, 0, 250000000) => '09:05:00.25'

### TruncatedToDay
    Syntax: TruncatedToDay(ts)                                                                                                   
Truncates ts to days 

### TruncatedToHour
    Syntax: TruncatedToHour(ts)                                                                                                  
Truncates ts to hours

### TruncatedToMinute
    Syntax: TruncatedToMinute(ts)                                                                                                
Truncates ts to minutes         

### TruncatedToMonth
    Syntax: TruncatedToMonth(ts)                                                                                                 
Truncates ts to monthes

### TruncatedToSecond
    Syntax: TruncatedToSecond(ts)                                                                                                
Truncates ts to seconds                        

### TruncatedToYear
    Syntax: TruncatedToYear(ts)                                                                                                  
Truncates ts to years                                             

### Week
    Syntax: Week(x)
Returns the ISO-week of date x (1-53)                             

### Year
    Syntax: Year(x)                                                                                                              
Returns the year of date x

    Year(Date(2023, 12, 31)) => 2023
    Year(DateTime(2024, 2, 29, 12, 0, 0)) => 2024
