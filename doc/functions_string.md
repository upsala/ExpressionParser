## String-Functions
- [CharAt](#CharAt): Returns the char at position x 
- [Concat](#Concat): Concatenate all values to a string 
- [ConcatWS](#ConcatWS): Concatenate all values to a string, with the given separator 
- [EndsWith](#EndsWith): Returns true if str ends with search 
- [Format](#Format): Replaces all '%' characters in the first string with the string values of the rest of the parameters
- [Left](#Left): Returns the first x chars of str 
- [Length](#Length): Returns the length of str 
- [Like](#Like): Checks if a string matches a pattern using SQL LIKE syntax
- [Lower](#Lower): Converts the chars of str to lowercase letters 
- [LPad](#LPad): Pads the left side of a string with a specified character
- [LTrim](#LTrim): Removes all whitespaces on the left side 
- [RegExFind](#RegExFind): Finds the first match of a regular expression pattern in a string
- [RegExMatch](#RegExMatch): Checks if a string contains a match for the given regular expression pattern
- [RegExReplace](#RegExReplace): Replaces all occurrences of a regular expression pattern in a string
- [RegExSplit](#RegExSplit): Splits a string using a regular expression pattern as the delimiter
- [Repeat](#Repeat): Repeats str x times 
- [Replace](#Replace): Replaces all occurrences of a substring in a string with another substring
- [Reverse](#Reverse): Reverses str 
- [Right](#Right): Returns the last x chars of str 
- [RPad](#RPad): Pads the right side of a string with a specified character
- [RTrim](#RTrim): Removes all whitespaces on the right side 
- [Split](#Split): Splits a string using a literal string as the delimiter
- [StartsWith](#StartsWith): Does str start with search? 
- [SubStr](#SubStr): Returns a substring of a string with a specified start and length
- [SubString](#SubString): Returns a substring of a string with a specified start and end
- [ToString](#ToString): Converts the given value to a string
- [Trim](#Trim): Removes all whitespaces on both sides of str 
- [Upper](#Upper): Converts the chars of str to uppercase letters 


### CharAt
    Sync: CharAt(str, x) 
Returns the char at position x 

### Concat
    Sync: Concat(str, ...) 
Concatenate all values to a string 

    Concat("This","is","a","test") => "Thisisatest"

### ConcatWS
    Sync: ConcatWS(sep, str, ...) 
Concatenate all values to a string, with the given separator 

    ConcatWS(" ", "This","is","a","test") => "This is a test"

### EndsWith
    Sync: EndsWith(str, search) 
Returns true if str ends with search 

### Format
    Sync: Format(str, ...) 
Replaces all '%' characters in the first string with the string values of the rest of the parameters.

    Format('a%c%', 'b', 1) => 'abc1'
    Format('a%c', 'b') => 'abc'

### Left
    Sync: Left(str, x) 
Returns the first x chars of str 

### Length
    Sync: Length(str) 
Returns the length of str 

    Length("Test") => 4

### Like
    Sync: Like(str, pattern) 
Checks if a string matches a pattern using SQL LIKE syntax. The function is case-insensitive.
- '%' matches any sequence of characters
- '_' matches any single character

    Like('abc', 'a%') => true
    Like('abc', 'a__') => true
    Like('abc', 'a_') => false

### Lower
    Sync: Lower(str) 
Converts the chars of str to lowercase letters 

    Lower("Test") => "test"

### LPad
    Sync: LPad(str, length, <padding>) 
Pads the left side of a string with a specified character (or space by default) to reach a specified length.

    LPad('abc', 6) => '   abc'
    LPad('abc', 6, '.') => '...abc'
    LPad('abc', 2) => 'abc'
    LPad('abc', 6, '.*') => '.*.abc'

### LTrim
    Sync: LTrim(x) 
Removes all whitespaces on the left side 

    LTrim("  Test  ") => "Test  "

### RegExFind
    Sync: RegExFind(str, pattern) 
Finds the first match of a regular expression pattern in a string and returns the matched substring. If no match is found, it returns an empty string.

    RegExFind('abc12', '[0-9]+') => '12'
    RegExFind('abc12', '^[0-9]+') => ''

### RegExMatch
    Sync: RegExMatch(str, pattern) 
Checks if a string contains a match for the given regular expression pattern. Returns true if a match is found, false otherwise.

    RegExMatch('abc12', '[0-9]+') => true
    RegExMatch('abc12', '^[0-9]+') => false
    RegExMatch('abc12', '^[a-z0-9]+$') => true

### RegExReplace
    Sync: RegExReplace(str, pattern, replace) 
Replaces all occurrences of a regular expression pattern in a string with a specified replacement string.

    RegExReplace('abc12', '[0-9]+', 'de') => 'abcde'

### RegExSplit
    Sync: RegExSplit(str, pattern, <limit>) 
Splits a string using a regular expression pattern as the delimiter and returns an array of substrings. The optional limit parameter controls the number of splits.

    RegExSplit('abc', '') => ['a','b','c','']
    RegExSplit('a,b,c', ',') => ['a','b','c']
    RegExSplit('a123b555c', '[0-9]+') => ['a','b','c']
    RegExSplit('a-b-c', '-', 2) => ['a','b-c']

### Repeat
    Sync: Repeat(str, x) 
Repeats str x times 

    Repeat('Test', 3) => 'TestTestTest'

### Replace
    Sync: Replace(str, search, replace) 
Replaces all occurrences of a substring in a string with another substring.

    Replace('abc', 'a', '1') => '1bc'
    Replace('abc', 'ab', '12') => '12c'

### Reverse
    Sync: Reverse(str) 
Reverses str 

    Reverse("Test") => "tseT"

### Right
    Sync: Right(str, x) 
Returns the last x chars of str 

### RPad
    Sync: RPad(str, length, <padding>) 
Pads the right side of a string with a specified character (or space by default) to reach a specified length.

    RPad('abc', 6) => 'abc   '
    RPad('abc', 6, '.') => 'abc...'
    RPad('abc', 2) => 'abc'
    RPad('abc', 6, '.*') => 'abc.*.'

### RTrim
    Sync: RTrim(str, <chars>) 
Removes all whitespaces on the right side of the string. If chars is specified, removes those characters instead.

    RTrim('  abc  ') => '  abc'
    RTrim('33abc33', '3') => '33abc'

### Split
    Sync: Split(str, pattern, <limit>) 
Splits a string using a literal string as the delimiter and returns an array of substrings. The optional limit parameter controls the number of splits.

    Split('This is a test', ' ') => ['This', 'is', 'a', 'test']
    Split('This is a test', ' ', 2) => ['This', 'is a test']
    Split('abc', '') => ['a', 'b', 'c', '']
    Split('abc', ',') => ['abc']

### StartsWith
    Sync: StartsWith(str, search, <offset>) 
Does str start with search? 

    StartsWith("This is a test", "This") => true
    StartsWith("This is a test", "test") => false

### SubStr
    Sync: SubStr(str, start, <length>) 
Returns a string, which is a substring of 'str'. The substring begins at the specified 'start' and has a length of 'length'. If 'length' is omitted, the string from 'start' to the end is returned. 
If 'start' is negative, the returned string will start at the offset'th character from the end of string.

    substr('This is a test', 5, 4) => 'is a'
    substr('This is a test', 5) => 'is a test'
    substr('This is a test', -9, 4) => 'is a'
    substr('This is a test', -9,) => 'is a test'

### SubString
    Sync: SubString(str, start, <end>) 
Returns a string, which is a substring of 'str'. The substring begins at the specified 'start' and extends to the character at index endIndex - 1. Thus the length of the substring is endIndex-beginIndex. If 'start' is negative, it is treated as 0. If 'end' is greater than the length of the string, it is treated as the length of the string.

    SubString('abcdefghijklmn', 5, 5) => ''
    SubString('abc', 1, 10) => 'bc'
    SubString('abcdefghijklmn', -5, 10) => 'abcdefghij'

### ToString
    Sync: ToString(x) 
Converts the given value to a string

    ToString(123.23) => "123.23"
    ToString([1,2,3]) => "[1,2,3]"

### Trim
    Sync: Trim(str)
Removes all whitespaces on both sides of str

    Trim("   Test   ") => "Test"

### Upper
    Sync: Upper(str) 
Converts the chars of str to uppercase letters 

    Upper("ExpressionParser") => "EXPRESSIONPARSER"
