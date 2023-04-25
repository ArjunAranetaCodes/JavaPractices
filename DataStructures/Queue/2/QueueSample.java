import java.util.PriorityQueue;
import java.util.Queue;

public class QueueSample {
    public static void main(String[] args) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(30);
        priorityQueue.add(10);
        priorityQueue.add(20);

        System.out.println("Priority Queue: " + priorityQueue);
    }
}
