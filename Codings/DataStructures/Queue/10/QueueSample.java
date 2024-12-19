import java.util.LinkedList;
import java.util.Queue;

public class QueueSample {
    public static void main(String[] args) {
        final Queue<Integer> sharedQueue = new LinkedList<>();

        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                produce(sharedQueue, i);
            }
        });

        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                consume(sharedQueue);
            }
        });

        producerThread.start();
        consumerThread.start();
    }

    static void produce(Queue<Integer> queue, int item) {
        synchronized (queue) {
            queue.add(item);
            System.out.println("Produced: " + item);
            queue.notify();
        }
    }

    static void consume(Queue<Integer> queue) {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int item = queue.poll();
            System.out.println("Consumed: " + item);
        }
    }
}
