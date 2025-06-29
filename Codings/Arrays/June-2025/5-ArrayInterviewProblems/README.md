# Array Interview Problems Tutorial

## Overview
This tutorial covers classic array interview problems in Java, including missing number, finding duplicates, maximum subarray sum, moving zeros, and finding pairs with a given sum.

## What You'll Learn
- How to find the missing number in a sequence
- How to detect duplicates in an array
- How to find the maximum subarray sum (Kadane's Algorithm)
- How to move all zeros to the end of an array
- How to find a pair with a given sum

## Key Concepts & Code Examples

### 1. Find the Missing Number
Find the missing number in an array containing numbers from 1 to n:
```java
public static int findMissingNumber(int[] arr, int n) {
    int total = n * (n + 1) / 2;
    int sum = 0;
    for (int num : arr) sum += num;
    return total - sum;
}
```

### 2. Find Duplicates
Print all duplicate elements:
```java
public static void printDuplicates(int[] arr) {
    HashSet<Integer> seen = new HashSet<>();
    HashSet<Integer> printed = new HashSet<>();
    for (int num : arr) {
        if (!seen.add(num) && !printed.contains(num)) {
            System.out.print(num + " ");
            printed.add(num);
        }
    }
    System.out.println();
}
```

### 3. Maximum Subarray Sum (Kadane's Algorithm)
Find the contiguous subarray with the largest sum:
```java
public static int maxSubArraySum(int[] arr) {
    int maxSoFar = arr[0], maxEndingHere = arr[0];
    for (int i = 1; i < arr.length; i++) {
        maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
        maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
}
```

### 4. Move Zeros to End
Move all zeros to the end of the array:
```java
public static void moveZerosToEnd(int[] arr) {
    int n = arr.length, count = 0;
    for (int i = 0; i < n; i++) {
        if (arr[i] != 0) arr[count++] = arr[i];
    }
    while (count < n) arr[count++] = 0;
}
```

### 5. Find Pair with Given Sum
Find a pair of numbers that add up to a given sum:
```java
public static int[] findPairWithSum(int[] arr, int sum) {
    HashSet<Integer> set = new HashSet<>();
    for (int num : arr) {
        if (set.contains(sum - num)) {
            return new int[]{num, sum - num};
        }
        set.add(num);
    }
    return new int[]{};
}
```

## Running the Program
1. Compile:
   ```bash
   javac ArrayInterviewProblems.java
   ```
2. Run:
   ```bash
   java ArrayInterviewProblems
   ```

## Practice Exercises
- Find the minimum and maximum in an array
- Find the longest consecutive sequence
- Find all pairs with a given difference

## Additional Resources
- [LeetCode Array Problems](https://leetcode.com/tag/array/)
- [Java Arrays Documentation](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html) 