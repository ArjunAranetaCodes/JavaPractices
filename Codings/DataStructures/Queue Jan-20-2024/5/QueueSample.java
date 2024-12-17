import java.util.LinkedList;
import java.util.Queue;

public class QueueSample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        System.out.println("Is the queue empty? " + queue.isEmpty());

        queue.offer("Java");
        System.out.println("Is the queue empty? " + queue.isEmpty());
    }
}
