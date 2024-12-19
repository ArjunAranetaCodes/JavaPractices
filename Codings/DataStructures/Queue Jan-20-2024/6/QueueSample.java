import java.util.LinkedList;
import java.util.Queue;

public class QueueSample {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Queue<Integer> queue = linkedList;

        queue.offer(10);
        queue.offer(20);

        System.out.println("Queue: " + queue);
    }
}
