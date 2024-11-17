import java.util.Queue;
import java.util.LinkedList;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        System.out.println("Initial Queue: " + queue);

        // Add elements
        queue.add(10);
        System.out.println("Queue after adding 10: " + queue);
        queue.add(20);
        System.out.println("Queue after adding 20: " + queue);
        queue.add(30);
        System.out.println("Queue after adding 30: " + queue);

        // Remove element
        System.out.println("Removed element: " + queue.remove());
        System.out.println("Queue after removing: " + queue);

        // Get element
        System.out.println("Element: " + queue.element());

        // Peek element
        System.out.println("Peeked element: " + queue.peek());

        // Check if queue is empty
        System.out.println("Queue is empty: " + queue.isEmpty());

        // Remove element using poll
        System.out.println("Removed element using poll: " + queue.poll());
        System.out.println("Queue after poll: " + queue);

        // Check if queue is empty
        System.out.println("Queue is empty: " + queue.isEmpty());

        // Remove element using remove
        System.out.println("Removed element using remove: " + queue.remove());
        System.out.println("Queue after remove: " + queue);

        // Check if queue is empty
        System.out.println("Queue is empty: " + queue.isEmpty());
    }
}