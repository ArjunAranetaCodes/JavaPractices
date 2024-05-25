## Problem: 
Implementing a Simple Chat System

## Description: 
Create a program that demonstrates the use of Deque to implement a simple chat system. The program should allow multiple users to send and receive messages.

## Input:
User 1: Hello!
User 2: Hi!
User 3: How are you?
User 1: I'm good, thanks!
## Output:
User 1: Hello!
User 2: Hi!
User 3: How are you?
User 1: I'm good, thanks!
## Code Answer:
```Java
import java.util.Deque;
import java.util.LinkedList;

public class ChatSystem {
private Deque<String> messageQueue = new LinkedList<>();

    public void sendMessage(String message) {
        messageQueue.addLast(message);
    }

    public String receiveMessage() {
        return messageQueue.pollFirst();
    }

    public static void main(String[] args) {
        ChatSystem chatSystem = new ChatSystem();

        Thread user1 = new Thread(() -> {
            chatSystem.sendMessage("Hello!");
        });

        Thread user2 = new Thread(() -> {
            chatSystem.sendMessage("Hi!");
        });

        Thread user3 = new Thread(() -> {
            chatSystem.sendMessage("How are you?");
        });

        Thread user4 = new Thread(() -> {
            chatSystem.sendMessage("I'm good, thanks!");
        });

        user1.start();
        user2.start();
        user3.start();
        user4.start();

        while (true) {
            String message = chatSystem.receiveMessage();
            if (message != null) {
                System.out.println(message);
            }
        }
    }
}
```

File Name: ChatSystem.java

This program demonstrates the use of Deque to implement a simple chat system. Multiple threads representing users send messages using the sendMessage method, and the receiveMessage method is used to retrieve and display the messages. The output shows the messages being sent and received by the respective threads.