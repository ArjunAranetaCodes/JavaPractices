## Problem: 
Implementing a Thread-Safe Set for Logging

## Description: 
Create a program that demonstrates the use of CopyOnWriteArraySet to implement a thread-safe set for logging purposes.

## Input:

Log: "Message 1"

Log: "Message 2"

Log: "Message 3"

## Output:

["Message 1", "Message 2", "Message 3"]

## Code Answer:
```Java
import java.util.*;

public class Logger {
private CopyOnWriteArraySet<String> logMessages = new CopyOnWriteArraySet<>();

    public void log(String message) {
        logMessages.add(message);
    }

    public void printLog() {
        System.out.println(logMessages);
    }

    public static void main(String[] args) {
        Logger logger = new Logger();

        Thread thread1 = new Thread(() -> {
            logger.log("Message 1");
        });

        Thread thread2 = new Thread(() -> {
            logger.log("Message 2");
        });

        Thread thread3 = new Thread(() -> {
            logger.log("Message 3");
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.printLog();
    }
}
```

File Name: Logger.java

This program demonstrates the use of CopyOnWriteArraySet to implement a thread-safe set for logging purposes. The Logger class uses a CopyOnWriteArraySet to store log messages, which ensures that multiple threads can safely add messages to the set without fear of concurrent modification exceptions. The main method creates three threads that log messages and then prints the log messages using the printLog method.