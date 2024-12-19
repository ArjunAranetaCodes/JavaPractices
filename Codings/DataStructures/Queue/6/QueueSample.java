import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueSample {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();

        blockingQueue.offer("First");
        blockingQueue.offer("Second");
        blockingQueue.offer("Third");

        System.out.println("Blocking Queue: " + blockingQueue);
    }
}
