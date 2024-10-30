## Problem:
Thread-Safe Unbounded Queue for Task Execution

## Description: 
Create a program that demonstrates the use of ConcurrentLinkedDeque as a thread-safe unbounded queue for task execution. The program should have multiple threads that represent task executors, and each executor should be able to add tasks to the queue.

## Input:
Executor 1: Add Task 1
Executor 2: Add Task 2
Executor 3: Add Task 3
Executor 4: Add Task 4
## Output:
Task 1 added to queue
Task 2 added to queue
Task 3 added to queue
Task 4 added to queue

## Code Answer:
```Java
import java.util.concurrent.ConcurrentLinkedDeque;

public class TaskExecutor {
private ConcurrentLinkedDeque<String> taskQueue = new ConcurrentLinkedDeque<>();

    public void addTask(String task) {
        taskQueue.add(task);
        System.out.println(task + " added to queue");
    }

    public void executeTasks() {
        while (true) {
            String task = taskQueue.poll();
            if (task != null) {
                System.out.println("Executing task: " + task);
                // Execute the task
            }
        }
    }

    public static void main(String[] args) {
        TaskExecutor taskExecutor = new TaskExecutor();

        Thread executor1 = new Thread(() -> {
            taskExecutor.addTask("Task 1");
        });

        Thread executor2 = new Thread(() -> {
            taskExecutor.addTask("Task 2");
        });

        Thread executor3 = new Thread(() -> {
            taskExecutor.addTask("Task 3");
        });

        Thread executor4 = new Thread(() -> {
            taskExecutor.addTask("Task 4");
        });

        executor1.start();
        executor2.start();
        executor3.start();
        executor4.start();

        taskExecutor.executeTasks();
    }
}
```
File Name: TaskExecutor.java

This program demonstrates the use of ConcurrentLinkedDeque as a thread-safe unbounded queue for task execution. Multiple threads representing task executors add tasks to the queue, and a separate thread executes the tasks from the queue. The output shows the tasks being added to the queue and executed by the respective threads.