import java.util.LinkedList;
import java.util.Queue;

public class QueueSample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.offer("Element 1");
        queue.offer("Element 2");
        queue.offer("Element 3");

        System.out.println("Queue: " + queue);

        String front = queue.poll();
        System.out.println("Removed from front: " + front);

        System.out.println("Queue after removal: " + queue);
    }
}
