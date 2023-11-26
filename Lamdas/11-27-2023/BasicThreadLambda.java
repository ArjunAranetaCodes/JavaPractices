public class BasicThreadLambda {
    public static void main(String[] args) {
        // Lambda expression to create a new thread
        Thread thread = new Thread(() -> System.out.println("Hello from BasicThreadLambda!"));

        // Start the thread
        thread.start();
    }
}
