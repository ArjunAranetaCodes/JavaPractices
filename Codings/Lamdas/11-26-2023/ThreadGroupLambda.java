public class ThreadGroupLambda {
    public static void main(String[] args) {
        // Lambda expression with thread group
        ThreadGroup threadGroup = new ThreadGroup("MyThreadGroup");

        Thread thread1 = new Thread(threadGroup, () -> System.out.println("Thread 1"));
        Thread thread2 = new Thread(threadGroup, () -> System.out.println("Thread 2"));

        // Start both threads
        thread1.start();
        thread2.start();

        System.out.println("Thread Group Name: " + threadGroup.getName());
    }
}
