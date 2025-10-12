public class ThreadSleepLambda {
    public static void main(String[] args) {
        // Lambda expression with thread sleep
        Thread thread = new Thread(() -> {
            System.out.println("Thread is running...");
            try {
                Thread.sleep(2000); // Sleep for 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread finished.");
        });

        // Start the thread
        thread.start();
    }
}
