import java.util.LinkedList;
import java.util.Queue;

public class QueueSample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        System.out.println("Is Queue empty? " + queue.isEmpty());

        queue.add("Element");

        System.out.println("Is Queue empty now? " + queue.isEmpty());
    }
}
