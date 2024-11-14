import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerProblem {
    private LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public void produce(String element) {
        try {
            queue.put(element);
            System.out.println(element + " added by Producer");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consume() {
        try {
            String element = queue.take();
            System.out.println(element + " removed by Consumer");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ProducerConsumerProblem producerConsumerProblem = new ProducerConsumerProblem();

        Thread producer = new Thread(() -> {
            producerConsumerProblem.produce("Element 1");
            producerConsumerProblem.produce("Element 2");
            producerConsumerProblem.produce("Element 3");
        });

        Thread consumer = new Thread(() -> {
            producerConsumerProblem.consume();
        });

        producer.start();
        consumer.start();
    }
}