# Unnamed Variables in For-Loops and Lambdas

This example demonstrates how to use unnamed variables in enhanced for-loops and lambda parameters, a feature introduced in Java 21 (preview, may require Java 22 for full support).

## Overview

Unnamed variables allow you to ignore loop or lambda parameters you don't care about, making your code more concise and readable.

## Code Example

```java
List<String> names = List.of("Alice", "Bob", "Charlie");

// Using unnamed variable in enhanced for-loop (Java 22+)
for (String _ : names) {
    System.out.println("Element found!");
}

// Using unnamed variable in lambda (Java 22+)
names.forEach(_ -> System.out.println("Processing element!"));
```

## Running the Example

Compile and run with preview features enabled (Java 21+):

```bash
javac --enable-preview --release 21 05_UnnamedInForAndLambda.java
java --enable-preview UnnamedInForAndLambda
```

> **Note:** If you see an error about unnamed variables not being supported in -source 21, try using Java 22 or later.

## Expected Output

```
Element found!
Element found!
Element found!
Processing element!
Processing element!
Processing element!
```

## Notes

- Unnamed variables in for-loops and lambdas are especially useful when you only care about the side effect, not the value.
- This feature helps reduce unnecessary variable names and improves code clarity.
- The `_` variable cannot be used in the loop or lambda body; it's just a placeholder. 