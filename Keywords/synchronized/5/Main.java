class SharedResource {
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    void method1() {
        // Code without synchronization

        synchronized (lock1) {
            // Code that needs synchronization with lock1
        }

        // Code without synchronization
    }

    void method2() {
        // Code without synchronization

        synchronized (lock2) {
            // Code that needs synchronization with lock2
        }

        // Code without synchronization
    }
}

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // Use synchronized blocks with different objects
        synchronized (sharedResource) {
            sharedResource.method1();
            sharedResource.method2();
        }
    }
}
