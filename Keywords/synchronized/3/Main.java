class SharedResource {
    synchronized static void synchronizedStaticMethod() {
        // Code that needs synchronization
    }
}

public class Main {
    public static void main(String[] args) {
        // Use synchronized static method
        SharedResource.synchronizedStaticMethod();
    }
}
