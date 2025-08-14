# Record Pattern Matching with Unnamed Variables

This example demonstrates how to use unnamed variables in record pattern matching, a feature introduced in Java 21 (preview, may require Java 22 for full support).

## Overview

Unnamed variables allow you to destructure a record and ignore fields you don't care about. This is useful for focusing only on relevant data.

## Code Example

```java
record Point(int x, int y) {}

Point p = new Point(10, 20);

if (p instanceof Point(int x, _)) {
    System.out.println("x = " + x);
}
```

## Running the Example

Compile and run with preview features enabled (Java 21+):

```bash
javac --enable-preview --release 21 03_RecordPatternUnnamed.java
java --enable-preview RecordPatternUnnamed
```

> **Note:** If you see an error about unnamed variables not being supported in -source 21, try using Java 22 or later.

## Expected Output

```
x = 10
```

## Notes

- Unnamed variables make record pattern matching more concise when you only care about some fields.
- The `_` variable cannot be used in the code block; it's just a placeholder.
- This feature improves code readability and reduces unnecessary variable declarations. 