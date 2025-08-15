# Switch Statement with Unnamed Patterns

This example demonstrates how to use unnamed patterns in a switch statement, a feature introduced in Java 21 (preview, may require Java 22 for full support).

## Overview

Unnamed patterns allow you to match a type in a switch statement without binding the value to a variable. This is useful when you only care about the type, not the value itself.

## Code Example

```java
Object obj = 42;

String result = switch (obj) {
    case String _ -> "It's a string!";
    case Integer _ -> "It's an integer!";
    case null, default -> "Unknown type or null";
};

System.out.println(result);
```

## Running the Example

Compile and run with preview features enabled (Java 21+):

```bash
javac --enable-preview --release 21 02_SwitchUnnamedPattern.java
java --enable-preview SwitchUnnamedPattern
```

> **Note:** If you see an error about unnamed variables not being supported in -source 21, try using Java 22 or later.

## Expected Output

```
It's an integer!
```

## Notes

- Unnamed patterns make switch statements more concise when you only care about the type.
- The `_` variable cannot be used in the case body; it's just a placeholder.
- This feature improves code readability and reduces unnecessary variable declarations. 