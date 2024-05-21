import java.util.Queue;
import java.util.LinkedList;

public class QueueDemo2 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        System.out.println("Initial Queue: " + queue);

        // Offer elements
        queue.offer(10);
        System.out.println("Queue after offering 10: " + queue);
        queue.offer(20);
        System.out.println("Queue after offering 20: " + queue);
        queue.offer(30);
        System.out.println("Queue after offering 30: " + queue);

        // Poll element
        System.out.println("Polled element: " + queue.poll());
        System.out.println("Queue after poll: " + queue);

        // Peek element
        System.out.println("Peeked element: " + queue.peek());

        // Get queue size
        System.out.println("Queue size: " + queue.size());

        // Check if queue is empty
        System.out.println("Queue is empty: " + queue.isEmpty());

        // Clear queue
        queue.clear();
        System.out.println("Queue after clearing: " + queue);

        // Check if queue is empty
        System.out.println("Queue is empty: " + queue.isEmpty());
    }
}