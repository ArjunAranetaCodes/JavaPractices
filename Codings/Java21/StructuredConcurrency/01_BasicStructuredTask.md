# Basic Structured Concurrency Example

This example demonstrates the fundamental concepts of Structured Concurrency in Java 21 using a simple task execution.

## Overview

The program shows how to:
- Create a structured task scope
- Submit a task to the scope
- Wait for task completion
- Handle task results and failures

## Key Concepts

1. **StructuredTaskScope**: A scope that manages the lifecycle of concurrent tasks
2. **ShutdownOnFailure**: A policy that automatically shuts down the scope if any task fails
3. **fork()**: Method to submit a task to the scope
4. **join()**: Method to wait for all tasks to complete
5. **throwIfFailed()**: Method to propagate any task failures

## Code Explanation

```java
try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
    // Submit a task
    Future<String> future = scope.fork(() -> {
        Thread.sleep(1000);
        return "Task completed successfully!";
    });

    // Wait for completion
    scope.join();
    scope.throwIfFailed();

    // Get result
    String result = future.resultNow();
}
```

## Running the Example

Compile and run with preview features enabled:

```bash
javac --enable-preview --release 21 01_BasicStructuredTask.java
java --enable-preview 01_BasicStructuredTask
```

## Expected Output

```
Task completed successfully!
```

## Notes

- The example uses `ShutdownOnFailure` policy which automatically shuts down the scope if any task fails
- The task scope is managed using try-with-resources for automatic cleanup
- Task failures are propagated using `throwIfFailed()`
- The example demonstrates basic error handling with try-catch 