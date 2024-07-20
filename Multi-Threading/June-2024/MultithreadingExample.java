

public class MultithreadingExample {
    public static void main(String[] args) {
        final Object lock = new Object();

        MyThread t1 = new MyThread("Thread-1", lock);
        MyThread t2 = new MyThread("Thread-2", lock);

        t1.start();
        t2.start();

        try {
            Thread.sleep(2000); // Ensure t1 and t2 start and wait
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock) {
            System.out.println("Main thread notifying one thread");
            lock.notify(); // Notify one waiting thread
        }

        try {
            Thread.sleep(2000); // Ensure one thread resumes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock) {
            System.out.println("Main thread notifying all threads");
            lock.notifyAll(); // Notify all waiting threads
        }

        try {
            t1.join(); // Wait for t1 to finish
            t2.join(); // Wait for t2 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished");
    }
}


class MyThread extends Thread {
    private final Object lock;

    public MyThread(String name, Object lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                System.out.println(Thread.currentThread().getName() + " is running");
                Thread.sleep(1000); // Simulate some work
                System.out.println(Thread.currentThread().getName() + " is waiting");
                lock.wait(); // Wait for notification
                System.out.println(Thread.currentThread().getName() + " is resumed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}