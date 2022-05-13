class SharedResource {
    private Object lock = new Object();

    void someMethod() {
        // Code without synchronization

        synchronized (lock) {
            // Code that needs synchronization
        }

    }
}

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // Use synchronized on object
        synchronized (sharedResource) {
            sharedResource.someMethod();
        }
    }
}
