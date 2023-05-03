import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static int sharedResource = 0;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> incrementSharedResource());
        Thread t2 = new Thread(() -> incrementSharedResource());

        t1.start();
        t2.start();
    }

    private static void incrementSharedResource() {
        lock.lock();
        try {
            // Critical section
            System.out.println(Thread.currentThread().getName() + ": " + (++sharedResource));
        } finally {
            lock.unlock();
        }
    }
}
