import java.util.LinkedList;
import java.util.Queue;

public class QueueSample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= 5; i++) {
            queue.offer(i);
        }

        System.out.println("Queue size: " + queue.size());
    }
}
