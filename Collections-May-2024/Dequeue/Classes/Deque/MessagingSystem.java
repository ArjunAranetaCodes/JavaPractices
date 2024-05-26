import java.util.Deque;
import java.util.LinkedList;

public class MessagingSystem {
    private Deque<String> messageQueue = new LinkedList<>();

    public void sendMessage(String message) {
        messageQueue.addLast(message);
    }

    public String receiveMessage() {
        return messageQueue.pollFirst();
    }

    public static void main(String[] args) {
        MessagingSystem messagingSystem = new MessagingSystem();

        Thread user1 = new Thread(() -> {
            messagingSystem.sendMessage("Hello!");
        });

        Thread user2 = new Thread(() -> {
            messagingSystem.sendMessage("Hi!");
        });

        Thread user3 = new Thread(() -> {
            messagingSystem.sendMessage("How are you?");
        });

        Thread user4 = new Thread(() -> {
            messagingSystem.sendMessage("I'm good, thanks!");
        });

        user1.start();
        user2.start();
        user3.start();
        user4.start();

        while (true) {
            String message = messagingSystem.receiveMessage();
            if (message != null) {
                System.out.println(message);
            }
        }
    }
}