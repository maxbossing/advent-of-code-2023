# Advent of Code 

This is a template for Advent Of Code in idiomatic Kotlin

# Usage
1. Click `Use Template` to create your own repository
2. Put the test input for the days in `input/Day<day with 0 added if < 10>_test.txt`
3. Put the real input for the days in `input/Day<day with 0 added if < 10>.txt
4. Create for each day it's own file Named `Day<day with 0 added if < 10>.kt`
5. In this file, create a main function and execute the `aocDay` function
```kotlin
fun main() = aocDay(1 /* The Day */) {
    part1test = 1234 // The part 1 result for the test input 
    part2test = 1234 // The part 2 result for the test input
    
    // Here goes your code for part 1
    part1 {
        
    }
    
    // Here goes your code for part 2
    part2 {
        
    }
    
}
```

You have access to multiple variables regarding the input:
* `inputString` The raw Input
* `inputLines` The Input splitted by line
* `inputInts` The Input splitted by line as Integers

Now just run the main function and it will test the code against Test input and then against real input.

# License

This repository is licensed under GPL v3