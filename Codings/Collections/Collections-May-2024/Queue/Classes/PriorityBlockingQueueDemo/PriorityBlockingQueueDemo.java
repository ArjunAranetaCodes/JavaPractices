import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>();

        System.out.println("Initial PriorityBlockingQueue: " + priorityBlockingQueue);

        // Put elements
        priorityBlockingQueue.put(30);
        System.out.println("PriorityBlockingQueue after putting 30: " + priorityBlockingQueue);
        priorityBlockingQueue.put(20);
        System.out.println("PriorityBlockingQueue after putting 20: " + priorityBlockingQueue);
        priorityBlockingQueue.put(10);
        System.out.println("PriorityBlockingQueue after putting 10: " + priorityBlockingQueue);

        // Take element
        System.out.println("Took element: " + priorityBlockingQueue.take());
        System.out.println("PriorityBlockingQueue after taking: " + priorityBlockingQueue);

        // Peek element
        System.out.println("Peeked element: " + priorityBlockingQueue.peek());

        // Get priorityBlockingQueue size
        System.out.println("PriorityBlockingQueue size: " + priorityBlockingQueue.size());

        // Check if priorityBlockingQueue is empty
        System.out.println("PriorityBlockingQueue is empty: " + priorityBlockingQueue.isEmpty());

        // Offer element
        System.out.println("Offered element 40: " + priorityBlockingQueue.offer(40));
        System.out.println("PriorityBlockingQueue after offering: " + priorityBlockingQueue);

        // Poll element
        System.out.println("Polled element: " + priorityBlockingQueue.poll());
        System.out.println("PriorityBlockingQueue after polling: " + priorityBlockingQueue);

        // Check if priorityBlockingQueue is empty
        System.out.println("PriorityBlockingQueue is empty: " + priorityBlockingQueue.isEmpty());

        // Remove element using remove
        System.out.println("Removed element using remove: " + priorityBlockingQueue.remove());
        System.out.println("PriorityBlockingQueue after removing: " + priorityBlockingQueue);

        // Remove element using remove
        System.out.println("Removed element using remove: " + priorityBlockingQueue.remove());
        System.out.println("PriorityBlockingQueue after removing: " + priorityBlockingQueue);

        // Check if priorityBlockingQueue is empty
        System.out.println("PriorityBlockingQueue is empty: " + priorityBlockingQueue.isEmpty());
    }
}