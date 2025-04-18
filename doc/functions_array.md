## Array-Functions

- [Array](#Array): Builds an array
- [ArrayCall](#ArrayCall): Calls a lambda with an array
- [ArrayConcat](#ArrayConcat): Concats arrays
- [ArrayDiff](#ArrayDiff): Returns the difference between arrays
- [ArrayDistinct](#ARRAYDISITNCT): Returns an array, with unique values
- [ArrayFlat](#ArrayFlat): Flattens an array
- [ArrayFilter](#ArrayFilter): Filters elements of an array
- [ArrayFind](#ArrayFind): Finds a element in an array
- [ArrayFindLast](#ArrayFindLast): Finds the last element in an array
- [ArrayGet](#ArrayGet): Returns an element of an array
- [ArrayIncludes](#ArrayIncludes): Is an element included in an array
- [ArrayIndexOf](#ArrayIndexOf): Returns the index of an array-element
- [ArrayInsert](#ArrayInsert): Insert a element in a array
- [ArrayIntersect](#ArrayIntersect): Returns the intersection of arrays
- [ArrayJoin](#ArrayJoin): Returns a string with all values of an array
- [ArrayLastIndexOf](#ArrayLastIndexOf): Returns the last position of an element in an array
- [ArrayMap](#ArrayMap): Applies a function to each element of an array
- [ArrayReduce](#ArrayReduce): Reduces an array to a single value
- [ARRAYREPLACE](#ARRAYREPLACE): Replaces values in an array
- [ArrayReverse](#ArrayReverse): Reverses the order of elements in an array
- [ArrayRotate](#ArrayRotate): Rotates elements in an array
- [ArraySample](#ArraySample): Returns a random sample from an array
- [ArraySet](#ArraySet): Sets a value at a specific position in an array
- [ArrayShuffle](#ArrayShuffle): Randomly shuffles elements in an array
- [ArraySlice](#ArraySlice): Returns a portion of an array
- [ArraySort](#ArraySort): Sorts the elements of an array
- [ArraySwap](#ArraySwap): Swaps two elements in an array
- [ArrayUnion](#ArrayUnion): Returns common elements from arrays

### Array 
    Syntax: Array(...)
Build an array, with the provided values (it is an alias for the built-in array-constructor)

    Array() => []
    Array(1,2,3) => [1,2,3]

### ArrayCall
    Syntax: ArrayCall(arr, lambda)
Calls a lambda function with the values of the array

    ArrayCall([1,2,3], (a,b,c)->a+b+c) => 6

The first parameter 'a' of the lambda is set with the first value of the array, the second parameter 'b' is set with the second value and so on.

### ArrayConcat 
    Syntax: ArrayConcat(arr, ...)
Concat all given arrays to one array

    ArrayConcat([1,2,3], [4,5,6]) => [1,2,3,4,5,6]
    ArrayConcat([1,2], 4, 5, 6) => [1,2,3,4,5,6]

### ArrayDiff
    Syntax: ArrayDiff(arr1, arr2)
Returns a array, with all elements from `arr1` which are not in `arr2`.

    ArrayDiff([1,2,3,4,5], [2,4,6]) => [1,3,5]

### ArrayDistinct
    Syntax: ArrayDistinct(arr)
Returns an array, where all values are unique

    ArrayDistinct([1,1,2,3,3,3]) => [1,2,3]

### ArrayFlat
    Syntax: ArrayFlat(arr)
Flattens a nested array structure into a single-level array. All elements from nested arrays are extracted and combined into a single array.

    ArrayFlat([[1,2],[3,4],[[5,6]]) => [1,2,3,4,5,6]

### ArrayFilter
    Syntax: ArrayFilter(arr, lambda)
Filters elements of an array using a lambda function

    ArrayFilter([1,2,3,4,5], (x)->x<3) => [1,2]

### ArrayFind
    Syntax: ArrayFind(arr, lambda)
Returns the first element, where the given lambda function returns true

    ArrayFind([1,2,3,4,5], (x)->x>3) => 4

### ArrayFindLast
    Syntax: ArrayFindLast(arr, lambda)
Returns the last element, where the given lambda function returns true

    ArrayFind([1,2,3,4,5], (x)->x>3) => 5

### ArrayGet
    Syntax: ArrayGet(arr, pos)
Returns the pos-element of the given array. E.g. the same as arr[pos]

    ArrayGet([1,2,3,4,5], 2) => 3

### ArrayIncludes
    Syntax: ArrayIncludes(arr, x)
Is x included in arr?

    ArrayIncludes([1,2,3,4,5], 3) => true

### ArrayIndexOf
    Syntax: ArrayIndexOf(arr, x)
Returns the position of 'x' in the array 'arr' or -1 if 'x' is not found.

    ArrayIndexOf([1,2,3,4,5], 3) => 2

### ArrayInsert
    Syntax: ArrayInsert(arr, x, y)
Insert element y at position x in the array

    ArrayInsert([1,2,3,4,5], 2, 6) => [1,2,6,3,4,5]

### ArrayIntersect
    Syntax: ArrayIntersect(arr, ...)
Returns an array with the common values of all given arrays

    ArrayIntersect([1,2,3],[3,4,5]) => [3]

### ArrayJoin
    Syntax: ArrayJoin(arr, <sep>)
Creates a string from arr, where all values are concenated with a optional separator

    ArrayJoin([1,2,3]) => 123
    ArrayJoin([1,2,3], ';') => 1;2;3

### ArrayLastIndexOf
    Syntax: ArrayLastIndexOf(arr, x)
Returns the position of the last x in arr

    ArrayLastIndexOf([1,1,2,2], 2) => 3

### ArrayMap
    Syntax: ArrayMap(arr, lambda)
Applies the lambda to the elements of the given arrays

    ArrayMap([1,2,3,4], (x)->x*2) => [2,4,6,8]
    ArrayMap([1,2,3,4], (v, p)->p) => [0,1,2,3]

### ArrayReduce
    Syntax: ArrayReduce(arr, lambda, <x>)
Iteratively reduce the array to a single value using a lambda function. The function applies the lambda to each element of the array, accumulating a result.

    ArrayReduce([1,2,3,4], (carry,value)->carry+value, 0) => 10
    ArrayReduce([1,2,3,4], (carry,value,index)->carry+value*index, 0) => 20

The lambda function receives the following parameters:
1. The current accumulated value (carry)
2. The current element from the array
3. The index of the current element
4. The original array

### ARRAYREPLACE
    Syntax: ARRAYREPLACE(arr, x, y, <limit>)
Replaces all occurences of 'x' with 'y' until the optional limit. Returns a new array with the replacements.

    ARRAYREPLACE([1,2,3,1,2], 1, 9) => [9,2,3,9,2]
    ARRAYREPLACE([1,2,3,1,2], 1, 9, 1) => [9,2,3,1,2]

### ArrayReverse
    Syntax: ArrayReverse(arr)
Reverses the array. First element will get last and so on.

    ArrayReverse([1,2,3,4]) => [4,3,2,1]

### ArrayRotate
    Syntax: ArrayRotate(arr, x)
Rotates the array by the given distance.

    ArrayRotate([1,2,3,4], 1) => [2,3,4,1]
    ArrayRotate([1,2,3,4], -1) => [4,1,2,3]

### ArraySample
    Syntax: ArraySample(arr, qty)
Returns a sample of the given array. The order of the elements is preserved. If qty is greater than the amount of elements 
in the array, the whole array is returned. Repeated calls of the function with the same parameters does not give the 
same result.

    ArraySample([1,2,3,4], 2) => [1,4]
    ArraySample([1,2,3,4], 10) => [1,2,3,4]

### ArraySet
    Syntax: ArraySet(arr, x, y)
Sets the value 'y' at position 'x' in the array.

    ArraySet([1,2,3,4], 2, 10) => [1,2,10,4]

### ArrayShuffle
    Syntax: ArrayShuffle(arr)
Shuffles the array. Multiple calls with the same parameter doesn't give the same result.

    ArrayShuffle([1,2,3,4]) => [4,2,3,1]
    ArrayShuffle([1,2,3,4]) => [1,4,3,2]

### ArraySlice
    Syntax: ArraySlice(arr, pos1, pos2)
Returns a slice of the given array with elements from pos1 to pos2 (inclusive), which can also by done by arr[pos1:pos2]. If pos2 < pos1, the elements are returned in reverse order.

    ArraySlice([1,2,3,4,5], 1, 3) => [2,3,4]
    ArraySlice([1,2,3,4,5], 3, 1) => [4,3,2]

Indices are clamped to the array bounds. Out-of-bounds indices will not cause an error.



### ArraySort
    Syntax: ArraySort(arr)
Sorts the array

    ArraySort([4,2,3,1]) => [1,2,3,4]

### ArraySwap
    Syntax: ArraySwap(arr, x, y)
Swaps the values of the keys x and y

    ArraySwap(['A', 'B', 'C', 'D'], 1, 3) => ['A', 'D', C', 'B']

### ArrayUnion
    Syntax: ArrayUnion(arr, ...)
Returns all elements from the array, which are also included in the following arrays

    ArrayUnion([1,2,3,4,5], [3,5,6,7]) => [3, 5]
