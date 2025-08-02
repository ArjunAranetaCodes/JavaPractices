# Array Basics Tutorial

## Overview
This tutorial covers the fundamental concepts and operations of arrays in Java. Arrays are one of the most important data structures that store multiple values of the same type in contiguous memory locations.

## What You'll Learn
- Array declaration and initialization
- Accessing array elements
- Array iteration techniques
- Common array operations (sum, average, min, max)
- Array copying methods
- Sorting and searching
- Multi-dimensional arrays
- Useful array utility methods

## Key Concepts

### 1. Array Declaration and Initialization
Arrays can be declared and initialized in several ways:

```java
// Method 1: Declare and initialize in one line
int[] numbers = {10, 20, 30, 40, 50};

// Method 2: Declare first, then initialize
int[] scores = new int[5];
scores[0] = 85;
scores[1] = 92;

// Method 3: Using array literal with new
String[] fruits = new String[]{"Apple", "Banana", "Orange"};
```

### 2. Array Properties
- **Fixed Size**: Once created, array size cannot be changed
- **Zero-based Indexing**: First element is at index 0
- **Contiguous Memory**: Elements are stored in adjacent memory locations
- **Type Safety**: All elements must be of the same type

### 3. Accessing Elements
```java
int firstElement = numbers[0];           // First element
int lastElement = numbers[numbers.length - 1];  // Last element
int middleElement = numbers[numbers.length / 2]; // Middle element
```

### 4. Array Length
```java
int length = numbers.length;  // Get array size
```

### 5. Iteration Techniques

#### Traditional For Loop
```java
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

#### Enhanced For Loop (For-Each)
```java
for (int number : numbers) {
    System.out.println(number);
}
```

#### Stream API
```java
java.util.Arrays.stream(numbers).forEach(System.out::println);
```

### 6. Common Operations

#### Sum and Average
```java
int sum = 0;
for (int score : scores) {
    sum += score;
}
double average = (double) sum / scores.length;
```

#### Find Maximum and Minimum
```java
int max = scores[0];
int min = scores[0];
for (int i = 1; i < scores.length; i++) {
    if (scores[i] > max) max = scores[i];
    if (scores[i] < min) min = scores[i];
}
```

### 7. Array Copying Methods

#### System.arraycopy()
```java
int[] original = {1, 2, 3, 4, 5};
int[] copy = new int[original.length];
System.arraycopy(original, 0, copy, 0, original.length);
```

#### Arrays.copyOf()
```java
int[] copy = java.util.Arrays.copyOf(original, original.length);
```

#### Clone Method
```java
int[] copy = original.clone();
```

### 8. Sorting and Searching

#### Sorting
```java
java.util.Arrays.sort(numbers);  // Sorts in ascending order
```

#### Binary Search (requires sorted array)
```java
int index = java.util.Arrays.binarySearch(numbers, 25);
```

#### Linear Search
```java
public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;
        }
    }
    return -1;
}
```

### 9. Multi-dimensional Arrays
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// Accessing elements
int element = matrix[1][2];  // Gets 6
```

### 10. Useful Array Methods

#### Arrays.toString()
```java
System.out.println(java.util.Arrays.toString(numbers));
```

#### Arrays.fill()
```java
java.util.Arrays.fill(numbers, 0);  // Fills array with 0
```

#### Arrays.equals()
```java
boolean areEqual = java.util.Arrays.equals(array1, array2);
```

## Running the Program
1. Compile the Java file:
   ```bash
   javac ArrayBasics.java
   ```

2. Run the program:
   ```bash
   java ArrayBasics
   ```

## Expected Output
The program will demonstrate all the concepts above with detailed output showing:
- Different ways to create arrays
- Element access examples
- Iteration methods
- Mathematical operations
- Copying techniques
- Sorting and searching
- Multi-dimensional array operations

## Common Pitfalls to Avoid
1. **ArrayIndexOutOfBoundsException**: Always check array bounds
2. **NullPointerException**: Ensure array is initialized before use
3. **Type Mismatch**: All elements must be of the same type
4. **Fixed Size**: Remember arrays cannot be resized after creation

## Practice Exercises
1. Create an array of 10 random numbers and find the second largest
2. Reverse an array without using additional space
3. Find the frequency of each element in an array
4. Merge two sorted arrays into a single sorted array
5. Find the missing number in an array of 1 to n

## Next Steps
After mastering array basics, explore:
- ArrayList (dynamic arrays)
- Collections Framework
- Stream API for advanced operations
- Array algorithms (sorting, searching)
- Multi-dimensional array applications

## Additional Resources
- [Java Arrays Documentation](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)
- [Arrays Utility Class](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Arrays.html)
- [Java Collections Framework](https://docs.oracle.com/javase/tutorial/collections/) 