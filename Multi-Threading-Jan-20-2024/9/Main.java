import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 3;
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            Thread workerThread = new Thread(() -> performTask(startLatch, endLatch));
            workerThread.start();
        }

        System.out.println("All threads are waiting...");
        startLatch.countDown(); // Start all threads simultaneously

        endLatch.await(); // Wait for all threads to finish
        System.out.println("All threads have completed the task.");
    }

    private static void performTask(CountDownLatch startLatch, CountDownLatch endLatch) {
        try {
            startLatch.await(); // Wait for the signal to start
            // Task logic
            System.out.println(Thread.currentThread().getName() + ": Performing the task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            endLatch.countDown(); // Signal that the task is complete
        }
    }
}
