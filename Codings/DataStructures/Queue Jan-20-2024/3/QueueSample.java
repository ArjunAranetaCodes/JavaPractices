import java.util.LinkedList;
import java.util.Queue;

public class QueueSample {
    public static void main(String[] args) {
        Queue<Double> queue = new LinkedList<>();

        queue.offer(3.14);
        queue.offer(2.71);

        System.out.println("Front element: " + queue.peek());
    }
}
