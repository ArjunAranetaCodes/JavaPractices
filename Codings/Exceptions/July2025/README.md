# Java Exception Handling Tutorial

## Overview

This tutorial covers comprehensive exception handling in Java, including different types of exceptions, best practices, and real-world examples. Exception handling is crucial for writing robust, production-ready Java applications.

## Table of Contents

1. [What are Exceptions?](#what-are-exceptions)
2. [Types of Exceptions](#types-of-exceptions)
3. [Exception Handling Keywords](#exception-handling-keywords)
4. [Try-Catch Blocks](#try-catch-blocks)
5. [Finally Block](#finally-block)
6. [Try-with-Resources](#try-with-resources)
7. [Custom Exceptions](#custom-exceptions)
8. [Exception Propagation](#exception-propagation)
9. [Best Practices](#best-practices)
10. [Common Mistakes](#common-mistakes)
11. [Performance Considerations](#performance-considerations)
12. [Real-World Examples](#real-world-examples)

## What are Exceptions?

An exception is an event that occurs during the execution of a program that disrupts the normal flow of instructions. In Java, exceptions are objects that represent errors or exceptional conditions.

### Exception Hierarchy

```
Throwable
├── Error (Unchecked)
│   ├── OutOfMemoryError
│   ├── StackOverflowError
│   └── ...
└── Exception (Checked)
    ├── IOException
    ├── SQLException
    ├── RuntimeException (Unchecked)
    │   ├── NullPointerException
    │   ├── ArrayIndexOutOfBoundsException
    │   ├── IllegalArgumentException
    │   └── ...
    └── ...
```

## Types of Exceptions

### 1. Checked Exceptions (Compile-time Exceptions)

- Must be handled at compile time
- Extend `Exception` but not `RuntimeException`
- Examples: `IOException`, `SQLException`, `ClassNotFoundException`

```java
// Must be handled or declared
public void readFile() throws IOException {
    FileReader reader = new FileReader("file.txt");
    // ...
}
```

### 2. Unchecked Exceptions (Runtime Exceptions)

- Don't need to be explicitly handled
- Extend `RuntimeException`
- Examples: `NullPointerException`, `ArrayIndexOutOfBoundsException`

```java
// No need to handle or declare
public void divide(int a, int b) {
    int result = a / b; // May throw ArithmeticException
}
```

## Exception Handling Keywords

### try
- Encloses code that might throw an exception
- Must be followed by catch, finally, or both

### catch
- Handles specific exceptions
- Can have multiple catch blocks
- Must be ordered from most specific to least specific

### finally
- Always executes regardless of exceptions
- Used for cleanup operations
- Cannot be used without try

### throws
- Declares that a method may throw exceptions
- Used for checked exceptions

### throw
- Explicitly throws an exception
- Used to create custom exceptions

## Try-Catch Blocks

### Basic Syntax

```java
try {
    // Code that might throw an exception
    riskyOperation();
} catch (SpecificException e) {
    // Handle specific exception
    System.out.println("Specific error: " + e.getMessage());
} catch (Exception e) {
    // Handle general exception
    System.out.println("General error: " + e.getMessage());
}
```

### Multiple Catch Blocks

```java
try {
    // Multiple operations that might throw different exceptions
    fileOperation();
    networkOperation();
    databaseOperation();
} catch (IOException e) {
    // Handle file/network errors
    logError("IO Error", e);
} catch (SQLException e) {
    // Handle database errors
    logError("Database Error", e);
} catch (Exception e) {
    // Handle any other exceptions
    logError("Unknown Error", e);
}
```

## Finally Block

The finally block always executes, regardless of whether an exception occurs.

```java
FileReader reader = null;
try {
    reader = new FileReader("file.txt");
    // Read file content
} catch (IOException e) {
    System.out.println("Error reading file: " + e.getMessage());
} finally {
    // Always close the reader
    if (reader != null) {
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("Error closing file: " + e.getMessage());
        }
    }
}
```

## Try-with-Resources

Introduced in Java 7, try-with-resources automatically manages resources that implement `AutoCloseable`.

```java
// Automatic resource management
try (FileReader reader = new FileReader("file.txt");
     BufferedReader bufferedReader = new BufferedReader(reader)) {
    
    String line = bufferedReader.readLine();
    System.out.println(line);
    
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
// Resources are automatically closed here
```

## Custom Exceptions

### Creating Custom Exceptions

```java
// Checked exception
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
    
    public InvalidAgeException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Unchecked exception
public class BusinessLogicException extends RuntimeException {
    public BusinessLogicException(String message) {
        super(message);
    }
}
```

### Using Custom Exceptions

```java
public void validateAge(int age) throws InvalidAgeException {
    if (age < 0 || age > 150) {
        throw new InvalidAgeException("Age must be between 0 and 150, got: " + age);
    }
}

public void processUser(String name) {
    if (name == null || name.trim().isEmpty()) {
        throw new BusinessLogicException("User name cannot be null or empty");
    }
}
```

## Exception Propagation

Exceptions propagate up the call stack until they are caught or the program terminates.

```java
public void methodA() throws Exception {
    System.out.println("Method A");
    methodB();
}

public void methodB() throws Exception {
    System.out.println("Method B");
    methodC();
}

public void methodC() throws Exception {
    System.out.println("Method C");
    throw new Exception("Error in method C");
}
```

## Best Practices

### 1. Log Exceptions Properly

```java
private static final Logger LOGGER = Logger.getLogger(MyClass.class.getName());

try {
    riskyOperation();
} catch (Exception e) {
    LOGGER.log(Level.SEVERE, "Operation failed", e);
    // Don't just print stack trace
}
```

### 2. Use Specific Exceptions

```java
// Good
try {
    fileOperation();
} catch (FileNotFoundException e) {
    // Handle file not found
} catch (IOException e) {
    // Handle other IO errors
}

// Bad
try {
    fileOperation();
} catch (Exception e) {
    // Too generic
}
```

### 3. Don't Ignore Exceptions

```java
// Bad
try {
    riskyOperation();
} catch (Exception e) {
    // Empty catch block - exception is ignored
}

// Good
try {
    riskyOperation();
} catch (Exception e) {
    LOGGER.warning("Operation failed: " + e.getMessage());
    // Handle appropriately
}
```

### 4. Use Try-with-Resources

```java
// Good
try (InputStream input = new FileInputStream("file.txt")) {
    // Use input stream
} catch (IOException e) {
    // Handle exception
}

// Bad
InputStream input = null;
try {
    input = new FileInputStream("file.txt");
    // Use input stream
} finally {
    if (input != null) {
        try {
            input.close();
        } catch (IOException e) {
            // Handle close exception
        }
    }
}
```

### 5. Chain Exceptions

```java
try {
    databaseOperation();
} catch (SQLException e) {
    throw new ServiceException("Failed to process user data", e);
}
```

## Common Mistakes

### 1. Catching Exception Too Broadly

```java
// Bad
try {
    // Code
} catch (Exception e) {
    // Too broad
}

// Good
try {
    // Code
} catch (SpecificException e) {
    // Handle specific exception
}
```

### 2. Using Exceptions for Flow Control

```java
// Bad
try {
    for (int i = 0; i < array.length; i++) {
        if (i < 0) {
            throw new IllegalArgumentException("Negative index");
        }
    }
} catch (IllegalArgumentException e) {
    // This will never execute in this loop
}

// Good
for (int i = 0; i < array.length; i++) {
    if (i < 0) {
        // Handle negative case without exception
        break;
    }
}
```

### 3. Not Closing Resources

```java
// Bad
FileReader reader = new FileReader("file.txt");
// Use reader but never close it

// Good
try (FileReader reader = new FileReader("file.txt")) {
    // Use reader
} catch (IOException e) {
    // Handle exception
}
```

## Performance Considerations

### 1. Exception Creation is Expensive

```java
// Expensive - creates stack trace
throw new Exception("Error");

// Less expensive - no stack trace
throw new RuntimeException("Error");
```

### 2. Avoid Exceptions in Loops

```java
// Bad - creates many exceptions
for (int i = 0; i < 1000; i++) {
    try {
        if (i < 0) throw new Exception("Negative");
    } catch (Exception e) {
        // Handle
    }
}

// Good - normal flow control
for (int i = 0; i < 1000; i++) {
    if (i < 0) {
        // Handle without exception
    }
}
```

## Real-World Examples

### 1. File Processing

```java
public void processFile(String filename) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = reader.readLine()) != null) {
            processLine(line);
        }
    } catch (FileNotFoundException e) {
        LOGGER.severe("File not found: " + filename);
        throw new BusinessException("File not found", e);
    } catch (IOException e) {
        LOGGER.severe("Error reading file: " + filename);
        throw new BusinessException("Error reading file", e);
    }
}
```

### 2. Database Operations

```java
public User getUserById(int id) {
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE id = ?")) {
        
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            return mapResultSetToUser(rs);
        } else {
            throw new UserNotFoundException("User not found with id: " + id);
        }
        
    } catch (SQLException e) {
        LOGGER.severe("Database error while fetching user: " + id);
        throw new DataAccessException("Error accessing database", e);
    }
}
```

### 3. API Response Handling

```java
public ApiResponse processRequest(String request) {
    try {
        validateRequest(request);
        Object result = businessLogic.process(request);
        return ApiResponse.success(result);
    } catch (ValidationException e) {
        LOGGER.warning("Validation failed: " + e.getMessage());
        return ApiResponse.badRequest(e.getMessage());
    } catch (BusinessException e) {
        LOGGER.severe("Business logic error: " + e.getMessage());
        return ApiResponse.serverError("Internal server error");
    } catch (Exception e) {
        LOGGER.severe("Unexpected error: " + e.getMessage());
        return ApiResponse.serverError("Unexpected error occurred");
    }
}
```

## Running the Examples

To run the example programs:

```bash
# Compile the programs
javac ExceptionExamples.java
javac ExceptionBestPractices.java

# Run the programs
java ExceptionExamples
java ExceptionBestPractices
```

## Summary

Exception handling is a fundamental aspect of Java programming. By following these best practices and understanding the different types of exceptions, you can write more robust and maintainable code. Remember to:

- Use specific exceptions when possible
- Always close resources properly
- Log exceptions with appropriate context
- Don't use exceptions for normal flow control
- Chain exceptions to preserve the original cause
- Use try-with-resources for automatic resource management

## Additional Resources

- [Oracle Java Documentation - Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/)
- [Java Exception Handling Best Practices](https://www.baeldung.com/java-exception-handling-best-practices)
- [Effective Java - Item 69: Use exceptions only for exceptional conditions](https://www.oreilly.com/library/view/effective-java-3rd/9780134686097/) 