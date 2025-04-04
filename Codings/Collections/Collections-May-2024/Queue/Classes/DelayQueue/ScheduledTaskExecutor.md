## Problem: 
Scheduled Task Executor

## Description: 
Create a program that demonstrates the use of DelayQueue to execute tasks at a specified delay. The program should allow tasks to be added with a delay and execute them when the delay has expired.

## Input:
Task 1: Execute after 5 seconds
Task 2: Execute after 10 seconds
Task 3: Execute after 15 seconds
## Output:
Task 1 executed after 5 seconds
Task 2 executed after 10 seconds
Task 3 executed after 15 seconds

## Code Answer:
```Java
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class ScheduledTaskExecutor {
    private DelayQueue<DelayedTask> taskQueue = new DelayQueue<>();

    public void addTask(DelayedTask task) {
        taskQueue.add(task);
    }

    public void executeTasks() {
        while (true) {
            DelayedTask task = taskQueue.take();
            System.out.println("Task executed: " + task.getTaskName());
            // Execute the task
        }
    }

    public static void main(String[] args) {
        ScheduledTaskExecutor scheduledTaskExecutor = new ScheduledTaskExecutor();

        DelayedTask task1 = new DelayedTask("Task 1", 5, TimeUnit.SECONDS);
        DelayedTask task2 = new DelayedTask("Task 2", 10, TimeUnit.SECONDS);
        DelayedTask task3 = new DelayedTask("Task 3", 15, TimeUnit.SECONDS);

        scheduledTaskExecutor.addTask(task1);
        scheduledTaskExecutor.addTask(task2);
        scheduledTaskExecutor.addTask(task3);

        scheduledTaskExecutor.executeTasks();
    }
}

class DelayedTask implements Delayed {
    private String taskName;
    private long delay;
    private TimeUnit timeUnit;

    public DelayedTask(String taskName, long delay, TimeUnit timeUnit) {
        this.taskName = taskName;
        this.delay = delay;
        this.timeUnit = timeUnit;
    }

    public String getTaskName() {
        return taskName;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return timeUnit.convert(delay, unit);
    }
}
```
File Name: ScheduledTaskExecutor.java

This program demonstrates the use of DelayQueue to execute tasks at a specified delay. Tasks are added to the queue with a delay, and the executeTasks method executes them when the delay has expired. The output shows the tasks being executed at the specified delay.