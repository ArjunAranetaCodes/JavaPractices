# Multiple Tasks with Structured Concurrency

This example demonstrates how to handle multiple concurrent tasks using Structured Concurrency in Java 21.

## Overview

The program shows how to:
- Create and manage multiple concurrent tasks
- Handle different task durations
- Collect and process results from multiple tasks
- Manage task lifecycle in a structured way

## Key Concepts

1. **Multiple Task Submission**: Using a loop to submit multiple tasks
2. **Task Collection**: Storing subtasks in a list for later processing
3. **Result Processing**: Iterating through completed tasks to get results
4. **Coordinated Shutdown**: All tasks are automatically managed by the scope

## Code Explanation

```java
try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
    List<StructuredTaskScope.Subtask<String>> subtasks = new ArrayList<>();
    
    // Submit multiple tasks with different durations
    for (int i = 1; i <= 3; i++) {
        final int taskId = i;
        subtasks.add(scope.fork(() -> {
            Thread.sleep(taskId * 1000);
            return "Task " + taskId + " completed!";
        }));
    }

    // Wait for all tasks
    scope.join();
    scope.throwIfFailed();

    // Process results
    for (var subtask : subtasks) {
        System.out.println(subtask.get());
    }
}
```

## Running the Example

Compile and run with preview features enabled:

```bash
javac --enable-preview --release 21 02_MultipleTasks.java
java --enable-preview 02_MultipleTasks
```

## Expected Output

```
Task 1 completed!
Task 2 completed!
Task 3 completed!
```

## Notes

- Tasks complete in order of their duration (1s, 2s, 3s)
- All tasks are managed within the same scope
- If any task fails, the scope is automatically shut down
- Results are processed only after all tasks complete successfully
- The example demonstrates proper resource cleanup with try-with-resources 