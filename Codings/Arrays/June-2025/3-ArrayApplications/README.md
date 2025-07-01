# Array Applications Tutorial

## Overview
This tutorial demonstrates practical array operations in Java, including frequency counting, reversing, merging, filtering, and finding unique elements.

## What You'll Learn
- How to count the frequency of elements in an array
- How to reverse an array in place
- How to merge two sorted arrays
- How to filter out even numbers
- How to find and print unique elements

## Key Concepts & Code Examples

### 1. Frequency Count
Count how many times each element appears in an array using a HashMap:
```java
HashMap<Integer, Integer> freqMap = new HashMap<>();
for (int num : arr) {
    freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
}
```

### 2. Reverse an Array
Reverse an array in place by swapping elements from both ends:
```java
public static void reverse(int[] arr) {
    int left = 0, right = arr.length - 1;
    while (left < right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
    }
}
```

### 3. Merge Two Sorted Arrays
Merge two sorted arrays into a single sorted array:
```java
public static int[] mergeSortedArrays(int[] a, int[] b) {
    int[] result = new int[a.length + b.length];
    int i = 0, j = 0, k = 0;
    while (i < a.length && j < b.length) {
        if (a[i] < b[j]) {
            result[k++] = a[i++];
        } else {
            result[k++] = b[j++];
        }
    }
    while (i < a.length) result[k++] = a[i++];
    while (j < b.length) result[k++] = b[j++];
    return result;
}
```

### 4. Remove Even Numbers
Filter out even numbers using streams:
```java
int[] odds = Arrays.stream(arr).filter(x -> x % 2 != 0).toArray();
```

### 5. Find Unique Elements
Print elements that appear only once:
```java
public static void printUniqueElements(int[] arr) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);
    for (int key : map.keySet()) {
        if (map.get(key) == 1) System.out.print(key + " ");
    }
    System.out.println();
}
```

## Running the Program
1. Compile:
   ```bash
   javac ArrayApplications.java
   ```
2. Run:
   ```bash
   java ArrayApplications
   ```

## Practice Exercises
- Find the intersection of two arrays
- Rotate an array by k positions
- Find the most frequent element

## Additional Resources
- [Java Arrays Documentation](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html) 