class SharedResource {
    synchronized void synchronizedMethod() {
    }
}

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        sharedResource.synchronizedMethod();
    }
}
