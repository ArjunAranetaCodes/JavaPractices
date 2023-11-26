public class RunnableLambda {
    public static void main(String[] args) {
        // Lambda expression with Runnable interface
        Runnable runnable = () -> System.out.println("Hello from RunnableLambda!");

        // Create a thread with the runnable
        Thread thread = new Thread(runnable);

        // Start the thread
        thread.start();
    }
}
