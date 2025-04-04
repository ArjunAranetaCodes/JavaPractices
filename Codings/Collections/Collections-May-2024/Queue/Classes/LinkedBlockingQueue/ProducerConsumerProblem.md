## Problem: 
Producer-Consumer Problem with Blocking Queue

## Description: 
Create a program that demonstrates the use of LinkedBlockingQueue to solve the producer-consumer problem. The program should have two threads: a producer thread that adds elements to the queue and a consumer thread that removes elements from the queue.

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
```

File Name: ProducerConsumerProblem.java

This program demonstrates the use of LinkedBlockingQueue to solve the producer-consumer problem. The producer thread adds elements to the queue, and the consumer thread removes elements from the queue. The output shows the elements being added and removed by the respective threads.