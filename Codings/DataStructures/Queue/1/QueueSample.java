import java.util.LinkedList;
import java.util.Queue;

public class QueueSample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.add("Apple");
        queue.add("Banana");
        queue.add("Orange");

        System.out.println("Queue: " + queue);

        String frontElement = queue.peek();
        System.out.println("Front element: " + frontElement);

        String removedElement = queue.poll();
        System.out.println("Removed element: " + removedElement);

        System.out.println("Updated Queue: " + queue);
    }
}
