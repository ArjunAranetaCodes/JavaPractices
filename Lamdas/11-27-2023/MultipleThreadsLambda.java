public class MultipleThreadsLambda {
    public static void main(String[] args) {
        // Lambda expression for multiple threads
        Thread thread1 = new Thread(() -> System.out.println("Thread 1"));
        Thread thread2 = new Thread(() -> System.out.println("Thread 2"));

        // Start both threads
        thread1.start();
        thread2.start();
    }
}
