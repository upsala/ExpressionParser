## Statistics-Functions
- [Cp](#Cp): Calculates the process capability index 
- [CpK](#CpK): Calculates the process capability index 
- [Kurtosis](#Kurtosis): Calculates the kurtosis of the givven array 
- [Mean](#Mean): Calculates the arithmetic mean of the given array 
- [Mode](#Mode): Calculates the mode of the given array 
- [Percentile](#Percentile): Calculates the percentile of the given array 
- [Range](#Range): Returns the difference of the max and the min value in the array 
- [Skewness](#Skewness): Calculates the skewness of the given array 
- [Std](#Std): Calculates the standard deviation of the given array 
- [Sum](#Sum): Returns the summary of all values, nulls are ignored 
- [Var](#Var): Calculates the variance of the given array 

### Cp
    Sync: Cp(lsl, usl, arr) 
Calculates the process capability index 

    Cp(1, 3, [1, 2, 3]) => 0.40825

### CpK
    Sync: CpK(lsl, usl, arr) 
Calculates the process capability index 

    CpK(1, 3, [1, 2, 3]) => 0.40825

### Kurtosis
    Sync: Kurtosis(arr) 
Calculates the kurtosis of the givven array 

    Kurtosis([1, 1, 2, 2, 3, 3]) => 9

### Mean
    Sync: Mean(arr) 
Calculates the arithmetic mean of the given array 

    Mean([1, 2, 3]) => 2
    Mean([1]) => 1

### Mode
    Sync: Mode(arr) 
Calculates the mode of the given array 

    Mode([1, 2, 3, 3]) => 3
    Mode([1]) => 1

### Percentile
    Sync: Percentile(arr, pct) 
Calculates the percentile of the given array 

    Percentile([9, 12, 28, 55, 63, 82, 91, 92, 96, 97], 0) => 9
    Percentile([9, 12, 28, 55, 63, 82, 91, 92, 96, 97], 0.25) => 20
    Percentile([9, 12, 28, 55, 63, 82, 91, 92, 96, 97], 0.5) => 72.5
    Percentile([9, 12, 28, 55, 63, 82, 91, 92, 96, 97], 0.75) => 91.5
    Percentile([9, 12, 28, 55, 63, 82, 91, 92, 96, 97], 1) => 97

### Range
    Sync: Range(arr) 
Returns the difference of the max and the min value in the array 

    Range([1,2,3]) => 2

### Skewness
    Sync: Skewness(arr) 
Calculates the skewness of the given array 

    Skewness([1, 2, 3, 4, 5, 100]) => 1.97353

### Std
    Sync: Std(arr) 
Calculates the standard deviation of the given array 

    Std([1, 2, 3]) => 0.8165

### Sum
    Sync: Sum(arr) 
Returns the summary of all values, nulls are ignored 

    Sum([1,2,3]) => 6

### Var
    Sync: Var(arr) 
Calculates the variance of the given array 

    Var([1, 2, 3]) => 0.66667
