public class SynchronizedLambda {
    private static int counter = 0;

    public static void main(String[] args) {
        // Lambda expression with synchronized block
        Runnable runnable = () -> {
            synchronized (SynchronizedLambda.class) {
                for (int i = 0; i < 5; i++) {
                    counter++;
                    System.out.println(Thread.currentThread().getName() + ": " + counter);
                }
            }
        };

        // Create two threads with the same runnable
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        // Start both threads
        thread1.start();
        thread2.start();
    }
}
