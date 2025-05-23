### ExpressionParser

## Table of contents
1. [General Info](#general-info)
2. [Quick start](#quick-start)
3. [Documentation](doc/index.md)
5. [TODO](#todo)
6. [Author and License](#author-and-license)
7. [Changelog](#changelog)

### General Info
ExpressionParser is a expression evaluator for Java, that allows to evaluate expressions, with a rich set of functions.

Key Features:
- Many difference datatypes (Double, Long, Integer, String, Temporal, List, Map, null, Boolean)
- No dependencies to external libraries
- Supports variables and variable-containers
- Standard boolean and mathematical operators
- Custom functions can be added at runtime
- Functions can be defined with a variable number of arguments
- A rich set of basic mathematical and boolean functions
- A rich set of functions for array-, object-, string- and timestamp-manipulation
- Crypto- and statistic-functions
- Caching of expressions
- Allows variable-aliases (WITH)
- User can decide, which functions should be enabled by default
- No direct access of java-objects

### Quick start

```java
//as one-liner
public static void test1() {
  System.out.println(ExpressionParser.parse("1+2+3").eval()); //6
}

//or with custom variables
public static void test2() {
  Expression expr = ExpressionParser.parse("3*a");
  expr.setVariable("a", Value.create(5));
  Value result = expr.eval();

  System.out.println(result); // 15
}

//or with all possible functions set
public static void test3() {
  var ctx = new DefaultExecutorContext();
  Expression expr = ExpressionParser.parse("arraycount([1,2,'test'])", ctx);
  Value result = expr.eval();

  System.out.println(result); //3
}

```

### TODO
- Documentation
- More testing

### Author
2021-2025 Weinzierl Stefan

### License
Apache V2.0

### Changelog
#### Version 1.2.1
- Optimized performance of ArrayUnion-Function
- Function names are no longer casesensitive 
- Removed function coalesce(), it was the same as ifnull()
- Fixed tests for object-functions
- ArraySlice doesn't throw an error if the range doesn't fit
- RPad & LPad failed, when longer padding-strings has been used

#### Version 1.2.0
- Added Lambda-Functions

#### Version 1.1.0
- Refactoring of the ExecutorContext. Now functions must not be know at parsing-time.

#### Version 1.0.1
- Introduced ExecutorStats

#### Version 1.0
- Initial release
