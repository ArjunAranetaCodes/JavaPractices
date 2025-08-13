# Basic Unnamed Variable Example

This example demonstrates the use of unnamed variables in pattern matching, a feature introduced in Java 21 (preview, requires --enable-preview and may require Java 22 for full support).

## Overview

Unnamed variables (written as `_`) allow you to match a value without binding it to a variable name. This is useful when you only care about the type, not the value itself.

## Code Example

```java
Object obj = "Hello, Java 21!";

if (obj instanceof String _) {
    System.out.println("It's a string, but we don't care about the value!");
}
```

## Running the Example

Compile and run with preview features enabled (Java 21+):

```bash
javac --enable-preview --release 21 01_BasicUnnamedVariable.java
java --enable-preview BasicUnnamedVariable
```

> **Note:** If you see an error about unnamed variables not being supported in -source 21, try using Java 22 or later.

## Expected Output

```
It's a string, but we don't care about the value!
```

## Notes

- Unnamed variables are useful for pattern matching when you don't need the matched value.
- This feature helps make code more concise and readable.
- The `_` variable cannot be used in the code block; it's just a placeholder. 