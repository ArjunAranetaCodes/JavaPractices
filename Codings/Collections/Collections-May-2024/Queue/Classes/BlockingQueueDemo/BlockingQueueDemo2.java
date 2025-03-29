import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueDemo2 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

        System.out.println("Initial BlockingQueue: " + blockingQueue);

        // Add elements
        blockingQueue.add(10);
        System.out.println("BlockingQueue after adding 10: " + blockingQueue);
        blockingQueue.add(20);
        System.out.println("BlockingQueue after adding 20: " + blockingQueue);
        blockingQueue.add(30);
        System.out.println("BlockingQueue after adding 30: " + blockingQueue);

        // Add element
        System.out.println("Added element 40: " + blockingQueue.add(40));
        System.out.println("BlockingQueue after adding: " + blockingQueue);

        // Offer element
        System.out.println("Offered element 50: " + blockingQueue.offer(50));
        System.out.println("BlockingQueue after offering: " + blockingQueue);

        // Poll element
        System.out.println("Pooled element: " + blockingQueue.poll());
        System.out.println("BlockingQueue after polling: " + blockingQueue);

        // Peek element
        System.out.println("Peeked element: " + blockingQueue.peek());

        // Get blockingQueue size
        System.out.println("BlockingQueue size: " + blockingQueue.size());

        // Check if blockingQueue is empty
        System.out.println("BlockingQueue is empty: " + blockingQueue.isEmpty());

        // Take element
        System.out.println("Took element: " + blockingQueue.take());
        System.out.println("BlockingQueue after taking: " + blockingQueue);

        // Remove element using remove
        System.out.println("Removed element using remove: " + blockingQueue.remove());
        System.out.println("BlockingQueue after removing: " + blockingQueue);

        // Remove element using remove
        System.out.println("Removed element using remove: " + blockingQueue.remove());
        System.out.println("BlockingQueue after removing: " + blockingQueue);

        // Remove element using remove
        System.out.println("Removed element using remove: " + blockingQueue.remove());
        System.out.println("BlockingQueue after removing: " + blockingQueue);

        // Check if blockingQueue is empty
        System.out.println("BlockingQueue is empty: " + blockingQueue.isEmpty());
    }
}