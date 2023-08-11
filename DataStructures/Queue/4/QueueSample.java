import java.util.LinkedList;
import java.util.Queue;

public class QueueSample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.offer("A");
        queue.offer("B");
        queue.offer("C");

        System.out.println("Queue before clearing: " + queue);

        queue.clear();

        System.out.println("Queue after clearing: " + queue);
    }
}
