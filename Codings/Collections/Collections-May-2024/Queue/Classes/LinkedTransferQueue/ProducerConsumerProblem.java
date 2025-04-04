import java.util.concurrent.LinkedTransferQueue;

public class ProducerConsumerProblem {
    private LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();

    public void produce(String element) {
        queue.add(element);
        System.out.println(element + " added by Producer");
    }

    public void consume() throws Exception{
        String element = queue.take();
        System.out.println(element + " removed by Consumer");
    }

    public static void main(String[] args) {
        ProducerConsumerProblem producerConsumerProblem = new ProducerConsumerProblem();

        Thread producer = new Thread(() -> {
            producerConsumerProblem.produce("Element 1");
            producerConsumerProblem.produce("Element 2");
            producerConsumerProblem.produce("Element 3");
        });

        Thread consumer = new Thread(() -> {
            try{
                producerConsumerProblem.consume();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        });

        producer.start();
        consumer.start();
    }
}