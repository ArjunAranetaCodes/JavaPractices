## Problem: 
Thread-Safe Bounded Queue for Logging

## Description: 
Create a program that demonstrates the use of LinkedBlockingDeque as a thread-safe bounded queue for logging. The program should have multiple threads that represent loggers, and each logger should be able to add log messages to the queue.

## Input:
Logger 1: Log Message 1
Logger 2: Log Message 2
Logger 3: Log Message 3
Logger 4: Log Message 4
## Output:
Log Message 1 added to queue
Log Message 2 added to queue
Log Message 3 added to queue
Log Message 4 added to queue
## Code Answer:
```Java
import java.util.concurrent.LinkedBlockingDeque;

public class LoggingSystem {
private LinkedBlockingDeque<String> logQueue = new LinkedBlockingDeque<>(10);

    public void logMessage(String message) {
        try {
            logQueue.put(message);
            System.out.println(message + " added to queue");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void processLogs() {
        while (true) {
            try {
                String message = logQueue.take();
                System.out.println("Processing log: " + message);
                // Process the log message
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        LoggingSystem loggingSystem = new LoggingSystem();

        Thread logger1 = new Thread(() -> {
            loggingSystem.logMessage("Log Message 1");
        });

        Thread logger2 = new Thread(() -> {
            loggingSystem.logMessage("Log Message 2");
        });

        Thread logger3 = new Thread(() -> {
            loggingSystem.logMessage("Log Message 3");
        });

        Thread logger4 = new Thread(() -> {
            loggingSystem.logMessage("Log Message 4");
        });

        logger1.start();
        logger2.start();
        logger3.start();
        logger4.start();

        loggingSystem.processLogs();
    }
}
```

File Name: LoggingSystem.java

This program demonstrates the use of LinkedBlockingDeque as a thread-safe bounded queue for logging. Multiple threads representing loggers add log messages to the queue, and a separate thread processes the logs from the queue. The output shows the log messages being added to the queue and processed by the respective threads.