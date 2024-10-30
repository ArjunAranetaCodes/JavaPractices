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