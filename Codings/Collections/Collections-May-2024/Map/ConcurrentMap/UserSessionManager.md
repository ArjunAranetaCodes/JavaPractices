## Problem: 
Implementing a Thread-Safe User Session Manager

## Description: 
Create a program that demonstrates the use of ConcurrentMap to implement a thread-safe user session manager.

## Input:

User sessions: {"user1", "session1"}, {"user2", "session2"}, {"user3", "session3"}
Output:

## User sessions:

user1 = session1

user2 = session2

user3 = session3

Session count: 3

## Code Answer:
```Java
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;

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

    public int getSessionCount() {
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

        System.out.println("Session count: " + manager.getSessionCount());
    }
}
```

File Name: UserSessionManager.java

This program demonstrates the use of ConcurrentMap to implement a thread-safe user session manager. The UserSessionManager class uses a ConcurrentHashMap to store user sessions. The createUserSession method adds a new user session, and the getUserSession method retrieves a user session by user name. The getSessionCount method returns the number of user sessions. The program prints the user sessions and the session count.

Note: ConcurrentMap is a collection that stores key-value pairs in a thread-safe manner, and it provides methods for navigating and searching the elements in the map. It is useful for implementing thread-safe caches, dictionaries, and other similar data structures.