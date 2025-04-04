## Problem: 
Producer-Consumer Problem with Transfer Queue

## Description: 
Create a program that demonstrates the use of LinkedTransferQueue to solve the producer-consumer problem. The program should have two threads: a producer thread that adds elements to the queue and a consumer thread that removes elements from the queue.

## Input:
Producer: Add Element 1
Producer: Add Element 2
Consumer: Remove Element
Producer: Add Element 3
## Output:
Element 1 added by Producer
Element 2 added by Producer
Element 1 removed by Consumer
Element 3 added by Producer
## Code Answer:
```Java
import java.util.concurrent.LinkedTransferQueue;

public class ProducerConsumerProblem {
private LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();

    public void produce(String element) {
        queue.add(element);
        System.out.println(element + " added by Producer");
    }

    public void consume() {
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
            producerConsumerProblem.consume();
        });

        producer.start();
        consumer.start();
    }
}
```
File Name: ProducerConsumerProblem.java

This program demonstrates the use of LinkedTransferQueue to solve the producer-consumer problem. The producer thread adds elements to the queue, and the consumer thread removes elements from the queue. The output shows the elements being added and removed by the respective threads.