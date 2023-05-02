import java.util.concurrent.Semaphore;

public class Main {
    private static final int MAX_PERMITS = 3;
    private static Semaphore semaphore = new Semaphore(MAX_PERMITS);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread workerThread = new Thread(() -> accessSharedResource());
            workerThread.start();
        }
    }

    private static void accessSharedResource() {
        try {
            semaphore.acquire(); // Acquire a permit
            System.out.println(Thread.currentThread().getName() + ": Accessing the shared resource");
            Thread.sleep(2000); // Simulate resource usage
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // Release the permit
        }
    }
}
