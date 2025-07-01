# Nested Scopes in Structured Concurrency

This example demonstrates how to use nested scopes in Structured Concurrency to create hierarchical task structures.

## Overview

The program shows how to:
- Create nested task scopes
- Manage tasks at different levels
- Combine results from nested tasks
- Handle errors at different scope levels
- Coordinate between outer and inner scopes

## Key Concepts

1. **Scope Hierarchy**: Creating nested scopes for complex task structures
2. **Result Composition**: Combining results from nested tasks
3. **Error Propagation**: How errors propagate through nested scopes
4. **Resource Management**: Proper cleanup of nested scopes

## Code Explanation

```java
try (var outerScope = new StructuredTaskScope.ShutdownOnFailure()) {
    // First task with nested scope
    var task1 = outerScope.fork(() -> {
        try (var innerScope = new StructuredTaskScope.ShutdownOnFailure()) {
            // Nested tasks
            var nestedTask1 = innerScope.fork(() -> {
                Thread.sleep(1000);
                return "Nested Task 1 completed";
            });

            var nestedTask2 = innerScope.fork(() -> {
                Thread.sleep(2000);
                return "Nested Task 2 completed";
            });

            // Wait for nested tasks
            innerScope.join();
            innerScope.throwIfFailed();

            // Combine nested results
            return nestedTask1.get() + " and " + nestedTask2.get();
        }
    });

    // Second task in outer scope
    var task2 = outerScope.fork(() -> {
        Thread.sleep(1500);
        return "Outer Task 2 completed";
    });

    // Wait for outer tasks
    outerScope.join();
    outerScope.throwIfFailed();
}
```

## Running the Example

Compile and run with preview features enabled:

```bash
javac --enable-preview --release 21 04_NestedScopes.java
java --enable-preview 04_NestedScopes
```

## Expected Output

```
Task 1 result: Nested Task 1 completed and Nested Task 2 completed
Task 2 result: Outer Task 2 completed
```

## Notes

- The example demonstrates a two-level task hierarchy
- Inner scope tasks run concurrently within the outer task
- Results from nested tasks are combined before being returned
- Each scope level has its own error handling
- The ShutdownOnFailure policy applies at each scope level
- Proper resource cleanup is ensured through try-with-resources
- Task timing is coordinated between nested and outer scopes 