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