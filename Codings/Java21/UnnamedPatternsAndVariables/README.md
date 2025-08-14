# Unnamed Patterns and Variables in Java 21+

This directory contains examples and tutorials demonstrating the Unnamed Patterns and Variables feature introduced as a preview in Java 21 (and enhanced in Java 22).

## What are Unnamed Patterns and Variables?

Unnamed patterns and variables allow you to match types or destructure objects without binding the matched value to a variable name. This is useful when you only care about the structure or type, not the actual value. The underscore (`_`) is used as a placeholder for these cases.

**Key benefits:**
- Cleaner, more concise code
- Improved readability
- Avoids unnecessary variable declarations

> **Note:** Full support for unnamed variables and patterns may require Java 22 or later. If you encounter errors about `unnamed variables are not supported in -source 21`, try using Java 22+.

## Example Programs

Each example comes with a detailed tutorial README.

1. **01_BasicUnnamedVariable.java**  
   Basic use of unnamed variables in pattern matching.  
   [Tutorial](./01_BasicUnnamedVariable.md)

2. **02_SwitchUnnamedPattern.java**  
   Using unnamed patterns in switch statements.  
   [Tutorial](./02_SwitchUnnamedPattern.md)

3. **03_RecordPatternUnnamed.java**  
   Unnamed variables in record pattern matching.  
   [Tutorial](./03_RecordPatternUnnamed.md)

4. **04_NestedUnnamedPattern.java**  
   Unnamed variables in nested patterns (e.g., nested records).  
   [Tutorial](./04_NestedUnnamedPattern.md)

5. **05_UnnamedInForAndLambda.java**  
   Unnamed variables in enhanced for-loops and lambda parameters.  
   [Tutorial](./05_UnnamedInForAndLambda.md)

## How to Run

Compile and run with preview features enabled (Java 21+):

```bash
javac --enable-preview --release 21 ExampleFile.java
java --enable-preview ExampleFile
```

If you see errors about unnamed variables not being supported, use Java 22 or later:

```bash
javac --enable-preview --release 22 ExampleFile.java
java --enable-preview ExampleFile
```

## References
- [JEP 443: Unnamed Patterns and Variables (Preview)](https://openjdk.org/jeps/443)
- [Java 21 Release Notes](https://www.oracle.com/java/technologies/javase/21-relnote-issues.html)
- [Java 22 Release Notes](https://www.oracle.com/java/technologies/javase/22-relnote-issues.html)

---

Feel free to explore each example and its tutorial for a hands-on understanding of this modern Java feature! 