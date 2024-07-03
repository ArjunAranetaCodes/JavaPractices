import java.util.PriorityQueue;

public class PriorityQueueDemo2 {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        System.out.println("Initial PriorityQueue: " + priorityQueue);

        // Add elements
        priorityQueue.add(30);
        System.out.println("PriorityQueue after adding 30: " + priorityQueue);
        priorityQueue.add(20);
        System.out.println("PriorityQueue after adding 20: " + priorityQueue);
        priorityQueue.add(10);
        System.out.println("PriorityQueue after adding 10: " + priorityQueue);

        // Remove element
        System.out.println("Removed element: " + priorityQueue.remove());
        System.out.println("PriorityQueue after removing: " + priorityQueue);

        // Peek element
        System.out.println("Peeked element: " + priorityQueue.peek());

        // Get priorityQueue size
        System.out.println("PriorityQueue size: " + priorityQueue.size());

        // Check if priorityQueue is empty
        System.out.println("PriorityQueue is empty: " + priorityQueue.isEmpty());

        // Poll element
        System.out.println("Polling element: " + priorityQueue.poll());
        System.out.println("PriorityQueue after polling: " + priorityQueue);

        // Check if priorityQueue is empty
        System.out.println("PriorityQueue is empty: " + priorityQueue.isEmpty());

        // Remove element using remove
        System.out.println("Removed element using remove: " + priorityQueue.remove());
        System.out.println("PriorityQueue after removing: " + priorityQueue);

        // Check if priorityQueue is empty
        System.out.println("PriorityQueue is empty: " + priorityQueue.isEmpty());
    }
}