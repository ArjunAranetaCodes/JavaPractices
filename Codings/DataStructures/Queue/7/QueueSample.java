import java.util.ArrayDeque;
import java.util.Queue;

public class QueueSample {
    public static void main(String[] args) {
        Queue<String> arrayDequeQueue = new ArrayDeque<>();

        arrayDequeQueue.add("A");
        arrayDequeQueue.add("B");
        arrayDequeQueue.add("C");

        System.out.println("ArrayDeque Queue: " + arrayDequeQueue);
    }
}
