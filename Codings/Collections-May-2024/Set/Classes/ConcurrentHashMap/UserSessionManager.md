## Problem: 
Implementing a Thread-Safe User Session Manager

## Description: 
Create a program that demonstrates the use of ConcurrentHashMap to implement a thread-safe user session manager.

## Input:

Login: "User1"

Login: "User2"

Logout: "User1"

Get Sessions: (should print "User2")

## Output:

User2

## Code Answer:
```Java
import java.util.concurrent.ConcurrentHashMap;

public class UserSessionManager {
    private ConcurrentHashMap<String, Boolean> sessions = new ConcurrentHashMap<>();

    public void login(String user) {
        sessions.put(user, true);
    }

    public void logout(String user) {
        sessions.remove(user);
    }

    public void printSessions() {
        System.out.println(sessions.keySet());
    }

    public static void main(String[] args) {
        UserSessionManager manager = new UserSessionManager();

        Thread thread1 = new Thread(() -> {
            manager.login("User1");
        });

        Thread thread2 = new Thread(() -> {
            manager.login("User2");
        });

        Thread thread3 = new Thread(() -> {
            manager.logout("User1");
        });

        Thread thread4 = new Thread(() -> {
            manager.printSessions();
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
```

File Name: UserSessionManager.java

This program demonstrates the use of ConcurrentHashMap to implement a thread-safe user session manager. The UserSessionManager class uses a ConcurrentHashMap to store user sessions, which ensures that multiple threads can safely access and modify the sessions without fear of concurrent modification exceptions. The main method creates four threads that login, logout, and print user sessions, demonstrating the thread safety of the session manager.