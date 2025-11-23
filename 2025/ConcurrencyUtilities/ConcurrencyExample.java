/**
 * Tutorial: Concurrency Utilities
 * Demonstrates advanced concurrency features
 */
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrencyExample {
    public static void main(String[] args) {
        // ExecutorService
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        System.out.println("ExecutorService Example:");
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
            });
        }
        
        executor.shutdown();
        try {
            executor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // CountDownLatch
        System.out.println("\nCountDownLatch Example:");
        CountDownLatch latch = new CountDownLatch(3);
        
        for (int i = 0; i < 3; i++) {
            final int id = i;
            new Thread(() -> {
                System.out.println("Thread " + id + " is working");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
                System.out.println("Thread " + id + " finished");
            }).start();
        }
        
        try {
            latch.await();
            System.out.println("All threads completed!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // AtomicInteger
        System.out.println("\nAtomicInteger Example:");
        AtomicInteger counter = new AtomicInteger(0);
        
        ExecutorService executor2 = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executor2.submit(() -> {
                int value = counter.incrementAndGet();
                System.out.println("Counter: " + value);
            });
        }
        
        executor2.shutdown();
        try {
            executor2.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Final counter value: " + counter.get());
    }
}

