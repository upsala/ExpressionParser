## Object-Functions
- [Object](#Object): Creates a object with x as key and y as
- [ObjectFilter](#ObjectFilter):
- [ObjectFind](#ObjectFind):
- [ObjectFlip](#ObjectFlip):  
- [ObjectKeys](#ObjectKeys):
- [ObjectMap](#ObjectMap):
- [ObjectMerge](#ObjectMerge):
- [ObjectReduce](#ObjectReduce):
- [ObjectRemoveKeys](#ObjectRemoveKeys):
- [ObjectSet](#ObjectSet):
- [ObjectValues](#ObjectValues):

### Object
    Syntax: Object(x, y, ...)   
Creates an object with x as key and y as

    Object(1, 2) => {1:2}
    Object(1, 2, 3, 4) => {1:2,3:4}

### ObjectFilter
    Syntax: Object(obj, lambda)
Filters a object with a lambda-function. The parameters for the lambda-function are value, key, object.

    ObjectFilter({1:2,3:4}, (k)->k==1 => {1:2}
    ObjectFilter({1:2,3:4}, (k,v)->v==4 => {3:4}

### ObjectFind
    Syntax: ObjectFind(obj, lambda)


### ObjectFlip
    Syntax: ObjectFlip(obj)       
Returns an object in flip order, i.e. keys become values and values become keys. If a value has several occurrences, the latest key will be used as its value, and all others will be lost.

    ObjectFlip({1:2,3:4}) => {2:1,4:3}

### ObjectKeys
    Syntax: ObjectKeys(obj)       
Returns the keys of an object as an array. The order of the keys is not specified.

    ObjectKeys({1:2,3:4}) => [1,3]

### ObjectMap
    Syntax: ObjectMap(obj, lambda)
Maps the values of an object to other values. 

### ObjectMerge
    Syntax: ObjectMerge(obj, ...)      

    ObjectMerge({1:2}, {3:4}) => {1:2,3:4}

### ObjectReduce
    Syntax: ObjectReduce(obj, lambda, initial)
Reduces a object to a single value using a lambda function and a initial value. The parameters for the lambda-function are value, key, object.

    ObjectReduce(

### ObjectRemoveKeys
    Syntax: ObjectRemoveKeys(obj, key, ...) 
Removes the specified keys from an object.

    ObjectRemoveKeys({1:2,3:4,5:6}, 3) => {1:2,5:6}
    ObjectRemoveKeys({1:2,3:4,5:6}, 3, 1, 4) => {5:6}

### ObjectRemoveValues
    Syntax: ObjectRemoveValues(obj, value, ...) 
Remove the specified values from an object. If a value exists multiple times, it is also removed multiple times.

    ObjectRemoveKeys({1:2,3:4,5:6}, 4) => {1:2,5:6}
    ObjectRemoveKeys({1:2,3:4,5:4}, 4) => {1:2}
    ObjectRemoveKeys({1:2,3:4,5:4}, 4, 2, 1) => {}

### ObjectSet
    Syntax: ObjectSet(obj, k, v)  
Adds a key-value-pair to an object. An existing key will be overwritten. If you want to add multiple key-values at one time you can use ObjectMerge(obj, {k1:v1, k2:v2, ...})

    ObjectSet({1:2}, 3, 4) => {1:2,3:4}

### ObjectValues
    Syntax: ObjectValues(obj)     
Returns the values of an object as array. The order of the values is not specified.

    ObjectValues({1:2,3:4}) => [2,4]
