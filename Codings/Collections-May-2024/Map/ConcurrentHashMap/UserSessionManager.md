## Problem: 
Implementing a Thread-Safe User Session Manager

## Description: 
Create a program that demonstrates the use of ConcurrentHashMap to implement a thread-safe user session manager.

## Input:

User sessions: {"user1", "session1"}, {"user2", "session2"}, {"user3", "session3"}

## Output:

User sessions:

user1 = session1

user2 = session2

user3 = session3

Active user count: 3

## Code Answer:
```Java
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class UserSessionManager {
    private ConcurrentMap<String, String> sessions;

    public UserSessionManager() {
        this.sessions = new ConcurrentHashMap<>();
    }

    public void createUserSession(String user, String session) {
        sessions.put(user, session);
    }

    public String getUserSession(String user) {
        return sessions.get(user);
    }

    public int getActiveUserCount() {
        return sessions.size();
    }

    public static void main(String[] args) {
        UserSessionManager manager = new UserSessionManager();

        manager.createUserSession("user1", "session1");
        manager.createUserSession("user2", "session2");
        manager.createUserSession("user3", "session3");

        System.out.println("User sessions:");
        for (Map.Entry<String, String> entry : manager.sessions.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("Active user count: " + manager.getActiveUserCount());
    }
}
```

File Name: UserSessionManager.java

This program demonstrates the use of ConcurrentHashMap to implement a thread-safe user session manager. The UserSessionManager class uses a ConcurrentHashMap to store user sessions, and provides methods for creating, retrieving, and counting user sessions. The main() method tests the user session manager by creating user sessions and retrieving values.

Note: ConcurrentHashMap is a thread-safe implementation of the Map interface, and is useful for creating caches, dictionaries, and other similar data structures that need to be accessed by multiple threads.