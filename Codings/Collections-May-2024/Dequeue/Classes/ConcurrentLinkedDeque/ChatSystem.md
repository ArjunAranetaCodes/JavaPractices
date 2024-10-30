## Problem: 
Thread-Safe Queue for Chat Messages

## Description: 
Create a program that demonstrates the use of ConcurrentLinkedDeque as a thread-safe queue for chat messages. The program should have multiple threads that represent users, and each user should be able to add messages to the queue.

## Input:
User 1: Message 1
User 2: Message 2
User 3: Message 3
User 4: Message 4
## Output:
Message 1 added to queue
Message 2 added to queue
Message 3 added to queue
Message 4 added to queue

## Code Answer:
```Java
import java.util.concurrent.ConcurrentLinkedDeque;

public class ChatSystem {
private ConcurrentLinkedDeque<String> messageQueue = new ConcurrentLinkedDeque<>();

    public void sendMessage(String message) {
        messageQueue.add(message);
        System.out.println(message + " added to queue");
    }

    public void displayMessages() {
        while (true) {
            String message = messageQueue.poll();
            if (message != null) {
                System.out.println("Message: " + message);
                // Display the message
            }
        }
    }

    public static void main(String[] args) {
        ChatSystem chatSystem = new ChatSystem();

        Thread user1 = new Thread(() -> {
            chatSystem.sendMessage("Message 1");
        });

        Thread user2 = new Thread(() -> {
            chatSystem.sendMessage("Message 2");
        });

        Thread user3 = new Thread(() -> {
            chatSystem.sendMessage("Message 3");
        });

        Thread user4 = new Thread(() -> {
            chatSystem.sendMessage("Message 4");
        });

        user1.start();
        user2.start();
        user3.start();
        user4.start();

        chatSystem.displayMessages();
    }
}
```

File Name: ChatSystem.java

This program demonstrates the use of ConcurrentLinkedDeque as a thread-safe queue for chat messages. Multiple threads representing users add messages to the queue, and a separate thread displays the messages from the queue. The output shows the messages being added to the queue and displayed by the respective threads.