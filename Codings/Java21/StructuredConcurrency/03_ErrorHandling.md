# Error Handling in Structured Concurrency

This example demonstrates how to handle errors and task failures in Structured Concurrency.

## Overview

The program shows how to:
- Handle task failures gracefully
- Check task states
- Process results from successful tasks
- Handle exceptions from failed tasks
- Use the ShutdownOnFailure policy

## Key Concepts

1. **Task State Checking**: Using `state()` to check if a task succeeded or failed
2. **Exception Handling**: Catching and processing task exceptions
3. **Automatic Shutdown**: How ShutdownOnFailure policy works
4. **Result Processing**: Handling both successful and failed tasks

## Code Explanation

```java
try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
    List<StructuredTaskScope.Subtask<String>> subtasks = new ArrayList<>();
    
    // Submit tasks with different outcomes
    subtasks.add(scope.fork(() -> {
        Thread.sleep(1000);
        return "Task 1 completed successfully";
    }));

    subtasks.add(scope.fork(() -> {
        Thread.sleep(2000);
        throw new RuntimeException("Task 2 failed!");
    }));

    try {
        scope.join();
        scope.throwIfFailed();
    } catch (ExecutionException e) {
        System.err.println("A task failed: " + e.getCause().getMessage());
    }

    // Process results based on task state
    for (var subtask : subtasks) {
        if (subtask.state() == StructuredTaskScope.Subtask.State.SUCCESS) {
            System.out.println(subtask.get());
        } else {
            System.out.println("Task failed: " + subtask.exception().getMessage());
        }
    }
}
```

## Running the Example

Compile and run with preview features enabled:

```bash
javac --enable-preview --release 21 03_ErrorHandling.java
java --enable-preview 03_ErrorHandling
```

## Expected Output

```
A task failed: Task 2 failed!
Task 1 completed successfully
Task failed: Task 2 failed!
Task 3 completed successfully
```

## Notes

- Task 2 is designed to fail after 2 seconds
- The ShutdownOnFailure policy automatically shuts down the scope when a task fails
- We can still process results from tasks that completed before the failure
- The example shows how to handle both successful and failed tasks
- Task states can be checked using the `state()` method
- Exceptions from failed tasks can be accessed using `exception()` 