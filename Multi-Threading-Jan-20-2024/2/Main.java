import java.util.LinkedList;
import java.util.Queue;

class Buffer {
    private Queue<Integer> items = new LinkedList<>();
    private int capacity;

    public Buffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(int item) {
        while (items.size() == capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        items.add(item);
        System.out.println("Produced: " + item);
        notify();
    }

    public synchronized void consume() {
        while (items.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int item = items.poll();
        System.out.println("Consumed: " + item);
        notify();
    }
}

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);

        Thread producerThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                buffer.produce(i);
            }
        }, "ProducerThread");

        Thread consumerThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                buffer.consume();
            }
        }, "ConsumerThread");

        producerThread.start();
        consumerThread.start();
    }
}
