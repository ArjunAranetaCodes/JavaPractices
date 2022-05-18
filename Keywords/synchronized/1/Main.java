class SharedResource {
    synchronized void synchronizedMethod() {
        // Code that needs synchronization
    }
}

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // Use synchronized method
        sharedResource.synchronizedMethod();
    }
}
