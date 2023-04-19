import java.util.LinkedList;
import java.util.Queue;

public class QueueSample {
    public static void main(String[] args) {
        Queue<Integer> circularQueue = new LinkedList<>();

        for (int i = 1; i <= 5; i++) {
            circularQueue.add(i);
        }

        System.out.println("Circular Queue: " + circularQueue);

        int removedElement = circularQueue.poll();
        circularQueue.add(6);

        System.out.println("Updated Circular Queue: " + circularQueue);
    }
}
