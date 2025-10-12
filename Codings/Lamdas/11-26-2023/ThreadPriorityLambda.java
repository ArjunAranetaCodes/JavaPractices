public class ThreadPriorityLambda {
    public static void main(String[] args) {
        // Lambda expression with thread priority
        Thread thread = new Thread(() -> System.out.println("Thread with Priority"), "PriorityThread");

        // Set thread priority
        thread.setPriority(Thread.MAX_PRIORITY);

        // Start the thread
        thread.start();
    }
}
