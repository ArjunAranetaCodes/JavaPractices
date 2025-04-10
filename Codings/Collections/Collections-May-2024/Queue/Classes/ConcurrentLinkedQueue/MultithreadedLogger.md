## Problem: 
Multithreaded Logger

## Description: 
Create a program that demonstrates the use of ConcurrentLinkedQueue in a multithreaded logger. The program should allow multiple threads to log messages concurrently without worrying about thread safety issues.

## Input:
Thread 1: Log Message 1
Thread 2: Log Message 2
Thread 3: Log Message 3
## Output:
Message 1 logged by Thread 1
Message 2 logged by Thread 2
Message 3 logged by Thread 3

## Code Answer:
```Java
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;

public class MultithreadedLogger {
    private ConcurrentLinkedQueue<String> logQueue = new ConcurrentLinkedQueue<>();
    private Logger logger = Logger.getLogger(MultithreadedLogger.class.getName());

    public void logMessage(String message, String threadName) {
        logQueue.add(message);
        logger.info(threadName + ": " + message);
    }

    public void processLogs() {
        while (true) {
            String message = logQueue.poll();
            if (message != null) {
                logger.info("Processed log message: " + message);
            }
        }
    }

    public static void main(String[] args) {
        MultithreadedLogger multithreadedLogger = new MultithreadedLogger();

        Thread thread1 = new Thread(() -> {
            multithreadedLogger.logMessage("Message 1", "Thread 1");
        });

        Thread thread2 = new Thread(() -> {
            multithreadedLogger.logMessage("Message 2", "Thread 2");
        });

        Thread thread3 = new Thread(() -> {
            multithreadedLogger.logMessage("Message 3", "Thread 3");
        });

        thread1.start();
        thread2.start();
        thread3.start();

        multithreadedLogger.processLogs();
    }
}
```
File Name: MultithreadedLogger.java

This program demonstrates the use of ConcurrentLinkedQueue in a multithreaded logger. Multiple threads can log messages concurrently without worrying about thread safety issues. The processLogs method processes the logged messages from the queue. The output shows the logged messages from each thread.