import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

        System.out.println("Initial BlockingQueue: " + blockingQueue);

        // Put elements
        blockingQueue.put(10);
        System.out.println("BlockingQueue after putting 10: " + blockingQueue);
        blockingQueue.put(20);
        System.out.println("BlockingQueue after putting 20: " + blockingQueue);
        blockingQueue.put(30);
        System.out.println("BlockingQueue after putting 30: " + blockingQueue);

        // Take element
        System.out.println("Took element: " + blockingQueue.take());
        System.out.println("BlockingQueue after taking: " + blockingQueue);

        // Peek element
        System.out.println("Peeked element: " + blockingQueue.peek());

        // Get blockingQueue size
        System.out.println("BlockingQueue size: " + blockingQueue.size());

        // Check if blockingQueue is empty
        System.out.println("BlockingQueue is empty: " + blockingQueue.isEmpty());

        // Offer element
        System.out.println("Offered element 40: " + blockingQueue.offer(40));
        System.out.println("BlockingQueue after offering: " + blockingQueue);

        // Poll element
        System.out.println("Pooled element: " + blockingQueue.poll());
        System.out.println("BlockingQueue after polling: " + blockingQueue);

        // Check if blockingQueue is empty
        System.out.println("BlockingQueue is empty: " + blockingQueue.isEmpty());

        // Remove element using remove
        System.out.println("Removed element using remove: " + blockingQueue.remove());
        System.out.println("BlockingQueue after removing: " + blockingQueue);

        // Check if blockingQueue is empty
        System.out.println("BlockingQueue is empty: " + blockingQueue.isEmpty());

        // Remove element using remove
        System.out.println("Removed element using remove: " + blockingQueue.remove());
        System.out.println("BlockingQueue after removing: " + blockingQueue);

        // Check if blockingQueue is empty
        System.out.println("BlockingQueue is empty: " + blockingQueue.isEmpty());
    }
}