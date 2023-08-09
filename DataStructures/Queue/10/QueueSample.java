import java.util.ArrayDeque;
import java.util.Queue;

public class QueueSample {
    public static void main(String[] args) {
        Queue<String> arrayDequeQueue = new ArrayDeque<>();

        arrayDequeQueue.offer("One");
        arrayDequeQueue.offer("Two");
        arrayDequeQueue.offer("Three");

        System.out.println("ArrayDeque Queue: " + arrayDequeQueue);
    }
}
