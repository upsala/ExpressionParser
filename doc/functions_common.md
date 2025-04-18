## Common-Functions
- [Between](#Between): Is x between low and high?                                                          
- [Bound](#Bound): Returns low if x<low, or returns high if x>high else return x                        
- [Count](#Count): Returns the length of x                                                         
- [IfNull](#IfNull): Returns the first value which is not null, if all values are null, null is returned 
- [IsArray](#IsArray): Is X a array?                                                                       
- [IsEmpty](#IsEmpty): Is x empty?                                                                         
- [IsNull](#IsNull): Is X = NULL?                                                                        
- [IsNumber](#IsNumber): Is X a number?                                                                      
- [IsObject](#IsObject): Is X a object? 
- [IsString](#IsString): Is X a string?                                                                      
- [IsTemporal](#IsTemporal): Is X a temporal? 
- [Max](#Max): Returns the biggest value                                                           
- [Min](#Min): Returns the smallest value                                                          
- [Type](#Type): Returns the type of x 
- [VarExists](#VarExists): Checks if variables exist


### Between
    Syntax: Between(low, x, high)
Is x between low and high?                                                          

    Between(1, 3, 5) => true
    Between(1, 10, 5) => false
    Between(1, 0, 5) => false

### Bound
    Syntax: Bound(low, x, high) 
Returns low if x<low, or returns high if x>high else return x                       

    Bound(1, 3, 5) => 3
    Bound(1, 10, 5) => 5
    Bound(1, 0, 5) => 1

### Count
    Syntax: Count(x) 
Returns the length of x                                                         

    Count([]) => 0
    Count([1,2,3]) => 3
    Count("test") => 4
    Count({1:2}) => 1

### IfNull
    Syntax: IfNull(x, ...) 
Returns the first non-null value or null if every value is null (or no parameters are given)

    IfNull(null, 1, 2, 3) => 1
    IfNull() => null
    IfNull(null) => null

### IsArray
    Syntax: IsArray(x) 
Is X a array?               

    IsArray([]) => true
    IsArray("") => false

### IsEmpty
    Syntax: IsEmpty(x) 
Is x empty?                                                                         

    IsEmpty([]) => true
    IsEmpty("") => true
    IsEmpty({}) => true
    IsEmpty("test") => false

### IsNull
    Syntax: IsNull(x) 
Is X = NULL?                                

    IsNull(true) => false
    IsNull(NULL) => true
    IsNull("Test") => false

### IsNumber
    Syntax: IsNumber(x) 
Is X a number?                                                                      

    IsNumber(123) => true
    IsNumber(123.45) => true
    IsNumber("123") => false
    IsNumber(null) => false

### IsObject
    Syntax: IsObject(x) 
Is X a object? 

    IsObject({}) => true
    IsObject({1:2}) => true
    IsObject([]) => false
    IsObject("test") => false

### IsString
    Syntax: IsString(x) 
Is X a string?                                                                      

    IsString("test") => true
    IsString(123) => false

### IsTemporal
    Syntax: IsTemporal(x) 
Is X a temporal? Checks if the value is a date, time, or datetime object.

    IsTemporal(Now()) => true
    IsTemporal("2023-01-01") => false
    IsTemporal(123) => false

### Max
    Syntax: Max(x, ...) 
Returns the biggest value                   

    Max(1,2,3) => 3
    Max("A","B") => "B"

### Min
    Syntax: Min(x, ...) 
Returns the smallest value                                                          

    Min(1,2,3) => 1
    Min("A","B") => "A"

### Type
    Syntax: Type(x) 
Returns the type of x as a string

    Type("test") => "string"
    Type(123) => "number"
    Type(123.45) => "number"
    Type(true) => "boolean"
    Type([1,2,3]) => "array"
    Type({a:1, b:2}) => "object"
    Type(null) => "null"
    Type(Now()) => "temporal"

### VarExists
    Syntax: VarExists(x, ...) 
Returns true if all variables in the list exist in the current context. This is useful for checking if variables are defined before using them.

    VarExists("a") => true (if variable 'a' exists)
    VarExists("a", "b") => true (if both variables 'a' and 'b' exist)
    VarExists("nonexistent") => false
