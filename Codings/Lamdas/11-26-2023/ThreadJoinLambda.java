public class ThreadJoinLambda {
    public static void main(String[] args) throws InterruptedException {
        // Lambda expression with thread join
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

        // Main thread waits for the 'thread' to finish
        thread.join();

        System.out.println("Main thread finished.");
    }
}
