class SharedResource {
    private Object lock = new Object();

    void someMethod() {
        // Code without synchronization

        synchronized (lock) {
        }

    }
}

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // Use synchronized block
        sharedResource.someMethod();
    }
}
